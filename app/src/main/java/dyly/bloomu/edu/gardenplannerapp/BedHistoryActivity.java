package dyly.bloomu.edu.gardenplannerapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class BedHistoryActivity extends AppCompatActivity {

    //Static strings to fill the tab text in onCreate()
    private static final String BED_PLANT_HISTORY = "Plant History";
    private static final String BED_HARVEST_HISTORY = "Harvest History";
    private static final String BED_WORK_HISTORY = "Work History";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_history);

        //Retrieve TabLayout component and set the text of each tab.
        TabLayout bedHistoryTabLayout = (TabLayout) findViewById(R.id.bedHistoryTabLayout);
        bedHistoryTabLayout.addTab(bedHistoryTabLayout.newTab().setText(BED_PLANT_HISTORY));
        bedHistoryTabLayout.addTab(bedHistoryTabLayout.newTab().setText(BED_HARVEST_HISTORY));
        bedHistoryTabLayout.addTab(bedHistoryTabLayout.newTab().setText(BED_WORK_HISTORY));
        bedHistoryTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Retrieve ViewPager component and implement the listeners for the tabs.
        final ViewPager bedHistoryViewPager = (ViewPager) findViewById(R.id.bedHistoryViewPager);
        final BedHistoryPageAdapter adapter = new BedHistoryPageAdapter(getSupportFragmentManager(),
                bedHistoryTabLayout.getTabCount());
        bedHistoryViewPager.setAdapter(adapter);
        bedHistoryViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(bedHistoryTabLayout));
        bedHistoryTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                bedHistoryViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //do nothing for now.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //do nothing for now.
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bed_history, menu);
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
}
