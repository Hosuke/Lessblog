package com.hosuke.entity;

import com.hosuke.service.MarkdownConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Comment {

    private Long id;

    private String commentText;

    private Date dateTime;

    private Date modifiedDateTime;

    private User user;

    private Post post;

    private boolean deleted = false;

    // simple (adjacency list) comments hierarchy implementation
    // probably not the most performance efficient choice since it will have additional DB queries for each level in each subtree

    private Comment parentComment;

    private List<Comment> childrenComments = new ArrayList<>();

    private List<CommentRating> commentRatings = new ArrayList<>();

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentText='" + commentText + '\'' +
                ", dateTime=" + dateTime +
                ", modifiedDateTime=" + modifiedDateTime +
                ", user=" + user +
//                ", post=" + post +
                ", deleted=" + deleted +
//                ", parentComment=" + parentComment +
                ", childrenComments=" + childrenComments +
                ", commentRatings=" + commentRatings +
                '}' + "\n";
    }

    public int commentLevel() {
        Comment comment = this;
        int level = 0;
        while ((comment = comment.getParentComment()) != null)
            level++;
        return level;
    }

    public boolean userCanDelete() {
        return LocalDateTime.now().isBefore(maxDeleteTime());
    }

    public LocalDateTime maxDeleteTime() {
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusMinutes(10);
    }

    // should refactor to store dates in UTC in database

    public long maxDeleteTimeUnixTimestamp() {
        return maxDeleteTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public boolean userCanEdit() {
        return LocalDateTime.now().isBefore(maxEditTime());
    }

    public LocalDateTime maxEditTime() {
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusMinutes(180);
    }

    public long maxEditTimeUnixTimestamp() {
        return maxEditTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public int getRatingSum() {
        return commentRatings.stream().mapToInt(Rating::getValue).sum();
    }

    public short getUserVoteValue(Long userId) {
        if (userId == null)
            return 0;

        Optional<CommentRating> rating = commentRatings.stream().filter(r -> r.getUser().getId().equals(userId)).findFirst();
        return rating.isPresent() ? rating.get().getValue() : 0;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getCommentTextHtml() {
        return MarkdownConverter.toHtml(getCommentText());
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getChildrenComments() {
        return childrenComments;
    }

    public void setChildrenComments(List<Comment> childrenComments) {
        this.childrenComments = childrenComments;
    }

    public List<CommentRating> getCommentRatings() {
        return commentRatings;
    }

    public void setCommentRatings(List<CommentRating> commentRatings) {
        this.commentRatings = commentRatings;
    }
}
