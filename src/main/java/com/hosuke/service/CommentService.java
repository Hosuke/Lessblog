package com.hosuke.service;


import com.hosuke.entity.Comment;
import com.hosuke.entity.Post;

public interface CommentService {

    Comment getComment(Long id);

    Long saveNewComment(Comment comment, Post post, Long parentId);

    void deleteComment(Long commentId) throws Exception; //ActionExpiredException;

    void updateComment(Comment newCommentData, Long commentId) throws Exception; //ActionExpiredException;

    void vote(Long commentId, boolean like) throws Exception; //AlreadyVotedException, ForbiddenException;
}
