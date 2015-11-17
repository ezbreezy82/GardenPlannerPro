package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import java.io.Serializable;

/**
 * Created by Dyly on 11/4/15.
 */
public class HistoryTableData implements Serializable {

    private int id, plantHistotyID, workHistoryID, harvestHistoryID, bedID;

    public HistoryTableData()
    {
        this.id = -1;
        this.plantHistotyID = -1;
        this.workHistoryID = -1;
        this.harvestHistoryID = -1;
        this.bedID = -1;
    }

    public HistoryTableData(int id, int plantHistotyID, int workHistoryID, int harvestHistoryID, int bedID) {
        this.id = id;
        this.plantHistotyID = plantHistotyID;
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
        return plantHistotyID;
    }

    public void setPlantHistotyID(int plantHistotyID) {
        this.plantHistotyID = plantHistotyID;
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
}
