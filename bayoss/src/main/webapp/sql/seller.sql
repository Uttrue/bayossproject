create table tbl_sell_member(
	sno int not null AUTO_INCREMENT PRIMARY KEY,
	sId varchar(20) not null,
	sPw varchar(100) not null,
	email varchar(100) not null,
	cellphone varchar(20) not null,
	regdate date default current_timestamp,
	status char(1) default 'T'
);

create table tbl_sell_store(
	seller_reg_no int not null AUTO_INCREMENT PRIMARY KEY,
	sId varchar(20),
	sell_store_name varchar(100) not null,
	sell_store_ceo varchar(20) not null,
	sell_store_regnum int not null,
	sell_store_opendate int not null,
	sell_store_phone int not null,
	sell_store_fax int,
	sell_store_status char(1) default 'F',
	sell_store_regdate date default current_timestamp,
	reglocation varchar(45) not null
);

create table tbl_sell_item(
	ino int not null AUTO_INCREMENT PRIMARY KEY,
	sId varchar(20) not null,
	item_title varchar(100) not null,
	item_cost int not null,
	item_start_date date,
	item_end_date date,
	mainimage varchar(100) not null,
	item_content varchar(1000) not null,
	sell_store_status char(1) default 'T',
	item_amount  int,
	sell_store_name varchar(100) not null,
	item_delete char(1) default 'F',
	reglocation varchar(45) not null
	
);

