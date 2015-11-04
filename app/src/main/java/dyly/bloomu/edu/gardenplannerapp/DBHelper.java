package dyly.bloomu.edu.gardenplannerapp;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dyly on 10/29/15.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
//    public String GARDEN_CREATE_QUERY = "CREATE TABLE "+GardenTableData.TABLE_NAME+"( INT,"+ GardenTableData.bedID+" INT,"+
//            GardenTableData.noteID+" INT);";
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, GardenTableData.DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operations", "Database trying to be created");
    }


    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        GardenTableData gardenTableData = new GardenTableData();
//        sdb.execSQL(GARDEN_CREATE_QUERY);
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int oldVersion, int newVersion) {

        sdb.execSQL("DROP TABLE ID EXISTS"+ GardenTableData.TABLE_NAME);

    }

   /* public void fillRow(DBHelper dbHelper, int id, int bedID, int noteID){
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(String.valueOf(GardenTableData.TableInfo.id), id);
        contentValues.put(String.valueOf(GardenTableData.TableInfo.bedID), bedID);
        contentValues.put(String.valueOf(GardenTableData.TableInfo.noteID), noteID);
        long k = sq.insert(GardenTableData.TableInfo.TABLE_NAME, null, contentValues);

        Log.d("DBHelper", "One row inserted");

    }*/


}
