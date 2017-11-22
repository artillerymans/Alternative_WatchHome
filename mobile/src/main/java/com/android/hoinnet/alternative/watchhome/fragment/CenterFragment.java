package com.android.hoinnet.alternative.watchhome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hoinnet.alternative.watchhome.BaseFragment;
import com.android.hoinnet.alternative.watchhome.R;
import com.android.hoinnet.alternative.watchhome.cross.VerticalInfiniteCycleViewPager;
import com.android.hoinnet.alternative.watchhome.cross.VerticalPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuzhiwei on 17-11-22.
 */

public class CenterFragment extends BaseFragment {

    private VerticalInfiniteCycleViewPager mVerticalInfiniteCycleViewPager;
    private List<Fragment> mFragments;
    private CenterAtTopFragment mCenterAtTopFragment;
    private CenterAtCoverFragment mCenterAtCoverFragment;
    private CenterAtBotFragment mCenterAtBotFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_center, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVerticalInfiniteCycleViewPager = (VerticalInfiniteCycleViewPager) view.findViewById(R.id.center_verticalinfinitecycleviewpager);
        mFragments = new ArrayList<>();
        mCenterAtTopFragment = new CenterAtTopFragment();
        mCenterAtCoverFragment = new CenterAtCoverFragment();
        mCenterAtBotFragment = new CenterAtBotFragment();
        mFragments.add(mCenterAtTopFragment);
        mFragments.add(mCenterAtCoverFragment);
        mFragments.add(mCenterAtBotFragment);
        mVerticalInfiniteCycleViewPager.setAdapter(new VerticalPagerAdapter(getFragmentManager(), mVerticalInfiniteCycleViewPager, mFragments));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
