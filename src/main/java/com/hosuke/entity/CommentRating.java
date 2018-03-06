package com.hosuke.entity;


public class CommentRating extends Rating {

    private Long id;

    private Comment comment;

    public CommentRating(User user, short value, Comment comment) {
        super(user, value);
        this.comment = comment;
    }

    public CommentRating() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
