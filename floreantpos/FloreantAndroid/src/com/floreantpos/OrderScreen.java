<<<<<<< HEAD
package com.floreantpos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.content.Intent;
//import android.widget.*;

public class OrderScreen extends Activity {@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.orderscreenlayout);
	//com.floreantpos.DBConnect.main(null);
	//com.floreantpos.TestDatabase.main(null);
	//TextView myTextView2 = (TextView) findViewById(R.id.FooPrint);
	//myTextView2.setText("moooooooo");
	
	
	Button BeveragesButton = (Button)findViewById(R.id.Beverages);
	
	BeveragesButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(OrderScreen.this, Beverages.class);
          startActivity(intent);
        }

      });
}
}
=======
package com.floreantpos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.content.Intent;
//import android.widget.*;

public class OrderScreen extends Activity {@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.orderscreenlayout);
	//com.floreantpos.DBConnect.main(null);
	//com.floreantpos.TestDatabase.main(null);
	//TextView myTextView2 = (TextView) findViewById(R.id.FooPrint);
	//myTextView2.setText("moooooooo");
	
	
	Button BeveragesButton = (Button)findViewById(R.id.Beverages);
	BeveragesButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(OrderScreen.this, Beverages.class);
          startActivity(intent);
        }

      });
	
	Button Breakfast = (Button)findViewById(R.id.Breakfast);
	Breakfast.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(OrderScreen.this, BreakFast.class);
          startActivity(intent);
        }

      });
	
	Button lunchButton = (Button)findViewById(R.id.Lunch);
	lunchButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(OrderScreen.this, Lunch.class);
          startActivity(intent);
        }

      });
	
	Button dinnerButton = (Button)findViewById(R.id.Dinner);
	dinnerButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          Intent intent = new Intent(OrderScreen.this, Dinner.class);
          startActivity(intent);
        }

      });
}
}
>>>>>>> ac066869d71bc12ab0b61504323c9dbfd19ff780
