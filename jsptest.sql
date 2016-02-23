/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : jsptest

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2016-02-23 18:35:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `salt` char(10) NOT NULL,
  `passwd` varchar(32) NOT NULL,
  `create_at` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  KEY `create_at` (`create_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for users_info
-- ----------------------------
DROP TABLE IF EXISTS `users_info`;
CREATE TABLE `users_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `truename` varchar(10) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `users_users_info_id` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_info
-- ----------------------------

-- ----------------------------
-- Table structure for users_log
-- ----------------------------
DROP TABLE IF EXISTS `users_log`;
CREATE TABLE `users_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `type` varchar(15) NOT NULL,
  `value` varchar(500) DEFAULT NULL,
  `create_at` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users_log_user_id` (`user_id`),
  KEY `type` (`type`),
  CONSTRAINT `users_log_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_log
-- ----------------------------
