package com.example.douban.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.douban.R;
import com.example.douban.app.base.MySupportActivity;
import com.example.douban.di.component.DaggerSearchComponent;
import com.example.douban.mvp.contract.SearchContract;
import com.example.douban.mvp.presenter.SearchPresenter;
import com.example.douban.mvp.ui.view.MySearchView;
import com.gyf.immersionbar.ImmersionBar;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.mancj.materialsearchbar.MaterialSearchBar;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/12/2019 15:46
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class SearchActivity extends MySupportActivity<SearchPresenter> implements SearchContract.View {

    @BindView(R.id.searchBar)
    MySearchView searchBar;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSearchComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_search; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initStatusBar();
        mPresenter.setSearchView(searchBar);
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
        finish();
    }

    @Override
    public void initSearchView(MySearchView searchBar) {
        searchBar.enableSearch();
        searchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                Toast.makeText(SearchActivity.this, text, Toast.LENGTH_SHORT).show();
                searchBar.setText("");
            }

            @Override
            public void onButtonClicked(int buttonCode) {
                if (buttonCode == MaterialSearchBar.BUTTON_BACK) {
                    finish();
                }
            }
        });
    }

    private void initStatusBar() {
        ImmersionBar.with(this)
                .transparentStatusBar()
                .statusBarColor(R.color.white)  // 状态栏颜色
                .statusBarDarkFont(true, 0.2f)        // 状态栏字体颜色(黑色)
                .keyboardEnable(true)           // 解决软键盘与底部输入框冲突问题，默认为false
                .fitsSystemWindows(true)
                .init();
    }
}
