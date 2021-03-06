package com.beanu.arad.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.beanu.arad.http.INetResult;
import com.beanu.arad.utils.MessageUtils;
import com.beanu.arad.widget.dialog.ProgressHUD;

/**
 * 基础类
 * 1.继承了INetResult 具备了网络处理能力
 * 2.添加了ProgressHUD 可以显示等待progress1
 */
public class BaseActivity extends AppCompatActivity implements INetResult {

    ProgressHUD mProgressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*禁止横屏*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onRequestSuccess(int requestCode) {

    }

    @Override
    public void onRequestFaild(String errorNo, String errorMessage) {
        showProgress(false);
        if(errorNo.equals("001")){
            //
        }else if(errorNo.equals("006")){
            //
        }else {
            MessageUtils.showShortToast(this, errorMessage);
        }
    }

    @Override
    public void onNoConnect() {
        showProgress(false);
        MessageUtils.showShortToast(this, "无网络连接");
    }

    public void showProgress(boolean show) {
        showProgressWithText(show, "加载中...");
    }

    public void showProgressWithText(boolean show, String message) {
        if (show) {
            mProgressHUD = ProgressHUD.show(this, message, true, true, null);
        } else {
            if (mProgressHUD != null) {
                mProgressHUD.dismiss();
            }
        }
    }
}
