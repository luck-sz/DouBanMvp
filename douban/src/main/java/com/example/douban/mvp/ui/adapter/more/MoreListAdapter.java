package com.example.douban.mvp.ui.adapter.more;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.app.data.entity.more.MoreListBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.noober.background.drawable.DrawableCreator;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import timber.log.Timber;

import static com.vondear.rxtool.RxImageTool.dip2px;


/**
 * 更多正在热映电影
 */
public class MoreListAdapter extends BaseQuickAdapter<MoreListBean, BaseViewHolder> {

    public MoreListAdapter(int layoutResId, List<MoreListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MoreListBean item) {
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.iv_img))
                        .url(item.getImg())
                        .build());
        // 电影名
        helper.setText(R.id.tv_movie_title, item.getTitle());
        // 评分
        MaterialRatingBar ratingBar = helper.getView(R.id.rating_movie);
        ratingBar.setRating((float) (item.getRating() / 2));
        helper.setText(R.id.tv_rating, item.getRating() + "");
        // 电影介绍
        StringBuffer sbType = new StringBuffer();
        for (String type : item.getTypes()) {
            sbType.append(type + " ");
        }
        StringBuffer sbActor = new StringBuffer();
        for (int i = 0; i < item.getActors().size(); i++) {
            sbActor.append(item.getActors() + " / ");
        }
        helper.setText(R.id.tv_year_actor, item.getYear() + " / " + sbType + "/ " + sbActor);
        int rank = item.getRank();
        Timber.d("排名" + rank);
        helper.setText(R.id.tv_rank, "No." + rank);
        // 为不同的排名设置不同颜色
        switch (rank) {
            case 1:
                helper.setBackgroundRes(R.id.tv_rank, R.drawable.movie_list_no_1);
                break;
            case 2:
                helper.setBackgroundRes(R.id.tv_rank, R.drawable.movie_list_no_2);
                break;
            case 3:
                helper.setBackgroundRes(R.id.tv_rank, R.drawable.movie_list_no_3);
                break;
            default:
                helper.setBackgroundRes(R.id.tv_rank, R.drawable.movie_list_no_other);
                break;
        }

    }
}
