package com.floreantpos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
//import android.content.Intent;
//import android.widget.*;

public class OrderScreen extends Activity {@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.orderscreenlayout);
	
	TextView myTextView = (TextView) findViewById(R.id.FooPrint);
	myTextView.setText(com.floreantpos.DBConnect.foo);
	//myTextView.setText("FooJobby");

/*	TextView myTextView2 = (TextView) findViewById(R.id.TextViewTest2);
	myTextView2.setText(com.floreantpos.TableLogin.pin);*/
}
}
