package com.liyunlong.mvp.demo.listeners;

import com.liyunlong.mvp.demo.data.MobileInfo;

/**
 * @author liyunlong
 * @date 2017/4/13 17:20
 */
public interface LoadListener {

    void onSuccess(MobileInfo mobileInfo);

    void onFail(String message);
}
