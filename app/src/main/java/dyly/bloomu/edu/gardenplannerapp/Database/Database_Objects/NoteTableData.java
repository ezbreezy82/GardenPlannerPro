package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

import android.util.Log;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dyly on 11/4/15.
 */
public class NoteTableData implements Serializable {
    private int id, bedID, gardenID, alert;
    private Date date;
    private String subject, note;

    public NoteTableData()
    {
        this.subject = null;
        this.note = null;
        setDate(Calendar.getInstance().toString());
    }

    public NoteTableData( String subject, String note, String date, int bedID, int gardenID, int alert) {
        this.subject = subject;
        this.note = note;
        setDate(date);
        this.bedID = bedID;
        this.gardenID = gardenID;
        this.alert = alert;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    /**
     * used for database retrieval of code
     * @param date string to be formated to a date
     */
    public void setDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            Log.d("Date for Plant History", e.getMessage());
        }

        this.date = convertedDate;
    }
}
