 
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

