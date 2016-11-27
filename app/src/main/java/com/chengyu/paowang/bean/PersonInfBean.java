package com.chengyu.paowang.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 澄鱼 on 2016/11/22.
 * @deprecated  个人信息数据封装   (用户名、密码、邮箱、电话号码)
 * @version     1.0
 */

public class PersonInfBean extends BmobObject{

    private  String  username;
    private  String  password;
    private  String  userEmail;
    private  String  userPhone;


    public String getUsername() {return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

}
