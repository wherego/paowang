package com.chengyu.paowang.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.chengyu.paowang.R;
import com.chengyu.paowang.bean.PersonInfBean;
import com.chengyu.paowang.presenter.RegisterPresenter;
import com.chengyu.paowang.utils.SnackbarUtils;
import com.chengyu.paowang.view.RegisterView;
import com.chengyu.paowang.widget.CircleImageView;
import com.dd.morphingbutton.MorphingButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 澄鱼
 * @version 1.0
 * @date 2016-11-17
 * @deprecated 注册详情页
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    @BindView(R.id.img_head)
    CircleImageView mHeadPicture;
    @BindView(R.id.but_register)
    MorphingButton mRegisterButton;
    @BindView(R.id.activity_register)
    RelativeLayout mContainerLayout;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_checkNumer)
    EditText etCheckNumer;
    @BindView(R.id.loadView)
    RelativeLayout loadView;

    private RegisterPresenter mRegisterPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏沉浸栏模式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();

    }

    /*初始化进入界面*/
    private void initView() {

        mRegisterPresenter = new RegisterPresenter(this);

        //界面进入过场动画
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ShowEnterAnimation();
        }
        morphToSquare(mRegisterButton, 0);

        hideLoading();
    }

    /*点击事件处理*/
    @OnClick({R.id.but_return, R.id.but_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_return:
                IntentLoginActivity();
                break;
            case R.id.but_register:

                PersonInfBean bean = new PersonInfBean();
                bean.setUsername(getUsername());
                bean.setPassword(getPassword());
                bean.setUserEmail(getEmial());
                bean.setUserPhone(getUsername());
                mRegisterPresenter.register(bean, getMsgCheckNum());

                showLoading();
                break;
        }
    }

    /*注册按钮相关方法*/
    private void morphToSquare(final MorphingButton btnMorph, int duration) {
        MorphingButton.Params square = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(8)
                .color(color(R.color.colorAccent))
                .colorPressed(color(R.color.colorAccent))
                .text("注册");
        btnMorph.morph(square);
    }

    private void morphToSuccess(final MorphingButton btnMorph) {
        MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(integer(R.integer.mb_animation))
                .cornerRadius(dimen(R.dimen.mb_height_56))
                .width(dimen(R.dimen.mb_height_56))
                .height(dimen(R.dimen.mb_height_56))
                .color(color(R.color.mb_green))
                .colorPressed(color(R.color.mb_green_dark))
                .icon(R.mipmap.ic_done);
        btnMorph.morph(circle);
    }

    private void morphToFailure(final MorphingButton btnMorph, int duration) {
        MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(dimen(R.dimen.mb_height_56))
                .width(dimen(R.dimen.mb_height_56))
                .height(dimen(R.dimen.mb_height_56))
                .color(color(R.color.mb_red))
                .colorPressed(color(R.color.mb_red_dark))
                .icon(R.mipmap.ic_fail);
        btnMorph.morph(circle);
    }


    /*进入动画相关方法*/
    private void ShowEnterAnimation() {

        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fabtransition);
        getWindow().setSharedElementEnterTransition(transition);


        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                mContainerLayout.setVisibility(View.GONE);
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                animateRevealShow();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }


        });
    }

    public void animateRevealShow() {

        Animator mAnimator = ViewAnimationUtils.createCircularReveal(mContainerLayout, mContainerLayout.getWidth() / 2, mHeadPicture.getHeight(), mHeadPicture.getWidth() / 2, mContainerLayout.getHeight());
        mAnimator.setDuration(1000);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                mContainerLayout.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);
            }
        });
        mAnimator.start();
    }


    public int dimen(@DimenRes int resId) {
        return (int) getResources().getDimension(resId);
    }

    public int color(@ColorRes int resId) {
        return getResources().getColor(resId);
    }

    public int integer(@IntegerRes int resId) {
        return getResources().getInteger(resId);
    }


    /**********************************************************************************************/

    /*获取账号*/
    @Override
    public String getUsername() {

        return etUsername.getText().toString();
    }

    /*获取密码*/
    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    /*获取邮箱*/
    @Override
    public String getEmial() {
        return etEmail.getText().toString();
    }

    /*获取短信验证码*/
    @Override
    public String getMsgCheckNum() {
        return etCheckNumer.getText().toString();
    }

    /*跳转主页面*/
    @Override
    public void IntentMainActivity() {

    }

    /*跳转登录页面*/
    @Override
    public void IntentLoginActivity() {

        finishAfterTransition();
    }

    /*登录按钮变化动画*/
    @Override
    public void changeAnimRegisterButton(boolean isSuccess) {

        if (isSuccess) {
            morphToSuccess(mRegisterButton);
        } else {
            morphToFailure(mRegisterButton, 500);
        }
    }

    /*展示注册动画*/
    @Override
    public void showLoading() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadView.setVisibility(View.VISIBLE);
            }
        });
    }

    /*隐藏注册动画*/
    @Override
    public void hideLoading() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                loadView.setVisibility(View.GONE);

            }
        });


    }

    /*展示SnackBar信息*/
    @Override
    public void showErrorMsg(final String msg) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                SnackbarUtils.showShortSnackbar(loadView, msg, R.color.colorAccent, R.color.colorPrimaryDark);
            }
        });

    }


}
