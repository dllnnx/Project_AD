package com.example.project_ad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	TextView start_text;
	Button start_btn;
	Button exit_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().hide();

		start_text = (TextView)findViewById(R.id.start_text);
		start_btn = (Button)findViewById(R.id.btn_start);
		exit_btn = (Button)findViewById(R.id.btn_exit);


		start_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ChoiceActivity.class);
				startActivity(i);
			}
		});

		exit_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}
}