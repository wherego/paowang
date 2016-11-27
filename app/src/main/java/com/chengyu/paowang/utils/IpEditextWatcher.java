package com.chengyu.paowang.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by 澄鱼 on 2016/11/5.
 */

public class IpEditextWatcher implements TextWatcher {


    public EditText mEditText;
    public EditText[] gwEdit;

    public IpEditextWatcher(EditText mEditText,EditText[] gwEdit) {
        super();
        this.mEditText = mEditText;
        this.gwEdit    = gwEdit;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTextChanged(Editable s) {


        if (s.length() == 3) {
            if (this.mEditText == gwEdit[0]) {
                gwEdit[1].requestFocus();
            } else if (this.mEditText == gwEdit[1]) {
                gwEdit[2].requestFocus();
            } else if (this.mEditText == gwEdit[2]) {
                gwEdit[3].requestFocus();
            } else if (this.mEditText == gwEdit[3]) {
                gwEdit[4].requestFocus();
            }
        } else if (s.length() == 0) {
            if (this.mEditText == gwEdit[4]) {
                gwEdit[3].requestFocus();
            }
            else if (this.mEditText == gwEdit[3]) {
                gwEdit[2].requestFocus();
            } else if (this.mEditText == gwEdit[2]) {
                gwEdit[1].requestFocus();
            } else if (this.mEditText == gwEdit[1]) {
                gwEdit[0].requestFocus();
            }
        }

    }

}
