package com.example.douban.mvp.presenter;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.douban.R;
import com.example.douban.app.data.entity.tv.TvBean;
import com.example.douban.mvp.ui.adapter.tv.TvItemAdapter;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;

import com.example.douban.mvp.contract.TvChildContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.List;


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
public class TvChildPresenter extends BasePresenter<TvChildContract.Model, TvChildContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;
    TvItemAdapter tvItemAdapter;

    @Inject
    public TvChildPresenter(TvChildContract.Model model, TvChildContract.View rootView) {
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

    public void getData(String tag, boolean update) {
        mModel.getTvData(tag, update)
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
                .subscribe(new ErrorHandleSubscriber<List<TvBean.SubjectsBean>>(mErrorHandler) {
                    @Override
                    public void onNext(List<TvBean.SubjectsBean> subjectsBeans) {
                        setTvAdapter(subjectsBeans, update);
                    }
                });
    }

    private void setTvAdapter(List<TvBean.SubjectsBean> subjectsBeans, boolean update) {
        if (tvItemAdapter == null) {
            tvItemAdapter = new TvItemAdapter(R.layout.item_tv, subjectsBeans);
        }
        if (update) {
            tvItemAdapter.setNewData(subjectsBeans);
        }
        tvItemAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        tvItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mApplication, subjectsBeans.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        mRootView.setTvItemAdapter(tvItemAdapter);
    }
}
