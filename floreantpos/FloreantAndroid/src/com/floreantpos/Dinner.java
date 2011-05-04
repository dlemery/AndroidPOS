package com.floreantpos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Dinner extends ListActivity{@Override

	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	//setContentView(R.layout.beverageslayout);
	com.floreantpos.DBConnect.dataConnect("dinner.php");
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
              DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
              String price = priceFormatter.format(json_data.getDouble("PRICE"));
              item.put("price", "Price: $" + price);    
              list.add(item);
              
             // result = new String(json_data.getString("NAME") + " " + json_data.getString("PRICE"));
      }    

    }

    catch(JSONException e){

            Log.e("log_tag", "Error parsing data "+e.toString());

    }
    
    String[] columns = new String[] { "name", "price"};
    int[] renderTo = new int[] { R.id.name, R.id.price};
    
    ListAdapter listAdapter = new SimpleAdapter(this, list, R.layout.dinneritem, columns, renderTo);

    setListAdapter(listAdapter);
    
    
    
    //TextView myTextView = (TextView) findViewById(R.id.beveragelist);
	//myTextView.setText(result);
	
}
protected void onListItemClick(ListView l, View v, int position, long id)
{
	super.onListItemClick(l, v, position, id);
	int nameStart = getListView().getItemAtPosition(position).toString().indexOf("name=")+5;
	int nameEnd = getListView().getItemAtPosition(position).toString().indexOf("}");
	final String foodName = new String(getListView().getItemAtPosition(position).toString().substring(nameStart, nameEnd));
	
	AlertDialog foo = new AlertDialog.Builder(Dinner.this).create();
	foo.setTitle("Food");
	foo.setMessage(foodName);
	foo.setButton("Buy", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			if(DBConnect.response.equalsIgnoreCase("1"))
			{
				DBConnect.sendorder(TableLogin.gettable(), "DINNER", TableLogin.getNickname(), foodName);
				if(DBConnect.Orderresponse.equalsIgnoreCase("1"))
				{
					AlertDialog success = new AlertDialog.Builder(Dinner.this).create();
					success.setTitle("Purchased");
					success.setMessage(foodName + " purchased for " + TableLogin.getNickname());
					success.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {        			
	        			
						}});
					success.show();
				}
				else
				{
					AlertDialog error = new AlertDialog.Builder(Dinner.this).create();
					error.setTitle("Error");
					error.setMessage("Error ordering.  Please contact server.");
					error.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {        			
	        			
						}});
					error.show();
					
				}
			}
			else
			{
				AlertDialog badlogin = new AlertDialog.Builder(Dinner.this).create();
	        	badlogin.setTitle("Login");
	        	badlogin.setMessage("You must be at a table to order!");
	        	badlogin.setButton("OK", new DialogInterface.OnClickListener() {
	        		public void onClick(DialogInterface dialog, int which) {
	        				        			
	        		}});
	        	badlogin.show();
			}			
		}});
	foo.setButton2("Cancel", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
		}});
	foo.show();
}
	
}
