package com.example.project_ad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class TofView extends View {

	public TofView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private String word;
	public Paint paintText, paintRect;
	private String ruWord = "кролик", engWord = "rabbit";
	public float rectW = (float) (getWidth() * 0.3);
	public float rectH = (float) (getWidth()/ruWord.length());
	public int MARGIN = 20;


	class Task{
		String ruWord, engWord;
//		Paint paintRect = new Paint();

		public Task(String ruWord, String engWord) {
			this.ruWord = ruWord;
			this.engWord = engWord;

//			paintRect = new Paint();
//			paintRect.setColor(Color.argb(81, 157, 141, 216));
//			paintRect.setStyle(Paint.Style.FILL);

		}

		void draw(Canvas canvas) {

			canvas.drawRect(MARGIN, MARGIN, rectH, rectW - MARGIN, paintText);
		}

	}

	class Word{
		public String word;

		public Word(String word) {
			this.word = word;
			paintText.setTextSize((float) (getWidth()/word.length()));
		}

		int length(){
			word.toString();
			return word.length();
		}
	}



	@Override
	protected void onDraw(Canvas canvas) {

//		Task task = new Task("кролик", "rabbit");
//		task.draw(canvas);

		paintRect = new Paint();
		paintRect.setColor(Color.argb(81, 157, 141, 216));
		paintRect.setStyle(Paint.Style.FILL);
		canvas.drawRect(MARGIN, MARGIN, (float) (getWidth() *0.3), getWidth()/ruWord.length(), paintRect);

	}
}
