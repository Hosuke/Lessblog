package com.hosuke.service;


import com.hosuke.controller.exception.ForbiddenException;
import com.hosuke.entity.Comment;
import com.hosuke.entity.Post;
import com.hosuke.service.Exception.ActionExpiredException;
import com.hosuke.service.Exception.AlreadyVotedException;

public interface CommentService {

    Comment getComment(Long id);

    Long saveNewComment(Comment comment, Post post, Long parentId);

    void deleteComment(Long commentId) throws ActionExpiredException;

    void updateComment(Comment newCommentData, Long commentId) throws ActionExpiredException;

    void vote(Long commentId, boolean like) throws AlreadyVotedException, ForbiddenException;
}
