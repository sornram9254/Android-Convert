package com.sornram9254.convert;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class classTemperature extends Activity {

	Button btn_temperature_back;
	Button btn_convert_temperature;
	Button btn_clear;
	EditText input;
	
	RadioButton radio_C_F;
	RadioButton radio_F_C;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperature);
		back();
		
		input = (EditText)findViewById(R.id.edittxt_temperature);
		radio_C_F = (RadioButton)findViewById(R.id.radioC2F);
		radio_F_C = (RadioButton)findViewById(R.id.radioF2C);

		btn_convert_temperature = (Button)findViewById(R.id.btnConvertTemperature);
		btn_convert_temperature.setOnClickListener(new View.OnClickListener() {
			  public void onClick(View v) {
		 		   // TODO Auto-generated method stub
				  float value = Float.valueOf(input.getText().toString());
				  if(radio_C_F.isChecked()){
					  input.setText("value: " + String.format("%.2f", convertC2F(value)) + " Fahrenheit");
				  }else {
					  input.setText("value: " + String.format("%.2f", convertF2C(value)) + " Celsius");
				  }
				  btn_convert_temperature.setEnabled(false);
			  }
		});
		clear();
	}
	
	private float convertF2C(float fahrenheit) {
	    return ((fahrenheit - 32) * 5 / 9);
	}
	
	private float convertC2F(float celsius) {
	    return ((celsius * 9) / 5) + 32;
	}
	
	public void clear(){
		btn_clear = (Button)findViewById(R.id.btnClear);
		btn_clear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				input.setText("");
				btn_convert_temperature.setEnabled(true);
			}
		});
	}
	
	public void back(){
		btn_temperature_back = (Button)findViewById(R.id.btnTemperatureBack);
		btn_temperature_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
