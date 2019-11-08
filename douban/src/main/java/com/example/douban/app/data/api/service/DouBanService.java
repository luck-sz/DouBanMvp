package com.example.douban.app.data.api.service;

import com.example.douban.app.data.entity.DoubanBean;
import com.example.douban.app.data.entity.NewMoviesBean;
import com.example.douban.app.data.entity.UsBoxBean;
import com.example.douban.app.data.entity.WeeklyBean;

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


    /**
     * 本周口碑榜
     *
     * @return
     */
    @GET("/v2/movie/weekly?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=6")
    Observable<WeeklyBean> getWeekly();

    /**
     * 新片榜
     *
     * @return
     */
    @GET("/v2/movie/new_movies?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<NewMoviesBean> getNewMovies();

    /**
     * 北美票房榜
     *
     * @return
     */
    @GET("/v2/movie/us_box?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<UsBoxBean> getUsBox();

}
