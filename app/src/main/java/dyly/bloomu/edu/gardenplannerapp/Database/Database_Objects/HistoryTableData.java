package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import java.io.Serializable;

/**
 * Created by Dyly on 11/4/15.
 */
public class HistoryTableData implements Serializable {

    private int id, plantHistoryID, workHistoryID, harvestHistoryID, bedID;

    public HistoryTableData()
    {
        this.id = -1;
        this.plantHistoryID = -1;
        this.workHistoryID = -1;
        this.harvestHistoryID = -1;
        this.bedID = -1;
    }

    public HistoryTableData(int id, int plantHistoryID, int workHistoryID, int harvestHistoryID, int bedID) {
        this.id = id;
        this.plantHistoryID = plantHistoryID;
        this.workHistoryID = workHistoryID;
        this.harvestHistoryID = harvestHistoryID;
        this.bedID = bedID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlantHistoryID() {
        return plantHistoryID;
    }

    public void setPlantHistoryID(int plantHistoryID) {
        this.plantHistoryID = plantHistoryID;
    }

    public int getWorkHistoryID() {
        return workHistoryID;
    }

    public void setWorkHistoryID(int workHistoryID) {
        this.workHistoryID = workHistoryID;
    }

    public int getHarvestHistoryID() {
        return harvestHistoryID;
    }

    public void setHarvestHistoryID(int harvestHistoryID) {
        this.harvestHistoryID = harvestHistoryID;
    }

    public int getBedID() {
        return bedID;
    }

    public void setBedID(int bedID) {
        this.bedID = bedID;
    }
}
