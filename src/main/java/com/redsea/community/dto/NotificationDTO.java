package com.redsea.community.dto;

import com.redsea.community.model.User;
import lombok.Data;

@Data
public class NotificationDTO  {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerId;
    private String typeName;
    private Integer type;

}
