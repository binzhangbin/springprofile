/*
Navicat MySQL Data Transfer

Source Server         : bin
Source Server Version : 50727
Source Host           : 122.51.29.87:3306
Source Database       : test_spring_profile

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-10-08 16:20:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `bid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `btxt` text COMMENT '日志内容',
  `btitle` tinytext COMMENT '博客标题',
  `uid` int(10) unsigned NOT NULL COMMENT '用户主键id',
  PRIMARY KEY (`bid`),
  KEY `pk_uid` (`uid`),
  CONSTRAINT `pk_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户唯一id',
  `uage` int(10) unsigned DEFAULT NULL COMMENT '用户年龄',
  `ubirthday` date DEFAULT NULL COMMENT '用户生日',
  `uname` varchar(255) DEFAULT NULL COMMENT '用户名',
  `upasswd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `uphoto` varchar(255) DEFAULT NULL COMMENT '用户头像路径',
  `uinfo` text COMMENT '用户个人简介',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
