package com.android.hoinnet.alternative.watchhome.cross;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.android.hoinnet.alternative.watchhome.interfaces.OnExtraPageChangeListener;

import java.util.List;


/**
 * Created by zhuzhiwei on 11/22/17.
 */
public class HorizontalPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener{
    private FragmentManager mFragmentManager;
    private List<Fragment> mFragments;
    private ViewPager mViewPager; // viewPager对象
    private int mCurrentPageIndex = 0; // 当前page索引（切换之前）
    private OnExtraPageChangeListener onExtraPageChangeListener; // ViewPager切换页面时的额外功能添加接口

    public HorizontalPagerAdapter(FragmentManager fragmentManager, ViewPager viewPager ,List<Fragment> fragmentList) {
        this.mFragmentManager = fragmentManager;
        this.mFragments = fragmentList;
        this.mViewPager = viewPager;
        this.mViewPager.setAdapter(this);
        this.mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        Fragment fragment = mFragments.get(position);
        if(!fragment.isAdded()){  //如果fragment还没有added
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.add(fragment, fragment.getClass().getSimpleName());
            ft.commitAllowingStateLoss();
            mFragmentManager.executePendingTransactions();
        }

        if(fragment.getView().getParent() == null){
            container.addView(fragment.getView()); // 为viewpager增加布局
        }

        return fragment.getView();
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView(mFragments.get(position).getView()); // 移出viewpager两边之外的page布局
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(null != onExtraPageChangeListener){ // 如果设置了额外功能接口
            onExtraPageChangeListener.onExtraPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        mFragments.get(mCurrentPageIndex).onPause(); // 调用切换前Fargment的onPause()
        //fragments.get(currentPageIndex).onStop(); // 调用切换前Fargment的onStop()
        if(mFragments.get(position).isAdded()){
            //fragments.get(i).onStart(); // 调用切换后Fargment的onStart()
            mFragments.get(position).onResume(); // 调用切换后Fargment的onResume()
        }
        mCurrentPageIndex = position;

        if(null != onExtraPageChangeListener){ // 如果设置了额外功能接口
            onExtraPageChangeListener.onExtraPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(null != onExtraPageChangeListener){ // 如果设置了额外功能接口
            onExtraPageChangeListener.onExtraPageScrollStateChanged(state);
        }
    }



    /**
     * 当前page索引（切换之前）
     * @return
     */
    public int getCurrentPageIndex() {
        return mCurrentPageIndex;
    }

    /**
     * 设置页面切换额外功能监听器
     * @param onExtraPageChangeListener
     */
    public void setOnExtraPageChangeListener(OnExtraPageChangeListener onExtraPageChangeListener) {
        this.onExtraPageChangeListener = onExtraPageChangeListener;
    }

    public OnExtraPageChangeListener getOnExtraPageChangeListener() {
        return onExtraPageChangeListener;
    }

}
