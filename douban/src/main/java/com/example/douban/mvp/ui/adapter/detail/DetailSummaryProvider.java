package com.example.douban.mvp.ui.adapter.detail;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;
import com.example.douban.mvp.ui.view.ExpandableTextView;

import timber.log.Timber;

public class DetailSummaryProvider extends BaseItemProvider<DetailMultipleItem, BaseViewHolder> {
    @Override
    public int viewType() {
        return DetailMultipleItemAdapter.TYPE_TEXT;
    }

    @Override
    public int layout() {
        return R.layout.item_detail_summary;
    }

    @Override
    public void convert(BaseViewHolder helper, DetailMultipleItem data, int position) {
        ExpandableTextView summary = helper.getView(R.id.etv_summary);
        summary.setText(data.getBean().getSummary());
    }
}
