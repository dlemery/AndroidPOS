package com.floreantpos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TableScreen extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tablescreenlayout);
	
	Button ViewMenuButton = (Button)findViewById(R.id.MenuButton);
	Button PersonalButton = (Button)findViewById(R.id.PersonalBill);
	Button GroupButton = (Button)findViewById(R.id.GroupBill);
	Button RefreshButton = (Button)findViewById(R.id.refresh);
	
	ViewMenuButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(TableScreen.this, OrderScreen.class);
          startActivity(intent);
        }

      });
	
	PersonalButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(TableScreen.this, PersonalBill.class);
          startActivity(intent);
        }

      });
	
	GroupButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(TableScreen.this, GroupBill.class);
          startActivity(intent);
        }

      });
	
	

	com.floreantpos.DBConnect.tableList("tablemembers.php", TableLogin.gettable(), null);
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
    
    ListAdapter listAdapter = new SimpleAdapter(this, list, R.layout.tablemember, columns, renderTo);
    ListView av = (ListView)findViewById(R.id.TableList);
    av.setAdapter(listAdapter);
    
    RefreshButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
        	
          Intent intent = new Intent(TableScreen.this, TableScreen.class);
          startActivity(intent);
        }

      });
	

}

}
