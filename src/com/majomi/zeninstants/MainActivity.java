package com.majomi.zeninstants;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	//public static final String KEY_121 = "http://xx.xx.xxx.xxx/hellomysql/mysqlcon.php"; //i use my real ip here
	public static final String KEY_121 = "http://192.168.1.138/zenManagement/index.php"; //i use my real ip here
	TextView txt;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.activity_main);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}


