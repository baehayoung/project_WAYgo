package iann.com.cumap;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    public static float currentX=0;
    public static float currentY=0;
    public static float destX=0;
    public static float destY=0;
    private ClientNet clientNet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientNet = new ClientNet();

        ViewPager mViewPger = (ViewPager)findViewById(R.id.view_pager);
        TabLayout mTab = (TabLayout) findViewById(R.id.tabs);

        FragmentPagerAdapter mFragmentPagerAdapter = new FragPagerAdapter(
                getSupportFragmentManager());
        mViewPger.setAdapter(mFragmentPagerAdapter);
        mTab.setupWithViewPager(mViewPger);

        receiveData();
    }

    private void receiveData(){
        clientNet.receiveInfo();
    }
}
