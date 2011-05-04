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
		com.floreantpos.DBConnect.tableList("groupbill.php", TableLogin.gettable(), TableLogin.getNickname());
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		Log.i("log_tag", DBConnect.FullResult);
		DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
		String price;
		double itemPrice = 0;
		double taxAmt = 0;
		double TotalAmount = 0;
		try{
	  	  JSONArray jArray = new JSONArray(DBConnect.FullResult);     
	      for(int i=1;i<jArray.length();i++){
	    	  HashMap<String, String> item = new HashMap<String, String>();
	              JSONObject json_data = jArray.getJSONObject(i);
	              item.put("Item", json_data.getString("ITEM_NAME"));
	              itemPrice = json_data.getDouble("ITEM_PRICE");
	              taxAmt = json_data.getDouble("TAX_AMOUNT");
	              TotalAmount = TotalAmount + itemPrice + taxAmt;
	              price = priceFormatter.format(itemPrice + taxAmt);
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
        String tipamount15 = pricey.format(TipAmount15);
        double TipAmount20 = TotalAmount*.20;
        String tipamount20 = pricey.format(TipAmount20);
	    
	    TextView gtotal = (TextView) findViewById(R.id.grouptotal);
	    
	    gtotal.setText("Total:  " + totalamount + "\n" + "15% Tip:  " + tipamount15 + "\n" + "20% Tip:  " + tipamount20);
	}
	
	
}
