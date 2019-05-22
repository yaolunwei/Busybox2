package ${packageName};

import android.support.annotation.NonNull;

import com.bigoat.base.BaseActivity;

public class ${actName} extends BaseActivity<${bindName}, ${vmName}> {

    @Override
    protected int myView() {
        return R.layout.${layoutName};
    }

    @Override
    protected void myCreate(@NonNull ${bindName} bind, @NonNull ${vmName} vm) {


		bind.setVm(vm);
    }

}
