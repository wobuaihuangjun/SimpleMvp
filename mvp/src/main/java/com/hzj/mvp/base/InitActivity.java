package com.hzj.mvp.base;

/**
 * Created by huangzj on 2016/2/29.
 *
 * Activity 初始化接口
 */
public interface InitActivity {

    /**
     * 用于初始化数据
     */
    void initData();

    /**
     * 用于初始化视图
     */
    void initView();

    /**
     * 用于异步加载数据
     */
    void loadData();
}
