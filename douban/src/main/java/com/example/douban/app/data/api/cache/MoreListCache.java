package com.example.douban.app.data.api.cache;

import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.app.data.entity.tv.Tags;
import com.example.douban.app.data.entity.tv.TvBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

public interface MoreListCache {

    /**
     * 更多热映电影
     *
     * @param data
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 3, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<DoubanBean.SubjectsBean>>> getMoreHot(Observable<List<DoubanBean.SubjectsBean>> data, EvictProvider evictProvider);

    /**
     * 即将上映电影
     *
     * @param data
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 3, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<DoubanBean.SubjectsBean>>> getMoreComing(Observable<List<DoubanBean.SubjectsBean>> data, EvictProvider evictProvider);

}
