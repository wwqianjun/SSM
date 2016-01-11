 
 CREATE DATABASE `ssm` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

 use ssm;
 create table role_user(id int primary key,rule_id int,user_id int);
 
 create table role(id int primary key, rights int,url varchar(216));

 create table user(id int primary key,name varchar(20),password varchar(20));
 
 --主键生成策略
 CREATE TABLE sequence (seq_name varchar(50) ,current_value numeric NOT NULL, max_value numeric NOT NULL );
 
mysql> delimiter //
mysql> create function current_seq_value(iv_seq_name varchar(50))  
    -> returns numeric 
    -> begin
    -> declare v_value  numeric;
    -> select current_value into v_value 
    -> from sequence 
    -> where seq_name = iv_seq_name;
    -> return v_value;
    -> end
    -> //
    
    create function next_seq_value(iv_sequence_name varchar(50), allotment int)
    returns numeric
	begin
		update sequence
		set current_value = current_value%max_value+allotment
		where seq_name = iv_sequence_name;
		return current_seq_value(iv_sequence_name)-allotment;	
	end
	
	select 'name' from mysql.proc where db= 'test' and 'type'='function';
	
	
	
	create function current_seq_value(iv_seq_name varchar(50))  
    returns numeric 
     begin
     declare v_value  numeric;
     select current_value into v_value 
     from sequence 
     where seq_name = iv_seq_name;
     return v_value;
     end
     //


CREATE TABLE `product_seckill_total` (
  `id` VARCHAR(15) NOT NULL COMMENT '主键ID',
  `total` int(11) unsigned NOT NULL COMMENT '产品数',
  `product_code` varchar(18) NOT NULL COMMENT '产品编号',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_product_code` (`product_code`) USING BTREE COMMENT 'product_code唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手q送福利';

CREATE TABLE `product_order` (
  `id` VARCHAR(15)  NOT NULL COMMENT '主键ID',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `moblie` varchar(11) NOT NULL COMMENT '手机号',
  `product_code` varchar(18) NOT NULL COMMENT '产品编号',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手q送福利';
