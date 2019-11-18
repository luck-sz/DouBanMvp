package com.example.douban.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.douban.R;
import com.example.douban.app.base.MySupportFragment;
import com.example.douban.app.data.entity.home.Banner;
import com.example.douban.di.component.DaggerHomeComponent;
import com.example.douban.mvp.contract.HomeContract;
import com.example.douban.mvp.presenter.HomePresenter;
import com.example.douban.mvp.ui.activity.MoreActivity;
import com.example.douban.mvp.ui.adapter.SectionMultipleItemAdapter;
import com.example.douban.mvp.ui.view.BannerViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.vondear.rxtool.RxSPTool;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.List;

import butterknife.BindView;

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
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    View view;
    View mBannerView;
    View mFootView;
    MZBannerView mMyBanner;
    RecyclerView mFootRecycler;
    boolean update;

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
        initToolBar();
        initBannerView();
        initFootView();
        initRefreshLayout();
        // 查询本地数据 为空时更新数据
        String mHomeData = RxSPTool.getContent(_mActivity, "HomeData");
        if (mHomeData.equals("")) {
            update = true;
        }
        if (mPresenter != null) {
            mPresenter.getBanners(update);
            mPresenter.getAllData(update);
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

    private void initToolBar() {
        toolbar.setTitle("首页");
        toolbar.inflateMenu(R.menu.main_home_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_search:
                        showMessage("搜索...");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void initBannerView() {
        mBannerView = getLayoutInflater().inflate(R.layout.view_banner, null, false);
        mMyBanner = mBannerView.findViewById(R.id.my_banner);
    }

    private void initFootView() {
        mFootView = getLayoutInflater().inflate(R.layout.item_movie_list, null, false);
        mFootRecycler = mFootView.findViewById(R.id.rv_movie_list);
    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeColors(ArmsUtils.getColor(_mActivity, R.color.black));
        mRefreshLayout.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.getBanners(true);
                mPresenter.getAllData(true);
            }
        });
    }

    @Override
    public void readGo(String title) {
        Intent intent = new Intent(_mActivity, MoreActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(MoreActivity.TITLE, title);
        intent.putExtras(bundle);
        launchActivity(intent);
    }

    @Override
    public void setBanner(List<Banner> banners) {
        mMyBanner.setIndicatorVisible(false);
        mMyBanner.setDelayedTime(3000);
        mMyBanner.setDuration(1500);
        mMyBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                showMessage("当前位置:" + position);
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

    // 添加头部Banner
    @Override
    public void addHeadView(SectionMultipleItemAdapter sectionMultipleItemAdapter) {
        if (sectionMultipleItemAdapter.getHeaderLayoutCount() < 1) {
            sectionMultipleItemAdapter.addHeaderView(mBannerView);
        }
    }

    // 设置Adapter Item
    @Override
    public void setMovieItemAdapter(SectionMultipleItemAdapter sectionMultipleItemAdapter) {
        mRecycleView.setLayoutManager(new GridLayoutManager(mContext, 6));
        mRecycleView.setAdapter(sectionMultipleItemAdapter);
    }
}
