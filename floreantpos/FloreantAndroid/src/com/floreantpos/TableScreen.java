<<<<<<< HEAD
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

public class TableScreen extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tablescreenlayout);
	
	//Button JoinTableButton = (Button)findViewById(R.id.JoinTable);
	
   // JoinTableButton.setOnClickListener(new View.OnClickListener() {

     
      /*public void onClick(View view) {
        Intent intent = new Intent(TableScreen.this, OrderScreen.class);
        startActivity(intent);
      }

    });*/

}

}
=======
package com.floreantpos;
import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.content.Intent;
//import android.view.*;
//import android.widget.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TableScreen extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tablescreenlayout);
	//com.floreantpos.DBConnect.dataPush();
	
	//Button JoinTableButton = (Button)findViewById(R.id.JoinTable);
	
   // JoinTableButton.setOnClickListener(new View.OnClickListener() {

     
      /*public void onClick(View view) {
        Intent intent = new Intent(TableScreen.this, OrderScreen.class);
        startActivity(intent);
      }

    });*/
	
	
	
	                
	         
	// Send Data To Page
	/*URL url = new URL(“http://10.99.11.35/jointable.php”);
	URLConnection conn = url.openConnection();
	conn.setDoOutput(true);
	OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	wr.write(data);
	wr.flush();*/
	
	

}

}
>>>>>>> ac066869d71bc12ab0b61504323c9dbfd19ff780
