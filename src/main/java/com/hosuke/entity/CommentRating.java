package com.hosuke.entity;


public class CommentRating extends Rating {

    private Long Id;

    private Comment comment;

    public CommentRating(User user, short value, Comment comment) {
        super(user, value);
        this.comment = comment;
    }

    public CommentRating() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
