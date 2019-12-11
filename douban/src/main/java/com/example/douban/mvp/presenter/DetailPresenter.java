package com.example.douban.mvp.presenter;

import android.app.Application;

import com.example.douban.app.data.entity.detail.DetailBean;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;
import com.example.douban.mvp.ui.adapter.detail.DetailMultipleItemAdapter;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import timber.log.Timber;

import javax.inject.Inject;

import com.example.douban.mvp.contract.DetailContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/03/2019 11:26
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class DetailPresenter extends BasePresenter<DetailContract.Model, DetailContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;
    List<DetailMultipleItem> list;
    DetailMultipleItemAdapter adapter;

    @Inject
    public DetailPresenter(DetailContract.Model model, DetailContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void getDetail(String id) {
        mRootView.setMotion();
        mModel.getDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<DetailBean>(mErrorHandler) {
                    @Override
                    public void onNext(DetailBean detailBean) {
                        mRootView.setTitleBar(detailBean.getTitle(), detailBean.getOriginal_title());
                        mRootView.setPicture(detailBean.getImages().getLarge(), detailBean.getImages().getMedium());
                        mRootView.initSlideShapeTheme(detailBean.getImages().getLarge());
                        mRootView.setHeadData(detailBean);
                        setDate(detailBean);
                        setAdapter(list);
                    }
                });
    }

    private void setDate(DetailBean detailBean) {
        list = new ArrayList<>();
        list.add(new DetailMultipleItem(DetailMultipleItem.HEAD_ITEM, true, "所属频道"));
        list.add(new DetailMultipleItem(DetailMultipleItem.TAG_LIST_ITEM, detailBean));
        list.add(new DetailMultipleItem(DetailMultipleItem.HEAD_ITEM, true, "简介"));
        list.add(new DetailMultipleItem(DetailMultipleItem.TEXT_ITEM, detailBean));
        list.add(new DetailMultipleItem(DetailMultipleItem.HEAD_ITEM, true, "演职员"));
        list.add(new DetailMultipleItem(DetailMultipleItem.ACTOR_LIST_ITEM, detailBean));
        // 有预告片时才显示
        if (detailBean.getBlooper_urls().size() > 0) {
            list.add(new DetailMultipleItem(DetailMultipleItem.HEAD_ITEM, true, "预告片 / 剧照"));
            list.add(new DetailMultipleItem(DetailMultipleItem.VIDEO_LIST_ITEM, detailBean));
        }
        list.add(new DetailMultipleItem(DetailMultipleItem.HEAD_ITEM, true, "短评"));
        list.add(new DetailMultipleItem(DetailMultipleItem.COMMENT_LIST_ITEM, detailBean));
    }

    private void setAdapter(List<DetailMultipleItem> list) {
        if (adapter == null) {
            adapter = new DetailMultipleItemAdapter(list);
        }
        mRootView.setDetailAdapter(adapter);
    }
}
