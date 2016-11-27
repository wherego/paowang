package com.chengyu.paowang.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 澄鱼 on 2016/4/14.
 * snakeBar统一管理类
 */
public class snakebar {


        private snakebar()
        {
        /* cannot be instantiated */
            throw new UnsupportedOperationException("cannot be instantiated");
        }

        public static boolean isShow = true;

        /**
         * 短时间显示snakebar
         *
         * @param view
         * @param text
         */
        public static void showShort(@NonNull View view, @NonNull CharSequence text)
        {
            if (isShow)
             Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
        }

        /**
         * 长时间显示snakebar
         *
         * @param view
         * @param text
         */
        public static void showLong(@NonNull View view, @NonNull CharSequence text)
        {
            if (isShow)
                Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
        }

        /**
         * 自定义显示Toast时间
         *
         * @param view
         * @param text
         * @param duration
         */
        public static void show(@NonNull View view, @NonNull CharSequence text, int duration)
        {
            if (isShow)
                Snackbar.make(view, text, duration).show();
        }



}
