package com.example.douban.mvp.ui.adapter.detail;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class CommentAdapter extends BaseQuickAdapter<DetailBean.PopularCommentsBean, BaseViewHolder> {

    public CommentAdapter(int layoutResId, List<DetailBean.PopularCommentsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DetailBean.PopularCommentsBean bean) {
        String url = bean.getAuthor().getAvatar();
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.cv_avatar))
                        .url(url)
                        .build());
        helper.setText(R.id.tv_author, bean.getAuthor().getName());
        helper.setText(R.id.tv_comment, bean.getContent());
        helper.setText(R.id.tv_time, bean.getCreated_at());
        MaterialRatingBar ratingBar = helper.getView(R.id.rating_comment);
        ratingBar.setRating((float) bean.getRating().getValue());
    }
}
