/*
 Navicat Premium Data Transfer

 Source Server         : centos
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 192.168.0.60:3306
 Source Schema         : homestay

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 03/09/2019 17:45:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict_clean_status
-- ----------------------------
DROP TABLE IF EXISTS `dict_clean_status`;
CREATE TABLE `dict_clean_status`  (
  `id` int(32) NOT NULL,
  `clean_status_code` int(1) NOT NULL COMMENT '状态代码',
  `clean_status_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '打扫状态字典' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_clean_status
-- ----------------------------
INSERT INTO `dict_clean_status` VALUES (0, 0, '预打扫', 0, NULL);
INSERT INTO `dict_clean_status` VALUES (1, 1, '待保洁', 1, NULL);
INSERT INTO `dict_clean_status` VALUES (2, 2, '正在保洁', 2, NULL);
INSERT INTO `dict_clean_status` VALUES (3, 3, '保洁完成', 3, NULL);

-- ----------------------------
-- Table structure for dict_clean_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_clean_type`;
CREATE TABLE `dict_clean_type`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clean_type_code` int(6) NOT NULL COMMENT '清洁类型字典',
  `clean_type_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '清洁类型名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁类型字典' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_clean_type
-- ----------------------------
INSERT INTO `dict_clean_type` VALUES ('0', 0, '常规保洁', 0, NULL);
INSERT INTO `dict_clean_type` VALUES ('1', 1, '深度保洁', 1, NULL);

-- ----------------------------
-- Table structure for dict_daily_nessities
-- ----------------------------
DROP TABLE IF EXISTS `dict_daily_nessities`;
CREATE TABLE `dict_daily_nessities`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `item_code` int(6) NOT NULL COMMENT '日用品代码',
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '日用品名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日用品字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dict_order_status
-- ----------------------------
DROP TABLE IF EXISTS `dict_order_status`;
CREATE TABLE `dict_order_status`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `item_code` int(6) NOT NULL COMMENT '订单状态代码',
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单状态字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_order_status
-- ----------------------------
INSERT INTO `dict_order_status` VALUES ('0', 0, '未派单', 0, NULL);
INSERT INTO `dict_order_status` VALUES ('1', 1, '已派单，未接受', 1, NULL);
INSERT INTO `dict_order_status` VALUES ('2', 2, '保洁中', 2, NULL);
INSERT INTO `dict_order_status` VALUES ('3', 3, '保洁完成', 3, NULL);
INSERT INTO `dict_order_status` VALUES ('4', 4, '已取消', 4, NULL);

-- ----------------------------
-- Table structure for dict_pic_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_pic_type`;
CREATE TABLE `dict_pic_type`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `item_code` int(10) NULL DEFAULT NULL COMMENT '图片类别代码',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片类别名称',
  `seq_no` int(3) NULL DEFAULT NULL COMMENT '序号',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图片类别字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dict_room_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_room_type`;
CREATE TABLE `dict_room_type`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `item_code` int(3) NOT NULL COMMENT '房间代码',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间名称',
  `seq_no` int(3) NOT NULL COMMENT '序号',
  `price` decimal(10, 2) NOT NULL COMMENT '标准价格',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间类型字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_room_type
-- ----------------------------
INSERT INTO `dict_room_type` VALUES ('1', 1, '一室', 1, 10.00, NULL);
INSERT INTO `dict_room_type` VALUES ('2', 2, '二室', 2, 20.00, NULL);
INSERT INTO `dict_room_type` VALUES ('3', 3, '三室', 3, 30.00, NULL);

-- ----------------------------
-- Table structure for homestay_info
-- ----------------------------
DROP TABLE IF EXISTS `homestay_info`;
CREATE TABLE `homestay_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id',
  `homestay_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名宿名称',
  `boss_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '老板姓名',
  `boss_telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '老板电话号码',
  `operators_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营者姓名',
  `operators_telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营者电话',
  `province_code` int(6) NULL DEFAULT NULL COMMENT '省代码',
  `province_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省名称',
  `city_code` int(6) NULL DEFAULT NULL COMMENT '市代码',
  `city_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市名称',
  `county_code` int(6) NULL DEFAULT NULL COMMENT '乡镇代码',
  `county_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '乡镇名称',
  `homestay_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `rooms_number` int(4) NOT NULL COMMENT '民宿房间数量',
  `is_reception` int(1) NOT NULL COMMENT '是否有前台，0否，1是',
  `is_vip` int(1) NOT NULL COMMENT '客户类型（办卡会员）0否，1是',
  `balance` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '账户余额，默认为0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_homestay_id`(`homestay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '民宿基本信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of homestay_info
-- ----------------------------
INSERT INTO `homestay_info` VALUES (1, '1', '星宇', '郑世轩', '13871030919', '郑世轩', '13871030919', NULL, NULL, NULL, NULL, NULL, NULL, '湖北省武汉市洪山区光谷广场', 12, 0, 0, 0.00);
INSERT INTO `homestay_info` VALUES (14, '804b5d2e3bf245aeb257a62acb89c538', '嘻嘻', '郑世轩', '13871030919', '郑世轩', '13871030919', NULL, NULL, NULL, NULL, NULL, NULL, '光谷广场', 12, 0, 0, 0.00);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间id',
  `clean_type` int(6) UNSIGNED ZEROFILL NOT NULL COMMENT '保洁类型关联dict_clean_type',
  `pre_clean_date` datetime(0) NULL DEFAULT NULL COMMENT '预打扫时间',
  `clean_price` decimal(10, 2) NOT NULL COMMENT '保洁费用',
  `is_check_out` int(1) NOT NULL COMMENT '是否已经退房，0是，1否',
  `check_out_date` datetime(0) NULL DEFAULT NULL COMMENT '退房时间',
  `clean_status_code` int(1) NOT NULL COMMENT '关联dict_clean_status',
  `create_date` datetime(0) NOT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁订单主表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '1', '1', '5', 000000, '2019-09-03 11:07:07', 100.00, 0, '2019-09-03 11:07:31', 1, '2019-09-03 11:07:54');

-- ----------------------------
-- Table structure for order_image
-- ----------------------------
DROP TABLE IF EXISTS `order_image`;
CREATE TABLE `order_image`  (
  `id` int(32) NOT NULL,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单id，关联order表order_id',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单图片信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` int(32) NOT NULL,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联订单记录表order_id',
  `staff_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '保洁阿姨选择',
  `actual_clean_date` datetime(0) NOT NULL COMMENT '实际保洁时间',
  `is_first` int(1) NOT NULL COMMENT '是否优先，0是，1否',
  `staff_cost` decimal(10, 2) NOT NULL COMMENT '保洁阿姨费用',
  `boss_cost` decimal(10, 2) NOT NULL COMMENT '保洁老板费用',
  `status` int(6) NOT NULL COMMENT '保洁单状态,关联dict_order_status表',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单保洁信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_record
-- ----------------------------
INSERT INTO `order_record` VALUES (1, '1', '4028b8816cf0b2a4016cf0baae390003', '2019-09-03 11:34:38', 0, 10.00, 20.00, 0, NULL);

-- ----------------------------
-- Table structure for room_image
-- ----------------------------
DROP TABLE IF EXISTS `room_image`;
CREATE TABLE `room_image`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间id',
  `pic_type_code` int(6) NOT NULL COMMENT '图片类别(关联dict_pic_type表item_code)',
  `pic_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片地址',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间图片信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_image
-- ----------------------------
INSERT INTO `room_image` VALUES (3, '1', '203', 0, '/path/4028b8816cf0be9f016cf0cca5a10001.jpg', '床');
INSERT INTO `room_image` VALUES (4, '1', '203', 1, '/path/4028b8816cf0be9f016cf0ccacf70002.jpg', '沙发');
INSERT INTO `room_image` VALUES (5, '1', '203', 2, '/path/4028b8816cf0be9f016cf0ccb46d0003.jpg', '厨房');
INSERT INTO `room_image` VALUES (6, '1', '203', 3, '/path/4028b8816cf0be9f016cf0ccbb940004.jpg', '阳台');
INSERT INTO `room_image` VALUES (7, '1', '203', 4, '/path/4028b8816cf0be9f016cf0ccc3140005.jpg', '卫生间');
INSERT INTO `room_image` VALUES (8, '1', '203', 5, '/path/4028b8816cf0be9f016cf0ccca6c0006.jpg', '');
INSERT INTO `room_image` VALUES (9, '1', '203', 6, '/path/4028b8816cf0be9f016cf0ccd0950007.jpg', '');
INSERT INTO `room_image` VALUES (10, '1', '203', 7, '/path/4028b8816cf0be9f016cf0ccdb7a0008.jpg', '牙刷');
INSERT INTO `room_image` VALUES (11, '1', '203', 8, '/path/4028b8816cf0be9f016cf0cce2720009.jpg', '洗发水');
INSERT INTO `room_image` VALUES (12, '1', '203', 9, '/path/4028b8816cf0be9f016cf0ccf310000a.jpg', '梳子');
INSERT INTO `room_image` VALUES (13, '1', '203', 10, '/path/4028b8816cf0be9f016cf0ccf9e6000b.jpg', '厕所用纸');
INSERT INTO `room_image` VALUES (14, '1', '203', 11, '/path/4028b8816cf0be9f016cf0cd03da000c.jpg', '客厅用纸');
INSERT INTO `room_image` VALUES (15, '1', '203', 12, '/path/4028b8816cf0be9f016cf0cd0cd0000d.jpg', '床单被套');
INSERT INTO `room_image` VALUES (16, '1', '203', 13, '/path/4028b8816cf0be9f016cf0cd1664000e.jpg', '厨具');
INSERT INTO `room_image` VALUES (17, '1', '203', 14, '/path/4028b8816cf0be9f016cf0cd2158000f.jpg', '垃圾袋');
INSERT INTO `room_image` VALUES (18, '1', '203', 0, '/path/4028b8816cf0be9f016cf0cca5a10001.jpg', '床');
INSERT INTO `room_image` VALUES (19, '1', '203', 1, '/path/4028b8816cf0be9f016cf0ccacf70002.jpg', '沙发');
INSERT INTO `room_image` VALUES (20, '1', '203', 2, '/path/4028b8816cf0be9f016cf0ccb46d0003.jpg', '厨房');
INSERT INTO `room_image` VALUES (21, '1', '203', 3, '/path/4028b8816cf0be9f016cf0cee4cb0010.jpg', '阳台');
INSERT INTO `room_image` VALUES (22, '1', '203', 4, '/path/4028b8816cf0be9f016cf0ccc3140005.jpg', '卫生间');
INSERT INTO `room_image` VALUES (23, '1', '203', 5, '/path/4028b8816cf0be9f016cf0ccca6c0006.jpg', '');
INSERT INTO `room_image` VALUES (24, '1', '203', 6, '/path/4028b8816cf0be9f016cf0ccd0950007.jpg', '');
INSERT INTO `room_image` VALUES (25, '1', '203', 7, '/path/4028b8816cf0be9f016cf0ccdb7a0008.jpg', '牙刷');
INSERT INTO `room_image` VALUES (26, '1', '203', 8, '/path/4028b8816cf0be9f016cf0cce2720009.jpg', '洗发水');
INSERT INTO `room_image` VALUES (27, '1', '203', 9, '/path/4028b8816cf0be9f016cf0ccf310000a.jpg', '梳子');
INSERT INTO `room_image` VALUES (28, '1', '203', 10, '/path/4028b8816cf0be9f016cf0ccf9e6000b.jpg', '厕所用纸');
INSERT INTO `room_image` VALUES (29, '1', '203', 11, '/path/4028b8816cf0be9f016cf0cd03da000c.jpg', '客厅用纸');
INSERT INTO `room_image` VALUES (30, '1', '203', 12, '/path/4028b8816cf0be9f016cf0cd0cd0000d.jpg', '床单被套');
INSERT INTO `room_image` VALUES (31, '1', '203', 13, '/path/4028b8816cf0be9f016cf0cd1664000e.jpg', '厨具');
INSERT INTO `room_image` VALUES (32, '1', '203', 14, '/path/4028b8816cf0be9f016cf0cd2158000f.jpg', '垃圾袋');
INSERT INTO `room_image` VALUES (33, '1', '203', 0, '/path/4028b8816cf0be9f016cf0cca5a10001.jpg', '床');
INSERT INTO `room_image` VALUES (34, '1', '203', 1, '/path/4028b8816cf0be9f016cf0ccacf70002.jpg', '沙发');
INSERT INTO `room_image` VALUES (35, '1', '203', 2, '/path/4028b8816cf0be9f016cf0ccb46d0003.jpg', '厨房');
INSERT INTO `room_image` VALUES (36, '1', '203', 3, '/path/4028b8816cf0be9f016cf0cf22c40011.jpg', '阳台');
INSERT INTO `room_image` VALUES (37, '1', '203', 4, '/path/4028b8816cf0be9f016cf0ccc3140005.jpg', '卫生间');
INSERT INTO `room_image` VALUES (38, '1', '203', 5, '/path/4028b8816cf0be9f016cf0ccca6c0006.jpg', '');
INSERT INTO `room_image` VALUES (39, '1', '203', 6, '/path/4028b8816cf0be9f016cf0ccd0950007.jpg', '');
INSERT INTO `room_image` VALUES (40, '1', '203', 7, '/path/4028b8816cf0be9f016cf0ccdb7a0008.jpg', '牙刷');
INSERT INTO `room_image` VALUES (41, '1', '203', 8, '/path/4028b8816cf0be9f016cf0cce2720009.jpg', '洗发水');
INSERT INTO `room_image` VALUES (42, '1', '203', 9, '/path/4028b8816cf0be9f016cf0ccf310000a.jpg', '梳子');
INSERT INTO `room_image` VALUES (43, '1', '203', 10, '/path/4028b8816cf0be9f016cf0ccf9e6000b.jpg', '厕所用纸');
INSERT INTO `room_image` VALUES (44, '1', '203', 11, '/path/4028b8816cf0be9f016cf0cd03da000c.jpg', '客厅用纸');
INSERT INTO `room_image` VALUES (45, '1', '203', 12, '/path/4028b8816cf0be9f016cf0cd0cd0000d.jpg', '床单被套');
INSERT INTO `room_image` VALUES (46, '1', '203', 13, '/path/4028b8816cf0be9f016cf0cd1664000e.jpg', '厨具');
INSERT INTO `room_image` VALUES (47, '1', '203', 14, '/path/4028b8816cf0be9f016cf0cd2158000f.jpg', '垃圾袋');
INSERT INTO `room_image` VALUES (48, '1', '203', 0, '/path/4028b8816cf0d59a016cf0d59a360000.jpg', '床');
INSERT INTO `room_image` VALUES (49, '1', '203', 1, '/path/4028b8816cf0be9f016cf0ccacf70002.jpg', '沙发');
INSERT INTO `room_image` VALUES (50, '1', '203', 2, '/path/4028b8816cf0be9f016cf0ccb46d0003.jpg', '厨房');
INSERT INTO `room_image` VALUES (51, '1', '203', 3, '/path/4028b8816cf0be9f016cf0cf22c40011.jpg', '阳台');
INSERT INTO `room_image` VALUES (52, '1', '203', 4, '/path/4028b8816cf0be9f016cf0ccc3140005.jpg', '卫生间');
INSERT INTO `room_image` VALUES (53, '1', '203', 5, '/path/4028b8816cf0be9f016cf0ccca6c0006.jpg', '');
INSERT INTO `room_image` VALUES (54, '1', '203', 6, '/path/4028b8816cf0be9f016cf0ccd0950007.jpg', '');
INSERT INTO `room_image` VALUES (55, '1', '203', 7, '/path/4028b8816cf0be9f016cf0ccdb7a0008.jpg', '牙刷');
INSERT INTO `room_image` VALUES (56, '1', '203', 8, '/path/4028b8816cf0be9f016cf0cce2720009.jpg', '洗发水');
INSERT INTO `room_image` VALUES (57, '1', '203', 9, '/path/4028b8816cf0be9f016cf0ccf310000a.jpg', '梳子');
INSERT INTO `room_image` VALUES (58, '1', '203', 10, '/path/4028b8816cf0be9f016cf0ccf9e6000b.jpg', '厕所用纸');
INSERT INTO `room_image` VALUES (59, '1', '203', 11, '/path/4028b8816cf0be9f016cf0cd03da000c.jpg', '客厅用纸');
INSERT INTO `room_image` VALUES (60, '1', '203', 12, '/path/4028b8816cf0be9f016cf0cd0cd0000d.jpg', '床单被套');
INSERT INTO `room_image` VALUES (61, '1', '203', 13, '/path/4028b8816cf0be9f016cf0cd1664000e.jpg', '厨具');
INSERT INTO `room_image` VALUES (62, '1', '203', 14, '/path/4028b8816cf0be9f016cf0cd2158000f.jpg', '垃圾袋');
INSERT INTO `room_image` VALUES (63, '1', '203', 0, '/path/4028b8816cf0d59a016cf0d59a360000.jpg', '床');
INSERT INTO `room_image` VALUES (64, '1', '203', 1, '/path/4028b8816cf0be9f016cf0ccacf70002.jpg', '沙发');
INSERT INTO `room_image` VALUES (65, '1', '203', 2, '/path/4028b8816cf0be9f016cf0ccb46d0003.jpg', '厨房');
INSERT INTO `room_image` VALUES (66, '1', '203', 3, '/path/4028b8816cf0be9f016cf0cf22c40011.jpg', '阳台');
INSERT INTO `room_image` VALUES (67, '1', '203', 4, '/path/4028b8816cf0be9f016cf0ccc3140005.jpg', '卫生间');
INSERT INTO `room_image` VALUES (68, '1', '203', 5, '/path/4028b8816cf0be9f016cf0ccca6c0006.jpg', '');
INSERT INTO `room_image` VALUES (69, '1', '203', 6, '/path/4028b8816cf0be9f016cf0ccd0950007.jpg', '');
INSERT INTO `room_image` VALUES (70, '1', '203', 7, '/path/4028b8816cf0be9f016cf0ccdb7a0008.jpg', '牙刷');
INSERT INTO `room_image` VALUES (71, '1', '203', 8, '/path/4028b8816cf0be9f016cf0cce2720009.jpg', '洗发水');
INSERT INTO `room_image` VALUES (72, '1', '203', 9, '/path/4028b8816cf0be9f016cf0ccf310000a.jpg', '梳子');
INSERT INTO `room_image` VALUES (73, '1', '203', 10, '/path/4028b8816cf0be9f016cf0ccf9e6000b.jpg', '厕所用纸');
INSERT INTO `room_image` VALUES (74, '1', '203', 11, '/path/4028b8816cf0be9f016cf0cd03da000c.jpg', '客厅用纸');
INSERT INTO `room_image` VALUES (75, '1', '203', 12, '/path/4028b8816cf0be9f016cf0cd0cd0000d.jpg', '床单被套');
INSERT INTO `room_image` VALUES (76, '1', '203', 13, '/path/4028b8816cf0be9f016cf0cd1664000e.jpg', '厨具');
INSERT INTO `room_image` VALUES (77, '1', '203', 14, '/path/4028b8816cf0be9f016cf0cd2158000f.jpg', '垃圾袋');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id(关联homestay_info表homestay_id)',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间编号,多少楼多少编号',
  `room_address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间地址',
  `open_method` int(1) NOT NULL COMMENT '开门方式：0密码锁：输入密码加#进入，1钥匙盒子',
  `room_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '保洁密码(主要是针对保洁密码长期不变的客户)',
  `room_type` int(2) NOT NULL COMMENT '房间户型(一室、二室、三室等)',
  `room_decoration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间内摆设分几个区域：床上，沙发区域，厨房区域，卫生间区域',
  `need_washing_sheets` int(1) NOT NULL COMMENT '是否需要洗床单0需要，1不需要',
  `price` decimal(10, 2) NOT NULL COMMENT '收费价格',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注：找到房间的说明(一个房门里面两个房间或多个的情况)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_room_info_hrId`(`homestay_id`, `room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (5, '1', '203', '二楼第三间', 0, '123', 1, NULL, 0, 123.00, NULL);

-- ----------------------------
-- Table structure for room_nessities_reminder
-- ----------------------------
DROP TABLE IF EXISTS `room_nessities_reminder`;
CREATE TABLE `room_nessities_reminder`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间id',
  `nessisties_id` int(6) NOT NULL COMMENT '不足物品代码，关联dict_daily_nessities表',
  `status` int(1) NULL DEFAULT NULL COMMENT '0已补充，1未补充',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '一次性物品不足提醒表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for staff_commission
-- ----------------------------
DROP TABLE IF EXISTS `staff_commission`;
CREATE TABLE `staff_commission`  (
  `id` int(11) NOT NULL,
  `staff_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人员id',
  `room_type` int(3) NOT NULL COMMENT '房间类型，关联dict_room_type表',
  `commission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间提成，房间成为一室、两室、三室等标准提成，如果在标准以外。另外加床另外加几元',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁阿姨的提成' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for staff_info
-- ----------------------------
DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '保洁人员id',
  `staff_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '保洁阿姨姓名',
  `staff_type` int(1) NOT NULL COMMENT '阿姨类别，0全职阿姨，1简直阿姨',
  `telphone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `id_no` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号码',
  `entry_time` datetime(0) NOT NULL COMMENT '入职时间',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '照片',
  `province_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省代码',
  `province_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省名称',
  `city_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市代码',
  `city_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市名称',
  `county_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区代码',
  `county_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_staff_info_telphone`(`telphone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁阿姨信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff_info
-- ----------------------------
INSERT INTO `staff_info` VALUES (5, '4028b8816cf0b2a4016cf0baae390003', '郑伟杰', 0, '13871030919', '420115199205033236', '2019-09-25 00:00:00', 'C4CA4238A0B923820DCC509A6F75849B', '/path/4028b8816cf0be9f016cf0be9fb70000.jpg', NULL, NULL, NULL, NULL, NULL, NULL, '湖北省武汉市江夏区');

-- ----------------------------
-- Table structure for staff_work_place
-- ----------------------------
DROP TABLE IF EXISTS `staff_work_place`;
CREATE TABLE `staff_work_place`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `staff_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联staff_info中staff_id',
  `province_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省代码',
  `province_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省名称',
  `city_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市代码',
  `city_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市名称',
  `county_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区代码',
  `county_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁阿姨工作位置' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
