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

create table tbl_comment(
	cmno int not null AUTO_INCREMENT PRIMARY KEY,
	cId varchar(20) not null,
	ino int not null,
	sId varchar(20) not null,
	comment varchar(1000) not null,
	item_title varchar(100) not null,
	regdate date default current_timestamp,
	status char(1) default 'T'
);

create table tbl_review(
	rno int not null AUTO_INCREMENT PRIMARY KEY,
	cId varchar(20) not null,
	ino int not null,
	sId varchar(20) not null,
	review varchar(10000) not null,
	item_title varchar(100) not null,
	regdate date default current_timestamp,
	status char(1) default 'T'
);



