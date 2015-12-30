package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import dyly.bloomu.edu.gardenplannerapp.Adapters.PlantHistoryNoteListAdapter;
import dyly.bloomu.edu.gardenplannerapp.Note;
import dyly.bloomu.edu.gardenplannerapp.R;

/**
 * Created by EVANDESKTOP on 10/25/2015.
 */
public class BedPlantHistoryActivity extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_bed_plant_history, container, false);

        //add custom header to list view.
        View header = getActivity().getLayoutInflater().inflate(R.layout.custom_notes_header, null);
        final ListView noteList = (ListView) rootView.findViewById(R.id.plantHistoryList);
        noteList.addHeaderView(header, null, false);

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Note presentation_data[] = null;
        try
        {
            presentation_data = new Note[]
                    {
                            new Note("re soiled bed", "Resoiled the bed and watered the specified bed.", formatter.parse("11/02/2015 2:22")),
                            new Note("Removed stink bugs.", "Bed was infested with stink bugs. I removed them " +
                                    "from the bed and sprayed so they will not come back.  " +
                                    "Please check to make sure that they are not there when viewing this.", formatter.parse("11/07/2015 3:13")),
                            new Note("Terminated japanese beetles", "", formatter.parse("10/31/2015 4:56")),
                            new Note("Replanted the carrots", "", formatter.parse("10/23/2015 5:05")),
                            new Note ("Plant seems dry", "", formatter.parse("11/09/2015 1:13"))

                    };
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        PlantHistoryNoteListAdapter adapter = new PlantHistoryNoteListAdapter(getContext(),
                R.layout.custom_bed_note, presentation_data);
        noteList.setAdapter(adapter);
        return rootView;
    }
    public void redirectToAddNewHistoryActivity(View view)
    {
        Intent intent = new Intent(getContext(), AddNewNoteActivity.class);
        startActivity(intent);
    }
}