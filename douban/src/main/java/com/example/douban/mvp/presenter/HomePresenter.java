package com.example.douban.mvp.presenter;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.douban.R;
import com.example.douban.app.data.entity.Banner;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.adapter.MovieItemAdapter;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;

import com.example.douban.mvp.contract.HomeContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.List;


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
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    MovieItemAdapter movieItemAdapter;


    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView) {
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

    public void getBanners() {
        mModel.getBanners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<List<Banner>>(mErrorHandler) {
                    @Override
                    public void onNext(List<Banner> banners) {
                        if (banners.size() > 0) {
                            mRootView.setBanner(banners);
                        }
                    }
                });
    }

    public void getAllData() {
        mModel.getAllData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();
                })
                .doFinally(() -> {
                    mRootView.hideLoading();
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<List<SectionMultipleItem>>(mErrorHandler) {
                    @Override
                    public void onNext(List<SectionMultipleItem> sectionMultipleItems) {
                        setMovieAdapter(sectionMultipleItems);
                    }
                });
    }


    private void setMovieAdapter(List<SectionMultipleItem> sectionMultipleItems) {
        if (movieItemAdapter == null && sectionMultipleItems.size() > 0) {
            movieItemAdapter = new MovieItemAdapter(R.layout.section_head, sectionMultipleItems);
        }
        mRootView.addHeadView(movieItemAdapter);
        mRootView.setMovieItem(movieItemAdapter);

    }

}
