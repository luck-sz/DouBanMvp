package com.example.douban.app.data.entity.tv;

import java.util.List;

public class TvBean {

    private List<SubjectsBean> subjects;

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rate : 8.6
         * cover_x : 838
         * title : 偶然发现的一天
         * url : https://movie.douban.com/subject/33446363/
         * playable : false
         * cover : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2568879190.webp
         * id : 33446363
         * cover_y : 1200
         * is_new : false
         */

        private String rate;
        private int cover_x;
        private String title;
        private String url;
        private boolean playable;
        private String cover;
        private String id;
        private int cover_y;
        private boolean is_new;

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public int getCover_x() {
            return cover_x;
        }

        public void setCover_x(int cover_x) {
            this.cover_x = cover_x;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isPlayable() {
            return playable;
        }

        public void setPlayable(boolean playable) {
            this.playable = playable;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCover_y() {
            return cover_y;
        }

        public void setCover_y(int cover_y) {
            this.cover_y = cover_y;
        }

        public boolean isIs_new() {
            return is_new;
        }

        public void setIs_new(boolean is_new) {
            this.is_new = is_new;
        }
    }
}
