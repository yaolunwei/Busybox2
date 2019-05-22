package cn.lecent.meet;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.bigoat.base.BaseActivity;
import com.bigoat.base.BaseViewModel;
import com.bigoat.ui.bar.StatusBar;

public class MainActivity extends BaseActivity {

    @Override
    protected int myView() {
        return R.layout.activity_main;
    }

    @Override
    protected void myCreate(@NonNull ViewDataBinding bind, @NonNull BaseViewModel vm) {
        StatusBar.setColor(this, getResources().getColor(R.color.colorPrimary), 112);
    }
}
