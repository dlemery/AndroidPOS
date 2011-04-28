package com.floreantpos;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;
import android.widget.*;

public class BreakFast extends ListActivity {@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		String result = new String("");
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.beverageslayout);
		com.floreantpos.DBConnect.dataConnect("breakfast.php");
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	    
		Log.i("log_tag", DBConnect.FullResult);
		try{
	  	  JSONArray jArray = new JSONArray(DBConnect.FullResult);
	  	  //JSONObject json_data = jArray.getJSONObject(1);
	      //result = new String(json_data.getString("PRICE"));
	            
	      for(int i=1;i<jArray.length();i++){
	    	  HashMap<String, String> item = new HashMap<String, String>();
	              JSONObject json_data = jArray.getJSONObject(i);
	              item.put("name", json_data.getString("NAME"));
	              item.put("price", json_data.getString("PRICE"));    
	              list.add(item);
	              
	             // result = new String(json_data.getString("NAME") + " " + json_data.getString("PRICE"));
	      }    

	    }

	    catch(JSONException e){

	            Log.e("log_tag", "Error parsing data "+e.toString());
	            result = new String("Error");

	    }
	    
	    String[] columns = new String[] { "name", "price"};
	    int[] renderTo = new int[] { R.id.name, R.id.price};
	    
	    ListAdapter listAdapter = new SimpleAdapter(this, list, R.layout.breakfastitem, columns, renderTo);

	    setListAdapter(listAdapter);
	    
	    
	    
	    //TextView myTextView = (TextView) findViewById(R.id.beveragelist);
		//myTextView.setText(result);
		
	}

}
