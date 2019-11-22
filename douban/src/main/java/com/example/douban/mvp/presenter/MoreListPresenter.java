package com.example.douban.mvp.presenter;

import android.app.Application;

import com.example.douban.R;
import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.app.data.entity.more.MoreListBean;
import com.example.douban.mvp.ui.adapter.more.MoreHotAdapter;
import com.example.douban.mvp.ui.adapter.more.MoreListAdapter;
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

import com.example.douban.mvp.contract.MoreListContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.List;


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
public class MoreListPresenter extends BasePresenter<MoreListContract.Model, MoreListContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;
    MoreListAdapter moreListAdapter;

    @Inject
    public MoreListPresenter(MoreListContract.Model model, MoreListContract.View rootView) {
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

    public void getMoreList(boolean update, String title) {
        mModel.getMoreList(update, title)
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
                .subscribe(new ErrorHandleSubscriber<List<MoreListBean>>(mErrorHandler) {
                    @Override
                    public void onNext(List<MoreListBean> moreListBeans) {
                        setAdapter(moreListBeans, update);
                    }
                });
    }

    private void setAdapter(List<MoreListBean> moreListBeans, boolean update) {
        if (moreListAdapter == null) {
            moreListAdapter = new MoreListAdapter(R.layout.item_more_list, moreListBeans);
        }
        if (update) {
            moreListAdapter.setNewData(moreListBeans);
        }
        mRootView.setAdapter(moreListAdapter);
    }


}
