package com.hzj.mvp.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.hzj.mvp.MvpFragment;
import com.hzj.mvp.MvpPresenter;
import com.hzj.mvp.MvpView;
import com.hzj.mvp.delegate.FragmentMvpDelegate;

import java.util.List;

/**
 * Fragment 基类
 * <p/>
 * Created by huangzj on 2016/3/1.
 */
public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V, P> {

    @NonNull
    @Override
    protected FragmentMvpDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new FragmentDelegateImpl<>(this);
        }
        return mvpDelegate;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    /**
     * 处理上滑事件
     *
     * @return 是否消耗事件
     */
    public abstract boolean onUpSlide();

    /**
     * 处理下滑事件
     *
     * @return 是否消耗事件
     */
    public abstract boolean onDownSlide();

    /**
     * 处理左滑事件
     *
     * @return 是否消耗事件
     */
    public abstract boolean onLeftSlide();

    /**
     * 处理右滑事件
     *
     * @return 是否消耗事件
     */
    public abstract boolean onRightSlide();


    @Override
    public void startActivity(Intent intent) {
        if (isIntentAvailable(intent)) {
            super.startActivity(intent);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (isIntentAvailable(intent)) {
            super.startActivityForResult(intent, requestCode);
        }
    }

    /**
     * intent 判空处理
     */
    private boolean isIntentAvailable(Intent intent) {
        if (intent == null) {
            return false;
        }
        final PackageManager packageManager = getContext().getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.GET_ACTIVITIES);
        return list.size() > 0;
    }
}
