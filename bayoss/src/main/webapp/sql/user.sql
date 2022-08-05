create table tbl_user(
	sno int not null AUTO_INCREMENT PRIMARY KEY,
	cId varchar(20) not null,
	cPw varchar(100) not null,
	email varchar(100) not null,
	cellphone varchar(20) not null,
	regdate date default current_timestamp,
	status char(1) default 'T'
);



