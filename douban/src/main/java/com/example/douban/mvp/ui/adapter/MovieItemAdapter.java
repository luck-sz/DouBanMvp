package com.example.douban.mvp.ui.adapter;

import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.MultipleItem;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;


public class MovieItemAdapter extends BaseSectionMultiItemQuickAdapter<SectionMultipleItem, BaseViewHolder> {

    public MovieItemAdapter(int sectionHeadResId, List<SectionMultipleItem> data) {
        super(sectionHeadResId, data);
        addItemType(SectionMultipleItem.HOT_ITEM, R.layout.item_hot);
        addItemType(SectionMultipleItem.COMING_ITEM, R.layout.item_coming);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final SectionMultipleItem item) {
        // deal with header viewHolder
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SectionMultipleItem item) {
        // deal with multiple type items viewHolder

        switch (helper.getItemViewType()) {
            case MultipleItem.HOT_ITEM:
                ArmsUtils.obtainAppComponentFromContext(mContext)
                        .imageLoader()
                        .loadImage(mContext, ImageConfigImpl
                                .builder()
                                .imageView(helper.getView(R.id.iv_img))
                                .url(item.getEntriesBean().getImages().getLarge())
                                .build());
                helper.setText(R.id.tv_movie_name, item.getEntriesBean().getTitle());
                break;
            case MultipleItem.COMING_ITEM:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
            default:
                break;
        }
    }
}
