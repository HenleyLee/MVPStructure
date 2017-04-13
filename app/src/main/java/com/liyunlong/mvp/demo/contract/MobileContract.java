package com.liyunlong.mvp.demo.contract;

import android.content.Context;

import com.liyunlong.mvp.BasePresenter;
import com.liyunlong.mvp.IMVPView;
import com.liyunlong.mvp.demo.data.MobileInfo;
import com.liyunlong.mvp.demo.listeners.LoadListener;

/**
 * @author liyunlong
 * @date 2017/4/13 16:29
 */
public interface MobileContract {


    interface MobileView extends IMVPView {

        void updateMobileInfo(MobileInfo mobileInfo);

        void updateFailInfo(String message);

    }

    abstract class MobilePresenter extends BasePresenter<MobileView> {

        public MobilePresenter(Context context) {
            super(context);
        }

        protected abstract void loadMobileInfo(String mobile);
    }

    interface Model {

        String getUrl(String mobile);

        void loadMobileInfo(String mobile, LoadListener listener);
    }

}