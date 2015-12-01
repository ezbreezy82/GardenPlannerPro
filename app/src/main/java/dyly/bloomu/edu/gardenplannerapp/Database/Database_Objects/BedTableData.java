package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import java.io.Serializable;

/**
 * Created by Dyly on 11/3/15.
 */
public class BedTableData implements Serializable{

    private int id, gardenID;

    public BedTableData() {
        this.gardenID = -1;
    }

    public BedTableData( int gardenID) {
        this.gardenID = gardenID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGardenID() {
        return gardenID;
    }

    public void setGardenID(int gardenID) {
        this.gardenID = gardenID;
    }
}
