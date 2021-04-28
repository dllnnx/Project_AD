package com.example.project_ad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SpellingChoiceActivity extends AppCompatActivity {

	Button easySp_btn;
	Button cancel_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spelling);
		getSupportActionBar().hide();

		easySp_btn = (Button)findViewById(R.id.easysp_btn);
		cancel_btn = (Button)findViewById(R.id.cancelsp_btn);

		easySp_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SpellingChoiceActivity.this, EasySpellingActivity.class);
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
