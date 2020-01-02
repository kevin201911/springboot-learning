/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : config

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 02/01/2020 14:05:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_server
-- ----------------------------
DROP TABLE IF EXISTS `config_server`;
CREATE TABLE `config_server` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `akey` varchar(30) DEFAULT NULL,
  `avalue` varchar(128) DEFAULT NULL,
  `application` varchar(30) DEFAULT NULL,
  `aprofile` varchar(30) DEFAULT NULL,
  `label` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of config_server
-- ----------------------------
BEGIN;
INSERT INTO `config_server` VALUES (2, 'name_server', '192.168.1.6:9876', 'product-service', 'dev', 'dev');
INSERT INTO `config_server` VALUES (3, 'name_server', '192.168.1.6:9876', 'order-service', 'dev', 'dev');
INSERT INTO `config_server` VALUES (4, 'order_topic', 'order_topic', 'order-service', 'dev', 'dev');
INSERT INTO `config_server` VALUES (5, 'order_topic', 'order_topic', 'product-service', 'dev', 'dev');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
