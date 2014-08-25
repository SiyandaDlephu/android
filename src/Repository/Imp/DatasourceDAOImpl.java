package Repository.Imp;

//import Model.Settings;
import Model.User;
import Repository.DBAdapter;
import Repository.DatasourceDAO;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by siyanda on 8/19/14.
 */
public class DatasourceDAOImpl implements DatasourceDAO {

    private SQLiteDatabase database;
    private DBAdapter dbHelper;

    public DatasourceDAOImpl(Context context)
    {
        dbHelper = new DBAdapter(context);
    }

    public void open()
    throws SQLException
    {
        database = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }



    @Override
    public void createUser(User user)
    {
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ContentValues values = new ContentValues();
        values.put(DBAdapter.COLUMN_NAME, user.getFirstname());
        values.put(DBAdapter.COLUMN_LASTNAME, user.getLastname());
        values.put(DBAdapter.COLUMN_CELLNUMBER, user.getCellnumber());
        values.put(DBAdapter.COLUMN_EMIAL, user.getEmail());
        values.put(DBAdapter.COLUMN_HOMEADDRESS, user.getHomeaddress());

        database.insert(DBAdapter.TABLE_MSHENGU_USER, null, values);
        close();
    }

    @Override
    public void updateUser(User user)
    {
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ContentValues values = new ContentValues();
        values.put(DBAdapter.COLUMN_NAME, user.getFirstname());
        values.put(DBAdapter.COLUMN_LASTNAME, user.getLastname());
        values.put(DBAdapter.COLUMN_CELLNUMBER, user.getCellnumber());
        values.put(DBAdapter.COLUMN_EMIAL, user.getEmail());
        values.put(DBAdapter.COLUMN_HOMEADDRESS, user.getHomeaddress());

        database.update(DBAdapter.TABLE_MSHENGU_USER, values, DBAdapter.COLUMN_ID + " =? ", new String[]{String.valueOf(user.getId())});
        close();
    }

    @Override
    public User findUserById(int id)
    {
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cursor cursor = database.query(DBAdapter.TABLE_MSHENGU_USER, new String[]{DBAdapter.COLUMN_ID, DBAdapter.COLUMN_NAME
        , DBAdapter.COLUMN_LASTNAME, DBAdapter.COLUMN_CELLNUMBER, DBAdapter.COLUMN_EMIAL, DBAdapter.COLUMN_HOMEADDRESS},
                DBAdapter.COLUMN_ID + " =? ", new String[]{String.valueOf(id)}, null,null,null,null);

                if(cursor !=null)
                    cursor.moveToFirst();
                User user = new User();


                user.setId(cursor.getInt(0));
                user.setFirstname(cursor.getString(1));
                user.setLastname(cursor.getString(2));
                user.setCellnumber(cursor.getString(3));
                user.setEmail(cursor.getString(4));
                user.setHomeaddress(cursor.getString(5));
                close();
                return user;
    }

    @Override
    public void deleteUser(User user)
    {
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        database.delete(DBAdapter.TABLE_MSHENGU_USER, DBAdapter.COLUMN_ID + " =? ", new String[]{String.valueOf(user.getId())});
        close();
    }


    @Override
    public List<User> getUser()
    {
        String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_MSHENGU_USER;
        final User customerInfo = new User();
        List<User> users =new ArrayList<User>();
        try
        {
            open();


            Cursor cursor = database.rawQuery(selectQuery, null);

            if(cursor.moveToFirst())
            {
                do {
                    customerInfo.setId(cursor.getInt(0));
                    customerInfo.setFirstname(cursor.getString(1));
                    customerInfo.setLastname(cursor.getString(2));
                    customerInfo.setEmail(cursor.getString(3));
                    customerInfo.setHomeaddress(cursor.getString(4));
                    customerInfo.setCellnumber(cursor.getString(5));

                    users.add(customerInfo);


                }while (cursor.moveToNext());
            }
            close();
            //return customerInfo;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        //database.rawQuery(selectQuery, null);

        return users;
    }
}
