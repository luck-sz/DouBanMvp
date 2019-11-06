package com.example.douban.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.MultipleItem;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;


public class MovieItemAdapter extends BaseSectionMultiItemQuickAdapter<SectionMultipleItem, MovieItemAdapter.MovieViewHolder> {

    public MovieItemAdapter(int sectionHeadResId, List<SectionMultipleItem> data) {
        super(sectionHeadResId, data);
        addItemType(SectionMultipleItem.HOT_ITEM, R.layout.item_hot);
        addItemType(SectionMultipleItem.COMING_ITEM, R.layout.item_coming);
    }

    @Override
    protected void convertHead(@NonNull MovieViewHolder helper, final SectionMultipleItem item) {
        // deal with header viewHolder
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(@NonNull MovieViewHolder helper, SectionMultipleItem item) {
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
                // 电影名字
                helper.setText(R.id.tv_movie_name, item.getEntriesBean().getTitle());
                // 评分
                helper.ratingBar.setRating(Float.parseFloat(item.getEntriesBean().getRating()) / 2);
                helper.setText(R.id.tv_rating, item.getEntriesBean().getRating());
                break;
            case MultipleItem.COMING_ITEM:
                ArmsUtils.obtainAppComponentFromContext(mContext)
                        .imageLoader()
                        .loadImage(mContext, ImageConfigImpl
                                .builder()
                                .imageView(helper.getView(R.id.iv_img))
                                .url(item.getEntriesBean().getImages().getLarge())
                                .build());
                // 电影名字
                helper.setText(R.id.tv_movie_name, item.getEntriesBean().getTitle());
                helper.setText(R.id.tv_wish, item.getEntriesBean().getWish() + "人想看");
                helper.setText(R.id.tv_date, item.getEntriesBean().getPubdate());
                break;
            default:
                break;
        }
    }

    public class MovieViewHolder extends BaseViewHolder {
        MaterialRatingBar ratingBar;

        public MovieViewHolder(View view) {
            super(view);
            ratingBar = (MaterialRatingBar) itemView.findViewById(R.id.rating_movie);
        }
    }
}
