package com.example.douban.mvp.model;

import android.app.Application;
import android.graphics.Movie;

import com.example.douban.app.data.api.service.DouBanService;
import com.example.douban.app.data.entity.Banner;
import com.example.douban.app.data.entity.DoubanBean;
import com.example.douban.app.data.entity.MovieListBean;
import com.example.douban.app.data.entity.NewMoviesBean;
import com.example.douban.app.data.entity.UsBoxBean;
import com.example.douban.app.data.entity.WeeklyBean;
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
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;


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

        return Observable.zip(mRepositoryManager.obtainRetrofitService(DouBanService.class)
                        .getNowPlaying()
                        .map(new Function<DoubanBean, List<SectionMultipleItem>>() {
                            @Override
                            public List<SectionMultipleItem> apply(DoubanBean doubanBean) throws Exception {
                                hotList.add(0, new SectionMultipleItem(true, "影院热映", true));
                                for (int i = 0; i < doubanBean.getEntries().size(); i++) {
                                    if (!doubanBean.getEntries().get(i).getRating().equals("") && hotList.size() < 7) {
                                        hotList.add(new SectionMultipleItem(SectionMultipleItem.HOT_ITEM, doubanBean.getEntries().get(i)));
                                    }
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
                                    comingList.add(new SectionMultipleItem(SectionMultipleItem.COMING_ITEM, doubanBean.getEntries().get(i)));
                                }
                                comingList.add(new SectionMultipleItem(true, "电影榜单", true));
                                return comingList;
                            }
                        }), new BiFunction<List<SectionMultipleItem>, List<SectionMultipleItem>, List<SectionMultipleItem>>() {
                    @Override
                    public List<SectionMultipleItem> apply(List<SectionMultipleItem> sectionMultipleItems, List<SectionMultipleItem> sectionMultipleItems1) throws Exception {
                        sectionMultipleItems.addAll(sectionMultipleItems1);
                        return sectionMultipleItems;
                    }
                });
    }

    @Override
    public Observable<List<MovieListBean>> getMovieListData() {
        Observable<MovieListBean> weeklyObservable = mRepositoryManager.obtainRetrofitService(DouBanService.class)
                .getWeekly()
                .map(new Function<WeeklyBean, MovieListBean>() {
                    @Override
                    public MovieListBean apply(WeeklyBean weeklyBean) throws Exception {
                        List<MovieListBean.Movie> movies = new ArrayList<>();
                        MovieListBean movieListBean = new MovieListBean();
                        movieListBean.setTitle("一周口碑电影榜");
                        movieListBean.setSize(weeklyBean.getSubjects().size());
                        movieListBean.setImg(weeklyBean.getSubjects().get(1).getSubject().getImages().getLarge());
                        for (int i = 0; i < 3; i++) {
                            movies.add(new MovieListBean.Movie(i + 1, weeklyBean.getSubjects().get(i).getSubject().getTitle(), weeklyBean.getSubjects().get(i).getSubject().getRating().getAverage()));
                        }
                        movieListBean.setMovies(movies);
                        return movieListBean;
                    }
                });
        Observable<MovieListBean> newMoviesObservable = mRepositoryManager.obtainRetrofitService(DouBanService.class)
                .getNewMovies()
                .map(new Function<NewMoviesBean, MovieListBean>() {
                    @Override
                    public MovieListBean apply(NewMoviesBean newMoviesBean) throws Exception {
                        MovieListBean movieListBean = new MovieListBean();
                        List<MovieListBean.Movie> movies = new ArrayList<>();
                        movieListBean.setTitle("一周新电影榜");
                        movieListBean.setSize(newMoviesBean.getSubjects().size());
                        movieListBean.setImg(newMoviesBean.getSubjects().get(0).getImages().getLarge());
                        for (int i = 0; i < 3; i++) {
                            movies.add(new MovieListBean.Movie(i + 1, newMoviesBean.getSubjects().get(i).getTitle(), newMoviesBean.getSubjects().get(i).getRating().getAverage()));
                        }
                        movieListBean.setMovies(movies);
                        return movieListBean;
                    }
                });
        Observable<MovieListBean> usBoxObservable = mRepositoryManager.obtainRetrofitService(DouBanService.class)
                .getUsBox()
                .map(new Function<UsBoxBean, MovieListBean>() {
                    @Override
                    public MovieListBean apply(UsBoxBean usBoxBean) throws Exception {
                        MovieListBean movieListBean = new MovieListBean();
                        List<MovieListBean.Movie> movies = new ArrayList<>();
                        movieListBean.setTitle("北美票房榜");
                        movieListBean.setSize(usBoxBean.getSubjects().size());
                        movieListBean.setImg(usBoxBean.getSubjects().get(0).getSubject().getImages().getLarge());
                        for (int i = 0; i < 3; i++) {
                            movies.add(new MovieListBean.Movie(i + 1, usBoxBean.getSubjects().get(i).getSubject().getTitle(), usBoxBean.getSubjects().get(i).getSubject().getRating().getAverage()));
                        }
                        movieListBean.setMovies(movies);
                        return movieListBean;
                    }
                });

        return Observable.zip(weeklyObservable, newMoviesObservable, usBoxObservable, new Function3<MovieListBean, MovieListBean, MovieListBean, List<MovieListBean>>() {
            @Override
            public List<MovieListBean> apply(MovieListBean list1, MovieListBean list2, MovieListBean list3) throws Exception {
                List<MovieListBean> movieListBeans = new ArrayList<>();
                movieListBeans.add(list1);
                movieListBeans.add(list2);
                movieListBeans.add(list3);
                return movieListBeans;
            }
        });
    }

}