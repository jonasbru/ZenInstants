package com.majomi.zeninstants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import com.majomi.zeninstants.messagescontroller.MessageManager;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;

public class NetworkManager {

	public static final String KEY_121 = "http://192.168.1.138/zenManagement/index.php";
	public static final String KEY_122 = "http://192.168.1.138/zenManagement/push.php";

	public static boolean updatePhrases() {
		AsyncTask<String, Integer, String> d = new UpdatePhrasesTask()
		.execute(KEY_121);
		try {
			parseJsonPhrases(d.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean pushNote() {
		AsyncTask<String, Integer, String> d = new PushNoteTask().execute(KEY_122);
		try {
			@SuppressWarnings("unused")
			String ret = d.get() + "\n CACA";
			return true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		} catch (ExecutionException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static void parseJsonPhrases(String json) {
		MessageManager mm = MessageManager.getMessageManager();

		List<MessageTextEntity> messages = new ArrayList<MessageTextEntity>();

		try {
			JSONArray jArray = new JSONArray(json);
			for (int i = 0; i < jArray.length(); i++) {
				JSONArray phrases = jArray.getJSONArray(i);

				for (int j = 0; j < phrases.length(); j++) {
					MessageTextEntity mv = null;

					JSONObject jo = phrases.getJSONObject(j);

					switch (i) {
					case 0 : //Text

						mv = new MessageTextEntity(jo.getString("text"));
						mv.setId(Long.parseLong(jo.getString("id")));

						break;

					case 1 :
						mv = new MessageImageEntity(jo.getString("text"), jo.getString("image"));
						mv.setId(Long.parseLong(jo.getString("id")));

						break;

					case 2 :
						mv = new MessageSoundEntity(jo.getString("text"), jo.getString("sound"));
						mv.setId(Long.parseLong(jo.getString("id")));

						break;

					case 3 :
						mv = new MessageVideoEntity(jo.getString("text"), jo.getString("video"));
						mv.setId(Long.parseLong(jo.getString("id")));

						break;

					default :
						throw new JSONException("Error parsing json..");
					}

					messages.add(mv);
				}
			}
		} catch (JSONException e) {
			Log.e("log_tag", "Error parsing data " + e.toString());
		}
		
		//If everithing went ok
		mm.replaceMessages(messages);

		Log.d("CACA", "Messages retrieved from the server ! : " + mm.getMessagesCloned());
	}

}



class UpdatePhrasesTask extends AsyncTask<String, Integer, String> {
	protected String doInBackground(String... urls) {
		return getServerData(urls[0]);
	}

	protected void onProgressUpdate(Integer... progress) {
		// setProgressPercent(progress[0]);
	}

	protected void onPostExecute(Long result) {
		// showDialog("Downloaded " + result + " bytes");
	}

	private String getServerData(String returnString) {

		InputStream is = null;

		String result = "";
		// the year data to send
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("year", "1970"));

		// http post
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(returnString);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());
		}

		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}
		// parse json data
		//		try {
		//			JSONArray jArray = new JSONArray(result);
		//			for (int i = 0; i < jArray.length(); i++) {
		//				// JSONObject json_data = jArray.getJSONObject(i);
		//				// Log.d("log_tag","id: "+json_data.getInt("id")+
		//				// ", name: "+json_data.getString("name")+
		//				// ", sex: "+json_data.getInt("sex")+
		//				// ", birthyear: "+json_data.getInt("birthyear")
		//				// );
		//				// Get an output to the screen
		//				returnString += "\n\t" + jArray.getJSONArray(i);
		//			}
		//		} catch (JSONException e) {
		//			Log.e("log_tag", "Error parsing data " + e.toString());
		//		}
		return result;
	}
}

class PushNoteTask extends AsyncTask<String, Integer, String> {
	protected String doInBackground(String... urls) {
		return getServerData(urls[0]);
	}

	protected void onProgressUpdate(Integer... progress) {
		// setProgressPercent(progress[0]);
	}

	protected void onPostExecute(Long result) {
		// showDialog("Downloaded " + result + " bytes");
	}

	private String getServerData(String returnString) {

		// InputStream is = null;

		// String result = "";

		// String android_id =
		// Secure.getString(getContext().getContentResolver(),
		// Secure.ANDROID_ID);
		MCrypt mcrypt = new MCrypt();
		String encrypted;
		try {
			encrypted = MCrypt.bytesToHex(mcrypt.encrypt("idblabrzebtg"));
		} catch (Exception e1) {
			e1.printStackTrace();
			return "";
		}

		try {			
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(returnString + "?p=1&i=0&t=t&h=" + encrypted);

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));

			String output;
			String output2;
			output2 = "Output from Server .... \n";
			while ((output = br.readLine()) != null) {
				output2 += output + "\n";
			}

			httpClient.getConnectionManager().shutdown();
			return output2;		
			//			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			//			HttpResponse response = httpclient.execute(httppost);
			//			HttpEntity entity = response.getEntity();
			// is = entity.getContent();

		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());
			return "";
		}

		// //convert response to string
		// try{
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(is,"iso-8859-1"),8);
		// StringBuilder sb = new StringBuilder();
		// String line = null;
		// while ((line = reader.readLine()) != null) {
		// sb.append(line + "\n");
		// }
		// is.close();
		// result=sb.toString();
		// }catch(Exception e){
		// Log.e("log_tag", "Error converting result "+e.toString());
		// }
		// //parse json data
		// try{
		// JSONArray jArray = new JSONArray(result);
		// for(int i=0;i<jArray.length();i++){
		// // JSONObject json_data = jArray.getJSONObject(i);
		// // Log.d("log_tag","id: "+json_data.getInt("id")+
		// // ", name: "+json_data.getString("name")+
		// // ", sex: "+json_data.getInt("sex")+
		// // ", birthyear: "+json_data.getInt("birthyear")
		// // );
		// //Get an output to the screen
		// returnString += "\n\t" + jArray.getJSONArray(i);
		// }
		// }catch(JSONException e){
		// Log.e("log_tag", "Error parsing data "+e.toString());
		// }
		//return output2;
	}
}