DROP DATABASE IF EXISTS kinoxp;
CREATE DATABASE kinoxp;

USE kinoxp;

CREATE TABLE `planner` (
  `planner_id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` varchar(45) DEFAULT NULL,
  `endDate` varchar(45) DEFAULT NULL,
  `start_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`planner_id`)
);

CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `duration` int(11) NOT NULL,
  `price_rank` int(11) NOT NULL,
  `actors` varchar(150) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `poster` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
);

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
);

