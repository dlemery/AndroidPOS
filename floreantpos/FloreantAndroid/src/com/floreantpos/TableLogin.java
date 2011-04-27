package com.floreantpos;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.content.Intent;
//import android.view.*;
//import android.widget.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TableLogin extends Activity {
	public static String table;
	public static String pin;
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tableloginlayout);
	
	Button ViewMenuButton = (Button)findViewById(R.id.ViewMenu);
	Button JoinTableButton = (Button)findViewById(R.id.JoinTable);
	final EditText TableNumber = (EditText)findViewById(R.id.TableNum);
	final EditText PinNumber = (EditText)findViewById(R.id.PinNum);
	
    JoinTableButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
    	table = new String(TableNumber.getText().toString());
    	pin = new String(PinNumber.getText().toString());
        Intent intent = new Intent(TableLogin.this, TableScreen.class);
        startActivity(intent);
      }

    });
    
    ViewMenuButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(TableLogin.this, TestDatabase.class);
          startActivity(intent);
        }

      });

}

}