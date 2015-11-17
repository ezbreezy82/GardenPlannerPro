package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import java.io.Serializable;

/**
 * Created by Dyly on 11/3/15.
 */
public class BedTableData implements Serializable{

    private int id, noteID, layoutID, imageID, historyID, gardenID;

    public BedTableData() {
        this.id = -1;
        this.noteID = -1;
        this.layoutID = -1;
        this.imageID = -1;
        this.historyID = -1;
        this.gardenID = -1;
    }

    public BedTableData(int noteID, int layoutID, int imageID, int historyID, int gardenID) {
        this.noteID = noteID;
        this.layoutID = layoutID;
        this.imageID = imageID;
        this.historyID = historyID;
        this.gardenID = gardenID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public int getLayoutID() {
        return layoutID;
    }

    public void setLayoutID(int layoutID) {
        this.layoutID = layoutID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    public int getGardenID() {
        return gardenID;
    }

    public void setGardenID(int gardenID) {
        this.gardenID = gardenID;
    }
}
