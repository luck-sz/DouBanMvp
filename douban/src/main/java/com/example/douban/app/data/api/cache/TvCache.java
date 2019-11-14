package com.example.douban.app.data.api.cache;

import com.example.douban.app.data.entity.tv.Tags;
import com.example.douban.app.data.entity.tv.TvBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

public interface TvCache {

    /**
     * 电视标签
     *
     * @param data
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    Observable<Reply<Tags>> getTags(Observable<Tags> data, EvictProvider evictProvider);

    /**
     * 电视标签
     *
     * @param data
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 3, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<TvBean.SubjectsBean>>> getTvData(Observable<List<TvBean.SubjectsBean>> data, EvictProvider evictProvider);
}
