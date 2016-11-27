package com.chengyu.paowang.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chengyu.paowang.R;
import com.chengyu.paowang.presenter.LoginPresenter;
import com.chengyu.paowang.utils.SnackbarUtils;
import com.chengyu.paowang.utils.mIntent;
import com.chengyu.paowang.view.LoginView;
import com.chengyu.paowang.widget.CircleImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity implements LoginView {


    @BindView(R.id.img_head)
    CircleImageView imgHead;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.but_return)
    ImageButton butReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.loadView)
    RelativeLayout loadView;


    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置全屏沉浸栏模式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();

    }


    private void initView() {

        mLoginPresenter = new LoginPresenter(this);

        //设置headbar标题
        tvTitle.setText("Login");
        butReturn.setVisibility(View.GONE);
    }


    /*监听事件处理*/
    @OnClick({R.id.register, R.id.but_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                mLoginPresenter.register();
                break;
            case R.id.but_login:
                mLoginPresenter.login();
                break;
        }
    }


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

    /*展示登录动画*/
    @Override
    public void showLoading() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadView.setVisibility(View.VISIBLE);
            }
        });

    }

    /*隐藏登录动画*/
    @Override
    public void hideLoading() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadView.setVisibility(View.GONE);
            }
        });

    }

    /*跳转主页面*/
    @Override
    public void IntentMainActivity() {

        mIntent.intent(this, MainActivity.class);
    }

    /*跳转注册页面*/
    @Override
    public void IntentRegisterActivity() {

        getWindow().setExitTransition(null);
        getWindow().setEnterTransition(null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =
                    ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, imgHead, imgHead.getTransitionName());
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class), options.toBundle());
        } else {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }

    }


    /*展示网络信息*/
    @Override
    public void showErrorMsg(final String msg) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                SnackbarUtils.showShortSnackbar(loadView,msg,R.color.colorAccent,R.color.colorPrimaryDark);
            }
        });



    }



}
