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
import android.widget.TextView;

public class GroupBill extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.groupbilllayout);
		com.floreantpos.DBConnect.tableList("groupbill.php", TableLogin.gettable(), null);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		Log.i("log_tag", DBConnect.FullResult);
		DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
		String price;
		double TotalAmount = 0;
		try{
	  	  JSONArray jArray = new JSONArray(DBConnect.FullResult);     
	      for(int i=1;i<jArray.length();i++){
	    	  HashMap<String, String> item = new HashMap<String, String>();
	              JSONObject json_data = jArray.getJSONObject(i);
	              item.put("Item", json_data.getString("ITEM_NAME"));
	              TotalAmount = TotalAmount + json_data.getDouble("TOTAL_PRICE");
	              price = priceFormatter.format(json_data.getDouble("TOTAL_PRICE"));
	              item.put("Price", price);    
	              list.add(item);
	             
	      }    

	    }

	    catch(JSONException e){

	            Log.e("log_tag", "Error parsing data "+e.toString());

	    }
	    
	    String[] columns = new String[] { "Item", "Price"};
	    int[] renderTo = new int[] { R.id.Item, R.id.Price};
	    
	    ListAdapter listAdapter = new SimpleAdapter(this, list, R.layout.billitem, columns, renderTo);
	    ListView av = (ListView)findViewById(R.id.grouplist);
	    av.setAdapter(listAdapter);
	    DecimalFormat pricey = new DecimalFormat("$#0.00");
        String totalamount = pricey.format(TotalAmount);
        double TipAmount15 = TotalAmount*.15;
        DecimalFormat tipey15 = new DecimalFormat("$#0.00");
        String tipamount15 = pricey.format(TipAmount15);
        double TipAmount20 = TotalAmount*.20;
        DecimalFormat tipey20 = new DecimalFormat("$#0.00");
        String tipamount20 = pricey.format(TipAmount20);
	    //String totalamount = Double.toString(TotalAmount);
	    
	    TextView gtotal = (TextView) findViewById(R.id.grouptotal);
	    
	    gtotal.setText("Total:  " + totalamount + "\n" + "15% Tip:  " + tipamount15 + "\n" + "20% Tip:  " + tipamount20);
	}
	
	
}
