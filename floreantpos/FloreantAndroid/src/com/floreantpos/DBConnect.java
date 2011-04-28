package com.floreantpos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

import android.util.Log;

public class DBConnect {
	public static String FullResult;
    private static InputStream is = null;
  
    public static void dataConnect(String page) {
       
          //String result = "";    
          //the data to send  
          ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
       
          //http post
          try{
                  HttpClient httpclient = new DefaultHttpClient();
                  HttpPost httppost = new HttpPost("http://10.66.17.70/" + page);
                  httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                  HttpResponse response = httpclient.execute(httppost);
                  HttpEntity entity = response.getEntity();
                  is = entity.getContent();
          }catch(Exception e){
                  Log.e("log_tag", "Error in http connection "+e.toString());     
          }
      
          //convert response to string
      
          try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(is ,"iso-8859-1"),8);
                  StringBuilder sb = new StringBuilder(); 
                  String line = null;
                  while ((line = reader.readLine()) != null) {
                          sb.append(line + "\n");
                  }
                  is.close();
                  FullResult=sb.toString();
      
          }catch(Exception e){
                  Log.e("log_tag", "Error converting result "+e.toString());
          }
          //parse json data
      
          

}
}