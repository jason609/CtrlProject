package com.ctrl.ctrlproject.dao;

import android.util.Log;

import com.beanu.arad.http.IDao;
import com.beanu.arad.http.INetResult;
import com.beanu.arad.utils.JsonUtil;
import com.ctrl.ctrlproject.base.Constant;
import com.ctrl.ctrlproject.entity.MemberInfo;
import com.ctrl.ctrlproject.utils.AopUtils;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录 dao
 * Created by Eric on 2015/10/28.
 */
public class WinDao extends IDao {

    /**
     * 用户信息
     * */
    private MemberInfo memberInfo;


    public WinDao(INetResult activity){
        super(activity);
    }

    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * */
    public void requestLogin(String userName,String password){
        Map<String,String> map = new HashMap<String,String>();
        map.put(Constant.APPKEY,Constant.APPKEY_VALUE);
        map.put(Constant.SECRET,Constant.SECRET_VALUE);
        map.put(Constant.VERSION,Constant.VERSION_VALUE);
        map.put(Constant.FORMAT,Constant.FORMAT_VALUE);
        map.put(Constant.TYPE, Constant.TYPE_VALUE);
        map.put(Constant.METHOD,"pm.ppt.members.login");//方法名称

        map.put("userName","18660771597");
        map.put("password","123456");

        String sign = AopUtils.sign(map, Constant.SECRET_VALUE);
        map.put("sign",sign);
        postRequest(Constant.RAW_URL, mapToRP(map), 0);
    }



    @Override
    public void onRequestSuccess(JsonNode result, int requestCode) throws IOException {
        if(requestCode == 0){
            Log.d("demo", "dao中结果集(登录返回): " + result);
            memberInfo = JsonUtil.node2pojo(result.findValue("memberInfo"), MemberInfo.class);
        }
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }
}
