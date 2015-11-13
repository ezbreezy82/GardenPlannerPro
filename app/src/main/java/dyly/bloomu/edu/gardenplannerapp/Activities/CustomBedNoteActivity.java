package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import dyly.bloomu.edu.gardenplannerapp.R;


/**
 * Created by EVANDESKTOP on 11/2/2015.
 */
public class CustomBedNoteActivity extends LinearLayout
{
    public CustomBedNoteActivity(Context context) {
        super(context, null);

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_bed_note, this);
    }
}
