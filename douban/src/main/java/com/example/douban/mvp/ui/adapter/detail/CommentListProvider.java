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
import com.example.douban.app.utils.RecycleViewDivider;
import com.example.douban.mvp.ui.activity.PlayerActivity;

import java.io.Serializable;

public class CommentListProvider extends BaseItemProvider<DetailMultipleItem, BaseViewHolder> {

    CommentAdapter commentAdapter;

    @Override
    public int viewType() {
        return DetailMultipleItemAdapter.TYPE_COMMENT_LIST;
    }

    @Override
    public int layout() {
        return R.layout.item_detail_comment_list;
    }

    @Override
    public void convert(BaseViewHolder helper, DetailMultipleItem data, int position) {
        RecyclerView mRecycleView = helper.getView(R.id.rv_comment_list);
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
        if (commentAdapter == null) {
            commentAdapter = new CommentAdapter(R.layout.item_detail_conment_item, data.getBean().getPopular_comments());
        }
        mRecycleView.setAdapter(commentAdapter);
    }
}
