create database auction_system;
use auction_system;


CREATE TABLE IF NOT EXISTS `User` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(100) UNIQUE,
	`user_name` VARCHAR(20),
	`first_name` VARCHAR(100),
	`last_name` VARCHAR(100),
	`password` VARCHAR(20),
    `communication` VARCHAR(200),
	PRIMARY KEY (`id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

insert into User(`email`, `user_name`, `first_name`, `last_name`, `password`) values ('vanthuyphan@gmail.com', 'vanthuyphan', 'van', 'phan', '123456');
insert into User(`email`, `user_name`, `first_name`, `last_name`, `password`) values ('bati@gmail.com', 'bati', 'bati', 'bati', '123456');
insert into User(`email`, `user_name`, `first_name`, `last_name`, `password`) values ('lukman@gmail.com', 'lukman', 'lukman', 'lukmna', '123456');


CREATE TABLE IF NOT EXISTS `Category` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100),
	`desc` VARCHAR(200),
	PRIMARY KEY (`id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

insert into category(name , `desc`) values('category 1' , ' here is the description');


CREATE TABLE IF NOT EXISTS `Product` (

    `id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100),
	`desc` VARCHAR(200),
    `catid` BIGINT,
	`user` VARCHAR(200) comment 'id of the user who offered the best bid',
    `bid_price` int,
    `status` int default 0,
	PRIMARY KEY (`id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

insert into Product(`name` , `desc` , `catid` , `bid_price`) values('product 1' , 'wda wd a desc ' ,2, 220);
select * from product;