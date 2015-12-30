package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import dyly.bloomu.edu.gardenplannerapp.Database.DBHelper;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.NoteTableData;
import dyly.bloomu.edu.gardenplannerapp.R;


public class AddNewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_note, menu);
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

    /**
     * To save a note in the database
     * @param view
     */
    public void onSave(View view)
    {
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
        NoteTableData noteTableData = new NoteTableData();
        EditText subject = (EditText)findViewById(R.id.subject_edit_text);
        EditText note = (EditText) findViewById(R.id.note_edit_text);


        noteTableData.setSubject(subject.getText().toString());
        noteTableData.setNote(note.getText().toString());
        //check if its a bed or garden note

        noteTableData.setBedID(getIntent().getIntExtra("BedID",-1));
        noteTableData.setAlert(0);

        dbHelper.setNoteTableData(noteTableData);
        //Closes activity
        finish();

    }
}
