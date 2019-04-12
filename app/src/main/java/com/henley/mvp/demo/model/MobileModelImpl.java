package com.henley.mvp.demo.model;

import com.henley.mvp.demo.listeners.LoadListener;
import com.henley.mvp.demo.net.MobileRunnable;
import com.henley.mvp.demo.contract.MobileContract;

import java.util.concurrent.Executors;

/**
 * Created by Henley on 2017/04/13
 */
public class MobileModelImpl implements MobileContract.Model {

    @Override
    public String getUrl(String mobile) {
        return String.format("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=%s", mobile);
    }

    @Override
    public void loadMobileInfo(String mobile, LoadListener listener) {
        MobileRunnable runnable = new MobileRunnable(getUrl(mobile), listener);
        Executors.newCachedThreadPool().submit(runnable);
    }

}