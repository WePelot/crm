```sql
-- 管理员信息表
create table `user_admin_info` (
    `id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '管理员信息表';

INSERT INTO `user_admin_info` VALUES('1','admin','123456',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP())

-- 销售人员信息表
create table `saleman_info` (
    `id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
	    `flag` INT(3) not null comment '销售组长，1为是，0为否',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '销售人员信息表';