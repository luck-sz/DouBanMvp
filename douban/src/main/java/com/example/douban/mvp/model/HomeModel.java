package com.example.douban.mvp.model;

import android.app.Application;

import com.example.douban.app.data.entity.Banner;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.example.douban.mvp.contract.HomeContract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/02/2019 13:29
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class HomeModel extends BaseModel implements HomeContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public HomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<List<Banner>> getBanners() {
        return Observable.create(new ObservableOnSubscribe<Document>() {
            @Override
            public void subscribe(ObservableEmitter<Document> emitter) throws Exception {
                Document document = Jsoup.connect("https://movie.douban.com/").get();
                emitter.onNext(document);
            }
        }).subscribeOn(Schedulers.io())
                .flatMap(new Function<Document, ObservableSource<List<Banner>>>() {
                    @Override
                    public ObservableSource<List<Banner>> apply(Document document) throws Exception {
                        Elements home = document.select("div.gallery-frame");
                        Elements bd = document.select("div.gallery-bd");
                        List<Banner> banners = new ArrayList<>();
                        for (int i = 0; i < home.size(); i++) {
                            String img = home.get(i).select("a").select("img").attr("src");
                            String title = home.get(i).select("a").select("img").attr("alt");
                            String content = bd.get(i).select("p").text();
                            String detail = home.get(i).select("a").attr("href");
                            Banner banner = new Banner(img, title, content, detail);
                            banners.add(banner);
                        }
                        return Observable.just(banners);
                    }
                });
    }
}