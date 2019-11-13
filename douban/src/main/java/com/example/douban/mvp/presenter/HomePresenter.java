package com.example.douban.mvp.presenter;

import android.app.Application;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.douban.R;
import com.example.douban.app.data.entity.Banner;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.adapter.SectionMultipleItemAdapter;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import timber.log.Timber;

import javax.inject.Inject;

import com.example.douban.mvp.contract.HomeContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.ArrayList;
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
    private SectionMultipleItemAdapter sectionMultipleItemAdapter;

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

    public void getBanners(boolean update) {
        mModel.getBanners(update)
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
                    mRootView.hideLoading();
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<List<SectionMultipleItem>>(mErrorHandler) {
                    @Override
                    public void onNext(List<SectionMultipleItem> sectionMultipleItems) {
                        setMovieAdapter(sectionMultipleItems, update);
                    }
                });
    }

    private void setMovieAdapter(List<SectionMultipleItem> sectionMultipleItems, boolean update) {
        if (sectionMultipleItemAdapter == null && sectionMultipleItems.size() > 0) {
            sectionMultipleItemAdapter = new SectionMultipleItemAdapter(sectionMultipleItems);
            mRootView.addHeadView(sectionMultipleItemAdapter);
        }
        if (update){
            sectionMultipleItemAdapter.setNewData(sectionMultipleItems);
        }
        mRootView.setMovieItem(sectionMultipleItemAdapter);
        sectionMultipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int type = sectionMultipleItems.get(position).getItemType();
                if (type == SectionMultipleItem.COMING_ITEM || type == SectionMultipleItem.HOT_ITEM) {
                    return 2;
                } else if (type == SectionMultipleItem.HEAD_ITEM || type == SectionMultipleItem.MOVIE_LIST_ITEM) {
                    return 6;
                } else {
                    return 0;
                }
            }
        });
        sectionMultipleItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SectionMultipleItem sectionMultipleItem = sectionMultipleItemAdapter.getData().get(position);
                if (view.getId() == R.id.more) {
                    Toast.makeText(mApplication, sectionMultipleItem.getHeader(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
