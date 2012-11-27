package com.majomi.zeninstants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	//public static final String KEY_121 = "http://xx.xx.xxx.xxx/hellomysql/mysqlcon.php"; //i use my real ip here
	public static final String KEY_121 = "http://192.168.1.138/zenManagement/con.php"; //i use my real ip here
	TextView txt;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a crude view - this should really be set via the layout resources 
        // but since its an example saves declaring them in the XML. 
        LinearLayout rootLayout = new LinearLayout(getApplicationContext()); 
        txt = new TextView(getApplicationContext()); 
        rootLayout.addView(txt); 
        setContentView(rootLayout); 

        // Set the text and call the connect function. 
        txt.setText("Connecting...");
      //call the method to run the data retreival
        AsyncTask<String, Integer, String> d = new DownloadFilesTask().execute(KEY_121);
        try {
			txt.setText(d.get() + "\n CACA");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        //txt.setText(getServerData(KEY_121)); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}

class DownloadFilesTask extends AsyncTask<String, Integer, String> {
    protected String doInBackground(String... urls) {
//        int count = urls.length;
//        long totalSize = 0;
//        for (int i = 0; i < count; i++) {
//            publishProgress((int) ((i / (float) count) * 100));
//            // Escape early if cancel() is called
//            if (isCancelled()) break;
//        }
//        return totalSize;
    	  return getServerData(urls[0]);
    }

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        //showDialog("Downloaded " + result + " bytes");
    }
    
    private String getServerData(String returnString) {
 	   
 	   InputStream is = null;
 	   
 	   String result = "";
 	    //the year data to send
 	    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
 	    nameValuePairs.add(new BasicNameValuePair("year","1970"));

 	    //http post
 	    try{
 	            HttpClient httpclient = new DefaultHttpClient();
 	            HttpPost httppost = new HttpPost(returnString);
 	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 	            HttpResponse response = httpclient.execute(httppost);
 	            HttpEntity entity = response.getEntity();
 	            is = entity.getContent();

 	    }catch(Exception e){
 	            Log.e("log_tag", "Error in http connection "+e.toString());
 	    }

 	    //convert response to string
 	    try{
 	            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
 	            StringBuilder sb = new StringBuilder();
 	            String line = null;
 	            while ((line = reader.readLine()) != null) {
 	                    sb.append(line + "\n");
 	            }
 	            is.close();
 	            result=sb.toString();
 	    }catch(Exception e){
 	            Log.e("log_tag", "Error converting result "+e.toString());
 	    }
 	    //parse json data
 	    try{
 	            JSONArray jArray = new JSONArray(result);
 	            for(int i=0;i<jArray.length();i++){
 	                    JSONObject json_data = jArray.getJSONObject(i);
 	                    Log.d("log_tag","id: "+json_data.getInt("id")+
 	                            ", name: "+json_data.getString("name")+
 	                            ", sex: "+json_data.getInt("sex")+
 	                            ", birthyear: "+json_data.getInt("birthyear")
 	                    );
 	                    //Get an output to the screen
 	                    returnString += "\n\t" + jArray.getJSONObject(i);
 	            }
 	    }catch(JSONException e){
 	            Log.e("log_tag", "Error parsing data "+e.toString());
 	    }
 	    return returnString;
 	}
}
