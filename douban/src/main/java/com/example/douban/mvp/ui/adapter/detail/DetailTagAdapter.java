package com.example.douban.mvp.ui.adapter.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.MovieListBean;
import com.example.douban.mvp.ui.activity.MoreActivity;
import com.example.douban.mvp.ui.adapter.home.SubTitleAdapter;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

public class DetailTagAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DetailTagAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String tag) {
        helper.setText(R.id.tv_tag, tag);
    }
}
