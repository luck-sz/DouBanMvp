package com.example.douban.app.data.api.service;

import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.app.data.entity.home.NewMoviesBean;
import com.example.douban.app.data.entity.home.UsBoxBean;
import com.example.douban.app.data.entity.home.WeeklyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DouBanService {

    /**
     * 获取正在热映电影
     *
     * @return
     */
    @Headers({"Domain-Name: movie"})
    @GET("/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<DoubanBean> getNowPlaying();

    /**
     * 获取即将上映电影
     *
     * @return
     */
    @Headers({"Domain-Name: movie"})
    @GET("/v2/movie/coming_soon?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<DoubanBean> getComing();


    /**
     * 本周口碑榜
     *
     * @return
     */
    @Headers({"Domain-Name: movie"})
    @GET("/v2/movie/weekly?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<WeeklyBean> getWeekly();

    /**
     * 新片榜
     *
     * @return
     */
    @Headers({"Domain-Name: movie"})
    @GET("/v2/movie/new_movies?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<NewMoviesBean> getNewMovies();

    /**
     * 北美票房榜
     *
     * @return
     */
    @Headers({"Domain-Name: movie"})
    @GET("/v2/movie/us_box?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<UsBoxBean> getUsBox();

}
