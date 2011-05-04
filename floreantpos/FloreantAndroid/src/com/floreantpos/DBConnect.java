package com.floreantpos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import android.util.Log;

public class DBConnect {
	public static String FullResult;
	public static String response = new String("");
	public static String Orderresponse = new String("");
    private static InputStream is = null;
    //private static OutputStream os = null;
    
    public static void dataConnect(String page) {
       
          //String result = "";    
          //the data to send  
          ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
       
          //http post
          try{
                  HttpClient httpclient = new DefaultHttpClient();
                  HttpPost httppost = new HttpPost("http://10.99.10.222/" + page);
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
    
    }
    
    
  
    
    public static void sendtable(String tablenumber, String pin, String nickname)
    {
    	 	
    		try {
    	        HttpClient client = new DefaultHttpClient();  
    	        String postURL = "http://10.99.10.222/jointable.php";
    	        HttpPost post = new HttpPost(postURL);
    	            List<NameValuePair> params = new ArrayList<NameValuePair>();
    	            params.add(new BasicNameValuePair("TABLE_NUMBER", tablenumber));
    	            params.add(new BasicNameValuePair("PIN", pin));
    	            params.add(new BasicNameValuePair("GUEST_NAME", nickname));
    	            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
    	            post.setEntity(ent);
    	            HttpResponse responsePOST = client.execute(post);  
    	            HttpEntity resEntity = responsePOST.getEntity();
    	            response = EntityUtils.toString(resEntity);
    	            if (resEntity != null) {    
    	               // Log.i("RESPONSE",response);
    	            }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    }
    public static void sendorder(String tablenumber, String groupname, String nickname, String item)
    {
    	Orderresponse = "";
    	try {
    		
    		
	        HttpClient client = new DefaultHttpClient();  
	        String postURL = "http://10.99.10.222/addtoorder.php";
	        HttpPost post = new HttpPost(postURL);
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("TABLE_NUMBER", tablenumber));
	            params.add(new BasicNameValuePair("GROUP_NAME", groupname));
	            params.add(new BasicNameValuePair("NAME", item));
	            params.add(new BasicNameValuePair("GUEST_NAME", nickname));
	            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
	            post.setEntity(ent);
	            HttpResponse responsePOST = client.execute(post);
	            HttpEntity resEntity = responsePOST.getEntity();
	            Orderresponse = EntityUtils.toString(resEntity);
	            if (resEntity != null) {    
	                Log.i("RESPONSE",Orderresponse);
	            }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
    
    public static void tableList(String page, String tablenumber) {
     
        //http post
        try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://10.99.10.222/" + page);
                List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("TABLE_NUMBER", tablenumber));
                UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
	            httppost.setEntity(ent);
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
  
  }

 }    
    


  
