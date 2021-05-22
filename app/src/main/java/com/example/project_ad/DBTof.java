package com.example.project_ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBTof {
	private static final String DATABASE_NAME = "tof.name";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "easyTof";

	private static final String COLUMN_ID = "id";
	private static final String COLUMN_RUWORD = "RuWord";
	private static final String COLUMN_ENWORD = "EnWord";
	private static final String COLUMN_BOOL = "Bool";

	private SQLiteDatabase mDataBase;

	public DBTof (Context context){
		OpenHelper mOpenHelper = new OpenHelper(context);
		mDataBase = mOpenHelper.getWritableDatabase();
	}

	public long insert(String ruword, String enword, int bool){
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_RUWORD, ruword);
		cv.put(COLUMN_ENWORD, enword);
		cv.put(COLUMN_BOOL, bool);
		return mDataBase.insert(TABLE_NAME, null, cv);
	}

	private int update(Tof_Task md){
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_RUWORD, md.getRuWord());
		cv.put(COLUMN_ENWORD, md.getEnWord());
		cv.put(COLUMN_BOOL, md.getBool());
		return mDataBase.update(TABLE_NAME, cv, COLUMN_ID + " = ?", new String[] { String.valueOf(md.getId())});
	}

	public void deleteAll() {
		mDataBase.delete(TABLE_NAME, null, null);
	}

	public void delete(long id) {
		mDataBase.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
	}

	public Tof_Task select(long id) {
		Cursor mCursor = mDataBase.query(TABLE_NAME, null, COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

		mCursor.moveToFirst();
		String RuWord = mCursor.getString(mCursor.getColumnIndex(COLUMN_RUWORD));
		String EnWord = mCursor.getString(mCursor.getColumnIndex(COLUMN_ENWORD));
		int Bool = mCursor.getInt(mCursor.getColumnIndex(COLUMN_BOOL));
		return new Tof_Task(id, RuWord, EnWord, Bool);
	}

	public ArrayList<Tof_Task> selectAll(){
		Cursor mCursor = mDataBase.query(TABLE_NAME, null, null, null, null, null, null);

		ArrayList<Tof_Task> arr = new ArrayList<Tof_Task>();
		mCursor.moveToFirst();
		if(!mCursor.isAfterLast()){
			do{
				long id = mCursor.getLong(mCursor.getColumnIndex(COLUMN_ID));
				String RuWord = mCursor.getString(mCursor.getColumnIndex(COLUMN_RUWORD));
				String EnWord = mCursor.getString(mCursor.getColumnIndex(COLUMN_ENWORD));
				int bool = mCursor.getInt(mCursor.getColumnIndex(COLUMN_BOOL));
			} while (mCursor.moveToNext());
		}
		return arr;
	}


	private class OpenHelper extends SQLiteOpenHelper {

		OpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			String query = "CREATE TABLE " + TABLE_NAME + " (" +
					COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					COLUMN_RUWORD+ " TEXT, " +
					COLUMN_ENWORD + " TEXT, " +
					COLUMN_BOOL + " BOOLEAN);";
			db.execSQL(query);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
	}

}
