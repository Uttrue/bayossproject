create table tbl_user(
	cno int not null AUTO_INCREMENT PRIMARY KEY,
	cId varchar(20) not null,
	cPw varchar(100) not null,
	email varchar(100) not null,
	cellphone varchar(20) not null,
	shipname varchar(100),
	address varchar(100),
	regdate date default current_timestamp,
	status char(1) default 'T'
);



