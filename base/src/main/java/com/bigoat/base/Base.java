package com.bigoat.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface Base {
    // Log
    void log(int type, @NonNull String tag, @Nullable Object... contents);
    void logv(@NonNull Object... contents);
    void logd(@NonNull Object... contents);
    void logi(@NonNull Object... contents);
    void logw(@NonNull Object... contents);
    void loge(@NonNull Object... contents);
    void loga(@NonNull Object... contents);
    void logJson(@NonNull String content);
    void logXml(@NonNull String content);
    void logFile(@NonNull String content);

    // Toast
    void showToast(int type, @NonNull String msg);
    void showToastNormal(@NonNull String msg);
    void showToastInfo(@NonNull String msg);
    void showToastWarning(@NonNull String msg);
    void showToastError(@NonNull String msg);
    void showToastSuccess(@NonNull String msg);

    // Progress
    void showProgress(@NonNull String msg);
    void showProgress();
    void hideProgress();
}
