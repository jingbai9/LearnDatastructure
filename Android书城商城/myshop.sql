/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2022-05-22 17:43:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `cust_id` int(10) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(20) DEFAULT NULL,
  `cust_password` varchar(20) DEFAULT NULL,
  `cust_status` bit(1) DEFAULT NULL,
  `cust_phone` varchar(20) DEFAULT NULL,
  `cust_address` varchar(50) DEFAULT NULL,
  `balance` double DEFAULT '0',
  PRIMARY KEY (`cust_id`) USING BTREE,
  KEY `cust_name` (`cust_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=976 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('267', 'user', '123456', '', null, null, '55.4');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `good_id` int(10) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(30) DEFAULT NULL,
  `good_price` double(20,1) DEFAULT NULL,
  `type_id` int(10) DEFAULT NULL,
  `good_detail` varchar(50) DEFAULT NULL,
  `good_icon_url` varchar(50) DEFAULT NULL,
  `good_image_detail_url` varchar(150) DEFAULT NULL,
  `pic_url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`good_id`) USING BTREE,
  KEY `fk_type_id` (`type_id`) USING BTREE,
  CONSTRAINT `fk_type_id` FOREIGN KEY (`type_id`) REFERENCES `types` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=405 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('100', 'book_100', '28.9', '1', '有货', 'book_100.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_100.jpg');
INSERT INTO `goods` VALUES ('101', 'book_101', '28.9', '1', '有货', 'book_101.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_101.jpg');
INSERT INTO `goods` VALUES ('102', 'book_102', '28.9', '1', '有货', 'book_102.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_102.jpg');
INSERT INTO `goods` VALUES ('103', 'book_103', '28.9', '1', '有货', 'book_103.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_103.jpg');
INSERT INTO `goods` VALUES ('104', 'book_104', '28.9', '1', '有货', 'book_104.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_104.jpg');
INSERT INTO `goods` VALUES ('105', 'book_105', '28.9', '1', '有货', 'book_105.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_105.jpg');
INSERT INTO `goods` VALUES ('106', 'book_106', '28.9', '1', '有货', 'book_106.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_106.jpg');
INSERT INTO `goods` VALUES ('107', 'book_107', '28.9', '1', '有货', 'book_107.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_107.jpg');
INSERT INTO `goods` VALUES ('108', 'book_108', '28.9', '1', '有货', 'book_108.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_108.jpg');
INSERT INTO `goods` VALUES ('109', 'book_109', '28.9', '1', '有货', 'book_109.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_109.jpg');
INSERT INTO `goods` VALUES ('200', 'book_200', '38.9', '2', '有货', 'book_200.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_200.jpg');
INSERT INTO `goods` VALUES ('201', 'book_201', '38.9', '2', '有货', 'book_201.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_201.jpg');
INSERT INTO `goods` VALUES ('202', 'book_202', '38.9', '2', '有货', 'book_202.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_202.jpg');
INSERT INTO `goods` VALUES ('203', 'book_203', '38.9', '2', '有货', 'book_203.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_203.jpg');
INSERT INTO `goods` VALUES ('204', 'book_204', '38.9', '2', '有货', 'book_204.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_204.jpg');
INSERT INTO `goods` VALUES ('205', 'book_205', '38.9', '2', '有货', 'book_205.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_205.jpg');
INSERT INTO `goods` VALUES ('206', 'book_206', '38.9', '2', '有货', 'book_206.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_206.jpg');
INSERT INTO `goods` VALUES ('207', 'book_207', '38.9', '2', '有货', 'book_207.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_207.jpg');
INSERT INTO `goods` VALUES ('300', 'book_300', '38.9', '3', '有货', 'book_300.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_300.jpg');
INSERT INTO `goods` VALUES ('301', 'book_301', '39.9', '3', '有货', 'book_301.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_301.jpg');
INSERT INTO `goods` VALUES ('302', 'book_302', '40.9', '3', '有货', 'book_302.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_302.jpg');
INSERT INTO `goods` VALUES ('303', 'book_303', '41.9', '3', '有货', 'book_303.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_303.jpg');
INSERT INTO `goods` VALUES ('304', 'book_304', '42.9', '3', '有货', 'book_304.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_304.jpg');
INSERT INTO `goods` VALUES ('305', 'book_305', '43.9', '3', '有货', 'book_305.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_305.jpg');
INSERT INTO `goods` VALUES ('306', 'book_306', '44.9', '3', '有货', 'book_306.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_306.jpg');
INSERT INTO `goods` VALUES ('307', 'book_307', '45.9', '3', '有货', 'book_307.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_307.jpg');
INSERT INTO `goods` VALUES ('400', 'book_400', '38.9', '4', '有货', 'book_400.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_400.jpg');
INSERT INTO `goods` VALUES ('401', 'book_401', '39.9', '4', '有货', 'book_401.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_401.jpg');
INSERT INTO `goods` VALUES ('402', 'book_402', '40.9', '4', '有货', 'book_402.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_402.jpg');
INSERT INTO `goods` VALUES ('403', 'book_403', '41.9', '4', '有货', 'book_403.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_403.jpg');
INSERT INTO `goods` VALUES ('404', 'book_404', '42.9', '4', '有货', 'book_404.jpg', '', 'http://127.0.0.1:8080/myshop/images/book_404.jpg');

-- ----------------------------
-- Table structure for og
-- ----------------------------
DROP TABLE IF EXISTS `og`;
CREATE TABLE `og` (
  `order_id` int(10) NOT NULL,
  `good_id` int(10) NOT NULL,
  `good_num` int(10) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`good_id`) USING BTREE,
  CONSTRAINT `fk_og_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of og
-- ----------------------------
INSERT INTO `og` VALUES ('1005', '106', '1');
INSERT INTO `og` VALUES ('1646', '102', '1');
INSERT INTO `og` VALUES ('3187', '100', '1');
INSERT INTO `og` VALUES ('4296', '100', '1');
INSERT INTO `og` VALUES ('5190', '100', '1');
INSERT INTO `og` VALUES ('5190', '101', '1');
INSERT INTO `og` VALUES ('7552', '100', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `cust_id` int(10) DEFAULT NULL,
  `order_status` varchar(10) DEFAULT NULL,
  `pay_mode` varchar(10) DEFAULT NULL,
  `order_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `order_remark` varchar(50) DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  `rec_name` varchar(20) DEFAULT NULL,
  `rec_phone` varchar(15) DEFAULT NULL,
  `rec_address` varchar(50) DEFAULT NULL,
  `logistics_progress` varchar(20) DEFAULT NULL,
  `logistics_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `cust_id` (`cust_id`) USING BTREE,
  KEY `rec_name` (`rec_name`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`cust_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7553 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1005', '267', '未发货', '微信', '2022-05-11 16:59:49', null, '28.9', 'gyy', '15000001111', 'adfasdfasdfasd', null, null);
INSERT INTO `orders` VALUES ('1646', '267', '未发货', '余额', '2022-05-22 15:24:02', null, '28.9', 'gyy', '15000001111', 'adfasdfasdfasd', null, null);
INSERT INTO `orders` VALUES ('3187', '267', '未发货', '微信', '2022-05-22 09:54:27', null, '28.9', 'gyy', '15000001111', 'adfasdfasdfasd', null, null);
INSERT INTO `orders` VALUES ('4296', '267', '未发货', '微信', '2022-05-22 14:34:47', null, '28.9', 'gyy', '15000001111', 'adfasdfasdfasd', null, null);
INSERT INTO `orders` VALUES ('5190', '267', '未发货', '余额', '2022-05-22 15:35:31', null, '57.79999999999999', 'gyy', '15000001111', 'adfasdfasdfasd', null, null);
INSERT INTO `orders` VALUES ('7552', '267', '未发货', '余额', '2022-05-22 15:43:59', null, '28.9', 'gyy', '15000001111', 'adfasdfasdfasd', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(32) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('0', 'admin', '123456');

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `type_id` int(10) NOT NULL,
  `type_name` varchar(20) DEFAULT NULL,
  `type_url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '材料类', null);
INSERT INTO `types` VALUES ('2', '汽车类', null);
INSERT INTO `types` VALUES ('3', '计算机类', null);
INSERT INTO `types` VALUES ('4', '其他', null);
