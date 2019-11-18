package com.example.douban.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.douban.app.base.MySupportActivity;
import com.example.douban.mvp.ui.fragment.ComingFragment;
import com.example.douban.mvp.ui.fragment.HotListFragment;
import com.gyf.immersionbar.ImmersionBar;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.douban.di.component.DaggerMoreComponent;
import com.example.douban.mvp.contract.MoreContract;
import com.example.douban.mvp.presenter.MorePresenter;

import com.example.douban.R;


import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 15:14
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MoreActivity extends MySupportActivity<MorePresenter> implements MoreContract.View {

    public static final String TITLE = "title";
    private String title;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMoreComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_more; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initStatusBar();
        if (getIntent() != null) {
            Intent intent = getIntent();
            title = intent.getStringExtra(TITLE);
            loadFragment(title);
        }
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

    private void initStatusBar() {
        ImmersionBar.with(this)
                .transparentStatusBar()
                .statusBarColor(R.color.white)  // 状态栏颜色
                .statusBarDarkFont(true)        // 状态栏字体颜色(黑色)
                .fitsSystemWindows(true)
                .keyboardEnable(true)           // 解决软键盘与底部输入框冲突问题，默认为false
                .init();
    }

    private void loadFragment(String title) {
        switch (title) {
            case "影院热映":
                if (findFragment(HotListFragment.class) == null) {
                    loadRootFragment(R.id.frame_content, HotListFragment.newInstance(title));  // 加载根Fragment
                }
                break;
            case "即将上映":
                if (findFragment(ComingFragment.class) == null) {
                    loadRootFragment(R.id.frame_content, ComingFragment.newInstance(title));  // 加载根Fragment
                }
                break;
            default:
                break;
        }
    }
}
