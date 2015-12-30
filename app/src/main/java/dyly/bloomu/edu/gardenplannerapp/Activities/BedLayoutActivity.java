package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.BedTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.LayoutTableData;
import dyly.bloomu.edu.gardenplannerapp.R;


public class BedLayoutActivity extends AppCompatActivity {

    private int bedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_layout);

        //check to see if there are any layouts
        ArrayList<LayoutTableData> listOfLayoutTableData = (ArrayList <LayoutTableData>) getIntent().getSerializableExtra("LayoutTableData");
        if(listOfLayoutTableData.size() > 0){
            //fill the canvas with the bit map
        }

        bedId = getIntent().getIntExtra("BedId",-1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bed_layout, menu);
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
        if( id == R.id.modifyBedLayout)
        {
            redirectToBedLayoutModifyActivity(item);
        }

        return super.onOptionsItemSelected(item);
    }

    public void redirectToBedLayoutModifyActivity(MenuItem item) {
        Intent intent = new Intent(this, BedLayoutModifyActivity.class);

        intent.putExtra("BedId", bedId);
        startActivity(intent);
    }
}
