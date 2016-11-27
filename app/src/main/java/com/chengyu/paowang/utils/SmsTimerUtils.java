package com.chengyu.paowang.utils;

import android.os.CountDownTimer;
import android.widget.Button;


/**
 *
 * 用于计数短信验证的倒计时工具类
 * @author Created by 澄鱼 on 2016/9/17.
 * @version 1.0
 */
public class SmsTimerUtils extends CountDownTimer {


        private Button button;

        public SmsTimerUtils(long millisInFuture, long countDownInterval, Button button) {
            super(millisInFuture, countDownInterval);
            this.button = button;
        }

        //计时过程显示
        @Override
        public void onTick(long millisUntilFinished) {
            button.setTextSize(14);
            button.setText(millisUntilFinished / 1000 + "秒后重新发送");
            button.setClickable(false);
        //    button.setBackgroundDrawable(getDrawable(R.drawable.bg_btn_shape_sending));
        }
        //计时完成触发
        @Override
        public void onFinish() {
            button.setText("获取验证码");
      //      button.setBackgroundDrawable(getDrawable(R.drawable.bg_btn_shape_login));
            button.setClickable(true);
        }


}
