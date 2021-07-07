/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 07/07/2021 23:13:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(12, 2) NULL DEFAULT NULL,
  `author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sales` int NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `img_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, 'Java核心技术', 119.00, 'Cay S. Horstmann', 3, 7, 'static/imgs/bookImgs/JAVA_core_technology.jpg');
INSERT INTO `books` VALUES (2, '数据结构与算法分析', 35.00, 'Mark Allen Weiss', 4, 6, 'static/imgs/bookImgs/Data_structure_and_algorithm_analysis.jpg');
INSERT INTO `books` VALUES (4, 'Java编程思想（第4版）', 108.00, 'Bruce Eckel', 4, 6, 'static/imgs/bookImgs/Thinking_in_Java.jpg');
INSERT INTO `books` VALUES (5, 'JavaScript高级程序设计', 99.00, '尼古拉斯·泽卡斯', 2, 8, 'static/imgs/bookImgs/Professional_JavaScript_fo_Web.jpg');
INSERT INTO `books` VALUES (6, 'JavaScript语言精粹', 35.00, 'Douglas Crockford', 1, 9, 'static/imgs/bookImgs/JavaScript_The_Good_Parts.jpg');
INSERT INTO `books` VALUES (7, 'C语言程序设计：现代方法', 79.00, 'K. N. King', 2, 8, 'static/imgs/bookImgs/C_Programming_A_Modern_Approach.jpg');
INSERT INTO `books` VALUES (8, '高性能JavaScript', 49.00, '尼古拉斯·泽卡斯', 1, 9, 'static/imgs/bookImgs/High_Performance_JavaScript.jpg');
INSERT INTO `books` VALUES (9, 'JavaScript权威指南', 109.00, '弗拉纳根', 1, 9, 'static/imgs/bookImgs/The_Definitive_Guide_to_JavaScript.jpg');
INSERT INTO `books` VALUES (11, '操作系统导论', 119.00, 'Remzi H. Arpaci-Dusseau', 1, 9, 'static/imgs/bookImgs/Operating_Systems_Three_Easy_Pieces.jpg');
INSERT INTO `books` VALUES (12, '数据结构与算法：java语言版', 59.00, '德罗兹德克', 2, 8, 'static/imgs/bookImgs/Data_Structures_and_Algorithms_in_Java.jpg');
INSERT INTO `books` VALUES (13, 'C++ Primer 中文版（第 5 版）', 128.00, 'Stanley B. Lippman', 1, 9, 'static/imgs/bookImgs/C++Primer, 5th_Edition.jpg');
INSERT INTO `books` VALUES (14, 'Python深度学习', 119.00, '弗朗索瓦•肖莱', 1, 9, 'static/imgs/bookImgs/Deep_Learning_with_Python.jpg');
INSERT INTO `books` VALUES (24, 'Python编程 : 从入门到实践', 89.00, '埃里克·马瑟斯', 4, 6, 'static/imgs/bookImgs/Python_Crash_Course.jpg');
INSERT INTO `books` VALUES (25, '算法（第4版）', 99.00, 'Robert Sedgewick', 3, 7, 'static/imgs/bookImgs/Algorithms_4th_edition.jpg');
INSERT INTO `books` VALUES (26, '计算机网络：自顶向下发方法', 89.00, 'James F. Kurose / Keith W. Ross', 1, 9, 'static/imgs/bookImgs/Computer_Networking_A_Top-Down_Approach.jpg');
INSERT INTO `books` VALUES (27, '流畅的Python', 139.00, 'Luciano Ramalho', 5, 5, 'static/imgs/bookImgs/Fluent_Python.jpg');
INSERT INTO `books` VALUES (28, 'Go程序设计语言', 79.00, '艾伦 A. A. 多诺万', 0, 10, 'static/imgs/bookImgs/The_Go_Programming_Language.jpg');
INSERT INTO `books` VALUES (29, '算法导论（原书第3版）', 128.00, 'Thomas H.Cormen', 0, 10, 'static/imgs/bookImgs/Introduction_to_Algorithms,Third_Edition.jpg');
INSERT INTO `books` VALUES (30, 'Effective Java : 3rd Edition', 119.00, 'Joshua Bloch', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (31, '深入理解计算机系统', 99.00, 'Randal E.Bryant', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (32, 'UNIX环境高级编程', 99.00, 'W.Richard Stevens', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (33, 'Effective C++', 65.00, 'Scott Meyers', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (34, '计算机程序设计艺术', 98.00, '唐纳德·E. 克努特', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (35, 'Head First Java', 98.00, 'Eric T Freeman', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (36, '深入理解ES6', 99.00, 'Nicholas C. Zakas', 1, 9, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (37, '深入剖析Tomcat', 59.00, 'Budi Kurniawan', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (38, 'TCP/IP网络编程', 79.00, '尹圣雨 / 金国哲', 0, 10, 'static/imgs/bookImgs/default.jpg');
INSERT INTO `books` VALUES (44, '斗罗大陆', 55.00, '唐家三少', 1, 9, 'static/imgs/bookImgs/default.jpg');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `orderDate` datetime NULL DEFAULT NULL,
  `itemsCount` int NULL DEFAULT NULL,
  `totalPrice` decimal(11, 2) NULL DEFAULT NULL,
  `orderStatus` int NULL DEFAULT NULL,
  `userId` int NULL DEFAULT NULL,
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('16118247766581', '2021-01-28 17:06:17', 4, 361.00, 0, 1, 'wh');
INSERT INTO `orders` VALUES ('16118320339521', '2021-01-28 19:07:14', 1, 128.00, 0, 1, 'wh');
INSERT INTO `orders` VALUES ('16118326936066', '2021-01-28 19:18:14', 4, 272.00, 2, 6, 'admin');
INSERT INTO `orders` VALUES ('16118328883796', '2021-01-28 19:21:28', 2, 188.00, 1, 6, 'admin');
INSERT INTO `orders` VALUES ('16118412308736', '2021-01-28 21:40:31', 2, 228.00, 0, 6, 'admin');
INSERT INTO `orders` VALUES ('16253286837851', '2021-07-04 00:11:24', 3, 262.00, 0, 1, 'wh');

-- ----------------------------
-- Table structure for orders_items
-- ----------------------------
DROP TABLE IF EXISTS `orders_items`;
CREATE TABLE `orders_items`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookId` int NULL DEFAULT NULL,
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Count` int NULL DEFAULT NULL,
  `singlePrice` decimal(11, 2) NULL DEFAULT NULL,
  `totalPrice` decimal(12, 2) NULL DEFAULT NULL,
  `orderId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `orderId`(`orderId`) USING BTREE,
  CONSTRAINT `orders_items_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_items
-- ----------------------------
INSERT INTO `orders_items` VALUES (13, 2, '数据结构与算法分析', 1, 35.00, 35.00, '16118247766581');
INSERT INTO `orders_items` VALUES (14, 4, 'Java编程思想（第4版）', 1, 108.00, 108.00, '16118247766581');
INSERT INTO `orders_items` VALUES (15, 1, 'Java核心技术', 1, 119.00, 119.00, '16118247766581');
INSERT INTO `orders_items` VALUES (16, 5, 'JavaScript高级程序设计', 1, 99.00, 99.00, '16118247766581');
INSERT INTO `orders_items` VALUES (17, 13, 'C++ Primer 中文版（第 5 版）', 1, 128.00, 128.00, '16118320339521');
INSERT INTO `orders_items` VALUES (18, 6, 'JavaScript语言精粹', 1, 35.00, 35.00, '16118326936066');
INSERT INTO `orders_items` VALUES (19, 7, 'C语言程序设计：现代方法', 1, 79.00, 79.00, '16118326936066');
INSERT INTO `orders_items` VALUES (20, 8, '高性能JavaScript', 1, 49.00, 49.00, '16118326936066');
INSERT INTO `orders_items` VALUES (21, 9, 'JavaScript权威指南', 1, 109.00, 109.00, '16118326936066');
INSERT INTO `orders_items` VALUES (22, 24, 'Python编程 : 从入门到实践', 1, 89.00, 89.00, '16118328883796');
INSERT INTO `orders_items` VALUES (23, 25, '算法（第4版）', 1, 99.00, 99.00, '16118328883796');
INSERT INTO `orders_items` VALUES (24, 26, '计算机网络：自顶向下发方法', 1, 89.00, 89.00, '16118412308736');
INSERT INTO `orders_items` VALUES (25, 27, '流畅的Python', 1, 139.00, 139.00, '16118412308736');
INSERT INTO `orders_items` VALUES (26, 1, 'Java核心技术', 1, 119.00, 119.00, '16253286837851');
INSERT INTO `orders_items` VALUES (27, 2, '数据结构与算法分析', 1, 35.00, 35.00, '16253286837851');
INSERT INTO `orders_items` VALUES (28, 4, 'Java编程思想（第4版）', 1, 108.00, 108.00, '16253286837851');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'wh', '5517', 'wh@qq.com');
INSERT INTO `users` VALUES (4, 'jisoo', '334455', 'jisoo@qq.com');
INSERT INTO `users` VALUES (5, 'wanghu', '5517', 'wanghu@qq.com');
INSERT INTO `users` VALUES (6, 'admin', 'admin', 'admin@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
