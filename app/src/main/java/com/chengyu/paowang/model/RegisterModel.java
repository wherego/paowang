package com.chengyu.paowang.model;

import android.util.Log;

import com.chengyu.paowang.bean.PersonInfBean;
import com.chengyu.paowang.presenter.RegisterPresenter;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 澄鱼 on 2016/11/27.
 * @deprecated  注册页
 * @version     1.0
 */

public class RegisterModel {

    private RegisterPresenter mRegisterPresenter;

    public RegisterModel(RegisterPresenter mRegisterPresenter) {
        this.mRegisterPresenter = mRegisterPresenter;
    }

    /*注册账号*/
    public void registerAccount(PersonInfBean bean,String checkNum){

        bean.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {

                if(e==null){

                    mRegisterPresenter.loadDataSuccess("成功");
                }else{

                    mRegisterPresenter.loadDataFailure(0);
                }
            }
        });
    }

}
