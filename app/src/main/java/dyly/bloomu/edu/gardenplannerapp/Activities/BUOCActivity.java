package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.BedTableData;
import dyly.bloomu.edu.gardenplannerapp.Database.DBHelper;
import dyly.bloomu.edu.gardenplannerapp.R;


public class BUOCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
        //BedTableData bedTableData = new BedTableData(1,1,1,1);
        //dbHelper.setBedTableData(bedTableData);

        setContentView(R.layout.activity_buoc);

        LinearLayout gardenLayout = (LinearLayout) findViewById(R.id.gardenLayoutLinear);


        //create buttons to put inside linear layout
        int counter = 1;
        for (int rows = 0; rows < 10; rows++)
        {
            LinearLayout currentLinear = new LinearLayout(this);
            currentLinear.setOrientation(LinearLayout.HORIZONTAL);

            for(int cols = 0; cols < 3; cols++)
            {
                final Button currButton = new Button(this);
                LinearLayout.LayoutParams param;
                param = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT, 1.0f);
                currButton.setLayoutParams(param);
                currButton.setWidth(50);
                currButton.setHeight(125);
                currButton.setGravity(Gravity.CENTER);
                currButton.setId(counter);
                currButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        redirectToBedOptions(currButton);
                    }
                });
                currButton.setText("" + currButton.getId());
                currentLinear.addView(currButton);
                counter++;
            }
            gardenLayout.addView(currentLinear);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void redirectToGardenNotes(View view)
    {
        Intent intent = new Intent(this, GardenNotesActivity.class);
        startActivity(intent);
    }

    public void redirectToBedOptions(View view)
    {
        Intent intent = new Intent(this, BedOptionsActivity.class);
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
        //findout what bed was clicked ID should be some integer from 1-30
        int bedID = view.getId();
        //set bed data for next activity
        ArrayList<BedTableData> listOfbedTableData = dbHelper.getBedTableData(bedID);
        Log.d("first bed retrieval", ""+listOfbedTableData.size());

        if(listOfbedTableData.isEmpty()){
            Log.d("Database", "No bed in DB");
            try{
                BedTableData bedTableData = new BedTableData();
                bedTableData.setGardenID(1);
                dbHelper.setBedTableData(bedTableData);
            }catch (SQLException e){
                Log.d("Database", e.getMessage());
            }

        }
        intent.putExtra("BedTableData", dbHelper.getBedTableData(bedID));

        startActivity(intent);
    }

    public void redirectToAddNewNoteActivity(View view)
    {
        Intent intent = new Intent(this, AddNewNoteActivity.class);
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());

        //a lttle help to see if its from the garden layout or bed options page
        intent.putExtra("BedorGarden", 0);
        intent.putExtra("GardenTableData", dbHelper.getGardenTableData(1));
        startActivity(intent);
    }
}
