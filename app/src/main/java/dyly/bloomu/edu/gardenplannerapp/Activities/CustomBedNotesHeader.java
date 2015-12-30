package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import dyly.bloomu.edu.gardenplannerapp.R;

/**
 * Created by EVANDESKTOP on 11/5/2015.
 */
public class CustomBedNotesHeader extends LinearLayout
{

    public CustomBedNotesHeader(Context context)
    {
        super(context, null);

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_notes_header, this);
    }
}
