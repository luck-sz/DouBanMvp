package com.example.douban.mvp.model;

import android.app.Application;

import com.example.douban.app.data.api.Api;
import com.example.douban.app.data.api.cache.TvCache;
import com.example.douban.app.data.api.service.TvService;
import com.example.douban.app.data.entity.tv.Tags;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.example.douban.mvp.contract.TvContract;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;


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
@FragmentScope
public class TvModel extends BaseModel implements TvContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public TvModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
        RetrofitUrlManager.getInstance().putDomain("tv", Api.TV_BASE_URL);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<Tags> getTags() {
        Observable<Tags> data = mRepositoryManager
                .obtainRetrofitService(TvService.class)
                .getTags();
        return mRepositoryManager
                .obtainCacheService(TvCache.class)
                .getTags(data, new EvictProvider(false))
                .map(new Function<Reply<Tags>, Tags>() {
                    @Override
                    public Tags apply(Reply<Tags> tagsReply) throws Exception {
                        return tagsReply.getData();
                    }
                });
    }
}