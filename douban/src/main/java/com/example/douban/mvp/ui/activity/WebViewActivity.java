package com.example.douban.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.douban.app.base.MySupportActivity;
import com.gyf.immersionbar.ImmersionBar;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.douban.di.component.DaggerWebViewComponent;
import com.example.douban.mvp.contract.WebViewContract;
import com.example.douban.mvp.presenter.WebViewPresenter;

import com.example.douban.R;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.LollipopFixedWebView;


import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;

public class WebViewActivity extends MySupportActivity<WebViewPresenter> implements WebViewContract.View {

    public static final String PARAM_TITLE = "title";
    public static final String PARAM_URL = "url";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.web_view_content)
    LinearLayout mWebView;

    private String url;
    private String title;
    private AgentWeb mAgentWeb;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerWebViewComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_web_view; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initStatusBar();
        if (getIntent() != null) {
            title = getIntent().getStringExtra(PARAM_TITLE);
            url = getIntent().getStringExtra(PARAM_URL);
        }
        initToolBar();
        initWebView();
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
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // 初始化状态栏
    private void initStatusBar() {
        ImmersionBar.with(this)
                .transparentStatusBar()
                .statusBarColor(R.color.white)  // 状态栏颜色
                .statusBarDarkFont(true, 0.2f)        // 状态栏字体颜色(黑色)
                .keyboardEnable(true)           // 解决软键盘与底部输入框冲突问题，默认为false
                .fitsSystemWindows(true)
                .init();
    }

    private void initToolBar() {
        if (title != null) {
            toolbar.setTitle(title);
        } else {
            toolbar.setTitle("");
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                killMyself();
            }
        });
    }

    // 初始化WebView
    private void initWebView() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mWebView, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebView(new LollipopFixedWebView(this))
                .createAgentWeb()
                .ready()
                .go(url);
    }
}
