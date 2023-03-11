/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : legal-system

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 07/03/2023 18:39:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for download_times
-- ----------------------------
DROP TABLE IF EXISTS `download_times`;
CREATE TABLE `download_times`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `downloads` int(0) NOT NULL,
  `current_dates` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of download_times
-- ----------------------------
INSERT INTO `download_times` VALUES (2, 2, 30, '2023-01-13');
INSERT INTO `download_times` VALUES (4, 1, 30, '2023-01-13');
INSERT INTO `download_times` VALUES (5, 2, 2, '2023-01-14');
INSERT INTO `download_times` VALUES (6, 2, 9, '2023-01-29');
INSERT INTO `download_times` VALUES (7, 2, 1, '2023-02-02');
INSERT INTO `download_times` VALUES (8, 2, 1, '2023-02-04');
INSERT INTO `download_times` VALUES (9, 2, 5, '2023-02-05');
INSERT INTO `download_times` VALUES (10, 1, 1, '2023-02-05');
INSERT INTO `download_times` VALUES (11, 2, 5, '2023-02-18');
INSERT INTO `download_times` VALUES (12, 2, 6, '2023-02-27');
INSERT INTO `download_times` VALUES (13, 2, 1, '2023-02-28');
INSERT INTO `download_times` VALUES (14, 2, 1, '2023-03-01');
INSERT INTO `download_times` VALUES (15, 2, 1, '2023-03-05');

SET FOREIGN_KEY_CHECKS = 1;
