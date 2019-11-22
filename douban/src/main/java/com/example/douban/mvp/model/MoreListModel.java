package com.example.douban.mvp.model;

import android.app.Application;

import com.example.douban.app.data.api.service.DouBanService;
import com.example.douban.app.data.entity.home.WeeklyBean;
import com.example.douban.app.data.entity.more.MoreListBean;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.example.douban.mvp.contract.MoreListContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/22/2019 14:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class MoreListModel extends BaseModel implements MoreListContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;
    List<String> types;
    List<String> actors;

    @Inject
    public MoreListModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<List<MoreListBean>> getMoreList(boolean update, String title) {
        switch (title) {
            case "一周口碑电影榜":
                return mRepositoryManager.obtainRetrofitService(DouBanService.class)
                        .getWeekly()
                        .map(new Function<WeeklyBean, List<MoreListBean>>() {
                            @Override
                            public List<MoreListBean> apply(WeeklyBean weeklyBean) throws Exception {
                                List<MoreListBean> moreListBeans = new ArrayList<>();
                                types = new ArrayList<>();
                                actors = new ArrayList<>();
                                for (int i = 0; i < weeklyBean.getSubjects().size(); i++) {
                                    String id = weeklyBean.getSubjects().get(i).getSubject().getId();
                                    String title = weeklyBean.getSubjects().get(i).getSubject().getTitle();
                                    String img = weeklyBean.getSubjects().get(i).getSubject().getImages().getLarge();
                                    double rating = weeklyBean.getSubjects().get(i).getSubject().getRating().getAverage();
                                    String year = weeklyBean.getSubjects().get(i).getSubject().getYear();
                                    types = weeklyBean.getSubjects().get(i).getSubject().getGenres();
                                    for (int j = 0; j < weeklyBean.getSubjects().get(i).getSubject().getCasts().size(); j++) {
                                        actors.add(weeklyBean.getSubjects().get(i).getSubject().getCasts().get(j).getName());
                                    }
                                    MoreListBean bean = new MoreListBean(i + 1, id, title, img, rating, year, types, actors);
                                    moreListBeans.add(bean);
                                }
                                return moreListBeans;
                            }
                        });
            case "一周新电影榜":
                return null;
            case "北美票房榜":
                return null;
            default:
                return null;
        }
    }
}