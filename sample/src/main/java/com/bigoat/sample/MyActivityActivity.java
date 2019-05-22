package com.bigoat.sample;

import android.support.annotation.NonNull;

import com.bigoat.base.BaseActivity;

import com.bigoat.sample.R;
import com.bigoat.sample.databinding.MyActivityBinding;


public class MyActivityActivity extends BaseActivity<MyActivityBinding, MyViewMode> {

    @Override
    protected int myView() {
        return R.layout.my_activity;
    }

    @Override
    protected void myCreate(@NonNull MyActivityBinding bind, @NonNull MyViewMode vm) {


        bind.setVm(vm);
    }

}
