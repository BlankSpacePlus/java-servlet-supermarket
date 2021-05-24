SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `supermarket`;
CREATE DATABASE `supermarket`;
USE `supermarket`;

-- ----------------------------
-- Table structure for superbills
-- ----------------------------
DROP TABLE IF EXISTS `superbills`;
CREATE TABLE `superbills` (
  `billid` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(20) NOT NULL,
  `productdesc` varchar(100) DEFAULT NULL,
  `productcount` varchar(10) NOT NULL,
  `totalprice` decimal(10,1) NOT NULL,
  `ispayment` int(10) NOT NULL,
  `providerid` int(10) NOT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`billid`),
  KEY `to_providor` (`providerid`),
  CONSTRAINT `to_providor` FOREIGN KEY (`providerid`) REFERENCES `superproviders` (`providerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of superbills
-- ----------------------------
INSERT INTO `superbills` VALUES ('1', '恰恰香瓜子', '恰恰香瓜子改改改', '100', '1000.0', '1', '1', 'admin', '2020-06-13');
INSERT INTO `superbills` VALUES ('2', '毛毛虫', '毛毛虫面包', '10', '50.0', '1', '1', 'creator1', '2020-06-03');
INSERT INTO `superbills` VALUES ('3', '奥利奥', '奥利奥饼干', '20', '140.0', '0', '2', 'creator2', '2020-06-04');

-- ----------------------------
-- Table structure for superproviders
-- ----------------------------
DROP TABLE IF EXISTS `superproviders`;
CREATE TABLE `superproviders` (
  `providerid` int(10) NOT NULL AUTO_INCREMENT,
  `providername` varchar(30) NOT NULL,
  `providerdesc` varchar(100) DEFAULT NULL,
  `providertel` varchar(50) DEFAULT NULL,
  `provideraddress` varchar(100) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `createtime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`providerid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of superproviders
-- ----------------------------
INSERT INTO `superproviders` VALUES ('1', 'Tim', 'TimTim', '123456', 'NanJing', 'creator1', '2020-06-03');
INSERT INTO `superproviders` VALUES ('2', 'Bob', 'BobBob', '121212', 'ChongQing', 'creator1', '2020-06-03');
INSERT INTO `superproviders` VALUES ('3', 'Amy', 'AmyAmy', '123123', 'HangZhou', 'creator2', '2020-06-04');

-- ----------------------------
-- Table structure for superusers
-- ----------------------------
DROP TABLE IF EXISTS `superusers`;
CREATE TABLE `superusers` (
  `userid` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `ubirthday` date DEFAULT NULL,
  `role` int(10) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of superusers
-- ----------------------------
INSERT INTO `superusers` VALUES ('admin', 'admin', 'admin', '10000', 'BeiJing', '2000-01-01', '0');
INSERT INTO `superusers` VALUES ('ming', 'ming', 'mingming', '30000', 'ShenZhen', '1995-06-06', '1');
INSERT INTO `superusers` VALUES ('sam', 'sam', 'sam', '20000', 'ShangHai', '1990-02-02', '1');
INSERT INTO `superusers` VALUES ('steve', 'steve', 'steve', '40000', 'HangZhou', '2015-08-10', '0');
