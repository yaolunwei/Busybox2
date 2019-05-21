package com.bigoat.sample;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bigoat.base.BaseActivity;
import com.bigoat.sample.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewMode> {

    @Override
    protected int myView() {
        return R.layout.activity_main;
    }

    @Override
    protected void myCreate(@NonNull ActivityMainBinding bind, @Nullable MainViewMode vm) {
        bind.setVm(vm);
    }
}
