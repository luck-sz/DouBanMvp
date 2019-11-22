package com.example.douban.di.module;

import com.example.douban.mvp.model.ComingListModel;

import dagger.Binds;
import dagger.Module;

import com.example.douban.mvp.contract.ComingListContract;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 16:38
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class ComingListModule {

    @Binds
    abstract ComingListContract.Model bindComingModel(ComingListModel model);
}