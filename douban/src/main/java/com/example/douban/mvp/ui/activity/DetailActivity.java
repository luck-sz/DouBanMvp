package com.example.douban.mvp.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.transition.ArcMotion;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.douban.R;
import com.example.douban.app.base.MySupportActivity;
import com.example.douban.di.component.DaggerDetailComponent;
import com.example.douban.mvp.contract.DetailContract;
import com.example.douban.mvp.presenter.DetailPresenter;
import com.example.douban.mvp.ui.view.CustomChangeBounds;
import com.example.douban.mvp.ui.view.MyNestedScrollView;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/03/2019 11:26
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class DetailActivity extends MySupportActivity<DetailPresenter> implements DetailContract.View {

    @BindView(R.id.img_item_bg)
    ImageView imgItemBg;
    @BindView(R.id.iv_one_photo)
    ImageView ivOnePhoto;
    @BindView(R.id.tv_one_directors)
    TextView tvOneDirectors;
    @BindView(R.id.tv_one_casts)
    TextView tvOneCasts;
    @BindView(R.id.tv_one_genres)
    TextView tvOneGenres;
    @BindView(R.id.tv_one_day)
    TextView tvOneDay;
    @BindView(R.id.tv_one_city)
    TextView tvOneCity;
    @BindView(R.id.ll_one_item)
    LinearLayout llOneItem;
    @BindView(R.id.nsv_scrollview)
    MyNestedScrollView nsvScrollview;
    @BindView(R.id.iv_title_head_bg)
    ImageView ivTitleHeadBg;
    @BindView(R.id.title_tool_bar)
    Toolbar titleToolBar;
    @BindView(R.id.rl_title_head)
    RelativeLayout rlTitleHead;
    // 影片详情页id
    private String id;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_detail; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        if (getIntent() != null && mPresenter != null) {
            id = getIntent().getStringExtra("id");
            mPresenter.getDetail(id);
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

    @Override
    public void setMotion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //定义ArcMotion
            ArcMotion arcMotion = new ArcMotion();
            arcMotion.setMinimumHorizontalAngle(50f);
            arcMotion.setMinimumVerticalAngle(50f);
            //插值器，控制速度
            Interpolator interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in);
            //实例化自定义的ChangeBounds
            CustomChangeBounds changeBounds = new CustomChangeBounds();
            changeBounds.setPathMotion(arcMotion);
            changeBounds.setInterpolator(interpolator);
            // 要添加动画的图片
            changeBounds.addTarget(ivOnePhoto);
            //将切换动画应用到当前的Activity的进入和返回
            getWindow().setSharedElementEnterTransition(changeBounds);
            getWindow().setSharedElementReturnTransition(changeBounds);
        }
    }

    @Override
    public void setTitleBar(String title, String subTitle) {
        setSupportActionBar(titleToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_left);
        }
        titleToolBar.setTitle(title);
        titleToolBar.setSubtitle(subTitle);
        titleToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
