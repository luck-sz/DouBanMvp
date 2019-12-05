package com.example.douban.app.data.entity.detail;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import com.example.douban.app.data.entity.home.DoubanBean;
import com.example.douban.app.data.entity.home.MovieListBean;

import java.io.Serializable;
import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class DetailMultipleItem extends SectionMultiEntity<Object> implements MultiItemEntity, Serializable {

    public static final int HEAD_ITEM = 1;
    public static final int TAG_LIST_ITEM = 2;
    public static final int TEXT_ITEM = 3;
    public static final int ACTOR_LIST_ITEM = 3;

    // Item类型
    private int itemType;
    // 头部标题
    private String title;

    // 文字
    private String content;
    // 列表
    private DetailBean bean;

    public DetailMultipleItem(int itemType, DetailBean bean) {
        super(bean);
        this.bean = bean;
        this.itemType = itemType;
    }

    public DetailMultipleItem(int itemType, boolean isHeader, String title) {
        super(isHeader, title);
        this.title = title;
        this.itemType = itemType;
    }

    public DetailMultipleItem(int itemType, String content) {
        super(content);
        this.content = content;
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DetailBean getBean() {
        return bean;
    }

    public void setBean(DetailBean bean) {
        this.bean = bean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
