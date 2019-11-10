package com.example.douban.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.MovieListBean;

import java.util.List;

public class SubTitleAdapter extends BaseQuickAdapter<MovieListBean.Movie, BaseViewHolder> {

    public SubTitleAdapter(int layoutResId, List<MovieListBean.Movie> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieListBean.Movie item) {
        helper.setText(R.id.tv_sub_movie_name, item.getRank() + "." + item.getMovie_name());
        helper.setText(R.id.tv_sub_rating, item.getRating() + "");
    }
}
