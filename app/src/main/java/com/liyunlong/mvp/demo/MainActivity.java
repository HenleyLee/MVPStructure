package com.liyunlong.mvp.demo;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.liyunlong.mvp.MVPViewHelper;
import com.liyunlong.mvp.demo.contract.MobileContract;
import com.liyunlong.mvp.demo.data.MobileInfo;
import com.liyunlong.mvp.demo.presenter.MobilePresenterImpl;

public class MainActivity extends AppCompatActivity implements MobileContract.MobileView, View.OnClickListener {

    private MobilePresenterImpl mobilePresenter;
    private MVPViewHelper mvpViewHelper;
    private EditText edtMobile;
    private TextView tvMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mvpViewHelper = new MVPViewHelper(this);
        mobilePresenter = new MobilePresenterImpl(this);
        mobilePresenter.attachView(this);
        initViews();
    }

    private void initViews() {
        edtMobile = (EditText) findViewById(R.id.mobile_input);
        tvMobile = (TextView) findViewById(R.id.mobile_result);
        edtMobile.setSelection(edtMobile.length());
        findViewById(R.id.mobile_submit).setOnClickListener(this);
    }

    @Override
    public void showToast(@StringRes int resId) {
        mvpViewHelper.showToast(resId);
    }

    @Override
    public void showToast(CharSequence message) {
        mvpViewHelper.showToast(message);
    }

    @Override
    public void showProgressDialog() {
        mvpViewHelper.showProgressDialog();
    }

    @Override
    public void showProgressDialog(boolean cancel) {
        mvpViewHelper.showProgressDialog(cancel);
    }

    @Override
    public void showProgressDialog(CharSequence message, boolean cancel) {
        mvpViewHelper.showProgressDialog(message, cancel);
    }

    @Override
    public void hideProgressDialog() {
        mvpViewHelper.hideProgressDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mobilePresenter.detachView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mobile_submit:
                String mobile = edtMobile.getText().toString().trim();
                if (TextUtils.isEmpty(mobile)) {
                    showToast("请输入手机号");
                } else {
                    mobilePresenter.loadMobileInfo(mobile);
                }
                break;
        }
    }

    @Override
    public void updateMobileInfo(MobileInfo mobileInfo) {
        tvMobile.setText(mobileInfo.toString());
    }

    @Override
    public void updateFailInfo(String message) {
        tvMobile.setText(message);
    }
}
