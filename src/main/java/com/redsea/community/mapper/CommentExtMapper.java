package com.redsea.community.mapper;

import com.redsea.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}