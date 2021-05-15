package com.example.project_ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class SpellingView2 extends View {
	private float mousePosX = 0, mousePosY = 0;
	private TaskView taskView;
	boolean isInit = false;
	ArrayList<TaskView.Task> tasks = new ArrayList<>();


	int taskTextColor, answerTextColor, taskBackgroundColor, answerBackgroundColor;


	public SpellingView2(Context context, AttributeSet attrs){
		super(context, attrs);


		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SpellingView2);


		taskTextColor = typedArray.getColor(R.styleable.SpellingView2_task_text_color, Color.BLACK);
		answerTextColor = typedArray.getColor(R.styleable.SpellingView2_answer_text_color, Color.BLACK);
		taskBackgroundColor = typedArray.getColor(R.styleable.SpellingView2_task_bgcolor, Color.argb(100, 149, 124, 243));
		answerBackgroundColor = typedArray.getColor(R.styleable.SpellingView2_answer_bgcolor, Color.argb(100, 72, 57, 129));


		tasks.add(new TaskView.Task("hello", 1, "qwer"));
		tasks.add(new TaskView.Task("apple", 3, "qkjl"));
		tasks.add(new TaskView.Task("boy", 1, "puop"));
		tasks.add(new TaskView.Task("change", 2, "eyao"));
		tasks.add(new TaskView.Task("multiplication", 7, "ioye"));
		tasks.add(new TaskView.Task("addition", 5, "ioya"));
	}


	public void init(){
		taskView = new TaskView(tasks.remove(0), getWidth(), getHeight());
		taskView.setAnswerLetterColor(answerTextColor);
		taskView.setAnswerBackgroundColor(answerBackgroundColor);
		taskView.setLetterColor(taskTextColor);
		taskView.setLetterBackgroundColor(taskBackgroundColor);
		isInit = true;
	}


	@Override
	protected void onDraw(Canvas canvas) {
		if (!isInit){
			init();
		}
		taskView.draw(canvas);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mousePosX = event.getX();
		mousePosY = event.getY();


		if (MotionEvent.ACTION_DOWN == event.getAction()){
			taskView.up((int) mousePosX, (int) mousePosY);
		}else if (MotionEvent.ACTION_UP == event.getAction()){
			if (taskView.checkAnswer()) init();
			taskView.down();
		}else if (MotionEvent.ACTION_MOVE == event.getAction()){
			taskView.move((int) mousePosX, (int) mousePosY);
		}
		invalidate();
		return true;
	}
}