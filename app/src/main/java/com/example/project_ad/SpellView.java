package com.example.project_ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SpellView extends View {

	private float mousePosX = 0, mousePosY = 0, dx = 0, dy = 0;
	private String text = "hello";
	private ArrayList<SpellingView2.MyChar> myChars;
	private ArrayList<SpellingView2.MyChar> answers;
	private boolean isInit = false;
	private SpellingView2.MyChar take = null;

	class MyChar{
		float x, y, size;
	}



	public SpellView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
}
