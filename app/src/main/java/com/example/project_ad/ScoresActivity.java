package com.example.project_ad;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class ScoresActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scores);
		getSupportActionBar().hide();

		MyScoreAdapter adapter = new MyScoreAdapter(this, makeScore());
		ListView lv = (ListView) findViewById(R.id.list1);
		lv.setAdapter(adapter);


	}

	MyScores[] makeScore(){
		MyScores[] arr = new MyScores[12];

		int[] numberArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		String[] dateArr = {"1.01.2021", "2.02.2021", "3.03.2021", "4.03.2021", "5.03.2021", "6.03.2021", "7.03.2021", "8.03.2021", "9.03.2021", "10.03.2021", "11.03.2021", "12.03.2021"};
		int[] scoresArr = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		for(int i = 0; i < arr.length; i++){
			MyScores score = new MyScores();
			score.number = numberArr[i];
			score.score = scoresArr[i];
			score.date = dateArr[i];
			arr[i] = score;
		}
		return arr;
	}

}
