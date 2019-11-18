package com.example.douban.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.app.data.entity.tv.TvBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class MoreHotAdapter extends BaseQuickAdapter<DoubanBean.SubjectsBean, BaseViewHolder> {

    public MoreHotAdapter(int layoutResId, List<DoubanBean.SubjectsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DoubanBean.SubjectsBean item) {
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.iv_img))
                        .url(item.getImages().getLarge())
                        .build());
        helper.setText(R.id.tv_movie_title, item.getTitle());
        // 评分
//        MaterialRatingBar ratingBar = helper.getView(R.id.rating_movie);
//        ratingBar.setRating(Float.parseFloat(item.getRate()) / 2);
//        helper.setText(R.id.tv_rating, item.getRate());
    }
}
