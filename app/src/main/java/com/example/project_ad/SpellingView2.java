 package com.example.project_ad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SpellingView2 extends View {
	private float mousePosX = 0, mousePosY = 0, dx = 0, dy = 0;
	private String word = "hello";
	private ArrayList<MyChar> myChars;
	private ArrayList<MyChar> answers;
	private boolean isInit = false;
	private MyChar take = null;

	public int minRectX, maxRectX, minRectY, maxRectY;
	public int minRightX, maxRightX, minRightY, maxRightY;
	public int count = 0;

	class Task{
		String word;
		int spaceIndex;
		ArrayList<String> distractor;

		public Task(String word, int spaceIndex, String[] distractor) {
			this.word = word;
			this.spaceIndex = spaceIndex;
			this.distractor = (ArrayList<String>) Arrays.asList(distractor);
			this.distractor.add(this.word.charAt(this.spaceIndex) + "");
			Collections.shuffle(this.distractor);
		}

		public void draw(Canvas canvas){
			for (int i = 0; i < word.length(); i++){

			}
		}

	}

	class MyChar{
		float x, y, size = getWidth() / word.length();
		Paint paintRect, paintText;
		String text;
		final float MARGIN = 5;

		public MyChar(float x, float y, float size, String text) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.text = text;
			paintRect = new Paint();
			paintRect.setColor(Color.argb(81, 157, 141, 216));
			paintRect.setStyle(Paint.Style.FILL);

			paintText = new Paint();
			paintText.setTextSize((float) (size * (0.9)));
		}

		public MyChar(MyChar myChar){
			this(myChar.x, myChar.y, myChar.size, myChar.text);
		}

		void draw(Canvas canvas){
			int missedInd = (int) (Math.random() * word.length());
			String missedChar = word.charAt(missedInd) + "";

			System.out.println(missedInd);

			for (int i = 0; i < word.length(); i++){
				canvas.drawRect(x + MARGIN, y + MARGIN, x + size - MARGIN,
						y + size, paintRect);
				if (i != missedInd) {
					canvas.drawText(text, x + size/6, y + size - size/5, paintText);
				} else{
					//					minRectX = x;
//					maxRectX = y;
//					minRectY = 10;
//					maxRectY = size;
				}
			}

//			canvas.drawRect(x + MARGIN, y + MARGIN, x + size - MARGIN,
//					y + size, paintRect);
//			canvas.drawText(text, x + size/6, y + size - size/5, paintText);
		}

		boolean isIn(float x, float y){
			return this.x <= x && x <= this.x + size &&
					this.y <= y && y <= this.y + size;
		}

		public void move(int dx, int dy){

		}
	}

	class MyMoveableChar extends MyChar{

		public MyMoveableChar(float x, float y, float size, String text) {
			super(x, y, size, text);
		}

		public void move(int x, int y){
			this.x = x;
			this.y = y;
		}

		public void update(MotionEvent motionEvent){

		}
	}

	public SpellingView2(Context context, AttributeSet attrs){
		super(context, attrs);
		isInit = false;
	}

	void init(){
		word = "hello";

		myChars = new ArrayList<>();
		float size2 = getWidth() / word.length();
		for (int i = 0; i < word.length(); i++){
			myChars.add(new MyChar(i * size2, 0, size2, word.charAt(i) + ""));
		}
		answers = new ArrayList<>();
		for (int i = 0; i < 4; i++){
			answers.add(new MyMoveableChar(i * size2 + (word.length() - 4) * size2 / 2, size2 * 2, size2,  "a"));
		}
	}

	public void setTask(Task task){

	}

	public int missedInd = (int) (Math.random() * word.length());
	public String missedChar = word.charAt(missedInd) + "";

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawRect(0, 0, getWidth(), getHeight(), new Paint());
		if (!isInit){
			init();
			isInit = true;
		}
		for (MyChar myChar: myChars){
			myChar.draw(canvas);
		}
		for (MyChar myChar: answers){
			myChar.draw(canvas);
		}
	}

	public boolean rightDown;
	public boolean down;
	public String text = "";

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mousePosX = event.getX();
		mousePosY = event.getY();


			if(event.getAction() == MotionEvent.ACTION_DOWN){
				down = true;
				if(event.getX() >= minRightX && event.getX() <= maxRightX && event.getY() >= minRightY && event.getY() <= maxRightY){
					rightDown = true;
				}
			}

			if (down == true) {
				if (rightDown == true) {
					if (event.getAction() == MotionEvent.ACTION_MOVE) {
						//text = event.getX() + "\n" + event.getY();
						if (event.getX() >= minRectX && event.getX() <= maxRectX && event.getY() >= minRectY && event.getY() <= maxRectY) {
							count++;
							invalidate();
							down = false;
							rightDown = false;
						}
					}
				} else {
					if (event.getX() >= minRectX && event.getX() <= maxRectX && event.getY() >= minRectY && event.getY() <= maxRectY) {
						invalidate();
						down = false;
						//rightDown = false;
					}
				}

				if (event.getAction() == MotionEvent.ACTION_UP) {
					rightDown = false;
				}
			}

			text = "Правильных ответов: " + count;

			return true;
	}
}