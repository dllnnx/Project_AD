package com.example.project_ad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ToFChoiceActivity extends AppCompatActivity {

	Button easyTof_btn, medTof_btn, hardTof_btn, cancel_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tofchoice);
		getSupportActionBar().hide();

		easyTof_btn = (Button) findViewById(R.id.easytof_btn);
		medTof_btn = (Button) findViewById(R.id.medtof_btn);
		hardTof_btn = (Button) findViewById(R.id.hardtof_btn);
		cancel_btn = (Button) findViewById(R.id.canceltof_btn);

		easyTof_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ToFChoiceActivity.this, EasyTofActivity.class);
				startActivity(i);
			}
		});

		cancel_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

}
