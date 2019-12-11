package com.example.douban.mvp.ui.adapter.detail;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActorAdapter extends BaseQuickAdapter<DetailBean.CastsBean, BaseViewHolder> {

    public ActorAdapter(int layoutResId, List<DetailBean.CastsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DetailBean.CastsBean castsBean) {
        // 头像地址
        String url = castsBean.getAvatars().getLarge();
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.cv_actor))
                        .url(url)
                        .build());
        // 演员名字
        helper.setText(R.id.tv_actor_name, castsBean.getName());
    }
}
