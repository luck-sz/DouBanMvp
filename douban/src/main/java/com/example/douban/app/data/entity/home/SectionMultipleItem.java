package com.example.douban.app.data.entity.home;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import com.example.douban.app.data.entity.Banner;
import com.example.douban.app.data.entity.DoubanBean;
import com.example.douban.app.data.entity.MovieListBean;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionMultipleItem extends SectionMultiEntity<Object> implements MultiItemEntity {

    public static final int HOT_ITEM = 1;
    public static final int COMING_ITEM = 2;
    public static final int MOVIE_LIST_ITEM = 3;
    public static final int HEAD_ITEM = 4;

    private int itemType;
    private boolean isMore;
    private String header;
    private DoubanBean.SubjectsBean subjectsBean;
    private List<MovieListBean> list;

    public SectionMultipleItem(int itemType, boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.itemType = itemType;
        this.header = header;
        this.isMore = isMore;
    }

    public SectionMultipleItem(int itemType, List<MovieListBean> listBeans) {
        super(listBeans);
        this.list = listBeans;
        this.itemType = itemType;
    }

    public SectionMultipleItem(int itemType, DoubanBean.SubjectsBean subjectsBean) {
        super(subjectsBean);
        this.subjectsBean = subjectsBean;
        this.itemType = itemType;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public List<MovieListBean> getList() {
        return list;
    }

    public void setList(List<MovieListBean> list) {
        this.list = list;
    }

    public DoubanBean.SubjectsBean getSubjectsBean() {
        return subjectsBean;
    }

    public void setSubjectsBean(DoubanBean.SubjectsBean entriesBean) {
        this.subjectsBean = entriesBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
