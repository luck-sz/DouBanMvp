package com.example.douban.mvp.ui.adapter.detail;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;

public class DetailHeadProvider extends BaseItemProvider<DetailMultipleItem, BaseViewHolder> {
    @Override
    public int viewType() {
        return DetailMultipleItemAdapter.TYPE_HEAD;
    }

    @Override
    public int layout() {
        return R.layout.item_detail_content_head;
    }

    @Override
    public void convert(BaseViewHolder helper, DetailMultipleItem data, int position) {
        helper.setText(R.id.tv_detail_content_head, data.getTitle());
    }

}
