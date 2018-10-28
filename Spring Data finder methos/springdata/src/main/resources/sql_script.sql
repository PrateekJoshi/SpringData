use mydb;

create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3)
);

select* from product;

insert into product values(1,"IWatch","From Apple",400);

insert into product values(2,"TV","From Sony",1000);

insert into product values(3,"Washer","From LG ",2000);

insert into product values(4,"Dryer","From LG",1500);

drop table product;