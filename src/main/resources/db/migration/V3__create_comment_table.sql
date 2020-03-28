create table comment
(
    id bigint auto_increment primary key ,
    parent_id bigint not null comment '父类ID',
    type int null comment '父类类型',
    commentator bigint null comment '评论人id',
    gmt_create bigint null comment '创建时间',
    gmt_modified bigint null comment '更新时间',
    like_count bigint default 0 null comment '点赞数',
    content varchar(1024) null comment '评论内容'
);

