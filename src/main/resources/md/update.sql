
--新增mac地址
alter table salesman_info add macaddr VARCHAR(64) comment 'mac地址，总负责人时填写';

--手机号改为NOT NULL-- 索引
ALTER TABLE salesman_info DROP INDEX phone;
ALTER TABLE customer_info DROP INDEX phone;

--将代理公司改为允许null值
ALTER TABLE customer_info MODIFY company varchar(64)comment '代理公司';