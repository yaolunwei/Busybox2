package cn.lecent.face;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.bigoat.base.BaseActivity;
import com.bigoat.base.BaseViewModel;
import com.bigoat.ui.list.BaseQuickAdapter;
import com.bigoat.ui.list.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.lecent.face.databinding.FaceActivityBinding;
import cn.lecent.face.detected.DetectedActivity;

public class FaceActivity extends BaseActivity<FaceActivityBinding, FaceViewMode> {

    private BaseQuickAdapter<FaceFun, BaseViewHolder> mAdapter;

    @Override
    protected int myView() {
        return R.layout.face_activity;
    }

    @Override
    protected void myCreate(@NonNull FaceActivityBinding bind, @NonNull FaceViewMode vm) {
        mAdapter = new BaseQuickAdapter<FaceFun, BaseViewHolder>(R.layout.face_fun_item) {
            @Override
            protected void convert(BaseViewHolder helper, FaceFun item) {
                helper.setImageResource(R.id.icon, item.icon);
                helper.setText(R.id.fun, item.name);
            }
        };

        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            FaceFun faceFun = (FaceFun) adapter.getItem(position);
            startActivity(new Intent(this, faceFun.activity));
        });

        mAdapter.addData(createFaceFun());

        bind.list.setLayoutManager(new GridLayoutManager(this,5));

        bind.list.setAdapter(mAdapter);

        vm.init(this);
    }


    private List<FaceFun> createFaceFun() {
        List<FaceFun> faceFuns = new ArrayList<>();

        FaceFun detectedFun = new FaceFun(R.drawable.face_detected_ic, "人脸检测", DetectedActivity.class);

        faceFuns.add(detectedFun);

        return faceFuns;
    }

    class FaceFun {
        public int icon;
        public String name;
        public Class activity;

        public FaceFun(int icon, String name, Class activity) {
            this.icon = icon;
            this.name = name;
            this.activity = activity;
        }
    }

}
