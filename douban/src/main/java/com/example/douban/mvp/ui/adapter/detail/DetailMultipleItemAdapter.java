package com.example.douban.mvp.ui.adapter.detail;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.example.douban.app.data.entity.detail.DetailMultipleItem;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.adapter.provider.ComingMovieProvider;
import com.example.douban.mvp.ui.adapter.provider.HeadProvider;
import com.example.douban.mvp.ui.adapter.provider.HotMovieProvider;
import com.example.douban.mvp.ui.adapter.provider.MovieListProvider;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class DetailMultipleItemAdapter extends MultipleItemRvAdapter<DetailMultipleItem, BaseViewHolder> {

    public static final int TYPE_HEAD = 100;
    public static final int TYPE_TEXT = 200;
    public static final int TYPE_TAG_LIST = 300;
    public static final int TYPE_ACTOR_LIST = 400;

    public DetailMultipleItemAdapter(@Nullable List<DetailMultipleItem> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(DetailMultipleItem entity) {
        if (entity.getItemType() == DetailMultipleItem.HEAD_ITEM) {
            return TYPE_HEAD;
        } else if (entity.getItemType() == DetailMultipleItem.TEXT_ITEM){
            return TYPE_TEXT;
        }else if (entity.getItemType() == DetailMultipleItem.TAG_LIST_ITEM){
            return TYPE_TAG_LIST;
        }else if (entity.getItemType() == DetailMultipleItem.ACTOR_LIST_ITEM){
            return TYPE_ACTOR_LIST;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new DetailHeadProvider());
        mProviderDelegate.registerProvider(new DetailTagListProvider());
        mProviderDelegate.registerProvider(new DetailSummaryProvider());
    }
}
