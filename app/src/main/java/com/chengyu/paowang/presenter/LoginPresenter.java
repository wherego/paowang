package com.chengyu.paowang.presenter;

import com.chengyu.paowang.bean.PersonInfBean;
import com.chengyu.paowang.model.LoginModel;
import com.chengyu.paowang.view.LoginView;

import java.util.List;

/**
 * Created by 澄鱼 on 2016/11/21.
 * @deprecated  登录页Presenter,从Model层检索数据后，返回给View层
 */

public class LoginPresenter implements BasePresenter<LoginView,List<PersonInfBean>>{

    private LoginView  mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenter(LoginView mLoginView) {

        attachView(mLoginView);
        mLoginModel = new LoginModel(this);
    }

    /*获取View对象，与View层关联*/
    @Override
    public void attachView(LoginView view) {

        this.mLoginView =  view;
    }

    @Override
    public void detachView() {

        this.mLoginView = null;
    }

    /*调用数据相关处理，与Model层关联，在拿到view对象后调用View实现方法回调*/
    @Override
    public <T> void loadDataSuccess(T t) {

        List<PersonInfBean> object = (List<PersonInfBean>)t;

        //账号不存在
        if (0 == object.size()) {

            mLoginView.showErrorMsg("账号不存在!");
            mLoginView.hideLoading();

        } else if (object.get(0).getPassword().equals(mLoginView.getPassword())) {

            mLoginView.hideLoading();
            mLoginView.IntentMainActivity();

        } else {
            mLoginView.showErrorMsg("密码错误!");
            mLoginView.hideLoading();
        }

    }

    @Override
    public void loadDataFailure(Integer ErrorCode) {

        mLoginView.hideLoading();

        if (ErrorCode == 9016) {

            mLoginView.showErrorMsg("无网络连接，请连接网络!");

        } else if (ErrorCode == 9010) {

            mLoginView.showErrorMsg("网络连接超时!");

        } else if (ErrorCode == 9019) {

            mLoginView.showErrorMsg("请输入正确的账号密码!");

        } else if (ErrorCode == 9015) {

            mLoginView.showErrorMsg("其他错误!");

        }
    }

    /*事件处理相关*/
    /*注册按钮事件*/
    public  void  register(){

        mLoginView.IntentRegisterActivity();
    }

    /*登录按钮事件*/
    public  void  login(){

        mLoginView.showLoading();
        mLoginModel.checkCount(mLoginView.getUsername().toString(),mLoginView.getPassword().toString());
    }
}
