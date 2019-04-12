package com.henley.mvp.demo.contract;

import android.content.Context;

import com.henley.mvp.BasePresenter;
import com.henley.mvp.IMVPView;
import com.henley.mvp.demo.data.MobileInfo;
import com.henley.mvp.demo.listeners.LoadListener;

/**
 * @author Henley
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