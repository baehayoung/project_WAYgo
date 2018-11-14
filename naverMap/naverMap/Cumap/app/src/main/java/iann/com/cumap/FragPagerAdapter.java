package iann.com.cumap;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragPagerAdapter extends FragmentPagerAdapter {
    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return MapFragment.newInstance();

            default:
                return null;
        }
    }

    private  static int PAGE_NUMBER = 1;
    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "WAYGO";

            default:
                return null;
        }
    }
}
