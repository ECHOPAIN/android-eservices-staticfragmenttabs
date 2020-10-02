package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int currentCounter;
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private TextView counterTextView;
    private TextView counter_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
        counter_textview = (TextView)  findViewById(R.id.counter_textview);
        counter_textview.setText(getResources().getString(R.string.counter_text,currentCounter));


    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {

        //we want two fragments with layouts : fragment_one, fragment_two.

        final Fragment fragment_one = FragmentOne.newInstance();
        final Fragment fragment_two = FragmentTwo.newInstance();


        //set adapter to viewpager and handle tragment change inside
        //viewpager.setAdapter(...);

        viewPager = (ViewPager) findViewById(R.id.tab_viewpager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position == 0){
                    return fragment_one;
                }else{
                    return fragment_two;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

    }


    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "Fragment1");
        adapter.addFragment(new FragmentTwo(), "Fragment2");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }

    public void setCurrentCounter(int value) {
        currentCounter = value;
    }

    public int getCurrentCounter() {
        return currentCounter;
    }

    public void updateCurrentCounterDisplay() {
        counter_textview.setText(getResources().getString(R.string.counter_text,currentCounter));
    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}
