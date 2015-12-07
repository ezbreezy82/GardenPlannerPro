package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import dyly.bloomu.edu.gardenplannerapp.Database.DBHelper;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.BedTableData;
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

        //check to see if theres bed data
        ArrayList<BedTableData> bedTableData = (ArrayList<BedTableData>)getIntent().getSerializableExtra("BedTableData");

        if(!bedTableData.isEmpty())
        {
            System.out.println(bedTableData.get(0).getGardenID());
            System.out.println(bedTableData.get(0).getId());

        }else{
            System.out.println("No bed table data");
        }

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
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
        // get bed layouts
        ArrayList<BedTableData> listOfBedTableData = (ArrayList<BedTableData>) getIntent().getSerializableExtra("BedTableData");

        intent.putExtra("LayoutTableData", dbHelper.getLayoutTableData(listOfBedTableData.get(0).getId()));
        startActivity(intent);
    }

    public void redirectToBedHistoryActivity(View view)
    {
        Intent intent = new Intent(this, BedHistoryActivity.class);
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
        // get bed layouts
        ArrayList<BedTableData> listOfBedTableData = (ArrayList<BedTableData>) getIntent().getSerializableExtra("BedTableData");

        intent.putExtra("HistoryTableData", dbHelper.getHistoryTableData(listOfBedTableData.get(0).getId()));
        startActivity(intent);
    }

    public void redirectToBedNotesActivity(View view)
    {
        Intent intent = new Intent(this, BedNotesActivity.class);
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
        // get bed layouts
        ArrayList<BedTableData> listOfBedTableData = (ArrayList<BedTableData>) getIntent().getSerializableExtra("BedTableData");

        // a little help to tell if its from garden layout or bed options page
        intent.putExtra("BedorGarden", 1);
        intent.putExtra("NotesTableData", dbHelper.getNoteTableData(listOfBedTableData.get(0).getId()));
        startActivity(intent);
    }

    public void redirectToBedImagesActivity(View view)
    {
        Intent intent = new Intent(this, BedImagesActivity.class);
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
        // get bed layouts
        ArrayList<BedTableData> listOfBedTableData = (ArrayList<BedTableData>) getIntent().getSerializableExtra("BedTableData");

        intent.putExtra("LayoutTableData", dbHelper.getImageTableData(listOfBedTableData.get(0).getId()));
        startActivity(intent);
    }
}
