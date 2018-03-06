package com.hosuke.mapper;

import com.hosuke.entity.Comment;

public interface CommentMapper {
    Comment selectById(int id);
}
