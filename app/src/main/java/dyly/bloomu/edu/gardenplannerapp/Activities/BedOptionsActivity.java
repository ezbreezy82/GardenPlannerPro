package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import dyly.bloomu.edu.gardenplannerapp.R;


public class BedOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_options);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bed_options, menu);
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

    public void redirectToBedLayoutActivity(View view)
    {
        Intent intent = new Intent(this, BedLayoutActivity.class);
        startActivity(intent);
    }

    public void redirectToBedHistoryActivity(View view)
    {
        Intent intent = new Intent(this, BedHistoryActivity.class);
        startActivity(intent);
    }

    public void redirectToBedNotesActivity(View view)
    {
        Intent intent = new Intent(this, BedNotesActivity.class);
        startActivity(intent);
    }

    public void redirectToBedImagesActivity(View view)
    {
        Intent intent = new Intent(this, BedImagesActivity.class);
        startActivity(intent);
    }
}
