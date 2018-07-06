/*
Navicat MySQL Data Transfer

Source Server         : 测试环境
Source Server Version : 50628
Source Host           : 192.168.91.105:3306
Source Database       : dev_cc_log

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-07-06 18:14:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_action_define
-- ----------------------------
DROP TABLE IF EXISTS `log_action_define`;
CREATE TABLE `log_action_define` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `desc_tmpl` varchar(1000) DEFAULT NULL COMMENT '描述模板',
  `remarks` varchar(1000) DEFAULT NULL COMMENT '备注',
  `system` varchar(100) DEFAULT NULL COMMENT '系统',
  `module` varchar(100) DEFAULT NULL COMMENT '模块',
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `is_deleted` char(1) DEFAULT 'N' COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for log_action_record
-- ----------------------------
DROP TABLE IF EXISTS `log_action_record`;
CREATE TABLE `log_action_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `action_id` int(11) NOT NULL,
  `user_park_id` varchar(100) DEFAULT NULL,
  `user_org_id` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_client` varchar(100) DEFAULT NULL,
  `user_ip` varchar(30) DEFAULT NULL,
  `log_content` varchar(1000) DEFAULT NULL,
  `log_year` char(4) NOT NULL,
  `log_month` char(2) NOT NULL,
  `log_day` char(2) NOT NULL,
  `log_time` char(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
