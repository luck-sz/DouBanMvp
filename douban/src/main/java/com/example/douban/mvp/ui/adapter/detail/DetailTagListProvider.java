package com.example.douban.mvp.ui.adapter.detail;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;

public class DetailTagListProvider extends BaseItemProvider<DetailMultipleItem, BaseViewHolder> {
    @Override
    public int viewType() {
        return DetailMultipleItemAdapter.TYPE_TAG_LIST;
    }

    @Override
    public int layout() {
        return R.layout.item_detail_tag_list;
    }

    @Override
    public void convert(BaseViewHolder helper, DetailMultipleItem data, int position) {
        RecyclerView mRecycleView = helper.getView(R.id.rv_tag_list);
        DetailTagAdapter detailTagAdapter = new DetailTagAdapter(R.layout.item_detail_tag_item, data.getBean().getGenres());
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRecycleView.setAdapter(detailTagAdapter);
    }

}
