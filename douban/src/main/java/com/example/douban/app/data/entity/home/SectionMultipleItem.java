package com.example.douban.app.data.entity.home;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;

import java.io.Serializable;
import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionMultipleItem extends SectionMultiEntity<Object> implements MultiItemEntity, Serializable {

    public static final int HOT_ITEM = 1;
    public static final int COMING_ITEM = 2;
    public static final int MOVIE_LIST_ITEM = 3;
    public static final int HEAD_ITEM = 4;

    // Item类型
    private int itemType;
    // 是否显示更多
    private boolean isMore;
    // 头部标题
    private String sectionHead;
    private DoubanBean.SubjectsBean subjectsBean;
    private List<MovieListBean> list;

    public SectionMultipleItem(int itemType, boolean isHeader, String sectionHead, boolean isMore) {
        super(isHeader, sectionHead);
        this.itemType = itemType;
        this.sectionHead = sectionHead;
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
        return sectionHead;
    }

    public void setHeader(String header) {
        this.sectionHead = header;
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
