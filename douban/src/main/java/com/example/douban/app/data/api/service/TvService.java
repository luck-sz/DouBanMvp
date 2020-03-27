package com.example.douban.app.data.api.service;

import com.example.douban.app.data.entity.tv.Tags;
import com.example.douban.app.data.entity.tv.TvBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface TvService {

    /**
     * 获取所有电视标签
     *
     * @return
     */
    @Headers({"Domain-Name: tv"})
    @GET("/j/search_tags?type=tv")
    Observable<Tags> getTags();

    /**
     * 根据标签获取该分类的电视
     */
    @Headers({"Domain-Name: tv"})
    @GET("/j/search_subjects?type=tv&sort=recommend&page_limit=100&page_start=0")
    Observable<TvBean> getTvData(@Query("tag") String tag);

}
