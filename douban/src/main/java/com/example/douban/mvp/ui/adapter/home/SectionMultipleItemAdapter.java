package com.example.douban.mvp.ui.adapter.home;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.example.douban.app.data.entity.home.SectionMultipleItem;
import com.example.douban.mvp.ui.adapter.provider.ComingMovieProvider;
import com.example.douban.mvp.ui.adapter.provider.HeadProvider;
import com.example.douban.mvp.ui.adapter.provider.HotMovieProvider;
import com.example.douban.mvp.ui.adapter.provider.MovieListProvider;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionMultipleItemAdapter extends MultipleItemRvAdapter<SectionMultipleItem, BaseViewHolder> {

    public static final int TYPE_HOT = 100;
    public static final int TYPE_COMING = 200;
    public static final int TYPE_MOVIE_LIST = 300;
    public static final int TYPE_HEAD = 400;

    public SectionMultipleItemAdapter(@Nullable List<SectionMultipleItem> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(SectionMultipleItem entity) {
        if (entity.getItemType() == SectionMultipleItem.HOT_ITEM) {
            return TYPE_HOT;
        } else if (entity.getItemType() == SectionMultipleItem.COMING_ITEM) {
            return TYPE_COMING;
        } else if (entity.getItemType() == SectionMultipleItem.HEAD_ITEM) {
            return TYPE_HEAD;
        } else if (entity.getItemType() == SectionMultipleItem.MOVIE_LIST_ITEM) {
            return TYPE_MOVIE_LIST;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new ComingMovieProvider());
        mProviderDelegate.registerProvider(new HotMovieProvider());
        mProviderDelegate.registerProvider(new MovieListProvider());
        mProviderDelegate.registerProvider(new HeadProvider());
    }
}
