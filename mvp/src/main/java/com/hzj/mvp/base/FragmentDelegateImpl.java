package com.hzj.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hzj.mvp.MvpPresenter;
import com.hzj.mvp.MvpView;
import com.hzj.mvp.delegate.FragmentMvpDelegateImpl;
import com.hzj.mvp.delegate.MvpDelegateCallback;


/**
 * 自定义的Fragment代理，将presenter的初始化操作提前到onCreate方法
 * <p/>
 * Created by huangzj on 2016/4/5.
 */
public class FragmentDelegateImpl<V extends MvpView, P extends MvpPresenter<V>>
        extends FragmentMvpDelegateImpl<V, P> {

    public FragmentDelegateImpl(MvpDelegateCallback<V, P> delegateCallback) {
        super(delegateCallback);
    }

    @Override
    public void onCreate(Bundle saved) {
        super.onViewCreated(null, null);//将presenter的初始化操作提前到onCreate方法
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //onViewCreated方法不再初始化presenter
    }


}
