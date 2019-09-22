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

 Date: 21/09/2019 21:15:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ad_image
-- ----------------------------
DROP TABLE IF EXISTS `ad_image`;
CREATE TABLE `ad_image`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '图片状态,0为下线,1为上线,默认查询状态为1上线中的数据',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片地址',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ad_image
-- ----------------------------
INSERT INTO `ad_image` VALUES (1, 1, '/path/1.png', '首页图片');
INSERT INTO `ad_image` VALUES (2, 0, '/path/2.png', '第二张');
INSERT INTO `ad_image` VALUES (3, 1, '/path/3.png', '第三张');

-- ----------------------------
-- Table structure for dict_clean_status
-- ----------------------------
DROP TABLE IF EXISTS `dict_clean_status`;
CREATE TABLE `dict_clean_status`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `clean_status_code` int(1) NOT NULL COMMENT '状态代码',
  `clean_status_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unique_dictCleanStatus_cleanStatusCode`(`clean_status_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '打扫状态字典' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_clean_status
-- ----------------------------
INSERT INTO `dict_clean_status` VALUES (1, 1, '待保洁', 1, NULL);
INSERT INTO `dict_clean_status` VALUES (2, 2, '正在保洁', 2, NULL);
INSERT INTO `dict_clean_status` VALUES (3, 3, '保洁完成', 3, NULL);
INSERT INTO `dict_clean_status` VALUES (4, 0, '预保洁', 0, NULL);

-- ----------------------------
-- Table structure for dict_clean_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_clean_type`;
CREATE TABLE `dict_clean_type`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `clean_type_code` int(6) NOT NULL COMMENT '清洁类型字典',
  `clean_type_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '清洁类型名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unique_dictCleanType_cleanTypeCode`(`clean_type_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁类型字典' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_clean_type
-- ----------------------------
INSERT INTO `dict_clean_type` VALUES (1, 1, '深度保洁', 1, NULL);
INSERT INTO `dict_clean_type` VALUES (2, 0, '常规保洁', 0, NULL);

-- ----------------------------
-- Table structure for dict_daily_nessities
-- ----------------------------
DROP TABLE IF EXISTS `dict_daily_nessities`;
CREATE TABLE `dict_daily_nessities`  (
  `id` int(10) NOT NULL,
  `item_code` int(6) NOT NULL COMMENT '日用品代码',
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '日用品名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unique_dictDailyNessities_itemCode`(`item_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日用品字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_daily_nessities
-- ----------------------------
INSERT INTO `dict_daily_nessities` VALUES (0, 0, '卫生纸', 0, NULL);
INSERT INTO `dict_daily_nessities` VALUES (1, 1, '垃圾袋', 1, NULL);
INSERT INTO `dict_daily_nessities` VALUES (2, 2, '牙刷', 2, NULL);
INSERT INTO `dict_daily_nessities` VALUES (3, 3, '沐浴露', 3, NULL);
INSERT INTO `dict_daily_nessities` VALUES (4, 4, '洗发水', 4, NULL);

-- ----------------------------
-- Table structure for dict_order_status
-- ----------------------------
DROP TABLE IF EXISTS `dict_order_status`;
CREATE TABLE `dict_order_status`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `item_code` int(6) NOT NULL COMMENT '订单状态代码',
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态名称',
  `seq_no` int(3) NOT NULL COMMENT '排序',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unique_dictOrderStatus_imteCode`(`item_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单状态字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_order_status
-- ----------------------------
INSERT INTO `dict_order_status` VALUES (1, 0, '未派单', 0, NULL);
INSERT INTO `dict_order_status` VALUES (2, 1, '已派单，未接受', 1, NULL);
INSERT INTO `dict_order_status` VALUES (3, 2, '保洁中', 2, NULL);
INSERT INTO `dict_order_status` VALUES (4, 3, '保洁完成', 3, NULL);
INSERT INTO `dict_order_status` VALUES (5, 4, '已取消', 4, NULL);

-- ----------------------------
-- Table structure for dict_pic_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_pic_type`;
CREATE TABLE `dict_pic_type`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `item_code` int(6) NOT NULL COMMENT '图片类别代码',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片类别名称',
  `seq_no` int(3) NOT NULL COMMENT '序号',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_dictPicType`(`item_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图片类别字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_pic_type
-- ----------------------------
INSERT INTO `dict_pic_type` VALUES (1, 1, '床上区域', 1, NULL);
INSERT INTO `dict_pic_type` VALUES (2, 2, '沙发区域', 2, NULL);
INSERT INTO `dict_pic_type` VALUES (3, 3, '厨房区域', 3, NULL);
INSERT INTO `dict_pic_type` VALUES (4, 4, '阳台区域', 4, NULL);
INSERT INTO `dict_pic_type` VALUES (5, 5, '洗漱台', 5, NULL);
INSERT INTO `dict_pic_type` VALUES (6, 6, '马桶', 6, NULL);
INSERT INTO `dict_pic_type` VALUES (7, 7, '卫生间地面', 7, NULL);
INSERT INTO `dict_pic_type` VALUES (8, 8, '牙膏牙刷', 8, NULL);
INSERT INTO `dict_pic_type` VALUES (9, 9, '洗发水、沐浴露', 9, NULL);
INSERT INTO `dict_pic_type` VALUES (10, 10, '梳子', 10, NULL);
INSERT INTO `dict_pic_type` VALUES (11, 11, '厕所用纸', 11, NULL);
INSERT INTO `dict_pic_type` VALUES (12, 12, '客厅用纸', 12, NULL);
INSERT INTO `dict_pic_type` VALUES (13, 13, '床单被套', 13, NULL);
INSERT INTO `dict_pic_type` VALUES (14, 14, '厨具', 14, NULL);
INSERT INTO `dict_pic_type` VALUES (15, 15, '垃圾袋', 15, NULL);
INSERT INTO `dict_pic_type` VALUES (16, 16, '其他', 16, NULL);

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
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_dictRoomType`(`item_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间类型字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_room_type
-- ----------------------------
INSERT INTO `dict_room_type` VALUES ('0', 0, '一室', 0, 0.00, NULL);
INSERT INTO `dict_room_type` VALUES ('1', 1, '二室', 1, 0.00, NULL);
INSERT INTO `dict_room_type` VALUES ('2', 2, '三室', 2, 0.00, NULL);

-- ----------------------------
-- Table structure for homestay_charge_record
-- ----------------------------
DROP TABLE IF EXISTS `homestay_charge_record`;
CREATE TABLE `homestay_charge_record`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id',
  `amount` decimal(10, 2) NOT NULL COMMENT '充值金额',
  `charge_date` datetime NULL DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '充值记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of homestay_charge_record
-- ----------------------------
INSERT INTO `homestay_charge_record` VALUES (5, '5a04276b87724632a5ced68fda0d00b7', 1444.00, '2019-09-21 10:32:38');

-- ----------------------------
-- Table structure for homestay_info
-- ----------------------------
DROP TABLE IF EXISTS `homestay_info`;
CREATE TABLE `homestay_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id',
  `homestay_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名宿名称',
  `boss_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '老板姓名',
  `boss_telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '老板电话号码',
  `operators_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营者姓名',
  `operators_telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营者电话',
  `homestay_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `rooms_number` int(4) NOT NULL COMMENT '民宿房间数量',
  `is_reception` int(1) NOT NULL COMMENT '是否有前台，0否，1是',
  `is_vip` int(1) NOT NULL COMMENT '客户类型（办卡会员）0否，1是',
  `balance` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '账户余额，默认为0',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营者登录密码',
  `reception_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前台房间密码',
  `work_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司电话',
  `customer_wx` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客服微信',
  `customer_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客服电话',
  `work_time` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_homestayInfo_homestayId`(`homestay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '民宿基本信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of homestay_info
-- ----------------------------
INSERT INTO `homestay_info` VALUES (14, '5a04276b87724632a5ced68fda0d00b7', '星空民宿', '郑世轩', '13777777777', '郑伟杰', '13888888888', '湖北省武汉市洪山区光谷广场', 12, 0, 0, 1444.00, 'F379EAF3C831B04DE153469D1BEC345E', '456', '027-59379656', 'sj18086601663', '027-59379656', '周一至周日 09:30-18:00');
INSERT INTO `homestay_info` VALUES (15, 'f782d9f1a4b243bd89367f4ff39cc327', '测试品牌', '张三', '13333333333', '李四', '13333333334', '江汉区', 12, 0, 0, 0.00, '202CB962AC59075B964B07152D234B70', '123', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id(homestay_info中的homestay_id)',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间id(room_info中的room_id)',
  `clean_type` int(6) NOT NULL COMMENT '保洁类型关联dict_clean_type',
  `pre_start_clean_date` datetime NULL DEFAULT NULL COMMENT '预打扫开始时间',
  `clean_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '保洁费用',
  `pre_end_clean_date` datetime NULL DEFAULT NULL COMMENT '预打扫结束时间',
  `is_check_out` int(1) NOT NULL COMMENT '是否已经退房，0是，1否',
  `check_out_date` datetime NULL DEFAULT NULL COMMENT '退房时间',
  `clean_status_code` int(1) NOT NULL COMMENT '关联dict_clean_status',
  `create_date` datetime NOT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_order_orderId`(`order_id`) USING BTREE COMMENT '订单id唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁订单主表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (3, '1', '5a04276b87724632a5ced68fda0d00b7', '111', 0, '2019-01-01 13:22:00', NULL, '2019-01-01 13:22:00', 0, NULL, 3, '2019-09-18 21:29:18');
INSERT INTO `order` VALUES (5, '4028b8816d53b54b016d53b54b630000', '5a04276b87724632a5ced68fda0d00b7', '111', 7, '2019-01-01 11:11:00', NULL, '2019-01-01 11:12:00', 3, NULL, 0, '2019-09-21 20:04:13');
INSERT INTO `order` VALUES (6, '4028b8816d53b54b016d53b5792f0001', '5a04276b87724632a5ced68fda0d00b7', '111', 7, '2019-01-01 11:11:00', NULL, '2019-01-01 11:12:00', 3, NULL, 0, '2019-09-21 20:04:25');
INSERT INTO `order` VALUES (7, '4028b8816d53b9de016d53b9dee60000', '5a04276b87724632a5ced68fda0d00b7', '111', 0, '2019-01-01 11:11:00', NULL, '2019-01-01 11:12:00', 0, NULL, 0, '2019-09-21 20:09:13');
INSERT INTO `order` VALUES (8, '4028b8816d53b9de016d53ba303a0001', '5a04276b87724632a5ced68fda0d00b7', '111', 0, '2019-01-01 11:11:00', NULL, '2019-01-01 11:12:00', 0, NULL, 0, '2019-09-21 20:09:34');
INSERT INTO `order` VALUES (9, '4028b8816d53bbc6016d53bbc6d30000', '5a04276b87724632a5ced68fda0d00b7', '111', 0, '2019-01-01 11:11:00', NULL, '2019-01-01 11:12:00', 0, NULL, 3, '2019-09-21 20:11:18');
INSERT INTO `order` VALUES (10, '4028b8816d53bff7016d53bff7ef0000', '5a04276b87724632a5ced68fda0d00b7', '111', 0, '2019-01-01 11:11:00', NULL, '2019-01-01 11:12:00', 0, NULL, 3, '2019-09-21 20:15:52');
INSERT INTO `order` VALUES (11, '4028b8816d53bff7016d53c05a6c0001', '5a04276b87724632a5ced68fda0d00b7', '111', 0, '2019-01-01 11:11:00', NULL, '2019-01-01 11:12:00', 3, NULL, 1, '2019-09-21 20:16:18');

-- ----------------------------
-- Table structure for order_image
-- ----------------------------
DROP TABLE IF EXISTS `order_image`;
CREATE TABLE `order_image`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单id，关联order表order_id',
  `pic_type_code` int(6) NOT NULL COMMENT '图片类型id,关联dict_pic_type的item_code',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '照片',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单图片信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_image
-- ----------------------------
INSERT INTO `order_image` VALUES (5, '1', 16, '/path/1.jpg', '无');
INSERT INTO `order_image` VALUES (6, '1', 16, '/path/2.jpg', '无');
INSERT INTO `order_image` VALUES (7, '1', 1, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (8, '1', 2, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (9, '1', 3, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (10, '1', 4, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (11, '1', 5, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (12, '1', 6, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (13, '1', 7, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (14, '1', 8, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (15, '1', 9, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (16, '1', 10, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (17, '1', 11, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (18, '1', 12, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (19, '1', 13, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (20, '1', 14, '/path/2.jpg', '11234123');
INSERT INTO `order_image` VALUES (21, '1', 15, '/path/2.jpg', '11234123');

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联订单记录表order_id',
  `staff_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '保洁阿姨选择',
  `actual_clean_date` datetime NULL DEFAULT NULL COMMENT '实际保洁时间',
  `is_first` int(1) NOT NULL DEFAULT 1 COMMENT '是否优先，0是，1否',
  `is_extra_bed` int(1) NOT NULL DEFAULT 1 COMMENT '是否有加床，0是，1否',
  `staff_cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '保洁阿姨费用',
  `boss_cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '保洁老板费用',
  `status` int(6) NOT NULL COMMENT '保洁单状态,关联dict_order_status表',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单保洁信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_record
-- ----------------------------
INSERT INTO `order_record` VALUES (4, '4028b8816d53b54b016d53b54b630000', NULL, '2019-09-21 20:56:02', 1, 1, NULL, 111.00, 0, NULL);
INSERT INTO `order_record` VALUES (5, '4028b8816d53b54b016d53b5792f0001', NULL, '2019-09-21 20:56:02', 1, 1, NULL, 111.00, 0, NULL);
INSERT INTO `order_record` VALUES (6, '4028b8816d53b9de016d53b9dee60000', NULL, '2019-09-21 20:56:02', 1, 1, NULL, 111.00, 0, NULL);
INSERT INTO `order_record` VALUES (7, '4028b8816d53b9de016d53ba303a0001', NULL, '2019-09-21 20:56:02', 1, 1, NULL, 111.00, 0, NULL);
INSERT INTO `order_record` VALUES (8, '4028b8816d53bbc6016d53bbc6d30000', NULL, '2019-09-21 20:56:02', 1, 1, NULL, 111.00, 0, NULL);
INSERT INTO `order_record` VALUES (9, '4028b8816d53bff7016d53bff7ef0000', NULL, '2019-09-21 20:56:02', 1, 1, NULL, 111.00, 0, NULL);
INSERT INTO `order_record` VALUES (10, '4028b8816d53bff7016d53c05a6c0001', NULL, '2019-09-21 20:56:02', 1, 1, NULL, 111.00, 3, NULL);

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
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_roomImage_hrp`(`homestay_id`, `room_id`, `pic_type_code`) USING BTREE COMMENT '同一个机构和房间的同一类型图片只能唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间图片信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_image
-- ----------------------------
INSERT INTO `room_image` VALUES (18, '5a04276b87724632a5ced68fda0d00b7', '111', 16, '/path/4028b8816d16c1de016d16c3760a0001.jpg', '1');
INSERT INTO `room_image` VALUES (19, '5a04276b87724632a5ced68fda0d00b7', '111', 1, '/path/4028b8816d16c1de016d16c3838f0002.jpg', '2');
INSERT INTO `room_image` VALUES (20, '5a04276b87724632a5ced68fda0d00b7', '111', 2, '/path/4028b8816d16c1de016d16c38e6f0003.jpg', '3');
INSERT INTO `room_image` VALUES (21, '5a04276b87724632a5ced68fda0d00b7', '111', 3, '/path/4028b8816d16c1de016d16c399900004.jpg', '4');
INSERT INTO `room_image` VALUES (22, '5a04276b87724632a5ced68fda0d00b7', '111', 4, '/path/4028b8816d16c1de016d16c3a31a0005.jpg', '5');
INSERT INTO `room_image` VALUES (23, '5a04276b87724632a5ced68fda0d00b7', '111', 5, '/path/4028b8816d16c1de016d16c3b0770006.jpg', '');
INSERT INTO `room_image` VALUES (24, '5a04276b87724632a5ced68fda0d00b7', '111', 6, '/path/4028b8816d16c1de016d16c3bac20007.jpg', '');
INSERT INTO `room_image` VALUES (25, '5a04276b87724632a5ced68fda0d00b7', '111', 7, '/path/4028b8816d16c1de016d16c3ce090008.jpg', '8');
INSERT INTO `room_image` VALUES (26, '5a04276b87724632a5ced68fda0d00b7', '111', 8, '/path/4028b8816d16c1de016d16c3de640009.jpg', '9');
INSERT INTO `room_image` VALUES (27, '5a04276b87724632a5ced68fda0d00b7', '111', 9, '/path/4028b8816d16c1de016d16c3f23c000a.jpg', '10');
INSERT INTO `room_image` VALUES (28, '5a04276b87724632a5ced68fda0d00b7', '111', 10, '/path/4028b8816d16c1de016d16c401be000b.jpg', '11');
INSERT INTO `room_image` VALUES (29, '5a04276b87724632a5ced68fda0d00b7', '111', 11, '/path/4028b8816d16c1de016d16c40db7000c.jpg', '12');
INSERT INTO `room_image` VALUES (30, '5a04276b87724632a5ced68fda0d00b7', '111', 12, '/path/4028b8816d16c1de016d16c41b99000d.jpg', '13');
INSERT INTO `room_image` VALUES (31, '5a04276b87724632a5ced68fda0d00b7', '111', 13, '/path/4028b8816d16c1de016d16c427e8000e.jpg', '14');
INSERT INTO `room_image` VALUES (32, '5a04276b87724632a5ced68fda0d00b7', '111', 14, '/path/4028b8816d16c1de016d16c43554000f.jpg', '15');
INSERT INTO `room_image` VALUES (33, '5a04276b87724632a5ced68fda0d00b7', '111', 15, '/path/4028b8816d16c1de016d16c43554000f.jpg', '15');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id(关联homestay_info表homestay_id)',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间编号,多少楼多少编号',
  `room_address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间地址',
  `open_method` int(1) NOT NULL COMMENT '开门方式：0密码锁：输入密码加#进入，1钥匙盒子',
  `is_permanent` int(1) NULL DEFAULT NULL COMMENT '是否永久有效,0是,1不是',
  `room_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '保洁密码(主要是针对保洁密码长期不变的客户)',
  `room_type` int(2) NOT NULL COMMENT '房间户型(一室、二室、三室等)',
  `room_decoration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间内摆设分几个区域：床上，沙发区域，厨房区域，卫生间区域',
  `need_washing_sheets` int(1) NOT NULL COMMENT '是否需要洗床单0需要，1不需要',
  `price` decimal(10, 2) NOT NULL COMMENT '收费价格',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注：找到房间的说明(一个房门里面两个房间或多个的情况)',
  `is_extra_bed` int(1) NULL DEFAULT NULL COMMENT '是否有加床，0是，1否',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unique_roomInfo_hr`(`homestay_id`, `room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '房间信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (5, '5a04276b87724632a5ced68fda0d00b7', '1212', '1212', 1, 0, '123', 0, NULL, 1, 123.00, NULL, 1);
INSERT INTO `room_info` VALUES (6, '5a04276b87724632a5ced68fda0d00b7', '111', '111', 0, 1, '111', 0, NULL, 0, 111.00, '无', 1);
INSERT INTO `room_info` VALUES (7, 'f782d9f1a4b243bd89367f4ff39cc327', '1111', '1111', 0, 0, '123', 0, NULL, 0, 123.00, NULL, 0);

-- ----------------------------
-- Table structure for room_nessities_reminder
-- ----------------------------
DROP TABLE IF EXISTS `room_nessities_reminder`;
CREATE TABLE `room_nessities_reminder`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `homestay_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '民宿id',
  `room_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间id',
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单id',
  `nessisties_id` int(6) NOT NULL COMMENT '不足物品代码，关联dict_daily_nessities表',
  `status` int(1) NULL DEFAULT NULL COMMENT '0已补充，1未补充',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '一次性物品不足提醒表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_nessities_reminder
-- ----------------------------
INSERT INTO `room_nessities_reminder` VALUES (1, '5a04276b87724632a5ced68fda0d00b7', '1212', '1', 0, 1, '1');
INSERT INTO `room_nessities_reminder` VALUES (2, '5a04276b87724632a5ced68fda0d00b7', '1212', '1', 1, 0, '1');

-- ----------------------------
-- Table structure for staff_commission
-- ----------------------------
DROP TABLE IF EXISTS `staff_commission`;
CREATE TABLE `staff_commission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人员id',
  `room_type` int(3) NOT NULL COMMENT '房间类型，关联dict_room_type表',
  `commission` decimal(10, 2) NOT NULL COMMENT '房间提成，房间成为一室、两室、三室等标准提成，如果在标准以外。另外加床另外加几元',
  `extra_fee` decimal(10, 2) NOT NULL COMMENT '加床费用',
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_staffCommission_sr`(`staff_id`, `room_type`) USING BTREE COMMENT '每个人每种类型房间只能唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁阿姨的提成' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff_commission
-- ----------------------------
INSERT INTO `staff_commission` VALUES (1, '4028b8816d097d91016d097e16220001', 0, 222.00, 222.00, NULL);

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
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `entry_time` datetime NOT NULL COMMENT '入职时间',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '照片',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_staffInfo_idNo`(`id_no`) USING BTREE COMMENT '身份证唯一',
  UNIQUE INDEX `unique_staffInfo_telphone`(`telphone`) USING BTREE COMMENT '手机号唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁阿姨信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff_info
-- ----------------------------
INSERT INTO `staff_info` VALUES (6, '4028b8816d097d91016d097e16220001', '张阿姨', 0, '13111111111', '420115199205033236', 'C4CA4238A0B923820DCC509A6F75849B', '2019-09-07 00:00:00', '/path/4028b8816d2081fe016d2081fe340000.jpg', '湖北省武汉市洪山区豹澥镇');
INSERT INTO `staff_info` VALUES (7, '4028b8816d3a0356016d3a0356630000', '测试2', 0, '13871030919', '42011519920503322X', 'F379EAF3C831B04DE153469D1BEC345E', '2019-09-16 00:00:00', NULL, '11');

-- ----------------------------
-- Table structure for staff_work_place
-- ----------------------------
DROP TABLE IF EXISTS `staff_work_place`;
CREATE TABLE `staff_work_place`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联staff_info中staff_id',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '保洁阿姨工作位置' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff_work_place
-- ----------------------------
INSERT INTO `staff_work_place` VALUES (1, '4028b8816d097d91016d097e16220001', '湖北省武汉市洪山区光谷广场');
INSERT INTO `staff_work_place` VALUES (2, '4028b8816d097d91016d097e16220001', '江汉区');
INSERT INTO `staff_work_place` VALUES (3, '4028b8816d097d91016d097e16220001', '湖北省武汉市洪山区光谷广场');
INSERT INTO `staff_work_place` VALUES (4, '4028b8816d097d91016d097e16220001', '湖北省武汉市洪山区光谷广场');

SET FOREIGN_KEY_CHECKS = 1;
