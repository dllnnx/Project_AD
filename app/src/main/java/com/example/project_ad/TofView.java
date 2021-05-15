package com.example.project_ad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


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
	public Task task = new Task("кролик", "rabbit", true);
	protected float trueX1, trueX2, trueY1, trueY2;
	protected float falseX1, falseX2, falseY1, falseY2;
	public int count = 0;


	class Task{
		String ruWord, engWord;
		int wordLength;
		boolean bool;

		public Task(String ruWord, String engWord, boolean bool) {
			this.ruWord = ruWord;
			this.engWord = engWord;
			this.bool = bool;

		}


		void draw(Canvas canvas) {
			if (ruWord.length() > engWord.length())
				wordLength = ruWord.length();
			else
				wordLength = engWord.length();

			float textSize = (float) (getWidth()/wordLength - MARGIN*2.5);
			float rectHeight = getWidth()/ruWord.length();
			Paint paintText2 = new Paint();

			paintRect = new Paint();
			paintRect.setColor(Color.argb(100, 149, 124, 243));
			paintRect.setStyle(Paint.Style.FILL);

			paintText = new Paint();
			paintText.setTextSize(textSize);
			paintText2.setTextSize(getWidth()/20);
			paintText2.setColor(Color.GRAY);

			canvas.drawRect(MARGIN, MARGIN, (float) (getWidth() *0.45), rectHeight, paintRect);
			canvas.drawText(engWord, MARGIN*2, rectHeight - MARGIN*2, paintText);
			canvas.drawText("Слово", MARGIN*2, (float) (rectHeight+MARGIN*2.5), paintText2);


			canvas.drawRect((float) (getWidth() - getWidth()*0.45 - MARGIN), MARGIN, (float) (getWidth() - MARGIN), rectHeight, paintRect);
			canvas.drawText(ruWord, (float) (getWidth() - getWidth()*0.45), rectHeight - MARGIN*2, paintText);
			canvas.drawText("Перевод", (float) (getWidth() - getWidth()*0.45), (float) (rectHeight+MARGIN*2.5), paintText2);


			paintText2.setTextSize(getWidth()/10 - MARGIN);
			paintText2.setColor(Color.BLACK);

			trueX1 = (float) (getWidth() * 0.1);
			trueX2 = (float) (getWidth()*0.4);
			trueY1 = (rectHeight + MARGIN)*2;
			trueY2 = (float) ((rectHeight + MARGIN)*2 + rectHeight*0.8);

			canvas.drawRect(trueX1, trueY1, trueX2, trueY2, paintRect);
			canvas.drawText("Правда", (float) (getWidth() * 0.1 + MARGIN/2), (float) ((rectHeight)*2 + rectHeight*0.8), paintText2);

			falseX1 = (float)(getWidth()*0.6);
			falseX2 = (float)(getWidth()*0.9);
			falseY1 = (rectHeight + MARGIN)*2;
			falseY2 = (float) ((rectHeight + MARGIN)*2 + rectHeight*0.8);

			canvas.drawRect(falseX1, falseY1, falseX2, falseY2, paintRect);
			canvas.drawText("Ложь", (float)(getWidth()*0.6 + MARGIN*2), (float) ((rectHeight)*2 + rectHeight*0.8), paintText2);

			paintText2.setTextSize(getWidth()/20);

			canvas.drawText("Счёт: " + count, MARGIN, rectHeight*5,paintText2);

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


		task.draw(canvas);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		float mousePosX = event.getX(), mousePosY = event.getY(0);
		float rightRectX1, rightRectX2, rightRectY1, rightRectY2;
		float wrongRectX1, wrongRectX2, wrongRectY1, wrongRectY2;
		//boolean down = false, rightDown = false;

		if (task.bool == true){
			rightRectX1 = trueX1; rightRectX2 = trueX2;
			rightRectY1 = trueY1; rightRectY2 = trueY2;
			wrongRectX1 = falseX1; wrongRectX2 = falseX2;
			wrongRectY1 = falseY1; wrongRectY2 = falseY2;
		}else{
			rightRectX1 = falseX1; rightRectX2 = falseX2;
			rightRectY1 = falseY1; rightRectY2 = falseY2;
			wrongRectX1 = trueX1; wrongRectX2 = trueX2;
			wrongRectY1 = trueY1; wrongRectY2 = trueY2;
		}

		if (event.getAction() == MotionEvent.ACTION_DOWN){
			if(mousePosX >= rightRectX1 && mousePosX <= rightRectX2 & mousePosY >= rightRectY1 && mousePosY <= rightRectY2){
				count++;
				invalidate();
			}
			if(mousePosX >= wrongRectX1 && mousePosX <= wrongRectX2 & mousePosY >= wrongRectY1 && mousePosY <= wrongRectY2){
				count--;
				invalidate();
			}
		}

		return true;
	}
}
