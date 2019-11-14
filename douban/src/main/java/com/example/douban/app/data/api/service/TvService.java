package com.example.douban.app.data.api.service;

import com.example.douban.app.data.entity.tv.Tags;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TvService {

    /**
     * 获取所有电视标签
     *
     * @return
     */
    @Headers({"Domain-Name: tv"})
    @GET("/j/search_tags?type=tv")
    Observable<Tags> getTags();

}
