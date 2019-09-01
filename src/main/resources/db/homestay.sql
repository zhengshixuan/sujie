/*
 Navicat Premium Data Transfer

 Source Server         : bsh
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : homestay

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 02/09/2019 00:26:38
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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图片类别字典表' ROW_FORMAT = Compact;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '民宿基本信息表' ROW_FORMAT = Compact;

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
  `pre_clean_date` datetime NULL DEFAULT NULL COMMENT '预打扫时间',
  `clean_price` decimal(10, 2) NOT NULL COMMENT '保洁费用',
  `is_check_out` int(1) NOT NULL COMMENT '是否已经退房，0是，1否',
  `check_out_date` datetime NULL DEFAULT NULL COMMENT '退房时间',
  `clean_status_code` int(1) NOT NULL COMMENT '关联dict_clean_status',
  `create_date` datetime NOT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁订单主表' ROW_FORMAT = Compact;

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
  `actual_clean_date` datetime NOT NULL COMMENT '实际保洁时间',
  `is_first` int(1) NOT NULL COMMENT '是否优先，0是，1否',
  `staff_cost` decimal(10, 2) NOT NULL COMMENT '保洁阿姨费用',
  `boss_cost` decimal(10, 2) NOT NULL COMMENT '保洁老板费用',
  `status` int(6) NOT NULL COMMENT '保洁单状态,关联dict_order_status表',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单保洁信息表' ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间图片信息表' ROW_FORMAT = Compact;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间信息' ROW_FORMAT = Compact;

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
  `entry_time` datetime NOT NULL COMMENT '入职时间',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '照片',
  `province_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省代码',
  `province_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省名称',
  `city_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市代码',
  `city_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市名称',
  `county_code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区代码',
  `county_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁阿姨信息' ROW_FORMAT = Compact;

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
