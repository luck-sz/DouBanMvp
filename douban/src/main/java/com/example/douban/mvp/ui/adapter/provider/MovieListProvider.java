package com.example.douban.mvp.ui.adapter.provider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.activity.MoreActivity;
import com.example.douban.mvp.ui.adapter.home.MoviesListAdapter;
import com.example.douban.mvp.ui.adapter.home.SectionMultipleItemAdapter;

/**
 * 电影榜单列表
 */
public class MovieListProvider extends BaseItemProvider<SectionMultipleItem, BaseViewHolder> {
    @Override
    public int viewType() {
        return SectionMultipleItemAdapter.TYPE_MOVIE_LIST;
    }

    @Override
    public int layout() {
        return R.layout.item_movie_list;
    }

    @Override
    public void convert(BaseViewHolder helper, SectionMultipleItem data, int position) {
        helper.addOnClickListener(R.id.ll_movie_list);
        RecyclerView mRecycleView = helper.getView(R.id.rv_movie_list);
        MoviesListAdapter moviesListAdapter = new MoviesListAdapter(R.layout.item_movie_child_list, data.getList());
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRecycleView.setAdapter(moviesListAdapter);
        moviesListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                // 电影榜单Item点击事件
                Intent intent = new Intent(mContext, MoreActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(MoreActivity.TITLE, data.getList().get(position).getTitle());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

}
