package com.hosuke.mapper;

import com.hosuke.entity.*;
import org.apache.ibatis.annotations.Param;

public interface CommentRatingMapper {

//    @Query("SELECT r FROM CommentRating r WHERE r.comment.id = :commentId AND r.user.id = :userId")
    CommentRating findUserRating(CommentRating commentRating);

    default CommentRating findUserRating(Long commentId, Long userId) {
        CommentRating commentRating = new CommentRating();
        Comment comment = new Comment();
        comment.setId(commentId);
        commentRating.setComment(comment);
        User user = new User();
        user.setId(userId);
        commentRating.setUser(user);
        return this.findUserRating(commentRating);
    }
}
