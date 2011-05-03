package com.floreantpos;
import java.net.URL;
import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TableScreen extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tablescreenlayout);
	
	Button ViewMenuButton = (Button)findViewById(R.id.MenuButton);
	
	ViewMenuButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(TableScreen.this, OrderScreen.class);
          startActivity(intent);
        }

      });
	

}

}
