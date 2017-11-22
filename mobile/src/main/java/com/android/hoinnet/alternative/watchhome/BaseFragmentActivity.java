package com.android.hoinnet.alternative.watchhome;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class BaseFragmentActivity extends FragmentActivity {
	protected String TAG = this.getClass().getSimpleName();
	protected Fragment mContent;
	protected FragmentManager mFragmentManager;
	protected Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		//每创建一个活动，就加入到活动管理器中  
		mFragmentManager = getSupportFragmentManager();
	}


	public void onResume() {
		super.onResume();
	}

	public void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		//每销毁一个活动，就从活动管理器中移除  
		super.onDestroy();
	}
}
