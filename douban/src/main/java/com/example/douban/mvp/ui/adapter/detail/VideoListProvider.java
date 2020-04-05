package com.example.douban.mvp.ui.adapter.detail;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;
import com.example.douban.mvp.ui.activity.PlayerActivity;

import java.io.Serializable;

public class VideoListProvider extends BaseItemProvider<DetailMultipleItem, BaseViewHolder> {

    VideoAdapter detailVideoAdapter;

    @Override
    public int viewType() {
        return DetailMultipleItemAdapter.TYPE_VIDEO_LIST;
    }

    @Override
    public int layout() {
        return R.layout.item_detail_list;
    }

    @Override
    public void convert(BaseViewHolder helper, DetailMultipleItem data, int position) {
        RecyclerView mRecycleView = helper.getView(R.id.rv_detail_list);
        detailVideoAdapter = new VideoAdapter(R.layout.item_detail_video_item, data.getBean().getTrailers());
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRecycleView.setAdapter(detailVideoAdapter);
        detailVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, PlayerActivity.class);
                intent.putExtra("PlayBean", data.getBean().getTrailers().get(position));
                mContext.startActivity(intent);
            }
        });
    }
}
