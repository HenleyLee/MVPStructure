package com.liyunlong.mvp.demo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author liyunlong
 * @date 2017/4/13 17:33
 */
public class Utility {

    public static boolean isNetworkConnected(Context context) {
        boolean flag = false;
        if (null == context) {
            return false;
        }
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity == null) {
                return false;
            }
            NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
            flag = networkInfo != null && networkInfo.isAvailable();
        } catch (Exception e) {
            return false;
        }
        return flag;
    }

}
