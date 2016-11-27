package com.chengyu.paowang.platform.bmob;

/**
 * Bmob插入数据请求回调接口
 * Created by 澄鱼 on 2016/11/22.
 */

public interface insertInterface {

    /**
     * 请求成功
     * @param objectId 插入数据行Id号
     * @param response 返回结果
     */
    void Success(String objectId, String response);


    /**
     * 请求失败
     * @param ErrorResponse 错误信息
     */
    void Failure(String ErrorResponse);
}
