package com.example.douban.app.data.entity.home;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import com.example.douban.app.data.entity.DoubanBean;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionMultipleItem extends SectionMultiEntity<Object> implements MultiItemEntity {

    public static final int HOT_ITEM = 1;
    public static final int COMING_ITEM = 2;

    private int itemType;
    private boolean isMore;
    private String header;
    private DoubanBean.EntriesBean entriesBean;

    public SectionMultipleItem(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
        this.header = header;
    }

    public SectionMultipleItem(int itemType, DoubanBean.EntriesBean entriesBean) {
        super(entriesBean);
        this.entriesBean = entriesBean;
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

    public DoubanBean.EntriesBean getEntriesBean() {
        return entriesBean;
    }

    public void setEntriesBean(DoubanBean.EntriesBean entriesBean) {
        this.entriesBean = entriesBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
