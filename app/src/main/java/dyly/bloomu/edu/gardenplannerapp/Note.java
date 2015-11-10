package dyly.bloomu.edu.gardenplannerapp;

import java.util.Date;

/**
 * Created by EVANDESKTOP on 11/5/2015.
 */
public class Note {
    private String subject;
    private String note;
    private Date timeStamp;


    public Note(){super();}

    public Note(String subject, String note)
    {
        super();
        this.subject = subject;
        this.note = note;
        //give object a timestamp when created.
        this.timeStamp = new Date();

    }

    public Note(String subject, String note, Date timeStamp)
    {
        this.subject = subject;
        this.note = note;
        this.timeStamp = timeStamp;
    }

    public String getSubject(){ return subject; }
    public String getNote(){ return note; }
    public Date getTimeStamp() { return timeStamp; }
}
