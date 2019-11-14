package com.example.douban.app.data.entity.home;

import java.util.List;

public class MovieListBean {

    /**
     * 电影榜单的List
     */

    private String title;
    private String img;
    private int size;
    private List<Movie> movies;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public static class Movie {
        private int rank;
        private String movie_name;
        private double rating;

        public Movie(int rank, String movie_name, double rating) {
            this.rank = rank;
            this.movie_name = movie_name;
            this.rating = rating;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getMovie_name() {
            return movie_name;
        }

        public void setMovie_name(String movie_name) {
            this.movie_name = movie_name;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

}
