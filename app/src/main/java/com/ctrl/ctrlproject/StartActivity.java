package com.ctrl.ctrlproject;

import android.os.Bundle;
import android.os.Handler;

import com.ctrl.ctrlproject.base.AppToolBarActivity;
public class StartActivity extends AppToolBarActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);
		Handler x=new Handler();
		x.postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(MainActivity.class,null);
			}
		},3000);
	}
	public void initViews() {
	}


	public void initListeners() {
	}


	public void initData() {

	}


}
