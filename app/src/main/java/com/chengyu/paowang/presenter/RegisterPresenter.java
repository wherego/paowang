package com.chengyu.paowang.presenter;

import com.chengyu.paowang.bean.PersonInfBean;
import com.chengyu.paowang.model.RegisterModel;
import com.chengyu.paowang.view.RegisterView;


/**
 * Created by 澄鱼 on 2016/11/27.
 */

public class RegisterPresenter implements BasePresenter<RegisterView,RegisterModel>{

    private RegisterView  mRegisterView;
    private RegisterModel mRegisterModel;


    public RegisterPresenter(RegisterView mRegisterView) {

        attachView(mRegisterView);
        mRegisterModel = new RegisterModel(this);
    }

    /*视图相关*/
    @Override
    public void attachView(RegisterView view) {

        this.mRegisterView = view;

    }

    @Override
    public void detachView() {

        this.mRegisterView = null;

    }

    /*数据加载相关*/
    @Override
    public <T> void loadDataSuccess(T t) {

      //  String result = (String) t;

        mRegisterView.hideLoading();

        mRegisterView.changeAnimRegisterButton(true);

    }

    @Override
    public void loadDataFailure(Integer ErrorCode) {

        mRegisterView.hideLoading();

        mRegisterView.changeAnimRegisterButton(false);
    }

    /*注册按钮点击注册账号*/
    public void register(PersonInfBean bean,String checkNum){

        mRegisterModel.registerAccount(bean,checkNum);
    }
}
