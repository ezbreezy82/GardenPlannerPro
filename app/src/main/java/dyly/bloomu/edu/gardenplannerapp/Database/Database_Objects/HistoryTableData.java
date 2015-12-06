package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import java.io.Serializable;

/**
 * Created by Dyly on 11/4/15.
 */
public class HistoryTableData implements Serializable {

<<<<<<< HEAD:app/src/main/java/dyly/bloomu/edu/gardenplannerapp/HistoryTableData.java
    private int id, plantHistoryID, workHistoryID, harvestHistoryID;
=======
    private int id, plantHistotyID, workHistoryID, harvestHistoryID, bedID;
>>>>>>> pr/4:app/src/main/java/dyly/bloomu/edu/gardenplannerapp/Database/Database_Objects/HistoryTableData.java

    public HistoryTableData()
    {
        this.id = -1;
        this.plantHistoryID = -1;
        this.workHistoryID = -1;
        this.harvestHistoryID = -1;
        this.bedID = -1;
    }

<<<<<<< HEAD:app/src/main/java/dyly/bloomu/edu/gardenplannerapp/HistoryTableData.java
    public HistoryTableData(int id, int plantHistoryID, int workHistoryID, int harvestHistoryID) {
=======
    public HistoryTableData(int id, int plantHistotyID, int workHistoryID, int harvestHistoryID, int bedID) {
>>>>>>> pr/4:app/src/main/java/dyly/bloomu/edu/gardenplannerapp/Database/Database_Objects/HistoryTableData.java
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

    public int getPlantHistotyID() {
        return plantHistoryID;
    }

    public void setPlantHistotyID(int plantHistoryID) {
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
