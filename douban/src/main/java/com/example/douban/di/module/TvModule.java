package com.example.douban.di.module;

import dagger.Binds;
import dagger.Module;

import com.example.douban.mvp.contract.TvContract;
import com.example.douban.mvp.model.TvModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/11/2019 10:29
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class TvModule {

    @Binds
    abstract TvContract.Model bindBookModel(TvModel model);
}