package com.redsea.community.dto;

import com.redsea.community.model.User;
import lombok.Data;

@Data
public class CommentCreateDTO {
    private Long id;
    private Long parentId;
    private String content;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private User user;
}
