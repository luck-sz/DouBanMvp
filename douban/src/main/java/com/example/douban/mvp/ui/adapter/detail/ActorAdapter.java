package com.example.douban.mvp.ui.adapter.detail;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.detail.DetailBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActorAdapter extends BaseQuickAdapter<DetailBean.CastsBean, BaseViewHolder> {

    private String url = "http://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png";

    public ActorAdapter(int layoutResId, List<DetailBean.CastsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DetailBean.CastsBean castsBean) {

        if (castsBean.getAvatars() != null) {
            // 头像地址
            url = castsBean.getAvatars().getLarge();
        }

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
