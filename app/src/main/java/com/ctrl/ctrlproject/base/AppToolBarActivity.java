package com.ctrl.ctrlproject.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.beanu.arad.base.ToolBarActivity;
import com.beanu.arad.utils.AnimUtil;
import com.ctrl.ctrlproject.MainActivity;

/**
 * 当前项目 所有activity的基类
 * Created by jaosn on 2016-12-2.
 */
public abstract class AppToolBarActivity extends ToolBarActivity implements PublishActivityCallBack,CreateInit{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*禁止横屏*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initViews();
        initListeners();
        initData();
    }


    /**
     * 跳到当前App的主页
     * 使用时再修改相关部分代码
     * */
    protected void toHomePage(){
        Intent intent = new Intent(AppToolBarActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        AnimUtil.intentSlidOut(AppToolBarActivity.this);
    }

    @Override
    public void startActivity(Class<?> openClass, Bundle bundle) {
        Intent intent = new Intent(this, openClass);
        if (null != bundle)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void openActivityForResult(Class<?> openClass, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, openClass);
        if (null != bundle)
            intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void setResultOk(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) ;
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }


}
