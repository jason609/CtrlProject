package com.ctrl.ctrlproject;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.ctrl.ctrlproject.base.AppToolBarActivity;

import butterknife.ButterKnife;

public class AppBarLayoutActivity extends AppToolBarActivity implements View.OnClickListener{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.inject(this);
		setContentView(R.layout.activity_appbarlauout);
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.setStatusBarColor(Color.parseColor("#30469b"));
		}
	}
	public void initViews() {
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

		toolbar.setTitle("This is Title");
		toolbar.setNavigationIcon(R.drawable.back);
		setSupportActionBar(toolbar);
	}
	public void initListeners() {
	}
	public void initData() {

	}


	@Override
	public void onClick(View v) {
	}

	@Override
	public String setupToolBarTitle() {
		return "dfsdfsdf";
	}
}
