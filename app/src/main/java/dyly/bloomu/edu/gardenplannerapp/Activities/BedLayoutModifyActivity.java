package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import dyly.bloomu.edu.gardenplannerapp.Database.DBHelper;
import dyly.bloomu.edu.gardenplannerapp.Database.Database_Objects.LayoutTableData;
import dyly.bloomu.edu.gardenplannerapp.R;


public class BedLayoutModifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_layout_modify);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bed_layout_modify, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        DBHelper dbHelper = DBHelper.getInstance(getApplicationContext());

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.saveModifiedBedImage)
        {
            final CustomBedLayoutCanvas canvas = (CustomBedLayoutCanvas) findViewById(R.id.canvas);
            Bitmap bmp = canvas.getmBitmap();
            LayoutTableData layoutTableData = new LayoutTableData();

            //convert bitmap to byte array for storage
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            //memory leak catch
            try {
                stream.close();
                bmp.recycle();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //set attributes for saving the layout
            layoutTableData.setImage(byteArray);
            layoutTableData.setBedID(getIntent().getIntExtra("BedId", -1));

            //save layout
            dbHelper.setLayoutTableData(layoutTableData);

            Toast.makeText(this,"Layout has been saved!",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void clearCanvas(View view)
    {
        final CustomBedLayoutCanvas canvas = (CustomBedLayoutCanvas) findViewById(R.id.canvas);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Clear Drawing");
        builder.setMessage("Are you sure you want to delete the current drawing?").
        setCancelable(true).
        setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                canvas.clearCanvas();
            }
        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.show();
    }

    public void undo(View view) {
        final CustomBedLayoutCanvas canvas = (CustomBedLayoutCanvas) findViewById(R.id.canvas);
        canvas.undo();
    }

    public void changeDrawingColor(View view)
    {
        Toast.makeText(this, "Coming soon.", Toast.LENGTH_LONG).show();
    }
}
