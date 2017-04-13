package com.liyunlong.mvp;

/**
 * @author liyunlong
 * @date 2017/2/28 15:52
 */
public class MVPViewNotAttachedException extends RuntimeException {

    public MVPViewNotAttachedException() {
        this("Please call Presenter.attachView(mvpView) before requesting data to the Presenter.");
    }

    public MVPViewNotAttachedException(String message) {
        super(message);
    }
}
