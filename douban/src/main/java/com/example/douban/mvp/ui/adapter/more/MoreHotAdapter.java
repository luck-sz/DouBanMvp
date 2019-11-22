package com.example.douban.mvp.ui.adapter.more;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.app.data.entity.tv.TvBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * 更多正在热映电影
 */
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
        // 电影名
        helper.setText(R.id.tv_movie_title, item.getTitle());
        // 评分
        MaterialRatingBar ratingBar = helper.getView(R.id.rating_movie);
        ratingBar.setRating((float) (item.getRating().getAverage() / 2));
        helper.setText(R.id.tv_rating, item.getRating().getAverage() + "");
        // 电影介绍
        StringBuffer sbType = new StringBuffer();
        for (String type : item.getGenres()) {
            sbType.append(type + " ");
        }
        StringBuffer sbActor = new StringBuffer();
        for (int i = 0; i < item.getCasts().size(); i++) {
            sbActor.append(item.getCasts().get(i).getName() + " / ");
        }
        helper.setText(R.id.tv_year_actor, item.getYear() + " / " + sbType + "/ " + sbActor);
    }
}
