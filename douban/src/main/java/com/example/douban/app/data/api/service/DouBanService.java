package com.example.douban.app.data.api.service;

import com.example.douban.app.data.entity.DoubanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DouBanService {

    /**
     * 获取正在热映电影
     *
     * @return
     */
    @GET("/v2/movie/nowplaying?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<DoubanBean> getNowPlaying();

    /**
     * 获取即将上映电影
     *
     * @return
     */
    @GET("/v2/movie/coming?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=6")
    Observable<DoubanBean> getComing();
}
