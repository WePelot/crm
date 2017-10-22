```sql

-- 销售人员信息表
create table `salesman_info` (
    `id` varchar(64) not null,
    `username` varchar(64) UNIQUE not null,
    `password` varchar(64) not null,
    `name` varchar(64) not null,
    `phone` varchar(32) not null,
    `identity` int(3) not null comment '身份，0为普通销售，1为销售组长，2为总负责人',
    `belong` varchar(64) comment '所属于上级ID',
    `macaddr` VARCHAR(64) comment 'mac地址，总负责人时填写',
    `deleted` int(3) not null default 0  comment '是否删除，0为未删除，1为已删除',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '销售人员信息表';

--无macaddr地址时的sql
INSERT INTO `salesman_info` VALUES(uuid(),'admin','crm889988','总监','15067189876',2,null,0, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
--有mac地址时的sql
INSERT INTO `salesman_info` VALUES(uuid(),'admin','crm889988','总监','15067189876',2,,''null,0, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
-- 客户信息表
create table `customer_info` (
    `id` varchar(64) not null,
    `salesmanid` varchar(64) not null comment '所属销售',
    `receptiontime` timestamp not null comment '接待时间',
    `company` varchar(64) comment '代理公司',
		`name`  varchar(64) not null comment '姓名',
    `phone` varchar(32)  not null comment '客户电话',
		`sex` int(3) not null comment '性别，1为男，2为女',
		`agerange` varchar(32) comment '年龄区间',
		`family_structure` varchar(32) comment '家庭结构',
		`residential_region` varchar(32) comment '居住区域',
		`residential_district` varchar(32) comment '居住小区',
		`workingarea` varchar(32) comment '工作区域',
		`msgaccess` varchar(32) comment '获知渠道',
		`company_type` varchar(32) comment '单位分类',
		`job` varchar(32) comment '职务',
		`preferred_product` varchar(32) comment '首选产品',
		`preferred_area` varchar(32) comment '首选面积',
		`psychological_unit_price` varchar(32) comment '意向单价',
		`psychological_total_price` varchar(32) comment '意向总价',
		`reason` varchar(32) comment '购房动机',
		`payway` varchar(32) comment '付款方式',
		`trip_tools` varchar(32) comment '出行工具',
		`key_factor` varchar(32) comment '关键因素',
		`asking_time` varchar(32) comment '置业次数',
		`loan_time` varchar(32) comment '贷款次数',
		`willingness` varchar(32) comment '客户意愿',
		`desc` varchar(300) comment '客户描述',
    `deleted` int(3) not null default 0  comment '是否删除，0为未删除，1为已删除',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '客户信息表';


-- 客户追踪信息
create table `customer_track_info` (
    `id` varchar(64) not null,
    `customer_info_id` varchar(64) comment '客户信息ID' not null,
    `desc` varchar(300) not null comment '具体事项',
    `deleted` int(3) not null default 0  comment '是否删除，0为未删除，1为已删除',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '客户信息追踪表';
