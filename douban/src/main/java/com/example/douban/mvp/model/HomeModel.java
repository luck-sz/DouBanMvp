package com.example.douban.mvp.model;

import android.app.Application;

import com.example.douban.app.data.api.service.DouBanService;
import com.example.douban.app.data.entity.Banner;
import com.example.douban.app.data.entity.DoubanBean;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
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
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import timber.log.Timber;


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
        }).flatMap(new Function<Document, ObservableSource<List<Banner>>>() {
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

    @Override
    public Observable<List<SectionMultipleItem>> getAllData() {
        List<SectionMultipleItem> hotList = new ArrayList<>();
        List<SectionMultipleItem> comingList = new ArrayList<>();
        List<SectionMultipleItem> allData = new ArrayList<>();

        return Observable.zip(mRepositoryManager.obtainRetrofitService(DouBanService.class)
                        .getNowPlaying()
                        .map(new Function<DoubanBean, List<SectionMultipleItem>>() {
                            @Override
                            public List<SectionMultipleItem> apply(DoubanBean doubanBean) throws Exception {
                                hotList.add(0, new SectionMultipleItem(true, "影院热映", true));
                                for (int i = 0; i < 6; i++) {
                                    hotList.add(new SectionMultipleItem(SectionMultipleItem.HOT_ITEM, doubanBean.getEntries().get(i)));
                                }
                                return hotList;
                            }
                        }),
                mRepositoryManager.obtainRetrofitService(DouBanService.class)
                        .getComing()
                        .map(new Function<DoubanBean, List<SectionMultipleItem>>() {
                            @Override
                            public List<SectionMultipleItem> apply(DoubanBean doubanBean) throws Exception {
                                comingList.add(0, new SectionMultipleItem(true, "即将上映", true));
                                for (int i = 0; i < 6; i++) {
                                    comingList.add(new SectionMultipleItem(SectionMultipleItem.HOT_ITEM, doubanBean.getEntries().get(i)));
                                }
                                return comingList;
                            }
                        }), new BiFunction<List<SectionMultipleItem>, List<SectionMultipleItem>, List<SectionMultipleItem>>() {
                    @Override
                    public List<SectionMultipleItem> apply(List<SectionMultipleItem> sectionMultipleItems, List<SectionMultipleItem> sectionMultipleItems1) throws Exception {
                        sectionMultipleItems.addAll(sectionMultipleItems1);
                        return null;
                    }
                });

//        return mRepositoryManager.obtainRetrofitService(DouBanService.class)
//                .getNowPlaying()
//                .map(new Function<DoubanBean, List<SectionMultipleItem>>() {
//                    @Override
//                    public List<SectionMultipleItem> apply(DoubanBean doubanBean) throws Exception {
//                        list.add(0, new SectionMultipleItem(true, "影院热映", true));
//                        for (int i = 0; i < 6; i++) {
//                            list.add(new SectionMultipleItem(SectionMultipleItem.HOT_ITEM, doubanBean.getEntries().get(i)));
//                        }
//                        return list;
//                    }
//                });
    }

}