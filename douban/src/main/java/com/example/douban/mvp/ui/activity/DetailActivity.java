package com.example.douban.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.transition.ArcMotion;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.douban.R;
import com.example.douban.app.base.MySupportActivity;
import com.example.douban.app.data.entity.detail.DetailBean;
import com.example.douban.app.utils.CommonUtils;
import com.example.douban.app.utils.StatusBarUtil;
import com.example.douban.di.component.DaggerDetailComponent;
import com.example.douban.mvp.contract.DetailContract;
import com.example.douban.mvp.presenter.DetailPresenter;
import com.example.douban.mvp.ui.adapter.detail.DetailMultipleItemAdapter;
import com.example.douban.mvp.ui.view.CustomChangeBounds;
import com.example.douban.mvp.ui.view.MyNestedScrollView;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import timber.log.Timber;

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
    @BindView(R.id.nsv_scrollview)
    MyNestedScrollView nsvScrollview;
    @BindView(R.id.iv_title_head_bg)
    ImageView ivTitleHeadBg;
    @BindView(R.id.title_tool_bar)
    Toolbar titleToolBar;
    @BindView(R.id.tv_detail_title)
    TextView tvDetailTitle;
    @BindView(R.id.tv_detail_sub_title)
    TextView tvDetailSubTitle;
    @BindView(R.id.mrb_detail_rating)
    MaterialRatingBar mrbDetailRating;
    @BindView(R.id.tv_detail_rating)
    TextView tvDetailRating;
    @BindView(R.id.tv_detail_type_and_time)
    TextView tvDetailTypeAndTime;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    // 影片详情页id
    private String id;
    // 这个是高斯图背景的高度
    private int imageBgHeight;
    // 在多大范围内变色
    private int slidingDistance;

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
        titleToolBar.inflateMenu(R.menu.detail_menu);
        titleToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void setPicture(String largeUrl,String mediumUrl) {
        ArmsUtils.obtainAppComponentFromContext(this)
                .imageLoader()
                .loadImage(this, ImageConfigImpl
                        .builder()
                        .imageView(ivOnePhoto)
                        .url(largeUrl)
                        .build());

        // "14":模糊度；"3":图片缩放3倍后再进行模糊
        // 这里是设置详情页背景
        Glide.with(this)
                .load(mediumUrl)
                .placeholder(R.drawable.stackblur_default)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .transform(new BlurTransformation(40, 8))// 设置高斯模糊
                .into(imgItemBg);
    }

    @Override
    public void initSlideShapeTheme(String largeUrl) {
        setImgHeaderBg(largeUrl);

        // toolbar的高度
        int toolbarHeight = titleToolBar.getLayoutParams().height;
        final int headerBgHeight = toolbarHeight + StatusBarUtil.getStatusBarHeight(this);

        // 使背景图向上移动到图片的最低端，保留（titlebar+statusbar）的高度
        ViewGroup.LayoutParams params = ivTitleHeadBg.getLayoutParams();
        ViewGroup.MarginLayoutParams ivTitleHeadBgParams = (ViewGroup.MarginLayoutParams) ivTitleHeadBg.getLayoutParams();
        int marginTop = params.height - headerBgHeight;
        ivTitleHeadBgParams.setMargins(0, -marginTop, 0, 0);

        ivTitleHeadBg.setImageAlpha(0);
        StatusBarUtil.setTranslucentImageHeader(this, 0, titleToolBar);

        // 上移背景图片，使空白状态栏消失(这样下方就空了状态栏的高度)
        if (imgItemBg != null) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) imgItemBg.getLayoutParams();
            layoutParams.setMargins(0, -StatusBarUtil.getStatusBarHeight(this), 0, 0);

            ViewGroup.LayoutParams imgItemBgparams = imgItemBg.getLayoutParams();
            // 获得高斯图背景的高度
            imageBgHeight = imgItemBgparams.height;
        }

        // 变色
        initScrollViewListener();
        initNewSlidingParams();
    }

    @Override
    public void setHeadData(DetailBean detailBean) {
        // 标题
        tvDetailTitle.setText(detailBean.getTitle());
        // 副标题和时间
        tvDetailSubTitle.setText(detailBean.getOriginal_title() + "  (" + detailBean.getYear() + ")");
        // 评分
        mrbDetailRating.setRating((float) (detailBean.getRating().getAverage() / 2));
        tvDetailRating.setText(detailBean.getRating().getAverage() + "");
        // 地区 类型 上映时间
        StringBuffer county = new StringBuffer();
        StringBuffer type = new StringBuffer();
        StringBuffer time = new StringBuffer();
        for (String c : detailBean.getCountries()) {
            county.append(c + " ");
        }
        for (String t : detailBean.getGenres()) {
            type.append(t + " ");
        }
        for (String m : detailBean.getPubdates()) {
            time.append(m + " \n");
        }
        tvDetailTypeAndTime.setText(county + " / " + type + "/ 上映时间:\n" + time);
    }

    @Override
    public void setDetailAdapter(DetailMultipleItemAdapter detailAdapter) {
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(detailAdapter);
    }

    /**
     * 加载titlebar背景
     */
    private void setImgHeaderBg(String imgUrl) {
        if (!TextUtils.isEmpty(imgUrl)) {

            // 高斯模糊背景 原来 参数：12,5  23,4
            Glide.with(this).load(imgUrl)
                    .error(R.drawable.stackblur_default)
                    .transform(new BlurTransformation(40, 8))
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            titleToolBar.setBackgroundColor(Color.TRANSPARENT);
                            ivTitleHeadBg.setImageAlpha(0);
                            ivTitleHeadBg.setVisibility(View.VISIBLE);
                            return false;
                        }
                    }).into(ivTitleHeadBg);
        }
    }

    private void initScrollViewListener() {
        // 为了兼容23以下
        nsvScrollview.setOnMyScrollChangeListener(new MyNestedScrollView.ScrollInterface() {
            @Override
            public void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                scrollChangeHeader(scrollY);
            }
        });
    }

    /**
     * 根据页面滑动距离改变Header方法
     */
    private void scrollChangeHeader(int scrolledY) {
        if (scrolledY < 0) {
            scrolledY = 0;
        }
        float alpha = Math.abs(scrolledY) * 1.0f / (slidingDistance);

        Drawable drawable = ivTitleHeadBg.getDrawable();

        if (drawable == null) {
            return;
        }
        if (scrolledY <= slidingDistance) {
            // title部分的渐变
            drawable.mutate().setAlpha((int) (alpha * 255));
            ivTitleHeadBg.setImageDrawable(drawable);
        } else {
            drawable.mutate().setAlpha(255);
            ivTitleHeadBg.setImageDrawable(drawable);
        }
    }

    private void initNewSlidingParams() {
        int titleBarAndStatusHeight = (int) (CommonUtils.getDimens(this, R.dimen.nav_bar_height) + StatusBarUtil.getStatusBarHeight(this));
        // 减掉后，没到顶部就不透明了
        slidingDistance = imageBgHeight - titleBarAndStatusHeight - (int) (CommonUtils.getDimens(this, R.dimen.nav_bar_height_more));
    }
}
