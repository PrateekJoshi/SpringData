use mydb;

create table employee(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

select * from employee;

drop table employee;

create table id_gen(
gen_name varchar(60) PRIMARY KEY,
gen_val int(20)
);

select * from id_gen;