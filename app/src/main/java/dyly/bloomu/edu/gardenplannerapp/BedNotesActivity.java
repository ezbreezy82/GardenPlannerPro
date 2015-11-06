package dyly.bloomu.edu.gardenplannerapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BedNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_notes_actvity);
        //add custom header to list view.
        View header = getLayoutInflater().inflate(R.layout.custom_bed_notes_header, null);
        final ListView noteList = (ListView) findViewById(R.id.noteList);
        noteList.addHeaderView(header, null, false);

        //demo for ListView
        Note note_data[] = new Note[15];
        for (int i = 0; i < note_data.length; i++)
        {
            note_data[i] = new Note("Subject Line!!!", "won't be displayed");
        }

        BedLayoutNoteListAdapter adapter = new BedLayoutNoteListAdapter(this,
                R.layout.custom_bed_note, note_data);
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
