package com.chengyu.paowang.application;

import android.app.Application;

import com.chengyu.paowang.bean.ConfigBean;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by 澄鱼 on 2016/11/22.
 * @deprecated  全局的Appliction 1.用于持有用户全局信息  2.初始化第三方平台库
 */

public class GlobalAppliction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /*初始化Bmob*/
        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        .setApplicationId(ConfigBean.bmobKey)
        ////请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(ConfigBean.bmobConnectTimeout)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(ConfigBean.bmobUploadBlockSize)
        ////文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(ConfigBean.bmobFileExpiration)
        .build();
        Bmob.initialize(config);
    }
}
