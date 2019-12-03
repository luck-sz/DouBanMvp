package com.example.douban.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.example.douban.mvp.contract.DetailContract;
import com.example.douban.mvp.model.DetailModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/03/2019 11:26
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class DetailModule {

    @Binds
    abstract DetailContract.Model bindDetailModel(DetailModel model);
}