/*
Navicat MySQL Data Transfer

Source Server         : 香港
Source Server Version : 50722
Source Host           : 119.28.46.184:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-06-03 20:56:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1', 'qq', '2');
INSERT INTO `stu` VALUES ('2', 'mmm', 'mm');

-- ----------------------------
-- Table structure for t_s_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_s_resource`;
CREATE TABLE `t_s_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reid` varchar(45) NOT NULL COMMENT '资源名',
  `name` varchar(45) NOT NULL COMMENT '资源中文名',
  `type` varchar(1) NOT NULL COMMENT '类型',
  `enabled` varchar(1) DEFAULT NULL COMMENT '状态',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(45) DEFAULT NULL COMMENT '修改者',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `pid` int(11) DEFAULT NULL COMMENT '父资源ID',
  `value` varchar(45) DEFAULT NULL COMMENT '资源值',
  `leaf` varchar(1) DEFAULT NULL COMMENT '是否叶子节点',
  PRIMARY KEY (`id`),
  UNIQUE KEY `reid_UNIQUE` (`reid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_resource
-- ----------------------------
INSERT INTO `t_s_resource` VALUES ('1', 'sytem', '系统管理', '0', 'Y', null, null, null, null, null, null, null, 'N');
INSERT INTO `t_s_resource` VALUES ('3', 'user', '用户管理', '0', 'Y', null, null, null, null, null, '1', 'user/render.do', null);
INSERT INTO `t_s_resource` VALUES ('4', 'role', '角色管理', '0', 'Y', null, null, null, null, null, '1', 'role/render.do', null);
INSERT INTO `t_s_resource` VALUES ('5', 'resource', '资源管理', '0', 'Y', null, null, null, null, null, '1', 'resource/render.do', null);
INSERT INTO `t_s_resource` VALUES ('6', '*', '通用权限', '1', 'Y', null, null, null, null, null, null, '*', null);
INSERT INTO `t_s_resource` VALUES ('15', 'monitor', '系统监控', '0', 'Y', null, null, null, null, null, '1', 'druid', null);
INSERT INTO `t_s_resource` VALUES ('99', 'account', '统计管理', '0', 'Y', null, null, null, null, null, '1', 'account/render.do', null);
INSERT INTO `t_s_resource` VALUES ('103', 'dictionary', '进士字典', '1', 'Y', null, null, null, null, null, '105', 'admin/jinShiAdmin.do', null);
INSERT INTO `t_s_resource` VALUES ('105', 'business', '美丽乡村', '0', 'Y', null, null, null, null, null, null, '', 'N');
INSERT INTO `t_s_resource` VALUES ('106', 'liuyan', '游客日记', '1', 'Y', null, null, null, null, null, '105', 'admin/tieZiAdmin.do', null);

-- ----------------------------
-- Table structure for t_s_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role`;
CREATE TABLE `t_s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roid` varchar(45) NOT NULL COMMENT '角色名',
  `name` varchar(45) NOT NULL COMMENT '角色中文名',
  `enabled` varchar(1) DEFAULT NULL COMMENT '状态',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(45) DEFAULT NULL COMMENT '修改者',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `roid_Unique` (`roid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role
-- ----------------------------
INSERT INTO `t_s_role` VALUES ('32', 'admin', '管理员', 'Y', null, null, null, null, null);
INSERT INTO `t_s_role` VALUES ('33', 'user', '普通用户', 'Y', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_s_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role_resource`;
CREATE TABLE `t_s_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ROLE_RESOURCE_ROLE_ID_idx` (`role_id`) USING BTREE,
  KEY `FK_ROLE_RESOURCE_RESOURCE_ID_idx` (`resource_id`) USING BTREE,
  CONSTRAINT `t_s_role_resource_ibfk_1` FOREIGN KEY (`resource_id`) REFERENCES `t_s_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_s_role_resource_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_s_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=796 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role_resource
-- ----------------------------
INSERT INTO `t_s_role_resource` VALUES ('792', '32', '6');
INSERT INTO `t_s_role_resource` VALUES ('793', '33', '106');
INSERT INTO `t_s_role_resource` VALUES ('794', '33', '105');
INSERT INTO `t_s_role_resource` VALUES ('795', '33', '103');

-- ----------------------------
-- Table structure for t_s_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user`;
CREATE TABLE `t_s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) NOT NULL COMMENT '用户名',
  `name` varchar(45) NOT NULL COMMENT '中文名',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `tel` varchar(45) NOT NULL COMMENT '电话',
  `mail` varchar(45) DEFAULT NULL COMMENT '邮件',
  `enabled` varchar(1) DEFAULT NULL COMMENT '状态',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(45) DEFAULT NULL COMMENT '修改者',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `password` varchar(45) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid_UNIQUE` (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_user
-- ----------------------------
INSERT INTO `t_s_user` VALUES ('1', 'test', '管理员', null, '111', null, 'Y', null, null, null, null, '管理员', '123');
INSERT INTO `t_s_user` VALUES ('90', '123123', '123123', null, '123123', null, 'Y', null, null, null, null, '普通用户', '123');
INSERT INTO `t_s_user` VALUES ('91', '123123123', '胡昊', null, '123123123123', null, 'N', null, null, null, null, '普通用户', '4nfdHgVoiiLjd+JaPa5d4Q');
INSERT INTO `t_s_user` VALUES ('93', '123123321', '123123', null, '12323', null, 'Y', null, null, null, null, '普通用户', 'Qpf0SxOVUjUkWySXOZ16kw');
INSERT INTO `t_s_user` VALUES ('94', '123324532423', '123213321', null, '123123', null, 'Y', null, null, null, null, '普通用户', '9bsMjeFGxntEurv05lhMwA');
INSERT INTO `t_s_user` VALUES ('95', '1120023921', '╰轻描淡写、描绘承诺', null, '13000000000', null, 'Y', null, null, null, null, '普通用户', 'Qpf0SxOVUjUkWySXOZ16kw');
INSERT INTO `t_s_user` VALUES ('96', '940300447', '娶个好媳妇不容易', null, '13000000000', null, 'Y', null, null, null, null, '普通用户', 'Qpf0SxOVUjUkWySXOZ16kw');
INSERT INTO `t_s_user` VALUES ('97', '33669974', ':) 你好', null, '12312123123', null, 'Y', null, null, null, null, '普通用户', 'T1Ltv7fRZKl8chk5VOJZJQ');
INSERT INTO `t_s_user` VALUES ('99', '12451245', '请别再说你用心 ゝ', null, '13000000000', null, 'Y', null, null, null, null, '普通用户', 'Qpf0SxOVUjUkWySXOZ16kw');

-- ----------------------------
-- Table structure for t_s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user_role`;
CREATE TABLE `t_s_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_ROLE_USER_ID_idx` (`user_id`) USING BTREE,
  KEY `FK_USER_ROLE_USER_ID_idx1` (`role_id`) USING BTREE,
  CONSTRAINT `t_s_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_s_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_user_role
-- ----------------------------
INSERT INTO `t_s_user_role` VALUES ('103', '1', '20');
INSERT INTO `t_s_user_role` VALUES ('104', '1', '2');
INSERT INTO `t_s_user_role` VALUES ('106', '1', '3');
INSERT INTO `t_s_user_role` VALUES ('120', '1', '32');
INSERT INTO `t_s_user_role` VALUES ('121', '90', '33');
