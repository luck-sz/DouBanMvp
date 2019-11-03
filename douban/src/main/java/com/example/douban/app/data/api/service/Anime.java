package com.example.douban.app.data.api.service;

import com.example.douban.app.data.entity.AnimeBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Anime {

    /**
     * 获取所有动画列表
     */
    @GET("/calendar")
    Observable<List<AnimeBean>> getAllData();
}
