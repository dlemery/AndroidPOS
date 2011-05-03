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

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TestDatabase extends Activity {
    private static InputStream is = null;
    private static String foo;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testdatabase);
        this.main(null);
        TextView myTextView2 = (TextView) findViewById(R.id.foojobby);
    	myTextView2.setText(foo);
        
    }
    public static void main(String[] args) {
       
          String result = "";    
          //the data to send  
          ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
       
          //http post
          try{
                  HttpClient httpclient = new DefaultHttpClient();
                  HttpPost httppost = new HttpPost("http://192.168.1.106/test.php");
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
                  result=sb.toString();
      
          }catch(Exception e){
                  Log.e("log_tag", "Error converting result "+e.toString());
          }
          //parse json data
      
          try{
        	  JSONArray jArray = new JSONArray(result);
        	  JSONObject json_data = jArray.getJSONObject(1);
              foo = new String(json_data.getString("GUEST_NAME"));
                  
                /* for(int i=0;i<jArray.length();i++){
                          JSONObject json_data = jArray.getJSONObject(i);
                          foo = new String(json_data.getString("Guest_Name"));
                          //foo = new String("id: "+json_data.getInt("User_ID")+", first name: "+json_data.getString("User_First_Name")+", last name: "+json_data.getInt("User_Last_Name"));
                          /*Log.i("log_tag","id: "+json_data.getInt("User_ID")+
                                  ", first name: "+json_data.getString("User_First_Name")+
                                  ", last name: "+json_data.getInt("User_Last_Name")
                          );*/
      
                 
      
          }
      
          catch(JSONException e){
      
                  Log.e("log_tag", "Error parsing data "+e.toString());
      
          }

}
}