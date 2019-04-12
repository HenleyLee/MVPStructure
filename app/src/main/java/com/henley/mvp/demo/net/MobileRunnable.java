package com.henley.mvp.demo.net;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.henley.mvp.demo.data.MobileInfo;
import com.henley.mvp.demo.listeners.LoadListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 下载任务
 *
 * @author Henley
 * @date 2017/4/11 18:32
 */
public class MobileRunnable implements Runnable {

    private String mUrl;
    private LoadListener mListener;

    public MobileRunnable(String url, LoadListener listener) {
        this.mUrl = url;
        this.mListener = listener;
    }

    private void sendComplete(MobileInfo mobileInfo) {
        if (mListener != null) {
            mListener.onSuccess(mobileInfo);
        }
    }

    private void sendError(String message) {
        if (mListener != null) {
            mListener.onFail(message);
        }
    }

    @Override
    public void run() {
        try {
            URL httpUrl = new URL(mUrl);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            int totalLength = connection.getContentLength();
            if (responseCode != 200) {
                sendError("The responseCode is " + responseCode + " .");
            } else if (totalLength <= 0) {
                sendError("The totalLength is " + totalLength + " .");
            } else {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    builder.append(line);
                }
                String result = builder.toString();
                if (!TextUtils.isEmpty(result) && result.contains("=")) {
                    String[] split = result.split("=");
                    MobileInfo mobileInfo = JSON.parseObject(split[1].trim(), MobileInfo.class);
                    sendComplete(mobileInfo);
                    Log.i("TAG", mobileInfo.toString());
                } else {
                    sendError(result);
                    Log.i("TAG", result);
                }
                bufferedReader.close();
                inputStream.close();
            }
        } catch (IOException e) {
            sendError(e.getMessage());
        }
    }
}
