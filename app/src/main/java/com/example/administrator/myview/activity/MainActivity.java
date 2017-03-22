package com.example.administrator.myview.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myview.R;
import com.example.administrator.myview.fragments.VpSimpleFragment;
import com.example.administrator.myview.view.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mviewPager;
    private ViewPagerIndicator mIndicator;

    private List<String> mTitles= Arrays.asList("短信1","收藏1","推荐1","短信2","收藏2","推荐2","短信3","收藏3","推荐3");
    private List<VpSimpleFragment> mContents=new ArrayList<>();
    private FragmentPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDatas();

        mviewPager.setAdapter(mAdapter);
        mIndicator.setmTabVisibleCount(4);
        mIndicator.setTabItemTitles(mTitles);
        mIndicator.setViewPager(mviewPager,0);

    }

    private void initDatas() {
        for(String title:mTitles){
            VpSimpleFragment fragment=VpSimpleFragment.newInstance(title);
            mContents.add(fragment);
        }

        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }

            @Override
            public int getCount() {
                return mContents.size();
            }
        };

    }

    private void initViews() {
        mviewPager=(ViewPager)findViewById(R.id.id_viewpager);
        mIndicator=(ViewPagerIndicator)findViewById(R.id.id_indicator);


    }


}
