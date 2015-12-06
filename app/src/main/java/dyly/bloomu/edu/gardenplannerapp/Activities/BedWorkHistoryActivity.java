package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dyly.bloomu.edu.gardenplannerapp.R;

/**
 * Created by EVANDESKTOP on 10/25/2015.
 */
public class BedWorkHistoryActivity extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_bed_work_history, container, false);
    }
}