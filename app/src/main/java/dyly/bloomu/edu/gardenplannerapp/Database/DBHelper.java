package dyly.bloomu.edu.gardenplannerapp.Database;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.BedTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.GardenTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.HarvestHistoryTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.HistoryTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.ImageTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.LayoutTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.NoteTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.PlantHistoryTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.WorkHistoryTableData;

/**
 * Created by Dyly on 10/29/15.
 */
public class DBHelper extends SQLiteOpenHelper {


    private static DBHelper mInstance = null;
    private static final String DATABASE_NAME = "GPlannerPro";
    private static final int DATABASE_VERSION = 4;
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
    public void onCreate(SQLiteDatabase sdb) {
        this.sdb = sdb;
        this.executeSQLScript("create_tables.sql");
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int oldVersion, int newVersion) {

        this.sdb = sdb;
        this.executeSQLScript("SQLscript/create_tables.sql");
        Log.d("Database operations", "Database Upgraded");

    }

    /**
     * Used to parse and execute SQL Scripts
     *
     * @param script the script to be used
     */
    private void executeSQLScript(String script) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = null;
            inputStream = assetManager.open(script);
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();

            //splits text by semi colon from file
            String[] createTableScript = outputStream.toString().split(";");
            for (int i = 0; i < createTableScript.length; i++) {
                String sqlStatement = createTableScript[i].trim();
                if (sqlStatement.length() > 0) {
                    this.sdb.execSQL(sqlStatement + ";");
                }
            }
        } catch (IOException e) {
            Log.d("File error: ", e.getMessage());
        } catch (SQLException e) {
            Log.d("Database error: ", e.getMessage());
        }


    }

    public void setGardenTableData(GardenTableData gardenTableData) {
        try {
            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("bedID", gardenTableData.getBedID());
            contentValues.put("noteID", gardenTableData.getNoteID());
            this.sdb.insert("garden", null, contentValues);

            this.sdb.close();
        } catch (SQLException e) {
            Log.d("Database, Garden add", e.getMessage());
        }
    }

    public void setBedTableData(BedTableData bedTableData) {
        try {
            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("noteID", bedTableData.getNoteID());
            contentValues.put("imageID", bedTableData.getImageID());
            contentValues.put("layoutID", bedTableData.getLayoutID());
            contentValues.put("historyID", bedTableData.getHistoryID());
            this.sdb.insert("bed", null, contentValues);

            this.sdb.close();
        } catch (SQLException e) {
            Log.d("Database, Bed add", e.getMessage());
        }
    }

    public void setImageTableData(ImageTableData imageTableData) {
        try {
            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("image", imageTableData.getImage());
            this.sdb.insert("image", null, contentValues);

            this.sdb.close();
        } catch (SQLException e) {
            Log.d("Database, Image add", e.getMessage());
        }
    }

    public void setLayoutTableData(LayoutTableData layoutTableData) {
        try {
            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("image", layoutTableData.getImage());
            this.sdb.insert("layout", null, contentValues);

            this.sdb.close();
        }catch(SQLException e){
            Log.d("Database, Layout add", e.getMessage());
        }
    }

    public void setNoteTableData(NoteTableData noteTableData) {
        try {
            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("subject", noteTableData.getSubject());
            contentValues.put("note", noteTableData.getNote());
            this.sdb.insert("note", null, contentValues);

            this.sdb.close();
        }catch(SQLException e){
            Log.d("Database, Note add",e.getMessage());
        }
    }

    public void setHistoryTableData(HistoryTableData historyTableData) {
        try {
            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("havrvestHistoryID", historyTableData.getHarvestHistoryID());
            contentValues.put("plantHistoryID", historyTableData.getPlantHistotyID());
            contentValues.put("workHistoryID", historyTableData.getWorkHistoryID());
            this.sdb.insert("history", null, contentValues);

            this.sdb.close();
        }catch(SQLException e){
            Log.d("Database, History add", e.getMessage());
        }
    }

    public void setPlantHistoryTableData(PlantHistoryTableData plantHistoryTableData) {
       try {
           this.sdb = getWritableDatabase();

           ContentValues contentValues = new ContentValues();
           contentValues.put("note", plantHistoryTableData.getNote());
           contentValues.put("date", plantHistoryTableData.getDate().toString());
           this.sdb.insert("plant_history", null, contentValues);

           this.sdb.close();
       }catch (SQLException e){
           Log.d("Database, PlantHistory add", e.getMessage());
       }
    }

    public void setHarvestHistoryTableData(HarvestHistoryTableData harvestHistoryTableData) {
        try {
            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("note", harvestHistoryTableData.getNote());
            contentValues.put("date", harvestHistoryTableData.getDate().toString());
            this.sdb.insert("harvest_history", null, contentValues);

            this.sdb.close();
        }catch(SQLException e){
            Log.d("Database, Harvest History add", e.getMessage());
        }
    }

    public void setWorkHistoryTableData(WorkHistoryTableData workHistoryTableData) {
        try {

            this.sdb = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("note", workHistoryTableData.getNote());
            contentValues.put("date", workHistoryTableData.getDate().toString());
            this.sdb.insert("work_history", null, contentValues);

            this.sdb.close();

        } catch (SQLException e) {
            Log.d("DataBase, Work History add", e.getMessage());
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
     *
     * @param sdb database to be used
     * @param id
     * @return ArrayList of <BedTableData/> Objects
     */
    public ArrayList<BedTableData> getBedTableData(SQLiteDatabase sdb, int id) {
        ArrayList<BedTableData> listOfBedTableData = new ArrayList<>();
        try {
            this.sdb = getReadableDatabase();
            BedTableData bedTableData = new BedTableData();

            //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
            Cursor cursor = sdb.query("bed", null, "_id = ?", null, null, null, null, null);

            //return empty arraylist if cursor is null
            if (cursor == null)
                return listOfBedTableData;

            //get all of the gardens beds with notes
            if (cursor.moveToFirst()) {
                do {
                    bedTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    bedTableData.setNoteID(cursor.getInt(cursor.getColumnIndex("noteID")));
                    bedTableData.setLayoutID(cursor.getInt(cursor.getColumnIndex("layoutID")));
                    bedTableData.setImageID(cursor.getInt(cursor.getColumnIndex("imageID")));
                    bedTableData.setHistoryID(cursor.getInt(cursor.getColumnIndex("historyID")));

                    listOfBedTableData.add(bedTableData);

                } while (cursor.moveToNext());
            }

            this.sdb.close();
        } catch (Exception e) {
            Log.d("BedTableData", e.getMessage());
        }


        return listOfBedTableData;
    }

    /**
     * Used to get <ImageTableData/> from the database, listed from first row to last row
     *
     * @param id
     * @return ArrayList of <ImageTableData/> Objects
     */
    public ArrayList<ImageTableData> getImageTableData(int id) {


        ArrayList<ImageTableData> listOfImagaeTableData = new ArrayList<>();
        try {
            this.sdb = getReadableDatabase();
            ImageTableData imageTableData = new ImageTableData();

            String dataExtracter = "SELECT *  FROM garden where id = '" + id + "';";
            Cursor cursor = this.sdb.query("image", null, "_id = ?", null, null, null, null, null);

            //return empty arraylist if cursor is null
            if (cursor == null)
                return listOfImagaeTableData;

            //get all of the gardens beds with notes

            if (cursor.moveToFirst()) {
                do {
                    imageTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    imageTableData.setImage(cursor.getBlob(cursor.getColumnIndex("image")));

                    listOfImagaeTableData.add(imageTableData);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("ImageTableData", e.getMessage());
        }

        this.sdb.close();
        return listOfImagaeTableData;
    }

    /**
     * Used to get <LayoutTableData/> from the database, listed from first row to last row
     *
     * @param id
     * @return ArrayList of <LayoutTableData/> Objects
     */
    public ArrayList<LayoutTableData> getLayoutTableData(int id) {

        ArrayList<LayoutTableData> listOfLayoutTableData = new ArrayList<>();
        try{
            this.sdb = getReadableDatabase();
            LayoutTableData layoutTableData = new LayoutTableData();

            String dataExtracter = "SELECT *  FROM garden where id = '" + id + "';";
            Cursor cursor = this.sdb.query("layout", null, "_id = ?", null, null, null, null, null);

            //return empty arraylist if cursor is null
            if (cursor == null)
                return listOfLayoutTableData;

            //get all of the gardens beds with notes

            if (cursor.moveToFirst()) {
                do {
                    layoutTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    layoutTableData.setImage(cursor.getBlob(cursor.getColumnIndex("image")));

                    listOfLayoutTableData.add(layoutTableData);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("LayoutTableData", e.getMessage());
        }
        return listOfLayoutTableData;
    }

    /**
     * Used to get <NoteTableData/> from the database, listed from first row to last row
     *
     * @param id
     * @return ArrayList of <NoteTableData/> Objects
     */
    public ArrayList<NoteTableData> getNoteTableData(int id) {
        this.sdb = getReadableDatabase();

        ArrayList<NoteTableData> listOfNoteTableData = new ArrayList<>();
        NoteTableData noteTableData = new NoteTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor = this.sdb.query("note", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfNoteTableData;

        //get all of the gardens beds with notes
        try {
            if (cursor.moveToFirst()) {
                do {
                    noteTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    noteTableData.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
                    noteTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfNoteTableData.add(noteTableData);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("NoteTableData", e.getMessage());
        }

        this.sdb.close();
        return listOfNoteTableData;
    }

    /**
     * Used to get <HistoryTableData/> from the database, listed from first row to last row
     *
     * @param id
     * @return ArrayList of <HistoryTableData/> Objects
     */
    public ArrayList<HistoryTableData> getHistopryTableData(int id) {
        this.sdb = getReadableDatabase();

        ArrayList<HistoryTableData> listOfHistoryTableData = new ArrayList<>();
        HistoryTableData historyTableData = new HistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor = sdb.query("history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfHistoryTableData;

        //get all of the gardens beds with notes
        try {
            if (cursor.moveToFirst()) {
                do {
                    historyTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    historyTableData.setPlantHistotyID(cursor.getInt(cursor.getColumnIndex("plantHistoryID")));
                    historyTableData.setWorkHistoryID(cursor.getInt(cursor.getColumnIndex("workHistoryID")));
                    historyTableData.setHarvestHistoryID(cursor.getInt(cursor.getColumnIndex("harvestHistoryID")));

                    listOfHistoryTableData.add(historyTableData);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("HistoryTableData", e.getMessage());
        }

        this.sdb.close();
        return listOfHistoryTableData;
    }

    /**
     * Used to get <PlantHistoryTableData/> from the database, listed from first row to last row
     *
     * @param id
     * @return ArrayList of <PlantHistoryTableData/> Objects
     */
    public ArrayList<PlantHistoryTableData> getPlantHistoryTableData(int id) {
        this.sdb = getReadableDatabase();

        ArrayList<PlantHistoryTableData> listOfPlantHistoryTableData = new ArrayList<>();
        PlantHistoryTableData plantHistoryTableData = new PlantHistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor = this.sdb.query("plant_history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfPlantHistoryTableData;

        //get all of the gardens beds with notes
        try {
            if (cursor.moveToFirst()) {
                do {
                    plantHistoryTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    plantHistoryTableData.setDate(cursor.getString(cursor.getColumnIndex("date")));
                    plantHistoryTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfPlantHistoryTableData.add(plantHistoryTableData);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("PlantHistoryTableData", e.getMessage());
        }

        this.sdb.close();
        return listOfPlantHistoryTableData;
    }

    /**
     * Used to get <WorkHistoryTableData/> from the database, listed from first row to last row
     *
     * @param id
     * @return ArrayList of <WorkHistoryTableData/> Objects
     */
    public ArrayList<WorkHistoryTableData> getWorkHistoryTableData(int id) {
        this.sdb = getReadableDatabase();

        ArrayList<WorkHistoryTableData> listOfWorkHistoryTableData = new ArrayList<>();
        WorkHistoryTableData workHistoryTableData = new WorkHistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor = this.sdb.query("work_history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfWorkHistoryTableData;

        //get all of the gardens beds with notes
        try {
            if (cursor.moveToFirst()) {
                do {
                    workHistoryTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    workHistoryTableData.setDate(cursor.getString(cursor.getColumnIndex("date")));
                    workHistoryTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfWorkHistoryTableData.add(workHistoryTableData);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("WorkHistoryTableData", e.getMessage());
        }

        this.sdb.close();
        return listOfWorkHistoryTableData;
    }

    /**
     * Used to get <HarvestHistoryTableData/> from the database, listed from first row to last row
     *
     * @param id
     * @return ArrayList of <HarvestHistoryTableData/> Objects
     */
    public ArrayList<HarvestHistoryTableData> getHarvestHistoryTableData(int id) {
        this.sdb = getReadableDatabase();
        ArrayList<HarvestHistoryTableData> listOfHarvestHistoryTableData = new ArrayList<>();
        HarvestHistoryTableData harvestHistoryTableData = new HarvestHistoryTableData();

        //String dataExtracter = "SELECT *  FROM garden where id = '"+id+"';";
        Cursor cursor = this.sdb.query("harvest_history", null, "_id = ?", null, null, null, null, null);

        //return empty arraylist if cursor is null
        if (cursor == null)
            return listOfHarvestHistoryTableData;

        //get all of the gardens beds with notes
        try {
            if (cursor.moveToFirst()) {
                do {
                    harvestHistoryTableData.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    harvestHistoryTableData.setDate(cursor.getString(cursor.getColumnIndex("date")));
                    harvestHistoryTableData.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    listOfHarvestHistoryTableData.add(harvestHistoryTableData);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("HarvestHistoryTableData", e.getMessage());
        }

        this.sdb.close();
        return listOfHarvestHistoryTableData;
    }

}
