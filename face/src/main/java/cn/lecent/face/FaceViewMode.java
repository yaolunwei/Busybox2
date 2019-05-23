package cn.lecent.face;

import android.content.Context;

import com.bigoat.base.BaseViewModel;
import com.bigoat.utils.LogUtils;
import com.evision.faceai.EVisionFaceSDK;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-5-23
 *     desc   :
 * </pre>
 */
public class FaceViewMode extends BaseViewModel {

    private String license = "2019/06/30!1vN-v3.0-r0.4.7";

    private String modelFolder = "/data/EVision";


    public void init(Context context) {
        new Thread() {
            @Override
            public void run() {
                try {
                    String machineID = EVisionFaceSDK.getMachineID(context);
                    LogUtils.d("machineID: " + machineID);

                    if (EVisionFaceSDK.hasInited()) {
                        LogUtils.d("人脸SDK已经初始化");

                    } else {
                        EVisionFaceSDK.InitSDK(context, license, 4, modelFolder);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();


    }


}
