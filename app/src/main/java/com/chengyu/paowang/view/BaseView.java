package com.chengyu.paowang.view;

/**
 * Created by 澄鱼 on 2016/11/27.
 * @deprecated   MVP之V，接口类，主要功能是声明view层展示view所用的方法，处理业务需要的方法，给P层提供调用接口
 *               MVP中V层和M层没有交互连接，所以，View是提供接口以便通过P层来获取M层的数据
 * @version      1.0
 */

public interface BaseView {

    /*展示网络请求动画*/
    public  void   showLoading();

    /*隐藏网络请求动画*/
    public  void   hideLoading();

    /*展示网络请求错误信息*/
    public  void   showErrorMsg(String msg);


}
