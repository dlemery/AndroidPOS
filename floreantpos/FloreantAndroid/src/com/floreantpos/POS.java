<<<<<<< HEAD
package com.floreantpos;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.*;
import android.widget.*;

public class POS extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button ConnectButton = (Button)findViewById(R.id.Connect);

        ConnectButton.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            Intent intent = new Intent(POS.this, TableLogin.class);
            startActivity(intent);
          }

        });
    }
=======
package com.floreantpos;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.*;
import android.widget.*;

public class POS extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button ConnectButton = (Button)findViewById(R.id.Connect);

        ConnectButton.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            Intent intent = new Intent(POS.this, TableLogin.class);
            startActivity(intent);
          }

        });
    }
>>>>>>> ac066869d71bc12ab0b61504323c9dbfd19ff780
}