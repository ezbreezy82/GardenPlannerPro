package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import dyly.bloomu.edu.gardenplannerapp.Adapters.BedLayoutNoteListAdapter;
import dyly.bloomu.edu.gardenplannerapp.Note;
import dyly.bloomu.edu.gardenplannerapp.R;


public class BedNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_notes_actvity);
        //add custom header to list view.
        View header = getLayoutInflater().inflate(R.layout.custom_notes_header, null);
        final ListView noteList = (ListView) findViewById(R.id.noteList);
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

        //demo for ListView
        Note note_data[] = new Note[15];
        for (int i = 0; i < note_data.length; i++)
        {
            note_data[i] = new Note("Subject Line!!!", "won't be displayed");
        }

        BedLayoutNoteListAdapter adapter = new BedLayoutNoteListAdapter(this,
                R.layout.custom_bed_note, presentation_data);
        noteList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bed_notes_actvity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void redirectToAddNewNoteActivity(View view)
    {
        Intent intent = new Intent(this, AddNewNoteActivity.class);
        startActivity(intent);
    }


}
