package com.example.douban.mvp.ui.adapter.detail;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;

import java.util.ArrayList;

public class DetailActorListProvider extends BaseItemProvider<DetailMultipleItem, BaseViewHolder> {
    @Override
    public int viewType() {
        return DetailMultipleItemAdapter.TYPE_ACTOR_LIST;
    }

    @Override
    public int layout() {
        return R.layout.item_detail_actor_list;
    }

    @Override
    public void convert(BaseViewHolder helper, DetailMultipleItem data, int position) {
        RecyclerView mRecycleView = helper.getView(R.id.rv_actor_list);
        DetailActorAdapter detailActorAdapter = new DetailActorAdapter(R.layout.item_detail_actor_item, data.getBean().getCasts());
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mRecycleView.setAdapter(detailActorAdapter);
    }

}
