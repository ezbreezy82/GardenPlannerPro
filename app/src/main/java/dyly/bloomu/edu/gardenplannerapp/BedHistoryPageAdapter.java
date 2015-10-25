package dyly.bloomu.edu.gardenplannerapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by EVANDESKTOP on 10/25/2015.
 */
public class BedHistoryPageAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs;

    public BedHistoryPageAdapter(FragmentManager fm, int numOfTabs)
    {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                BedPlantHistoryActivity plantHistoryTab = new BedPlantHistoryActivity();
                return plantHistoryTab;
            case 1:
                BedHarvestHistoryActivity harvestHistoryTab = new BedHarvestHistoryActivity();
                return harvestHistoryTab;
            case 2:
                BedWorkHistoryActivity workHistoryTab = new BedWorkHistoryActivity();
                return workHistoryTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}