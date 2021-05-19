package com.example.project_ad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class EasyTofActivity extends AppCompatActivity {

	Button true_btn, false_btn;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_easytof);
		getSupportActionBar().hide();


		true_btn = (Button) findViewById(R.id.true_btn);
		false_btn = (Button) findViewById(R.id.false_btn);
		int count = 0;


		true_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		false_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

	}
}
