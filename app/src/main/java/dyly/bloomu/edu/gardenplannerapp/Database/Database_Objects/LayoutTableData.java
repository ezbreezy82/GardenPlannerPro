package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import java.sql.Blob;

/**
 * Created by Dyly on 11/4/15.
 */
public class LayoutTableData {

    private int id;
    private byte[] image;

    public LayoutTableData(){

        this.id = -1;
        this.image = null;
    }
    public LayoutTableData(int id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
