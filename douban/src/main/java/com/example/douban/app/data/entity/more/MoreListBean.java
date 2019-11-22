package com.example.douban.app.data.entity.more;

import java.util.List;

public class MoreListBean {

    private int rank;
    private String id;             // 电影id
    private String title;       // 电影标题
    private String img;         // 电影图片
    private double rating;     // 电影评分
    private String year;        // 上映日期
    private List<String> types; // 电影类型
    private List<String> actors;// 演员表

    public MoreListBean(int rank, String id, String title, String img, double rating, String year, List<String> types, List<String> actors) {
        this.rank = rank;
        this.id = id;
        this.title = title;
        this.img = img;
        this.rating = rating;
        this.year = year;
        this.types = types;
        this.actors = actors;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }
}
