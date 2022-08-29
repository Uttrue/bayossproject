create table tbl_homeboard(
	hno int not null AUTO_INCREMENT PRIMARY KEY,
	sId varchar(20),
	main_category varchar(100) not null,
	detail_category varchar(100) not null,
	content varchar(1000) not null,
	regdate date default current_timestamp,
	reglocation varchar(45) not null
);


