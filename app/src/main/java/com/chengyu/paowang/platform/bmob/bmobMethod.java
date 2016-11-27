package com.chengyu.paowang.platform.bmob;


import android.util.Log;

import com.chengyu.paowang.bean.PersonInfBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 澄鱼 on 2016/11/22.
 * @deprecated  bmob常用数据库方法封装(增删改查)
 * @version     1.0
 */

public class bmobMethod {

    /**
     * @deprecated bmob添加一行数据
     * @author     澄鱼
     * @param t    数据封装bean
     * @param tableName 插入表名
     */
    public static void insert(PersonInfBean t, String tableName, final insertInterface insertListener ){

        t.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {


                if(e==null){
                    Log.i("bbb","创建数据成功：" + objectId);
                    insertListener.Success(objectId,e.toString());
                }else{
                    Log.i("bbb","失败："+e.getMessage()+","+e.getErrorCode());
                    insertListener.Failure(e.toString());
                }

            }
        });

    }

}
