package id.baperan.baper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import id.baperan.baper.Fragment.GambarFragment;
import id.baperan.baper.Fragment.ChatFragment;
import id.baperan.baper.Fragment.ContactsFragment;
import id.baperan.baper.Fragment.HomeFragment;
import id.baperan.baper.Fragment.TimelineFragment;

public class HomeActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;


    //Fragments

    ChatFragment chatFragment;
    GambarFragment gambarFragment;
    ContactsFragment ContactsFragment;
    HomeFragment homeFragment;
    TimelineFragment timelineFragment;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_timeline:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_home:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_chat:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        timelineFragment =new TimelineFragment();
        homeFragment =new HomeFragment();
        chatFragment=new ChatFragment();

        adapter.addFragment(timelineFragment);
        adapter.addFragment(homeFragment);
        adapter.addFragment(chatFragment);
        viewPager.setAdapter(adapter);
    }
}
