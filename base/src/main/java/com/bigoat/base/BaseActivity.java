package com.bigoat.base;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-11-15
 *     desc   : Activity基础
 * </pre>
 */
public abstract class BaseActivity<Binding extends ViewDataBinding, ViewMode extends BaseViewModel> extends AppCompatActivity implements UIBase {
    protected String tag;

    protected Binding bind;
    protected ViewMode vm;

    private Map<String, Object> mData = new LinkedHashMap<>();

    private Intent mIntent;
    private Bundle mBundle = new Bundle();

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    /**
     * 布局文件
     *
     * @return layoutId
     */
    protected abstract @LayoutRes int myView();

    /**
     * 业务操作
     *
     * @param bind Binding
     * @param vm ViewMode
     */
    protected abstract void myCreate(@NonNull Binding bind, @Nullable ViewMode vm);

    /**
     * 创建ViewMode
     *
     * @return ViewMode
     */
    private ViewMode createViewModel() {
        try {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class clazz = (Class<ViewMode>) type.getActualTypeArguments()[1];
            return  (ViewMode) ViewModelProviders.of(this).get(clazz);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tag = getClass().getSimpleName();
        mFragmentManager = getSupportFragmentManager();

        vm = createViewModel();

        injectBundle(getIntent().getExtras());

        bind = DataBindingUtil.setContentView(this, myView());

        vm.toastData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer type) {
                if (type == null || vm.toastMsg == null) return;

                showToast(type, vm.toastMsg);
            }
        });

        vm.progressData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isShow) {
                if (isShow == null) return;

                if (isShow) {
                    showProgress(vm.progressMsg);
                } else {
                    hideProgress();
                }
            }
        });

        bind.setLifecycleOwner(this);

        myCreate(bind, vm);

        vm.create();
    }

    @Override
    protected void onStart() {
        super.onStart();
        vm.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        vm.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        vm.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        vm.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vm.onDestroy();
    }


    @Override
    public void back() {

    }

    @Override
    public void close() {

    }

    @Override
    public void log(int type, @NonNull String tag,  @Nullable Object... contents) {
    }

    @Override
    public void logv(@NonNull Object... contents) {
    }

    @Override
    public void logd(@NonNull Object... contents) {
    }

    @Override
    public void logi(@NonNull Object... contents) {
    }

    @Override
    public void logw(@NonNull Object... contents) {
    }

    @Override
    public void loge(@NonNull Object... contents) {
    }

    @Override
    public void loga(@NonNull Object... contents) {
    }

    @Override
    public void logJson(@NonNull String content) {
    }

    @Override
    public void logXml(@NonNull String content) {
    }

    @Override
    public void logFile(@NonNull String content) {
    }

    @Override
    public void showToast(int type, @NonNull String msg) {
        switch (type) {
            case 0x10:
                break;

            case 0x20:
                break;

            case 0x30:
                break;

            case 0x40:
                break;

            default:
                break;
        }
    }

    @Override
    public void showToastNormal(@NonNull String msg) {
        showToast(0x00, msg);
    }

    @Override
    public void showToastInfo(@NonNull String msg) {
        showToast(0x01, msg);
    }

    @Override
    public void showToastWarning(@NonNull String msg) {
        showToast(0x02, msg);
    }

    @Override
    public void showToastError(@NonNull String msg) {
        showToast(0x03, msg);
    }

    @Override
    public void showToastSuccess(@NonNull String msg) {
        showToast(0x04, msg);
    }

    @Override
    public void showProgress(@NonNull String msg) {

    }

    @Override
    public void showProgress() {
       showProgress("");
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public UIBase with(@NonNull String key, @NonNull Object value) {
        if (value instanceof String) {
            mBundle.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            mBundle.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            mBundle.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            mBundle.putFloat(key, (Float) value);
        } else if (value instanceof Double) {
            mBundle.putDouble(key, (Double) value);
        } else {
//            mBundle.putString(key, GsonUtils.toJson(value));
        }

        return this;
    }

    @Override
    public UIBase withObject(@NonNull String key, @NonNull Object value) {
        with(key, value);
        return this;
    }

    @Override
    public UIBase withString(@NonNull String key, @NonNull String value) {
        with(key, value);
        return this;
    }

    @Override
    public UIBase withBoolean(@NonNull String key, @NonNull Boolean value) {
        with(key, value);
        return this;    }

    @Override
    public UIBase withInteger(@NonNull String key, @NonNull Integer value) {
        with(key, value);
        return this;    }

    @Override
    public UIBase withFloat(@NonNull String key, @NonNull Float value) {
        with(key, value);
        return this;    }

    @Override
    public UIBase withDouble(@NonNull String key, @NonNull Double value) {
        with(key, value);
        return this;
    }

    @Override
    public UIBase startActivity(Class activity) {
        mIntent = new Intent(this, activity);
        return this;
    }

    @Override
    public UIBase addFragment(@IdRes int container, @NonNull Fragment fragment) {
        mFragmentTransaction = mFragmentManager.beginTransaction().addToBackStack(null).add(container, fragment);
        return this;
    }

    @Override
    public UIBase replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        return this;
    }

    @Override
    public void go() {
        mFragmentTransaction.commit();
        // TODO
    }


    /**
     * TODO Roadmap
     *
     * 1. ARoute 跳转
     * 2. Fragment 替换操作支持 ARoute uri地址
     */


    private void injectBundle(Bundle bundle) {
        if (bundle != null) {
            injectBundle(this, bundle);
            injectBundle(vm, bundle);
        }

    }

    private void injectBundle(Object o, Bundle bundle) {
        try {
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                boolean annotationPresent = field.isAnnotationPresent(AutoArg.class);
                if (annotationPresent) {
                    field.setAccessible(true);

                    Object value = bundle.get(field.getName());

                    if (value instanceof String) {
                        String str = (String) value;
                        try {
//                            Object obj = GsonUtils.fromJson(str, field.getType());

//                            field.set(o, obj);
                        } catch (Exception e) {
                            field.set(o, str);
                        }

                    } else {
                        field.set(o, value);
                    }

                }
            }
        } catch (Exception e) {
            logw(e.getMessage());
        }
    }

}