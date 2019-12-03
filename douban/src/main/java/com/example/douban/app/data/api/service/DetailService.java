package com.example.douban.app.data.api.service;

import com.example.douban.app.data.entity.detail.DetailBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface DetailService {

    /**
     * 获取详情页数据
     *
     * @return
     */
    @Headers({"Domain-Name: movie"})
    @GET("/v2/movie/subject/{id}?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<DetailBean> getDetail(@Path("id") String id);

}
