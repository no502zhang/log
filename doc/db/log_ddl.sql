/*
Navicat MySQL Data Transfer

Source Server         : 华为云
Source Server Version : 50639
Source Host           : 192.168.95.58:38635
Source Database       : cofco_pre_cc_log

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-07-12 19:36:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_action_define
-- ----------------------------
DROP TABLE IF EXISTS `log_action_define`;
CREATE TABLE `log_action_define` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `park_id` varchar(32) DEFAULT NULL COMMENT '所属园区',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `desc_tmpl` varchar(1000) DEFAULT NULL COMMENT '描述模板',
  `remarks` varchar(1000) DEFAULT NULL COMMENT '备注',
  `system` varchar(100) DEFAULT NULL COMMENT '系统',
  `module` varchar(100) DEFAULT NULL COMMENT '模块',
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`park_id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行为定义';

-- ----------------------------
-- Table structure for log_action_record
-- ----------------------------
DROP TABLE IF EXISTS `log_action_record`;
CREATE TABLE `log_action_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `park_id` varchar(32) NOT NULL COMMENT '所属园区',
  `action_id` int(11) NOT NULL COMMENT '行为ID',
  `source_id` varchar(32) DEFAULT NULL COMMENT '行为来源对象ID',
  `user_park_id` varchar(100) DEFAULT NULL COMMENT '用户园区ID',
  `user_org_id` varchar(100) DEFAULT NULL COMMENT '用户机构ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `user_client` varchar(100) DEFAULT NULL COMMENT '用户使用的客户端',
  `user_ip` varchar(30) DEFAULT NULL COMMENT '用户IP',
  `log_content` varchar(1000) DEFAULT NULL COMMENT '日志内容',
  `log_year` char(4) NOT NULL COMMENT '记录年',
  `log_month` char(2) NOT NULL COMMENT '记录月',
  `log_day` char(2) NOT NULL COMMENT '记录日',
  `log_time` char(6) NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`),
  KEY `idx_park_action_source` (`park_id`,`action_id`,`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行为记录';
