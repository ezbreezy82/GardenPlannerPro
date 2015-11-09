package dyly.bloomu.edu.gardenplannerapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());
         mydatabase = openOrCreateDatabase(dbHelper.getDatabaseName(),MODE_PRIVATE,null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mydatabase.close();
        Log.d("OnDestroy", "Database Closed");
    }

    public void redirectToBUOCActivity(View view)
    {

        Intent intent = new Intent(this, BUOCActivity.class);
        startActivity(intent);

    }

    public void redirectToPlantSeedDBctivity(View view)
    {
        Toast.makeText(this,"Database Coming soon",Toast.LENGTH_LONG).show();
    }

    public void redirectToSupportctivity(View view)
    {
        Intent intent = new Intent(this, SupportActivity.class);
        startActivity(intent);
    }

    public void redirectToAboutAppActivity(View view)
    {
        Intent intent = new Intent(this, AboutAppActivity.class);
        startActivity(intent);
    }
}
