package com.hosuke.entity;


public class PostRating extends Rating {

    private Long Id;

    private Post post;

    public PostRating(User user, short value, Post post) {
        super(user, value);
        this.post = post;
    }

    public PostRating() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
