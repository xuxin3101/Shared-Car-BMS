/*
Navicat MySQL Data Transfer

Source Server         : yxz.gamewan.top
Source Server Version : 50719
Source Host           : 140.143.31.29:3306
Source Database       : BMS

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-04-16 19:57:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `token` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', 'admin', 'gXBUxWueJDAAQqqcziMEPjGOBpGxkNNO');
INSERT INTO `login` VALUES ('2', 'xuxin', null);

-- ----------------------------
-- Table structure for `tmpmailcode`
-- ----------------------------
DROP TABLE IF EXISTS `tmpmailcode`;
CREATE TABLE `tmpmailcode` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `mailaddress` varchar(25) NOT NULL,
  `code` char(6) NOT NULL,
  `sendtime` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mailaddress` (`mailaddress`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmpmailcode
-- ----------------------------
INSERT INTO `tmpmailcode` VALUES ('1', '310199939@qq.com', 'bykXyl', '2019-04-15 22:23:29');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin@qq.com');
INSERT INTO `user` VALUES ('2', 'xuxin', '123456', '310199939@qq.com');
