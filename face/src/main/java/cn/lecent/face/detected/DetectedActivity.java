package cn.lecent.face.detected;

import android.support.annotation.NonNull;

import com.bigoat.base.BaseActivity;
import com.evision.faceai.DetectedFace;
import com.evision.faceai.FaceAI;

import cn.lecent.face.R;
import cn.lecent.face.databinding.DetectedActivityBinding;

public class DetectedActivity extends BaseActivity<DetectedActivityBinding, DetectedViewMode> {

    @Override
    protected int myView() {
        return R.layout.detected_activity;
    }

    @Override
    protected void myCreate(@NonNull DetectedActivityBinding bind, @NonNull DetectedViewMode vm) {
    }

}
