package com.example.dexencryptdemo;
//import com.example.dexencryptdemo.encrypt.ByteCrypt;

import com.example.dexencryptdemo.encrypt.IClass;

//import com.example.dexencryptdemo.encrypt.ByteCrypt;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hello.hello1();
		IClass i = new IClass(this.getApplicationContext());
		
		//String a = ByteCrypt.getString("yangzheng21333".getBytes());
//        Toast.makeText(this.getApplicationContext(), a, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}