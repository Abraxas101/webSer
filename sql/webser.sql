/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : webser

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-04-09 10:55:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_source
-- ----------------------------
DROP TABLE IF EXISTS `data_source`;
CREATE TABLE `data_source` (
  `datasource_id` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `driverclassname` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `initialsize` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `maxactive` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `validationquery` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `datasource_name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for service_config
-- ----------------------------
DROP TABLE IF EXISTS `service_config`;
CREATE TABLE `service_config` (
  `service_id` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `datasource_id` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `service_name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `service_sql1` text COLLATE utf8mb4_bin DEFAULT NULL,
  `service_sql2` text COLLATE utf8mb4_bin DEFAULT NULL,
  `json_format` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `columns_desc` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
