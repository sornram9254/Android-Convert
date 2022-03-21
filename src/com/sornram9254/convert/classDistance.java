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

public class classDistance extends Activity {

	Button btn_distance_back;
	Button btn_convert_distance;
	Button btn_clear;
	EditText input;
	
	RadioButton radio_K_M;
	RadioButton radio_M_K;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.distance);
		back();

		input = (EditText)findViewById(R.id.edittxt_distance);
		radio_K_M = (RadioButton)findViewById(R.id.radioK2M);
		radio_M_K = (RadioButton)findViewById(R.id.radioM2K);

		btn_convert_distance = (Button)findViewById(R.id.btnConvertDistance);
		btn_convert_distance.setOnClickListener(new View.OnClickListener() {
			  public void onClick(View v) {
		 		   // TODO Auto-generated method stub
				  float value = Float.valueOf(input.getText().toString());
				  if(radio_K_M.isChecked()){
					  input.setText("value: " + String.format("%.2f", convertK2M(value)) + " Miles");
				  }else {
					  input.setText("value: " + String.format("%.2f", convertM2K(value)) + " Kmh");
				  }
				  btn_convert_distance.setEnabled(false);
			  }
		});
		clear();
	}
	
	private double convertM2K(double inputValue) {
	    return (inputValue * 1.609344);
	}

	private double convertK2M(double inputValue) {
	    return (inputValue * 0.621372);
	}
	
	public void clear(){
		btn_clear = (Button)findViewById(R.id.btnClear);
		btn_clear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				input.setText("");
				btn_convert_distance.setEnabled(true);
			}
		});
	}
	
	public void back(){
		btn_distance_back = (Button)findViewById(R.id.btnDistanceBack);
		btn_distance_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
