package dyly.bloomu.edu.gardenplannerapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import dyly.bloomu.edu.gardenplannerapp.Note;
import dyly.bloomu.edu.gardenplannerapp.R;

/**
 * Created by EVANDESKTOP on 11/5/2015.
 */
public class BedLayoutNoteListAdapter extends ArrayAdapter<Note> {

    Context context;
    int layoutResourceId;
    Note data[] = null;

    public BedLayoutNoteListAdapter(Context context, int layoutResourceId, Note[] data)
    {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        NoteHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new NoteHolder();
            holder.subject = (TextView)row.findViewById(R.id.subject);
            holder.timeStamp = (TextView)row.findViewById(R.id.timeStamp);

            row.setTag(holder);
        }else
        {
            holder = (NoteHolder)row.getTag();
        }

        Note note = data[position];
        holder.subject.setText(note.getSubject());

        //format date.
        String timeStampFormatted = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(note.getTimeStamp());
        holder.timeStamp.setText(timeStampFormatted);

        return row;
    }

    static class NoteHolder
    {
        TextView subject;
        TextView timeStamp;
    }
}


