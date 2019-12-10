package com.example.douban.mvp.ui.adapter.detail;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;

public class DetailVideoListProvider extends BaseItemProvider<DetailMultipleItem, BaseViewHolder> {

    DetailVideoAdapter detailVideoAdapter;

    @Override
    public int viewType() {
        return DetailMultipleItemAdapter.TYPE_VIDEO_LIST;
    }

    @Override
    public int layout() {
        return R.layout.item_detail_video_list;
    }

    @Override
    public void convert(BaseViewHolder helper, DetailMultipleItem data, int position) {
        RecyclerView mRecycleView = helper.getView(R.id.rv_video_list);
        detailVideoAdapter = new DetailVideoAdapter(R.layout.item_detail_video_item, data.getBean().getTrailers());
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRecycleView.setAdapter(detailVideoAdapter);
    }

}
