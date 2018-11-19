package com.hackathon.healthy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by martinhocorreiamussamba on 19/11/18.
 */

public final class ContactManagerHelper  extends SQLiteOpenHelper{

    private static final String CREATE_TABLE ="create table "+ ContactContract.ContactEntry.TABLE_NAME+"("+ ContactContract.ContactEntry.FATHERNAME +" text,"+ ContactContract.ContactEntry.FATHEREMAIL +" text," +
            ContactContract.ContactEntry.FATHERPASSWORD+ " text,"+ ContactContract.ContactEntry.BABYNAME +" text,"+ ContactContract.ContactEntry.BABYAGE+" text,"
            + " text," +ContactContract.ContactEntry.BABYSEX+" text);";

    private static final String DROP_TABLE="Drop table if exists "+ContactContract.ContactEntry.TABLE_NAME;

    public static final String DATABASE_NAME="healthy.db";
    public static final int DATABASE_VERSION=1;

   public ContactManagerHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operation", "database created...");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_TABLE);
       Log.d("Database Operations","table created" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL(DROP_TABLE);
         onCreate(db);

    }

    public boolean Insert(String fathername, String fatheremail, String fatherpassword, String babyname, String babyidade, String babysexo, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fathername", fathername);
        contentValues.put("fatheremail", fatheremail);
        contentValues.put("fatherpassword", fatherpassword);
        contentValues.put("babyname", babyname);
        contentValues.put("babysex", babysexo);
        contentValues.put("babyage", babyidade);

        long ins =sqLiteDatabase.insert(ContactContract.ContactEntry.TABLE_NAME,null, contentValues);

        if(ins==-1) {
            return false;
        }
        else
        return true;

    }

    public boolean checkLogin(String email, String password)
    {
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();

        Cursor cursor =sqLiteDatabase.rawQuery("select * from "+ ContactContract.ContactEntry.TABLE_NAME +
                " where fatheremail=? and fatherpassword=?", new String[]{email, password});

        if(cursor.getCount()>0)
        {
            return true;
        }
        return false;
    }
}
