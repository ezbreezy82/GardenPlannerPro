package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by Dyly on 11/3/15.
 */
public class GardenTableData implements Serializable {

    private int id, bedID, noteID;
    public static final String TABLE_NAME= "Garden";
    public GardenTableData()
    {
        this.id = -1;
        this.bedID = -1;
        this.noteID = -1;

    }
    public GardenTableData(int id, int bedID, int noteID)
    {
        this.id = id;
        this.bedID = bedID;
        this.noteID = noteID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBedID() {
        return bedID;
    }

    public void setBedID(int bedID) {
        this.bedID = bedID;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
}
