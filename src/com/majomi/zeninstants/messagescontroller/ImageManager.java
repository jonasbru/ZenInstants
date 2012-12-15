package com.majomi.zeninstants.messagescontroller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.majomi.zeninstants.AppLog;
import com.majomi.zeninstants.R;

public class ImageManager {
	private Context context = null;
	private int maxCacheImages = 5;
	private String cachePrefix = "cimg";
	private String internalPrefix = "iimg";

	//********** Singleton *************
	static private ImageManager imageManager = null;

	static public ImageManager getImageManager() {
		if(imageManager == null) {
			imageManager = new ImageManager();
		}	
		return imageManager;
	}

	private ImageManager() {	
	}
	//******** END Singleton ***********

	public Context getContext() {
		return context;
	}

	public void setContext(Context contextt) {
		context = contextt;
	}

	/******************** General *************************************************/
	public String moveToCache (String internalFilePath){
		File internalFile = new File(internalFilePath);
		File f = null;

		// Make some space for the file in the cache
		removeExcedentCacheData();

		try {
			f = File.createTempFile(cachePrefix, null, context.getCacheDir());
			copy(internalFile,f);
			deleteData(internalFilePath);
		} catch (IOException e) {
			if (f != null)
				AppLog.logError("Copy file from: " + internalFile.getAbsolutePath() + " to " + f.getAbsolutePath() );
			else
				AppLog.logError("Impossible to create file in: " + context.getCacheDir().getAbsolutePath());
			e.printStackTrace();
		}

		if(f != null){
			return f.getAbsolutePath();
		}else{
			return null;
		}
	}

	public Boolean isAnInternalFile(String file){
		return file.contains(internalPrefix);
	}
	
	public Bitmap loadDataAsImage(String path){
		return BitmapFactory.decodeFile(path);
	}

	public Boolean deleteData(String path){
		File file = new File(path);
		AppLog.logString("Delete file :" + path);
		return file.delete();
	}
	/******************** Internal Storage *************************************************/

	public File[] getInternalImageFileList(){
		FilenameFilter imagefilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				return filename.contains("img");
			}
		};
		return context.getFilesDir().listFiles(imagefilter);
	}

	public void clearInternal(){
		File[] list = getAllInternalFileList();
		for(int i = 0; i < list.length; i++)
			deleteData(list[i].getAbsolutePath());
	}

	public long getInternalSpace(){
		long size = 0;
		File[] list = getAllInternalFileList();
		for(int i = 0; i < list.length;i++){
			size += list[i].length();
		}
		return size;
	}

	public String saveInternalDataFromURL(String url){
		byte[] img = getDataByURL(url);
		if(img != null)
			return saveInternalData(img);
		AppLog.logWarningString("Data not found (from url: " + url);
		return null;
	}
	
	private String saveInternalData(byte[] bytes){
		return saveData(bytes,context.getFilesDir(), internalPrefix);
	}

	private String saveInternalData(InputStream is){
		return saveInternalData(readBytes(is));
	}

	private File[] getAllInternalFileList(){
		return context.getFilesDir().listFiles();
	}
	/******************** Cache Storage *************************************************/

	public String saveCacheData(Bitmap img){
		// Make some space for the file in the cache
		removeExcedentCacheData();
		
		return saveData(img, context.getCacheDir(), cachePrefix);
	}

	public File[] getAllCacheFileList(){
		return context.getCacheDir().listFiles();
	}

	public File[] getCacheImageFileList(){
		FilenameFilter imagefilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				return filename.contains("img");
			}
		};
		return context.getCacheDir().listFiles(imagefilter);
	}

	public void clearCache(){
		File[] list = getAllCacheFileList();
		for(int i = 0; i < list.length; i++)
			deleteData(list[i].getAbsolutePath());
	}

	public long getCacheSpace(){
		long size = 0;
		File[] list = getAllCacheFileList();
		for(int i = 0; i < list.length;i++){
			size += list[i].length();
		}

		return size;
	}
	
	private void removeExcedentCacheData(){
		// Make some space for the file in the cache
		int nbFiles = getAllCacheFileList().length;
		for (int i=0; i < nbFiles - maxCacheImages + 1 ; i++)
			getCacheOlderModifiedImage().delete();
	}

	private File getCacheOlderModifiedImage (){
		File[] files = getAllCacheFileList();
		if (files.length == 0) {
			return null;
		}

		File oldModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (oldModifiedFile.lastModified() > files[i].lastModified()) {
				oldModifiedFile = files[i];
			}
		}

		return oldModifiedFile;
	}

	/******************** Data utils *************************************************/

	private String saveData(byte[] bytes, File dir, String prefix){
		String fileName = new String();
		try {
			File f = File.createTempFile(prefix, null, dir);
			FileOutputStream fos = new FileOutputStream(f); //openFileOutput("plop", Context.MODE_PRIVATE);
			fos.write(bytes);
			fos.close();
			fileName = f.getAbsolutePath();
			AppLog.logString("Files saved : " + fileName);
		} catch (IOException e) {
			AppLog.logError("Can't save data in: " + fileName);
			e.printStackTrace();
		}
		return fileName;
	}
	
	private String saveData(Bitmap bmp, File dir, String prefix){
		String fileName = null;
		try {
			File f = File.createTempFile(prefix, null,dir);
			FileOutputStream out = new FileOutputStream(f);
			bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
			fileName = f.getAbsolutePath();
			AppLog.logString("Image saved :" + fileName);
		} catch (Exception e) {
			AppLog.logError("Image not saved :" + fileName);
			e.printStackTrace();
		}
		return fileName;
	}
	
	

	private byte[] readBytes(InputStream inputStream) {
		// this dynamically extends to take the bytes you read
		ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

		// this is storage overwritten on each iteration with bytes
		int bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];

		// we need to know how may bytes were read to write them to the byteBuffer
		int len = 0;
		try {
			while ((len = inputStream.read(buffer)) != -1) {
				byteBuffer.write(buffer, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			AppLog.logError("Can t read the input stream" + inputStream.toString());
			e.printStackTrace();
			return null;
		}

		// and then we can return your byte array.
		return byteBuffer.toByteArray();
	}

	private byte[] getDataByURL(String url){
		try {
			InputStream is = (InputStream) new URL(url).getContent();
			return readBytes(is);
		} catch (IOException e) {
			AppLog.logError("Can't load :" + url);
			e.printStackTrace();
		}
		return null;
	}

	private void copy(File src, File dst) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);

		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	/**************************** DEBUG TO REMOVE ********************************************/	
	public String saveDemoImage(){
		//saveInternalData(InputStream is)
		InputStream is = context.getResources().openRawResource(R.drawable.video_icon);
		return saveInternalData(is);//CacheData(readBytes(is));
	}

	private void DisplayListFile(String[] f){
		for(int i = 0; i < f.length;i++){
			AppLog.logString("File: " + f[i]);
		}

	}
	private void DisplayListFile(File[] f){
		for(int i = 0; i < f.length;i++){
			AppLog.logString("File: " + f[i].getAbsolutePath());
		}

	}

	public int getMaxCacheImages() {
		return maxCacheImages;
	}

	public void setMaxCacheImages(int maxCacheImages) {
		this.maxCacheImages = maxCacheImages;
	}
}
