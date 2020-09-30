package android.eservices.staticfragmenttabs;

import android.os.Bundle;
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
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();

        /*final Button button_increment = (Button) findViewById(R.id.button_increment);
        final Button button_decrement = (Button) findViewById(R.id.button_increment);
        button_increment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
            }
        });*/
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

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}
