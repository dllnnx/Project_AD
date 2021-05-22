package com.example.project_ad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class EasyTofActivity extends AppCompatActivity {

	DBTof mDBConnector;
	Context mContext;
	ListView mListView;
	SimpleCursorAdapter scAdapter;
	Cursor cursor;
	//myListAdapter myAdapter;

	Button true_btn, false_btn, cancel_btn;
	TextView enWordTv, ruWordTv, countTv;

	ArrayList<Task> tasks = new ArrayList<>();
	int[] count = {0};
	int amount;


	Task curTask;

	public class Task{
		String ruWord, enWord;
		boolean bool;

		public Task(String ruWord, String enWord, boolean bool) {
			this.ruWord = ruWord;
			this.enWord = enWord;
			this.bool = bool;
		}


	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tof);
		getSupportActionBar().hide();

		mDBConnector = new DBTof(getApplicationContext());

		mDBConnector.insert("кролик", "rabbit", 1);
		mDBConnector.insert("собака", "dog", 1);
		mDBConnector.insert("кошка", "animal", 0);
		mDBConnector.insert("корова", "cow", 1);
		mDBConnector.insert("стол", "bed", 0);
		mDBConnector.insert("дом", "table", 0);
		mDBConnector.insert("дружба", "friendship", 1);
		mDBConnector.insert("друзья", "children", 0);
		mDBConnector.insert("красный", "blue", 0);
		mDBConnector.insert("семья", "family", 1);
		mDBConnector.insert("сестра", "sister", 1);
		mDBConnector.insert("школа", "house", 1);
		mDBConnector.insert("молоко", "milk", 1);

		for(Tof_Task tof_task: mDBConnector.selectAll()){
			tasks.add(new Task(tof_task.getRuWord(), tof_task.getEnWord(), tof_task.getBool() == 1));
		}


		true_btn = (Button) findViewById(R.id.true_btn);
		false_btn = (Button) findViewById(R.id.false_btn);
		cancel_btn = (Button) findViewById(R.id.tofCancel_btn);
		enWordTv = (TextView) findViewById(R.id.enWord_tv);
		ruWordTv = (TextView) findViewById(R.id.ruWord_tv);
		countTv = (TextView) findViewById(R.id.count_tv);

		boolean rightBtn = false;


		countTv.setText("Счёт: " + count[0]);

		true_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (curTask.bool){
					count[0]++;
				}

				if(!tasks.isEmpty()){
					tasks.remove(0);
					nextTask();
				}

			}
		});

		false_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if(!curTask.bool){
					count[0]++;
				}

				if(!tasks.isEmpty()){
					tasks.remove(0);
					nextTask();
				}

			}
		});

		cancel_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});


//		tasks.add(new Task("кролик", "rabbit", true));
//		tasks.add(new Task("собака", "dog", true));
//		tasks.add(new Task("кошка", "animal", false));
//		tasks.add(new Task("корова", "cow", true));
//		tasks.add(new Task("стол", "bed", false));

		amount = tasks.size();

		nextTask();
	}

	public void nextTask(){
		if (!tasks.isEmpty()){
			curTask = tasks.get(0);


			enWordTv.setText(curTask.enWord);
			ruWordTv.setText(curTask.ruWord);
			countTv.setText("Счёт: " + count[0]);
		}else{
			float res = (float)count[0]/amount * 100;
			countTv.setText("Задания закончились!\nРезультат: " + (int) res + "%");
		}
	}
}
