package com.example.douban.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.douban.R;
import com.example.douban.app.base.MySupportFragment;
import com.example.douban.app.data.entity.Banner;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.di.component.DaggerHomeComponent;
import com.example.douban.mvp.contract.HomeContract;
import com.example.douban.mvp.presenter.HomePresenter;
import com.example.douban.mvp.ui.adapter.MovieItemAdapter;
import com.example.douban.mvp.ui.adapter.MoviesListAdapter;
import com.example.douban.mvp.ui.view.BannerViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.List;

import butterknife.BindView;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
public class HomeFragment extends MySupportFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.rv_list)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    View view;
    View mBannerView;
    View mFootView;
    MZBannerView mMyBanner;
    RecyclerView mFootRecycler;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
        }
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mMyBanner.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        mMyBanner.start();//开始轮播
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initBannerView();
        initFootView();
        initRefreshLayout();
        if (mPresenter != null) {
            mPresenter.getBanners();
            mPresenter.getMovieListData();
            mPresenter.getAllData();
        }
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }

    private void initBannerView() {
        mBannerView = getLayoutInflater().inflate(R.layout.view_banner, null, false);
        mMyBanner = mBannerView.findViewById(R.id.my_banner);
    }

    private void initFootView() {
        mFootView = getLayoutInflater().inflate(R.layout.view_foot, null, false);
        mFootRecycler = mFootView.findViewById(R.id.rv_movies_list);
    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeColors(ArmsUtils.getColor(_mActivity, R.color.colorPrimary));
        mRefreshLayout.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.getAllData();
            }
        });
    }

    @Override
    public void setBanner(List<Banner> banners) {
        mMyBanner.setIndicatorVisible(false);
        mMyBanner.setDelayedTime(3000);
        mMyBanner.setDuration(1500);
        mMyBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
            }
        });
        mMyBanner.setPages(banners, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        mMyBanner.start();
    }

    @Override
    public void addHeadView(MovieItemAdapter movieItemAdapter) {
        if (movieItemAdapter.getHeaderLayoutCount() < 1) {
            movieItemAdapter.addHeaderView(mBannerView);
        }
    }

    @Override
    public void setMovieItem(MovieItemAdapter movieItemAdapter) {
        mRecycleView.setLayoutManager(new GridLayoutManager(_mActivity, 3));
        mRecycleView.setAdapter(movieItemAdapter);
    }

    @Override
    public void setMoviesListItem(MoviesListAdapter moviesListItem) {
        mFootRecycler.setLayoutManager(new LinearLayoutManager(_mActivity, LinearLayoutManager.HORIZONTAL, false));
        mFootRecycler.setAdapter(moviesListItem);
    }

    @Override
    public void addFootView(MovieItemAdapter movieItemAdapter) {
        if (movieItemAdapter.getFooterLayoutCount() == 0) {
            movieItemAdapter.addFooterView(mFootView);
        }
    }
}
