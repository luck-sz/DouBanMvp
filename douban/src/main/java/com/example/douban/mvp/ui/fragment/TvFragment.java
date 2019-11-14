package com.example.douban.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.douban.app.base.MySupportFragment;
import com.example.douban.mvp.contract.TvContract;
import com.example.douban.mvp.ui.adapter.TabAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.douban.di.component.DaggerTvComponent;
import com.example.douban.mvp.presenter.TvPresenter;

import com.example.douban.R;

import java.util.List;

import butterknife.BindView;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/11/2019 10:29
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class TvFragment extends MySupportFragment<TvPresenter> implements TvContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.vp_content)
    ViewPager vp_content;
    @BindView(R.id.tab)
    SlidingTabLayout st_tab;
    View view;

    public static TvFragment newInstance() {
        TvFragment fragment = new TvFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerTvComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_tv, container, false);
        }
        return view;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initToolBar();
        mPresenter.initTab();
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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
        toolbar.setTitle("电视");
        toolbar.inflateMenu(R.menu.main_book_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
    }

    @Override
    public void setTabTitle(List<String> title) {
        TabAdapter adapter = new TabAdapter(getChildFragmentManager());
        for (int i = 0; i < title.size(); i++) {
            Timber.d(title.get(i));
            adapter.addFragment(TvChildFragment.newInstance(title.get(i)), title.get(i));
        }
        vp_content.setAdapter(adapter);
        st_tab.setViewPager(vp_content);
        // 设置tab选项卡的默认选项
        st_tab.setCurrentTab(0);
    }
}
