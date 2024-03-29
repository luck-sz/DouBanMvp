package com.example.douban.mvp.ui.adapter.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.MovieListBean;
import com.example.douban.mvp.ui.activity.MoreActivity;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

public class MoviesListAdapter extends BaseQuickAdapter<MovieListBean, BaseViewHolder> {

    public MoviesListAdapter(int layoutResId, List<MovieListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MovieListBean item) {
        helper.addOnClickListener(R.id.ll_movie_list);
        helper.setText(R.id.tv_movies_list_title, item.getTitle());
        helper.setText(R.id.tv_movie_tip, "每周五更新·共" + item.getSize() + "部");

        RecyclerView mRecycleView = helper.getView(R.id.rv_sub_movie);
        SubTitleAdapter subTitleAdapter = new SubTitleAdapter(R.layout.item_sub_title, item.getMovies());
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecycleView.setNestedScrollingEnabled(false);//禁止滑动
        subTitleAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, MoreActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(MoreActivity.TITLE, item.getTitle());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        mRecycleView.setAdapter(subTitleAdapter);
//        ArmsUtils.obtainAppComponentFromContext(mContext)
//                .imageLoader()
//                .loadImage(mContext, ImageConfigImpl
//                        .builder()
//                        .transformation()
//                        .imageView(helper.getView(R.id.movies_img))
//                        .url(item.getImg())
//                        .build());
        Glide.with(mContext).load(item.getImg())
                .apply(RequestOptions.bitmapTransform(new VignetteFilterTransformation())).into((ImageView) helper.getView(R.id.movies_img));
    }
}
