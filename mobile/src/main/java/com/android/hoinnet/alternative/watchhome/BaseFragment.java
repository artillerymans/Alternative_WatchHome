package com.android.hoinnet.alternative.watchhome;

import android.app.Activity;
import android.support.v4.app.Fragment;


public class BaseFragment extends Fragment {
	
	protected Activity mActivity;

	@SuppressWarnings("deprecation")
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mActivity = activity;
	}
}
