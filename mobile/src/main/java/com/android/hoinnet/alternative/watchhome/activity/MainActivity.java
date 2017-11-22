package com.android.hoinnet.alternative.watchhome.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.android.hoinnet.alternative.watchhome.BaseFragmentActivity;
import com.android.hoinnet.alternative.watchhome.R;
import com.android.hoinnet.alternative.watchhome.cross.HorizontalInfiniteCycleViewPager;
import com.android.hoinnet.alternative.watchhome.cross.HorizontalPagerAdapter;
import com.android.hoinnet.alternative.watchhome.fragment.CenterFragment;
import com.android.hoinnet.alternative.watchhome.fragment.LeftFragment;
import com.android.hoinnet.alternative.watchhome.fragment.RightFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseFragmentActivity {

    private HorizontalInfiniteCycleViewPager mHorizontalInfiniteCycleViewPager;
    private List<Fragment> mFragmentList;
    private LeftFragment mLeftFragment;
    private CenterFragment mCenterFragment;
    private RightFragment mRightFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFragmentList = new ArrayList<>();
        mLeftFragment = new LeftFragment();
        mCenterFragment = new CenterFragment();
        mRightFragment = new RightFragment();
        mFragmentList.add(mLeftFragment);
        mFragmentList.add(mCenterFragment);
        mFragmentList.add(mRightFragment);
        mHorizontalInfiniteCycleViewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.main_horizontalinfinitecycleviewpager);
        mHorizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter(getSupportFragmentManager(), mHorizontalInfiniteCycleViewPager, mFragmentList));
    }
}
