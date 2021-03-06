package com.chengyu.paowang.utils;

/**
 * Created by 澄鱼 on 2016/4/14.
 * Log统一管理类
 */
public class log {

    private log()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "way";

    // 下面四个是默认tag的函数
    public static void i(String msg)
    {
        if (isDebug)
            log.i(TAG, msg);
    }

    public static void d(String msg)
    {
        if (isDebug)
            log.d(TAG, msg);
    }

    public static void e(String msg)
    {
        if (isDebug)
            log.e(TAG, msg);
    }

    public static void v(String msg)
    {
        if (isDebug)
            log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg)
    {
        if (isDebug)
            log.i(tag, msg);
    }

    public static void d(String tag, String msg)
    {
        if (isDebug)
            log.i(tag, msg);
    }

    public static void e(String tag, String msg)
    {
        if (isDebug)
            log.i(tag, msg);
    }

    public static void v(String tag, String msg)
    {
        if (isDebug)
            log.i(tag, msg);
    }
}
