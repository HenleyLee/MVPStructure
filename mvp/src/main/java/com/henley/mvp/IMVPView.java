package com.henley.mvp;

import android.support.annotation.StringRes;
import android.support.annotation.UiThread;

/**
 * 负责绘制UI元素、与用户进行交互(在Android中体现为Activity)
 * <ul>
 * <li>UI层，包含所有UI相关组件
 * <li>持有对应的Presenter的对象，可通过依赖注入解耦此部分
 * <li>由Presenter来负责更新UI
 * </ul>
 *
 * @author Henley
 * @date 2017/2/28 15:27
 */
public interface IMVPView {

    /**
     * 显示提示信息
     *
     * @param resId 提示信息资源ID
     */
    void showToast(@StringRes int resId);

    /**
     * 显示提示信息
     *
     * @param message 提示信息
     */
    void showToast(CharSequence message);

    /**
     * 显示加载对话框
     */
    @UiThread
    void showProgressDialog();

    /**
     * 显示加载对话框
     *
     * @param cancel 是否可取消
     */
    @UiThread
    void showProgressDialog(boolean cancel);

    /**
     * 显示加载对话框
     *
     * @param message 提示信息
     * @param cancel  是否可取消
     */
    @UiThread
    void showProgressDialog(CharSequence message, boolean cancel);

    /**
     * 隐藏加载对话框
     */
    @UiThread
    void hideProgressDialog();
}
