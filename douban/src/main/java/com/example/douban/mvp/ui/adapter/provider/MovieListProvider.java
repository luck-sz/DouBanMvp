package com.example.douban.mvp.ui.adapter.provider;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.adapter.MoviesListAdapter;
import com.example.douban.mvp.ui.adapter.SectionMultipleItemAdapter;

import timber.log.Timber;

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
        helper.addOnClickListener(R.id.card_view);
        RecyclerView mRecycleView = helper.getView(R.id.rv_movie_list);
        MoviesListAdapter moviesListAdapter = new MoviesListAdapter(R.layout.item_movie_child_list, data.getList());
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRecycleView.setAdapter(moviesListAdapter);
        moviesListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                // 电影榜单Item点击事件
                Toast.makeText(mContext,data.getList().get(position).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
