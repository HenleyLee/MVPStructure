package com.henley.mvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * MVP模式中IMVPView的实现类
 *
 * @author Henley
 * @date 2017/2/28 15:54
 */
public class MVPViewHelper implements IMVPView {

    private Context context;
    private Toast toast;
    private ProgressDialog mProgressDialog;

    public MVPViewHelper(Context context) {
        this.context = context;
    }


    @Override
    public void showToast(@StringRes int resId) {
        showToast(context.getString(resId));
    }

    @Override
    public void showToast(CharSequence message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    @Override
    public void showProgressDialog() {
        showProgressDialog(true);
    }

    @Override
    public void showProgressDialog(boolean cancel) {
        showProgressDialog("", cancel);
    }

    @Override
    public void showProgressDialog(CharSequence message, boolean cancel) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(cancel);
        mProgressDialog.setCanceledOnTouchOutside(cancel);
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
