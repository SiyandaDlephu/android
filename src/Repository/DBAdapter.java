package Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by siyanda on 8/19/14.
 */
public class DBAdapter extends SQLiteOpenHelper{

   // public static final String TABLE_SETTINGS = "settings";
    public static final String TABLE_MSHENGU_USER ="mshenguuser";

    public static final String COLUMN_ID = "_id";
   // public static final String COLUMN_URL = "url";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_CELLNUMBER = "cellnumber";
    public static final String COLUMN_EMIAL = "email";
    public static final String COLUMN_HOMEADDRESS = "homeaddress";

    private static final String DATABASE_NAME = "mshengu.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation ql statement

  /*  private static final String CREATE_SETTINGS_TABLE = " create table IF NOT EXISTS " + TABLE_SETTINGS + " ( "
                                                                                     + COLUMN_ID + " integer primary key autoincrement, "
                                                                                     + COLUMN_URL + " text not null); ";*/

    private static final String CREATE_USER_TABLE = " create table IF NOT EXISTS " + TABLE_MSHENGU_USER + " ( "
                                                                                   + COLUMN_ID + " integer primary key autoincrement ,"
                                                                                   + COLUMN_NAME + " text not null, "
                                                                                   + COLUMN_LASTNAME + " text not null"
                                                                                   + COLUMN_CELLNUMBER + " text not null"
                                                                                   + COLUMN_EMIAL + " text not null"
                                                                                   + COLUMN_HOMEADDRESS + " text not null ); ";

    public DBAdapter(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        //database.execSQL(CREATE_SETTINGS_TABLE);
        database.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(DBAdapter.class.getName(),
                "Upgrading database from verion " + oldVersion + " to " + newVersion + ", which will destroy all old data");

        //db.execSQL(" DROP TABLE IF EXISTS" + TABLE_SETTINGS);
        db.execSQL(" DROP TABLE IF EXISTS" + TABLE_MSHENGU_USER);

        onCreate(db);
    }
}
