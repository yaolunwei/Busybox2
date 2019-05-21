package com.bigoat.base;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

public interface UIBase extends Base {
    UIBase with(@NonNull String key, @NonNull Object value);
    UIBase withObject(@NonNull String key, @NonNull Object value);
    UIBase withString(@NonNull String key, @NonNull String value);
    UIBase withBoolean(@NonNull String key, @NonNull Boolean value);
    UIBase withInteger(@NonNull String key, @NonNull Integer value);
    UIBase withFloat(@NonNull String key, @NonNull Float value);
    UIBase withDouble(@NonNull String key, @NonNull Double value);

    UIBase startActivity(Class activity);

    UIBase addFragment(@IdRes int container, @NonNull Fragment fragment);
    UIBase replaceFragment(Fragment fragment);

    void go();
    void back();
    void close();
}
