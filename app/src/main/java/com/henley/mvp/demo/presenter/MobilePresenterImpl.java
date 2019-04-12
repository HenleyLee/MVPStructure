package com.henley.mvp.demo.presenter;

import android.content.Context;

import com.henley.mvp.demo.data.MobileInfo;
import com.henley.mvp.demo.listeners.LoadListener;
import com.henley.mvp.demo.utils.Utility;
import com.henley.mvp.demo.contract.MobileContract;
import com.henley.mvp.demo.model.MobileModelImpl;

/**
 * Created by Henley on 2017/04/13
 */
public class MobilePresenterImpl extends MobileContract.MobilePresenter implements LoadListener {

    private final MobileModelImpl mobileModel;

    public MobilePresenterImpl(Context context) {
        super(context);
        mobileModel = new MobileModelImpl();
    }

    @Override
    public void loadMobileInfo(String mobile) {
        if (Utility.isNetworkConnected(getContext())) {
            getMVPView().showProgressDialog("正在查询，请稍后", true);
            getMVPView().updateFailInfo("正在查询，请稍后");
            mobileModel.loadMobileInfo(mobile, this);
        } else {
            getMVPView().showToast("当前网络不可用，请检查网络链接");
            getMVPView().updateFailInfo("当前网络不可用，请检查网络链接");
        }
    }

    @Override
    public void onSuccess(MobileInfo mobileInfo) {
        getMVPView().hideProgressDialog();
        getMVPView().updateMobileInfo(mobileInfo);
    }

    @Override
    public void onFail(String message) {
        getMVPView().hideProgressDialog();
        getMVPView().updateFailInfo(message);
    }
}