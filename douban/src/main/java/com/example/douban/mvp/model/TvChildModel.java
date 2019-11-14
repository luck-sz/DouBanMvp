package com.example.douban.mvp.model;

import android.app.Application;

import com.example.douban.app.data.api.service.TvService;
import com.example.douban.app.data.entity.tv.TvBean;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.example.douban.mvp.contract.TvChildContract;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/14/2019 11:25
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class TvChildModel extends BaseModel implements TvChildContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public TvChildModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<List<TvBean.SubjectsBean>> getTvData(String tag, boolean update) {
        return mRepositoryManager.obtainRetrofitService(TvService.class)
                .getTvData(tag)
                .map(new Function<TvBean, List<TvBean.SubjectsBean>>() {
                    @Override
                    public List<TvBean.SubjectsBean> apply(TvBean tvBean) throws Exception {
                        return tvBean.getSubjects();
                    }
                });
    }
}