package com.henley.mvp.demo.listeners;

import com.henley.mvp.demo.data.MobileInfo;

/**
 * @author Henley
 * @date 2017/4/13 17:20
 */
public interface LoadListener {

    void onSuccess(MobileInfo mobileInfo);

    void onFail(String message);
}
