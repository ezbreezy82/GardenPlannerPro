package dyly.bloomu.edu.gardenplannerapp;

/**
 * Created by Dyly on 11/4/15.
 */
public class HistoryTableData {

    private int id, plantHistoryID, workHistoryID, harvestHistoryID;

    public HistoryTableData()
    {
        this.id = -1;
        this.plantHistoryID = -1;
        this.workHistoryID = -1;
        this.harvestHistoryID = -1;
    }

    public HistoryTableData(int id, int plantHistoryID, int workHistoryID, int harvestHistoryID) {
        this.id = id;
        this.plantHistoryID = plantHistoryID;
        this.workHistoryID = workHistoryID;
        this.harvestHistoryID = harvestHistoryID;
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
}
