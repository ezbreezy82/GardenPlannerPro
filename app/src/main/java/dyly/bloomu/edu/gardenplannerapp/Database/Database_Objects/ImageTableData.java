package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Dyly on 11/4/15.
 */
public class ImageTableData implements Serializable {

    private int id, bedID, gardenID;
    private byte[] image;

    public ImageTableData(){

        this.id = -1;
        this.bedID = -1;
        this.gardenID = -1;
        this.image = null;
    }

    public ImageTableData(int id, int bedID, int gardenID, byte[] image) {
        this.id = id;
        this.bedID = bedID;
        this.gardenID = gardenID;
        this.image = image;
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

    public int getGardenID() {
        return gardenID;
    }

    public void setGardenID(int gardenID) {
        this.gardenID = gardenID;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
