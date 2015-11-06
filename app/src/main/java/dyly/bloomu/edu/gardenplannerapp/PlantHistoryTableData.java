package dyly.bloomu.edu.gardenplannerapp;

import java.util.Date;

/**
 * Created by Dyly on 11/4/15.
 */
public class PlantHistoryTableData {
    private int id;
    private Date date;
    private String note;

    public PlantHistoryTableData()
    {
        this.id = -1;
        this.date = null;
        this.note = null;
    }

    public PlantHistoryTableData(int id, Date date, String note) {
        this.id = id;
        this.date = date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
