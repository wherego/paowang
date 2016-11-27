package com.chengyu.paowang.view;

/**
 * Created by 澄鱼 on 2016/11/27.
 * @deprecated  登录页详情页   View展示层(1.三方平台短信  2.注册账号  3.返回登录界面)
 * @version     1.0
 */

public interface RegisterView  extends  BaseView{

    /*获取账号*/
    String getUsername();

    /*获取密码*/
    String getPassword();

    /*获取邮箱*/
    String getEmial();

    /*获取短信验证码*/
    String getMsgCheckNum();

    /*跳转主页面*/
    void   IntentMainActivity();

    /*跳转登录页面*/
    void   IntentLoginActivity();

    /*注册按钮变化动画*/
    void   changeAnimRegisterButton(boolean isSuccess);
}
