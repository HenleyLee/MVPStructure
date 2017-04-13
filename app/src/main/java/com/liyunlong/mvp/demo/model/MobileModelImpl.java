package com.liyunlong.mvp.demo.model;

import com.liyunlong.mvp.demo.listeners.LoadListener;
import com.liyunlong.mvp.demo.net.MobileRunnable;
import com.liyunlong.mvp.demo.contract.MobileContract;

import java.util.concurrent.Executors;

/**
 * Created by liyunlong on 2017/04/13
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