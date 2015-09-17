-- create db , user and grant
CREATE USER 'garen'@'%' IDENTIFIED BY 'garen';
CREATE DATABASE `garen` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
grant all privileges on `garen`.* to 'garen'@'%' identified by 'garen';

-- table

CREATE TABLE `demo_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_created` varchar(32) DEFAULT '',
  `gmt_modified` varchar(32) DEFAULT '',
  `gmt_creator` varchar(64) DEFAULT '',
  `gmt_modifier` varchar(64) DEFAULT ''
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='demo';