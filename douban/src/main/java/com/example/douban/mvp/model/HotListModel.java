package com.example.douban.mvp.model;

import android.app.Application;

import com.example.douban.app.data.api.cache.MoreListCache;
import com.example.douban.app.data.api.service.DouBanService;
import com.example.douban.app.data.entity.home.DoubanBean;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.example.douban.mvp.contract.HotListContract;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;


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
@FragmentScope
public class HotListModel extends BaseModel implements HotListContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public HotListModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<List<DoubanBean.SubjectsBean>> getAllData(boolean update) {
        Observable<List<DoubanBean.SubjectsBean>> listObservable = mRepositoryManager.obtainRetrofitService(DouBanService.class)
                .getNowPlaying()
                .map(new Function<DoubanBean, List<DoubanBean.SubjectsBean>>() {
                    @Override
                    public List<DoubanBean.SubjectsBean> apply(DoubanBean doubanBean) throws Exception {
                        return doubanBean.getSubjects();
                    }
                });

        return mRepositoryManager.obtainCacheService(MoreListCache.class)
                .getMoreHot(listObservable, new EvictProvider(update))
                .map(new Function<Reply<List<DoubanBean.SubjectsBean>>, List<DoubanBean.SubjectsBean>>() {
                    @Override
                    public List<DoubanBean.SubjectsBean> apply(Reply<List<DoubanBean.SubjectsBean>> listReply) throws Exception {
                        return listReply.getData();
                    }
                });
    }
}