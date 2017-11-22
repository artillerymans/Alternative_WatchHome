package com.android.hoinnet.alternative.watchhome.interfaces;

/**
 * Created by zhuzhiwei on 17-11-22.
 */

public interface OnExtraPageChangeListener {
    void onExtraPageScrolled(int position, float positionOffset, int positionOffsetPixels);
    void onExtraPageSelected(int position);
    void onExtraPageScrollStateChanged(int state);
}
