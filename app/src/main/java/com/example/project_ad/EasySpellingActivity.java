package com.example.project_ad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EasySpellingActivity extends AppCompatActivity {

	SpellingView2 spView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_easyspelling);
		getSupportActionBar().hide();

		spView = (SpellingView2)findViewById(R.id.spelling_view);
		boolean isDone = false;


	}

}
