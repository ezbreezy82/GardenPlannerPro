package dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects;

/**
 * Created by Dyly on 11/4/15.
 */
public class NoteTableData {
    private int id;
    private String subject, note;

    public NoteTableData()
    {
        this.id = -1;
        this.subject = null;
        this.note = null;
    }

    public NoteTableData(int id, String subject, String note) {
        this.id = id;
        this.subject = subject;
        this.note = note;
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
}
