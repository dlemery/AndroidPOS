package com.floreantpos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PersonalBill extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		com.floreantpos.DBConnect.tableList("tablemembers.php", TableLogin.gettable());
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		Log.i("log_tag", DBConnect.FullResult);
		DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
		String dueamount;
		try{
	  	  JSONArray jArray = new JSONArray(DBConnect.FullResult);     
	      for(int i=1;i<jArray.length();i++){
	    	  HashMap<String, String> item = new HashMap<String, String>();
	              JSONObject json_data = jArray.getJSONObject(i);
	              item.put("Person", json_data.getString("GUEST_NAME"));
	              
	              dueamount = priceFormatter.format(json_data.getDouble("DUE_AMOUNT"));
	              item.put("CurrentTotal", dueamount);    
	              list.add(item);
	             
	      }    

	    }

	    catch(JSONException e){

	            Log.e("log_tag", "Error parsing data "+e.toString());

	    }
	    
	    String[] columns = new String[] { "Person", "CurrentTotal"};
	    int[] renderTo = new int[] { R.id.Person, R.id.CurrentTotal};
	    
	    ListAdapter listAdapter = new SimpleAdapter(this, list, R.layout.billitem, columns, renderTo);
	    ListView av = (ListView)findViewById(R.id.TableList);
	    av.setAdapter(listAdapter);
		
	}

}

