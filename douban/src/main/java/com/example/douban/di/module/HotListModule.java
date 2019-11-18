package com.example.douban.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.example.douban.mvp.contract.HotListContract;
import com.example.douban.mvp.model.HotListModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 15:34
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class HotListModule {

    @Binds
    abstract HotListContract.Model bindHotListModel(HotListModel model);
}