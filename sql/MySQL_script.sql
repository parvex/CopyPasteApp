create database copypastedb;
use  copypastedb;
 
drop table contact;
drop table users;
drop table pastes;


select * from  users;
select * from pastes;
 

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(45) NOT NULL UNIQUE,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;


CREATE TABLE `pastes` (
  `paste_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `syntax` bool NOT NULL,
  `path` char(100) NOT NULL UNIQUE,
  PRIMARY KEY (`paste_id`),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

