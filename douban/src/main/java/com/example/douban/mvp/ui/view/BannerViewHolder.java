package com.example.douban.mvp.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.Banner;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

public class BannerViewHolder implements MZViewHolder<Banner> {
    ImageView mImageView;
    TextView mTitle;
    TextView mContext;

    @Override
    public View createView(Context context) {
        // 返回页面布局
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
        mImageView = (ImageView) view.findViewById(R.id.banner_image);
        mTitle = (TextView) view.findViewById(R.id.banner_title);
        mContext = (TextView) view.findViewById(R.id.banner_content);
        return view;
    }

    @Override
    public void onBind(Context context, int position, Banner banner) {
        // 数据绑定
        Glide.with(context).load(banner.getImg())
                .apply(RequestOptions.bitmapTransform(new VignetteFilterTransformation())).into(mImageView);
        mTitle.setText(banner.getTitle());
        mContext.setText(banner.getContent());
    }
}
