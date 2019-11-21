package com.example.douban.mvp.presenter;

import android.app.Application;

import com.example.douban.R;
import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.mvp.ui.adapter.MoreComingAdapter;
import com.example.douban.mvp.ui.adapter.MoreHotAdapter;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;

import com.example.douban.mvp.contract.ComingContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.List;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 16:38
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class ComingPresenter extends BasePresenter<ComingContract.Model, ComingContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    MoreComingAdapter moreComingAdapter;

    @Inject
    public ComingPresenter(ComingContract.Model model, ComingContract.View rootView) {
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

    public void getAllData(boolean update) {
        mModel.getAllData(update)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    if (update) {
                        mRootView.showLoading();
                    }
                })
                .doFinally(() -> {
                    if (update) {
                        mRootView.hideLoading();
                    }
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<List<DoubanBean.SubjectsBean>>(mErrorHandler) {
                    @Override
                    public void onNext(List<DoubanBean.SubjectsBean> subjectsBeans) {
                        setAdapter(subjectsBeans, update);
                    }
                });
    }

    private void setAdapter(List<DoubanBean.SubjectsBean> subjectsBeans, boolean update) {
        if (moreComingAdapter == null) {
            moreComingAdapter = new MoreComingAdapter(R.layout.item_more_coming, subjectsBeans);
        }
        if (update) {
            moreComingAdapter.setNewData(subjectsBeans);
        }
        mRootView.setAdapter(moreComingAdapter);
    }
}
