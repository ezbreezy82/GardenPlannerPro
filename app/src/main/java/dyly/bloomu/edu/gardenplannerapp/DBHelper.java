package dyly.bloomu.edu.gardenplannerapp;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dyly on 10/29/15.
 */
public class DBHelper extends SQLiteOpenHelper{


    private static DBHelper mInstance = null;
    public static final String DATABASE_NAME = "GPlannerPro";
    private static final int DATABASE_VERSION = 1;
//    public String GARDEN_CREATE_QUERY = "CREATE TABLE "+GardenTableData.TABLE_NAME+"( INT,"+ GardenTableData.bedID+" INT,"+
//            GardenTableData.noteID+" INT);";
    private SQLiteDatabase sdb;
    Context context;

    public static DBHelper getInstance(Context ctx) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (mInstance == null) {
            mInstance = new DBHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }
    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        //context.deleteDatabase(DATABASE_NAME);
        Log.d("Database operations", "Database trying to be created");
    }


    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        executeSQLScript(sdb,"createTables.sql");
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int oldVersion, int newVersion) {


        Log.d("Database operations", "Database Upgraded");

    }

    /**
     * Used to parse and execute SQL Scripts
     * @param sdb the database being used
     * @param script the script to be used
     */
    private void executeSQLScript(SQLiteDatabase sdb, String script)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;
        try{
            inputStream = assetManager.open(script);
            while((length = inputStream.read(buffer))!= -1){
                outputStream.write(buffer,0,length);
            }
            outputStream.close();
            inputStream.close();

            //splits text by semi colon from file
            String[] createTableScript = outputStream.toString().split(";");
            for (int i = 0; i<createTableScript.length;i++)
            {
                String sqlStatement = createTableScript[i].trim();
                if(sqlStatement.length() >0)
                {
                    sdb.execSQL(sqlStatement+";");
                }
            }
        }catch (IOException e)
        {
            Log.d("File error: ",e.getMessage());
        }catch (SQLException e){
            Log.d("Database error: ",e.getMessage());
        }
    }
//      not needed yet because there are not multiple gardens
//    public ArrayList<GardenTableData> getGardenTableData(SQLiteDatabase sdb, int id)
//    {
//        ArrayList<GardenTableData> listOfGardenTableData = new ArrayList<>();
//        GardenTableData gardenTableData = new GardenTableData();
//
//        String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
//        Cursor cursor =  sdb.query("garden", null, "_id = ?", null, null, null, null, null);
//        //return empty arraylist if cursor is null
//        if (cursor == null)
//            return listOfGardenTableData;
//
//        //get all of the gardens beds with notes
//        try{
//            if(cursor.moveToFirst())
//            {
//                do{
//                    gardenTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
//                    gardenTableData.setId(cursor.getInt(cursor.getColumnIndex("bedID")));
//                    gardenTableData.setId(cursor.getInt(cursor.getColumnIndex("noteID")));
//
//                    listOfGardenTableData.add(gardenTableData);
//
//                }while (cursor.moveToNext());
//            }
//
//        }catch (Exception e)
//        {
//            Log.d("GardenTableData", e.getMessage());
//        }
//
//        return listOfGardenTableData;
//    }

    /**
     * Used to get all of <BedTableData/> from the database, listed from frst row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <BedTableData/> Objects
     */
    public ArrayList<BedTableData> getBedTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<BedTableData> listOfBedTableData = new ArrayList<>();
        BedTableData bedTableData = new BedTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("bed", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfBedTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    bedTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    bedTableData.setNoteID(cursor.getInt(cursor.getColumnIndex("noteID")));
                    bedTableData.setLayoutID(cursor.getInt(cursor.getColumnIndex("layoutID")));
                    bedTableData.setImageID(cursor.getInt(cursor.getColumnIndex("imageID")));
                    bedTableData.setHistoryID(cursor.getInt(cursor.getColumnIndex("historyID")));

                    listOfBedTableData.add(bedTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("BedTableData", e.getMessage());
        }

        return listOfBedTableData;
    }

    /**
     * Used to get <ImageTableData/> from the database, listed from first row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <ImageTableData/> Objects
     */
    public ArrayList<ImageTableData> getImageTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<ImageTableData> listOfImagaeTableData = new ArrayList<>();
        ImageTableData imageTableData = new ImageTableData();

        String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("image", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfImagaeTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    imageTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    imageTableData.setImage(cursor.getBlob(cursor.getColumnIndex("image")));

                    listOfImagaeTableData.add(imageTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("ImageTableData", e.getMessage());
        }

        return listOfImagaeTableData;
    }

    /**
     * Used to get <LayoutTableData/> from the database, listed from first row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <LayoutTableData/> Objects
     */
    public ArrayList<LayoutTableData> getLayoutTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<LayoutTableData> listOfLayoutTableData = new ArrayList<>();
        LayoutTableData layoutTableData = new LayoutTableData();

        String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("layout", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfLayoutTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    layoutTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    layoutTableData.setImage(cursor.getBlob(cursor.getColumnIndex("image")));

                    listOfLayoutTableData.add(layoutTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("LayoutTableData", e.getMessage());
        }
        return listOfLayoutTableData;
    }

    /**
     * Used to get <NoteTableData/> from the database, listed from first row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <NoteTableData/> Objects
     */
    public ArrayList<NoteTableData> getNoteTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<NoteTableData> listOfNoteTableData = new ArrayList<>();
        NoteTableData noteTableData = new NoteTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("note", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfNoteTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    noteTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    noteTableData.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
                    noteTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfNoteTableData.add(noteTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("NoteTableData", e.getMessage());
        }

        return listOfNoteTableData;
    }

    /**
     * Used to get <HistoryTableData/> from the database, listed from first row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <HistoryTableData/> Objects
     */
    public ArrayList<HistoryTableData> getHistopryTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<HistoryTableData> listOfHistoryTableData = new ArrayList<>();
        HistoryTableData historyTableData = new HistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfHistoryTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    historyTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    historyTableData.setPlantHistotyID(cursor.getInt(cursor.getColumnIndex("plantHistoryID")));
                    historyTableData.setWorkHistoryID(cursor.getInt(cursor.getColumnIndex("workHistoryID")));
                    historyTableData.setHarvestHistoryID(cursor.getInt(cursor.getColumnIndex("harvestHistoryID")));

                    listOfHistoryTableData.add(historyTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("HistoryTableData", e.getMessage());
        }

        return listOfHistoryTableData;
    }

    /**
     * Used to get <PlantHistoryTableData/> from the database, listed from first row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <PlantHistoryTableData/> Objects
     */
    public ArrayList<PlantHistoryTableData> getPlantHistoryTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<PlantHistoryTableData> listOfPlantHistoryTableData = new ArrayList<>();
        PlantHistoryTableData plantHistoryTableData = new PlantHistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("plant_history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfPlantHistoryTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    plantHistoryTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    plantHistoryTableData.setDate(cursor.getString(cursor.getColumnIndex("date")));
                    plantHistoryTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfPlantHistoryTableData.add(plantHistoryTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("PlantHistoryTableData", e.getMessage());
        }

        return listOfPlantHistoryTableData;
    }

    /**
     * Used to get <WorkHistoryTableData/> from the database, listed from first row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <WorkHistoryTableData/> Objects
     */
    public ArrayList<WorkHistoryTableData> getWorkHistoryTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<WorkHistoryTableData> listOfWorkHistoryTableData = new ArrayList<>();
        WorkHistoryTableData workHistoryTableData = new WorkHistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("work_history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfWorkHistoryTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    workHistoryTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    workHistoryTableData.setDate(cursor.getString(cursor.getColumnIndex("date")));
                    workHistoryTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfWorkHistoryTableData.add(workHistoryTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("WorkHistoryTableData", e.getMessage());
        }

        return listOfWorkHistoryTableData;
    }

    /**
     * Used to get <HarvestHistoryTableData/> from the database, listed from first row to last row
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <HarvestHistoryTableData/> Objects
     */
    public ArrayList<HarvestHistoryTableData> getHarvestHistoryTableData(SQLiteDatabase sdb, int id)
    {
        ArrayList<HarvestHistoryTableData> listOfHarvestHistoryTableData = new ArrayList<>();
        HarvestHistoryTableData harvestHistoryTableData = new HarvestHistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor =  sdb.query("harvest_history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfHarvestHistoryTableData;

        //get all of the gardens beds with notes
        try{
            if(cursor.moveToFirst())
            {
                do{
                    harvestHistoryTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    harvestHistoryTableData.setDate(cursor.getString(cursor.getColumnIndex("date")));
                    harvestHistoryTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfHarvestHistoryTableData.add(harvestHistoryTableData);

                }while (cursor.moveToNext());
            }

        }catch (Exception e)
        {
            Log.d("HarvestHistoryTableData", e.getMessage());
        }

        return listOfHarvestHistoryTableData;
    }

}
