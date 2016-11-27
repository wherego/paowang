package com.chengyu.paowang.view;

import com.chengyu.paowang.model.LoginModel;

/**
 * Created by 澄鱼 on 2016/11/21.
 * @deprecated :
 *               登录详情页
 * @version    : 1.0
 */

public interface LoginView {

    /*获取账号*/
    String getUsername();

    /*获取密码*/
    String getPassword();

    /*展示登录动画*/
    void   showLoading();

    /*隐藏登录动画*/
    void   hideLoading();

    /*跳转主页面*/
    void   IntentMainActivity();

    /*跳转注册页面*/
    void   IntentRegisterActivity();

    /*跳转手势解锁页面*/

    /*展示网络请求错误信息*/
    void   showErrorMsg(String msg);

}
