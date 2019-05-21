package com.bigoat.base;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.Nullable;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-11-19
 *     desc   : 基础数据模型
 * </pre>
 */
public class BaseLiveData<T> extends MutableLiveData<T> {
    public T value;

    @Override
    public void setValue(T value) {
        super.setValue(value);
        this.value = value;
    }

    @Nullable
    @Override
    public T getValue() {
        return super.getValue();
    }

    public void value(T value) {
        try {
            super.setValue(value);
        } catch (IllegalStateException e) {
            postValue(value);
        }
    }
}
