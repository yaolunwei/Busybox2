package com.bigoat.sample.http;

import android.support.annotation.NonNull;

import com.bigoat.base.BaseActivity;
import com.bigoat.sample.R;
import com.bigoat.sample.databinding.ActivityHttpBinding;

public class HttpActivity extends BaseActivity<ActivityHttpBinding, HttpViewMode> {

    @Override
    protected int myView() {
        return R.layout.activity_http;
    }

    @Override
    protected void myCreate(@NonNull ActivityHttpBinding bind, @NonNull HttpViewMode vm) {

    }
}
