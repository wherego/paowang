package com.chengyu.paowang.model;

import android.util.Log;

import com.chengyu.paowang.bean.PersonInfBean;
import com.chengyu.paowang.presenter.LoginPresenter;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by 澄鱼 on 2016/11/21.
 *
 * @deprecated 登录页Model, 业务具体处理，包括负责存储、检索、操纵数据等
 */

public class LoginModel {

    //LoginPresenter对象引用
    private LoginPresenter mLoginPresenter;

    public LoginModel(LoginPresenter mLoginPresenter) {
        this.mLoginPresenter = mLoginPresenter;
    }

    //账号、密码验证
    public void checkCount(final String username, final String password) {

        BmobQuery<PersonInfBean> query = new BmobQuery<PersonInfBean>();
        query.addWhereEqualTo("username", username)
                .setLimit(1)
                .findObjects(new FindListener<PersonInfBean>() {

                    @Override
                    public void done(List<PersonInfBean> object, BmobException e) {

                        if (e == null) {

                            mLoginPresenter.loadDataSuccess(object);

                        } else {

                            mLoginPresenter.loadDataFailure(e.getErrorCode());
                        }
                    }
                });
    }

}
