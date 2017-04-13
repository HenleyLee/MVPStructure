package com.liyunlong.mvp;

import android.content.Context;

/**
 * 负责完成View与Model间的交互(作为View与Model交互的中间纽带，处理与用户的交互)
 *
 * @author liyunlong
 * @date 2017/2/28 15:32
 */
public class BasePresenter<MVPView extends IMVPView> implements IPresenter<MVPView> {

    private Context mContext;
    private MVPView mMVPView;

    public BasePresenter(Context context) {
        this.mContext = context;
    }

    @Override
    public void attachView(MVPView mvpView) {
        this.mMVPView = mvpView;
    }

    @Override
    public void detachView() {
        this.mMVPView = null;
    }

    public Context getContext() {
        return mContext;
    }

    public MVPView getMVPView() {
        checkViewAttached();
        return mMVPView;
    }

    private boolean isViewAttached() {
        return mMVPView != null;
    }

    private void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MVPViewNotAttachedException();
        }
    }
}
