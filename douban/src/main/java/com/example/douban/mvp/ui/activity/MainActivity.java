package com.example.douban.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.douban.R;
import com.example.douban.app.base.MySupportActivity;
import com.example.douban.di.component.DaggerMainComponent;
import com.example.douban.mvp.contract.MainContract;
import com.example.douban.mvp.presenter.MainPresenter;
import com.example.douban.mvp.ui.fragment.HomeFragment;
import com.gyf.immersionbar.ImmersionBar;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/02/2019 13:28
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MainActivity extends MySupportActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private SupportFragment[] mFragments = new SupportFragment[3];

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initStatusBar();
        initToolBar();
        initFragment();
        showHideFragment(mFragments[0]);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_home_menu, menu);
        return true;
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

    private void initToolBar() {
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.main_home_menu);
    }

    private void initFragment() {
        SupportFragment firstFragment = findFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[0] = HomeFragment.newInstance();
            loadMultipleRootFragment(R.id.frame_content, 0,
                    mFragments[0]
            );
        } else {
            mFragments[0] = firstFragment;
        }
    }

}
