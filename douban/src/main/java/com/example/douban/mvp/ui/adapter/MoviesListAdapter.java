package com.example.douban.mvp.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.MoviesList;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

public class MoviesListAdapter extends BaseQuickAdapter<MoviesList, BaseViewHolder> {

    public MoviesListAdapter(int layoutResId, List<MoviesList> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MoviesList item) {
        helper.setText(R.id.tv_movies_list_title, item.getTitle());
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.movies_img))
                        .url(item.getSubjects().get(0).getSubject().getImages().getLarge())
                        .build());
    }
}
