package com.chengyu.paowang.presenter;

/**
 * Created by 澄鱼 on 2016/11/21.
 * @deprecated  BasePresenter,定义Presenter基本视图绑定解除接口，定义Presenter基本数据加载状态接口
 */

public interface BasePresenter<V,M> {

    /*绑定视图*/
    public  void attachView(V view);

    /*解除视图*/
    public  void detachView();

    /*加载数据成功*/
    public  <T> void loadDataSuccess(T t);

    /*加载数据失败*/
    void loadDataFailure(Integer ErrorCode);

}
