package com.example.douban.mvp.ui.adapter.detail;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

public class DetailVideoAdapter extends BaseQuickAdapter<DetailBean.TrailersBean, BaseViewHolder> {

    public DetailVideoAdapter(int layoutResId, List<DetailBean.TrailersBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DetailBean.TrailersBean trailersBean) {
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.iv_video))
                        .url(trailersBean.getMedium())
                        .build());
    }
}
