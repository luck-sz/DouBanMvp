package com.example.douban.app.eventbus;

public class Sort {

    private boolean isSort;

    public Sort(boolean isSort) {
        this.isSort = isSort;
    }

    public boolean isSort() {
        return isSort;
    }

    public void setSort(boolean sort) {
        isSort = sort;
    }
}
