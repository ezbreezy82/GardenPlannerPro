package dyly.bloomu.edu.gardenplannerapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by EVANDESKTOP on 10/25/2015.
 */
public class BedPlantHistoryActivity extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_bed_plant_history, container, false);
    }
}