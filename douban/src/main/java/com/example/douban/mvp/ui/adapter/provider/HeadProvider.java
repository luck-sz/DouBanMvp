package com.example.douban.mvp.ui.adapter.provider;

import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.adapter.SectionMultipleItemAdapter;

public class HeadProvider extends BaseItemProvider<SectionMultipleItem, BaseViewHolder> {
    @Override
    public int viewType() {
        return SectionMultipleItemAdapter.TYPE_HEAD;
    }

    @Override
    public int layout() {
        return R.layout.section_head;
    }

    @Override
    public void convert(BaseViewHolder helper, SectionMultipleItem data, int position) {
        helper.setText(R.id.header, data.getHeader());
        helper.setVisible(R.id.more, data.isMore());
        helper.addOnClickListener(R.id.more);
    }

}
