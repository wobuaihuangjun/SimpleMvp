package com.hzj.simplemvp;

import com.hzj.mvp.MvpBasePresenter;

/**
 * Created by hzj on 2016/8/31.
 */
public class MainPresenter extends MvpBasePresenter<IMainView> {

    public void clickButton() {
        if (isViewAttached()) {
            getView().showToast();
        }
    }

}
