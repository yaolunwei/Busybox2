package com.bigoat.base;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-11-19
 *     desc   : 基础ViewModel进行逻辑处理
 * </pre>
 */
public class BaseViewModel extends ViewModel implements Base {
    private boolean isCreate = false;

    String tag;

    BaseLiveData<Integer> toastData = new BaseLiveData<>();
    String toastMsg;

    BaseLiveData<Boolean> progressData = new BaseLiveData<>();
    String progressMsg;

    protected BaseViewModel() {
        tag = getClass().getSimpleName();
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
        if (msg.equals("")) return;

        toastMsg = msg;
        toastData.setValue(type);

        toastData.setValue(null);
        toastMsg = null;
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
        progressMsg = msg;
        progressData.setValue(true);

        progressMsg = null;
        progressData.setValue(null);
    }

    @Override
    public void showProgress() {
        showProgress("");
    }

    @Override
    public void hideProgress() {
        progressData.setValue(false);
        progressData.setValue(null);
    }

    /**
     * 监听Activity 和 Fragment 生命周期
     */
    public void create() {
        if (!isCreate) {
            onCreate();
            isCreate = true;
        }
    }

    public void onCreate() {}

    public void onStart() {}

    public void onResume() {}

    public void onPause() {}

    public void onStop() {}

    public void onDestroy() {}
}
