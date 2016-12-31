package cn.jianke.humanbody.widget;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import cn.jianke.humanbody.R;

/**
 * @className: HumanBodyPopupWindow
 * @classDescription: 人体图提示对话框
 * @author: leibing
 * @createTime: 2016/12/31
 */
public class HumanBodyPopupWindow extends PopupWindow{
    // 人体图Handler
    private HumanBodyHandler mHumanBodyHandler;

    /**
     * Constructor
     * @author leibing
     * @createTime 2016/12/31
     * @lastModify 2016/12/31
     * @param activity 页面实例
     * @param posName 部位名称
     * @return
     */
    public HumanBodyPopupWindow(Activity activity, String posName){
        // 初始化人体图Handler
        mHumanBodyHandler = new HumanBodyHandler(activity);
        // 构造view
        View view = LayoutInflater.from(activity).inflate(R.layout.popwindow_human_body_tips, null);
        // findview
        TextView posNameTv = (TextView) view.findViewById(R.id.tv_posname);
        // updateUI
        if (posName != null && !posName.equals("")){
            posNameTv.setText(posName);
        }
        // 添加view到当前视图
        this.setContentView(view);
        // 设置自适配
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
    }

    /**
     *
     * @author leibing
     * @createTime 2016/12/31
     * @lastModify 2016/12/31
     * @param mHumanBodyPopupWindow PopupWindow实例
     * @param delayTime 延迟时间（单位：毫秒）
     * @return
     */
    public void delayDismissDialog(HumanBodyPopupWindow mHumanBodyPopupWindow ,int delayTime){
        if (delayTime <= 500)
            delayTime = 500;
        if (mHumanBodyHandler != null){
            mHumanBodyHandler.postDelayed(new HumanBodyRunnable(mHumanBodyPopupWindow) ,delayTime);
        }
    }

    /**
     * @className: HumanBodyHandler
     * @classDescription: 人体图Handler
     * @author: leibing
     * @createTime: 2016/12/31
     */
    private static class HumanBodyHandler extends Handler{
        // 页面引用弱引用
        private WeakReference<Activity> mActivityWeakReference;

        /**
         * Constuctor
         * @author leibing
         * @createTime 2016/12/31
         * @lastModify 2016/12/31
         * @param activity 页面实例
         * @return
         */
        public HumanBodyHandler(Activity activity){
            mActivityWeakReference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 弱引用还存在则更新UI
            if (mActivityWeakReference != null && mActivityWeakReference.get() != null){

            }
        }
    }

    /**
     * @className:
     * @classDescription:
     * @author: leibing
     * @createTime: 2016/12/31
     */
    private static class HumanBodyRunnable implements Runnable{
        // 人体图PopupWindow
        private HumanBodyPopupWindow mHumanBodyPopupWindow;

        /**
         * Constructor
         * @author leibing
         * @createTime 2016/12/31
         * @lastModify 2016/12/31
         * @param mHumanBodyPopupWindow 人体图PopupWindow
         * @return
         */
        public HumanBodyRunnable(HumanBodyPopupWindow mHumanBodyPopupWindow){
            this.mHumanBodyPopupWindow = mHumanBodyPopupWindow;
        }

        @Override
        public void run() {
            if (mHumanBodyPopupWindow != null && mHumanBodyPopupWindow.isShowing()){
                mHumanBodyPopupWindow.dismiss();
            }
        }
    }
}
