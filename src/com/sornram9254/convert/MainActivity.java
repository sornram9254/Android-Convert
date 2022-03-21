package com.sornram9254.convert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageButton btn_distance;
	ImageButton btn_temperature;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Distance();
		Temperature();
	}

	public void Distance() {
		btn_distance = (ImageButton)findViewById(R.id.btnDistance);
		btn_distance.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goDistance = new Intent(getApplicationContext(),classDistance.class);
				startActivity(goDistance);
			}});
	}
	public void Temperature() {
		btn_temperature = (ImageButton)findViewById(R.id.btnTemperature);
		btn_temperature.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goTemperature = new Intent(getApplicationContext(),classTemperature.class);
				startActivity(goTemperature);
			}});
	}
	
	private static long back_pressed;
	@Override
	public void onBackPressed() // ref: http://androidsnippets.com/double-back-press-to-exit
	{
		if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
		else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
		back_pressed = System.currentTimeMillis();
	}
}
