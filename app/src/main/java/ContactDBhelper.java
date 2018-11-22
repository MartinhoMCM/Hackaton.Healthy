import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hackathon.healthy.ContactContract;



public final class ContactDBhelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="contact.db";
    public static final int DATABASE_VERSION=1;

    ContactDBhelper(Context context)
    {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations", "Database created...");
    }


    public static final String CREATE_TABLE ="create table " + ContactContract.ContactEntry.TABLE_NAME +
            "(" + ContactContract.ContactEntry.FATHERNAME+" text," +
            ContactContract.ContactEntry.FATHEREMAIL+ " text,"+ ContactContract.ContactEntry.FATHERPASSWORD +" text,"+ContactContract.ContactEntry.BABYNAME+ " text,"+
            ContactContract.ContactEntry.BABYAGE+ " text," + ContactContract.ContactEntry.BABYSEX+ " text);";

    public static final String DROP_TABLE ="drop table if exists "+ContactContract.ContactEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "table created..");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL(DROP_TABLE);
         onCreate(db);
    }

    public void Insert(String fathername, String fatheremail, String fatherpassword, String babyname, String babyage, String babysex, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.FATHERNAME, fathername);
        contentValues.put(ContactContract.ContactEntry.FATHEREMAIL, fatheremail);
        contentValues.put(ContactContract.ContactEntry.FATHERPASSWORD, fatherpassword);
        contentValues.put(ContactContract.ContactEntry.BABYNAME, babyname);
        contentValues.put(ContactContract.ContactEntry.BABYAGE, babyage);
        contentValues.put(ContactContract.ContactEntry.BABYSEX, babysex);


        sqLiteDatabase.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations", "Datas inserted...");


    }
}
