package dyly.bloomu.edu.gardenplannerapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import dyly.bloomu.edu.gardenplannerapp.Note;
import dyly.bloomu.edu.gardenplannerapp.R;

/**
 * Created by EVANDESKTOP on 11/17/2015.
 */
public class HarvestHistoryNoteListAdapter extends ArrayAdapter<Note>
{
    Context context;
    int layoutResourceId;
    Note data[] = null;
    private ListPopupWindow listPopupWindow;
    private String[] controls = {"Edit", "Delete"};

    public HarvestHistoryNoteListAdapter(Context context, int layoutResourceId, Note[] data)
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
            holder.noteControls = (ImageButton)row.findViewById(R.id.noteControls);

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
        holder.noteControls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPopupWindow = new ListPopupWindow(getContext());
                listPopupWindow.setAdapter(new ArrayAdapter<>(
                        getContext(),
                        R.layout.custom_bed_note_control_list_item,
                        controls));
                listPopupWindow.setAnchorView(v.findViewById(R.id.noteControls));
                listPopupWindow.setWidth(100);
                listPopupWindow.setHeight(120);
                listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //if position == 1, Edit mode. redirect to edit the note.
                        if (position == 0)
                            redirectToEditNote();
                        if (position == 1)
                            requestDeletionOfNote();

                    }
                });
                listPopupWindow.show();


            }
        });

        return row;
    }

    static class NoteHolder
    {
        TextView subject;
        TextView timeStamp;
        ImageButton noteControls;
    }

    public void redirectToEditNote()
    {
        Toast.makeText(getContext(), "Coming soon", Toast.LENGTH_LONG).show();
    }

    public void requestDeletionOfNote()
    {
        Toast.makeText(getContext(),"Coming soon",Toast.LENGTH_LONG).show();
    }
}
