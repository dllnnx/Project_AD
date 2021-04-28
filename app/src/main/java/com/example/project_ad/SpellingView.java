//package com.example.project_ad;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//
//public class SpellingView extends View {
//
//	public String text = "hello";
//	private ArrayList <MyChar> myChars;
//	private ArrayList<MyChar> answers;
//	public float size = getWidth() / text.length();
//
//	public SpellingView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//
//		for(int i = 0; i < text.length(); i++){
//			myChars.add(new MyChar(text.charAt(i) + "", i * size, i, size));
//		}
//

//	}
//
//	public int minRectX, maxRectX, minRectY, maxRectY;
//	public int minRightX, maxRightX, minRightY, maxRightY;
//	public int count = 0;
//
//	public int missedInd = (int) (Math.random() * text.length());
//	public String missedChar = text.charAt(missedInd) + "";
//
//	//private ArrayList<MyChar> chars;
//	private float mousePosX = 0, mousePosY = 0, dx = 0, dy = 0;
//	private MyChar take = null;
//
//	class MyChar{
//		float x, y, sizeX;
//		String text;
//		Paint paint, textPaint, paint2;
//		final float MARGIN = 5;
//
//		public MyChar(String text, float x, float y, float sizeX) {
//			this.text = text;
//			this.x = x;
//			this.y = y;
//			this.sizeX = sizeX;
//			paint = new Paint();
//			paint.setColor(Color.argb(81, 157, 141, 216));
//			paint.setStyle(Paint.Style.FILL);
//
//			textPaint = new Paint();
//			textPaint.setTextSize((float) (size * (0.9)));
//
//			paint2 = new Paint();
//			paint2.setColor(Color.BLACK);
//			paint2.setStyle(Paint.Style.STROKE);
//		}
//
//
//		public MyChar(MyChar myChar){
//			this(myChar.text, myChar.x, myChar.y, myChar.sizeX);
//		}
//
//
//		boolean draw(Canvas canvas){
//
//			canvas.drawRect(x + MARGIN, y + MARGIN, x + sizeX - MARGIN, y + sizeX - MARGIN, paint);
//			canvas.drawText(text, x, y, textPaint);
//
//			//тут был paint и word, size, missed
//
//			int missedInd = (int) (Math.random() * word.length());
//			String missedChar = word.charAt(missedInd) + "";
//
//
//			//////////////////////////////////////////////////////////
//			for (int i = 0; i < word.length(); i++){
//				if (i != missedInd) {
//					canvas.drawRect(size * i + 5, 10, size * (i + 1) - 5, size, paint);
//					canvas.drawText(word.charAt(i) + "", size * i + size / 6, size - size / 5, textPaint);
//					chars.add(new MyChar(word.charAt(i) + "", size * i + size / 6, size - size / 5));
//				} else{
//					canvas.drawRect(size * i + 5, 10, size * (i + 1) - 5, size, paint2);
//					minRectX = size * i + 5;
//					maxRectX = size * (i + 1) - 5;
//					minRectY = 10;
//					maxRectY = size;
//				}
//			}
//
//			int space = (getWidth() - (4 * (size + 5)) ) / 2;
//			int ansInd = (int) (Math.random() * 4);
//			for (int i = 0; i < 4; i++){
//				canvas.drawRect(size * i + 5 + space, size * 3, size * (i + 1) + space, size * 4, paint2);
//
//				if (i == ansInd){
//					canvas.drawText(missedChar, size * i + space + size/6, (size * 4) - size/5, textPaint);
//					chars.add(new MyChar(missedChar, size * i + space + size/6, (size * 4) - size/5));
//					minRightX = size * i + 5 + space;
//					minRightY = size * 3;
//					maxRightX = size * (i + 1) + space;
//					maxRightY = size * 4;
//				} else{
//					Random random = new Random();
//					char randChar = (char) ((char)random.nextInt(26) + 'a');
//					while (randChar == word.charAt(missedInd)){
//						randChar = (char) ((char)random.nextInt(26) + 'a');
//					}
//					canvas.drawText(randChar + "",size * i + space + size/6, (size * 4) - size/5, textPaint);
//					chars.add(new MyChar(randChar + "",size * i + space + size/6, (size * 4) - size/5));
//				}
//
//			}
//
//			Paint textPaint2 = new Paint();
//			textPaint2.setTextSize(size/3);
//			textPaint2.setColor(Color.argb(100, 34, 34, 34));
//			canvas.drawText(text, 30, size*5, textPaint2);
//		}
//
//
//		boolean isIn(float x, float y){
//			return this.x <= x && x<= this.x +sizeX && this.y <= y && y <= this.y + sizeX;
//		}
//
//	}
//
//
//	@Override
//	protected void onDraw(Canvas canvas) {
//
//
//
//
//		Paint paint = new Paint();
//		paint.setColor(Color.argb(81, 157, 141, 216));
//		paint.setStyle(Paint.Style.FILL);
//		Paint textPaint = new Paint();
//
//		Paint paint2 = new Paint();
//		paint2.setColor(Color.BLACK);
//		paint2.setStyle(Paint.Style.STROKE);
//
//		String word = "hello";
//		int size = canvas.getWidth() / word.length();
//		//endY = size;
//
//		textPaint.setTextSize((float) (size * (0.9)));
//
//		int missedInd = (int) (Math.random() * word.length());
//		String missedChar = word.charAt(missedInd) + "";
//
//
//		for (int i = 0; i < word.length(); i++){
//			if (i != missedInd) {
//				canvas.drawRect(size * i + 5, 10, size * (i + 1) - 5, size, paint);
//				canvas.drawText(word.charAt(i) + "", size * i + size / 6, size - size / 5, textPaint);
//			} else{
//				canvas.drawRect(size * i + 5, 10, size * (i + 1) - 5, size, paint2);
//				minRectX = size * i + 5;
//				maxRectX = size * (i + 1) - 5;
//				minRectY = 10;
//				maxRectY = size;
//			}
//		}
//
//		int space = (getWidth() - (4 * (size + 5)) ) / 2;
//		int ansInd = (int) (Math.random() * 4);
//		for (int i = 0; i < 4; i++){
//			canvas.drawRect(size * i + 5 + space, size * 3, size * (i + 1) + space, size * 4, paint2);
//
//			if (i == ansInd){
//				canvas.drawText(missedChar, size * i + space + size/6, (size * 4) - size/5, textPaint);
//				minRightX = size * i + 5 + space;
//				minRightY = size * 3;
//				maxRightX = size * (i + 1) + space;
//				maxRightY = size * 4;
//			} else{
//				Random random = new Random();
//				char randChar = (char) ((char)random.nextInt(26) + 'a');
//				while (randChar == word.charAt(missedInd)){
//					randChar = (char) ((char)random.nextInt(26) + 'a');
//				}
//				canvas.drawText(randChar + "",size * i + space + size/6, (size * 4) - size/5, textPaint);
//			}
//
//		}
//
//		Paint textPaint2 = new Paint();
//		textPaint2.setTextSize(size/3);
//		textPaint2.setColor(Color.argb(100, 34, 34, 34));
//		canvas.drawText(text2, 30, size*5, textPaint2);
//
//	}
//
//	public String text2 = "";
//	public boolean rightDown;
//	public boolean down;
//
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//
//		///
//
//
//		if(event.getAction() == MotionEvent.ACTION_DOWN){
//			down = true;
//			if(event.getX() >= minRightX && event.getX() <= maxRightX && event.getY() >= minRightY && event.getY() <= maxRightY){
//				rightDown = true;
//			}
//		}
//
//		if (down == true) {
//			if (rightDown == true) {
//				if (event.getAction() == MotionEvent.ACTION_MOVE) {
//					//text = event.getX() + "\n" + event.getY();
//					if (event.getX() >= minRectX && event.getX() <= maxRectX && event.getY() >= minRectY && event.getY() <= maxRectY) {
//						count++;
//						invalidate();
//						down = false;
//						rightDown = false;
//					}
//				}
//			} else {
//				if (event.getX() >= minRectX && event.getX() <= maxRectX && event.getY() >= minRectY && event.getY() <= maxRectY) {
//					invalidate();
//					down = false;
//					//rightDown = false;
//				}
//			}
//
//			if (event.getAction() == MotionEvent.ACTION_UP) {
//				rightDown = false;
//			}
//		}
//
//		text2 = "Правильных ответов: " + count;
//
//		return true;
//	}
//}
