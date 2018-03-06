package com.hosuke.entity;


import org.jsoup.select.Evaluator;

public class PostRating extends Rating {

    private Long id;

    private Post post;

    public PostRating(User user, short value, Post post) {
        super(user, value);
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostRating{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                ", value=" + value +
                '}';
    }

    public PostRating() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
