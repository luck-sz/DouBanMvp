package com.example.douban.mvp.ui.fragment.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.douban.app.base.MySupportFragment;
import com.example.douban.app.utils.RecycleViewDivider;
import com.example.douban.mvp.ui.activity.MainActivity;
import com.example.douban.mvp.ui.activity.MoreActivity;
import com.example.douban.mvp.ui.adapter.more.MoreHotAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.douban.di.component.DaggerHotListComponent;
import com.example.douban.mvp.contract.HotListContract;
import com.example.douban.mvp.presenter.HotListPresenter;

import com.example.douban.R;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 15:34
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class HotListFragment extends MySupportFragment<HotListPresenter> implements HotListContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRecycleView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    String title;
    private RecycleViewDivider divider;

    public static HotListFragment newInstance(String title) {
        HotListFragment fragment = new HotListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MoreActivity.TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerHotListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot_list, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(MoreActivity.TITLE);
            initToolBar(title);
        }
        mPresenter.getAllData(true);
        initRefreshLayout();
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

    private void initToolBar(String title) {
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_mActivity, MainActivity.class);
                launchActivity(intent);
            }
        });
    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeColors(ArmsUtils.getColor(_mActivity, R.color.black));
        mRefreshLayout.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.getAllData(true);
            }
        });
    }

    @Override
    public void setAdapter(MoreHotAdapter moreHotAdapter) {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 添加自定义分割线
        if (divider == null) {
            // 只添加一次
            divider = new RecycleViewDivider(_mActivity, LinearLayoutManager.HORIZONTAL);
            mRecycleView.addItemDecoration(divider);
        }
        mRecycleView.setAdapter(moreHotAdapter);
    }
}
