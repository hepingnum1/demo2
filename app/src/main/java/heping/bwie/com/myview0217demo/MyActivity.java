package heping.bwie.com.myview0217demo;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends FragmentActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list=new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
         list.add(new MyF1());
        list.add(new F2());
        list.add(new F3());

       tabLayout= (TabLayout) findViewById(R.id.tablayout);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));

        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));

        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
     tabLayout.setupWithViewPager(viewPager);
       // tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
    class  MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        private String tabTitles[] = new String[]{"tab1", "tab2", "tab3"};
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
