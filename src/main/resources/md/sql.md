```sql

-- 销售人员信息表
create table `salesman_info` (
    `id` varchar(64) not null,
    `username` varchar(64) UNIQUE not null,
    `password` varchar(64) not null,
    `name` varchar(64) not null,
    `phone` varchar(32) UNIQUE not null,
    `identity` int(3) not null comment '身份，0为普通销售，1为销售组长，2为总负责人',
    `belong` varchar(64) comment '所属于上级ID',
    `deleted` int(3) not null comment '身份，0为未删除，1为已删除',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '销售人员信息表';

INSERT INTO `salesman_info` VALUES(uuid(),'hongcj','123456','洪陈金','15067189876',2,null,0, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP())