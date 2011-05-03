package com.floreantpos;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.content.Intent;
//import android.view.*;
//import android.widget.*;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TableLogin extends Activity {
	private static String table;
	private static String pin;
	private static String nickname;
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tableloginlayout);
	
	Button ViewMenuButton = (Button)findViewById(R.id.ViewMenu);
	Button JoinTableButton = (Button)findViewById(R.id.JoinTable);
	final EditText TableNumber = (EditText)findViewById(R.id.TableNum);
	final EditText PinNumber = (EditText)findViewById(R.id.PinNum);
	final EditText NickName = (EditText)findViewById(R.id.Name);
	
    JoinTableButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
    	table = new String(TableNumber.getText().toString());
    	pin = new String(PinNumber.getText().toString());
    	nickname = new String(NickName.getText().toString());
        //Intent intent = new Intent(TableLogin.this, TableScreen.class);
    	com.floreantpos.DBConnect.sendtable(table, pin, nickname);
    	Intent intent = new Intent(TableLogin.this, TableScreen.class);
    	//com.floreantpos.DBConnect.dataConnect("beverages.php");
        if (DBConnect.response.equals("1"))
        {
        	startActivity(intent);
        }
        else
        {
        	AlertDialog badlogin = new AlertDialog.Builder(TableLogin.this).create();
        	badlogin.setTitle("Login");
        	badlogin.setMessage("Invalid Login! Please try again.");
        	badlogin.setButton("OK", new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int which) {
        			TableNumber.setText("");
        			PinNumber.setText("");
        			
        		}});
        	badlogin.show();
        	
        }
        
      }

    });
    
    ViewMenuButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(TableLogin.this, OrderScreen.class);
          startActivity(intent);
        }

      });
    
    

}
	public static String gettable()
	{
		return table;
	}
	public static String getNickname()
	{
		return nickname;
	}

}