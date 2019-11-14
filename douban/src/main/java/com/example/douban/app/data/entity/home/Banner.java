package com.example.douban.app.data.entity.home;

public class Banner {

    /**
     * 首页Banner
     */

    private String img;
    private String title;
    private String content;
    private String detail;

    public Banner(String img) {
        this.img = img;
    }

    public Banner(String img, String title, String content, String detail) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.detail = detail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
