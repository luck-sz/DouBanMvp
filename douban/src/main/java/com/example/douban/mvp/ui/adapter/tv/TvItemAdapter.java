package com.example.douban.mvp.ui.adapter.tv;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.MovieListBean;
import com.example.douban.app.data.entity.tv.TvBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class TvItemAdapter extends BaseQuickAdapter<TvBean.SubjectsBean, BaseViewHolder> {

    public TvItemAdapter(int layoutResId, List<TvBean.SubjectsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TvBean.SubjectsBean item) {
        helper.addOnClickListener(R.id.iv_img);
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.iv_img))
                        .url(item.getCover())
                        .build());
        helper.setText(R.id.tv_movie_name, item.getTitle());
        // 评分
        MaterialRatingBar ratingBar = helper.getView(R.id.rating_movie);
        ratingBar.setRating(Float.parseFloat(item.getRate()) / 2);
        helper.setText(R.id.tv_rating, item.getRate());
    }
}
