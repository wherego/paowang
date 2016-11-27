package com.chengyu.paowang.bean;

/**
 * Created by 澄鱼 on 2016/11/22.
 * @deprecated 1.第三方平台初始化配置保存  2.一些常用配置保存
 * @version    1.0
 */

public class ConfigBean {

    /*Bmob配置相关*/
    public  final  static  String  bmobKey = "e3aca3f8d61e2f4cc527875649f00a19";
    public  final  static  Integer bmobConnectTimeout = 30;
    public  final  static  Integer bmobUploadBlockSize = 1024*1024;
    public  final  static  Integer bmobFileExpiration = 2500;

    /*Bmob数据库相关*/
    public  final  static  String  table_userInf = "IUser";
}
