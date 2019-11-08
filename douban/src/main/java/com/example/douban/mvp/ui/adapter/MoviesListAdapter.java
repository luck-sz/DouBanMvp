package com.example.douban.mvp.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.MovieListBean;
import com.example.douban.app.data.entity.WeeklyBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

public class MoviesListAdapter extends BaseQuickAdapter<MovieListBean, BaseViewHolder> {

    public MoviesListAdapter(int layoutResId, List<MovieListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MovieListBean item) {
        helper.setText(R.id.tv_movies_list_title, item.getTitle());
        helper.setText(R.id.tv_movie_tip, "每周五更新·共" + item.getSize() + "部");
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.movies_img))
                        .url(item.getImg())
                        .build());
    }
}
