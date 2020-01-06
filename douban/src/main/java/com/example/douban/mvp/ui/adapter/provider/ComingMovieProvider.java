package com.example.douban.mvp.ui.adapter.provider;

import android.content.Intent;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.douban.R;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.activity.DetailActivity;
import com.example.douban.mvp.ui.adapter.home.SectionMultipleItemAdapter;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.vondear.rxtool.RxTimeTool;

import timber.log.Timber;

public class ComingMovieProvider extends BaseItemProvider<SectionMultipleItem, BaseViewHolder> {
    @Override
    public int viewType() {
        return SectionMultipleItemAdapter.TYPE_COMING;
    }

    @Override
    public int layout() {
        return R.layout.item_coming;
    }

    @Override
    public void convert(BaseViewHolder helper, SectionMultipleItem data, int position) {
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext, ImageConfigImpl
                        .builder()
                        .imageView(helper.getView(R.id.iv_img))
                        .url(data.getSubjectsBean().getImages().getLarge())
                        .build());
        // 电影名字
        helper.setText(R.id.tv_movie_name, data.getSubjectsBean().getTitle());
        helper.setText(R.id.tv_wish, data.getSubjectsBean().getCollect_count() + "人想看");
        Timber.d(data.getSubjectsBean().getMainland_pubdate());
        String month = data.getSubjectsBean().getMainland_pubdate().substring(5, 7);
        String day = data.getSubjectsBean().getMainland_pubdate().substring(8);
        helper.setText(R.id.tv_date, month + "月" + day + "日");
    }

    @Override
    public void onClick(BaseViewHolder helper, SectionMultipleItem data, int position) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra("id", data.getSubjectsBean().getId());
        mContext.startActivity(intent);
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, SectionMultipleItem data, int position) {
        Toast.makeText(mContext, "longClick " + position, Toast.LENGTH_SHORT).show();
        return true;
    }
}
