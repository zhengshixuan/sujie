/*
 Navicat Premium Data Transfer

 Source Server         : bsh
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : renren_security

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 08/09/2019 23:11:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'GMT+08:00');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', NULL, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016C88A5F0007874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'lianxq1566707526832', 1566744397721, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1566745200000, -1, 5, 'WAITING', 'CRON', 1565660771000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016C88A5F0007874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES (1, 'testTask', 'renren', '0 0/30 * * * ?', 0, '参数测试', '2019-08-13 09:44:32');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 181 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES (1, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 10:00:00');
INSERT INTO `schedule_job_log` VALUES (2, 1, 'testTask', 'renren', 0, NULL, 0, '2019-08-13 10:44:05');
INSERT INTO `schedule_job_log` VALUES (3, 1, 'testTask', 'renren', 0, NULL, 0, '2019-08-13 10:44:33');
INSERT INTO `schedule_job_log` VALUES (4, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 13:30:00');
INSERT INTO `schedule_job_log` VALUES (5, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 14:00:00');
INSERT INTO `schedule_job_log` VALUES (6, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 15:00:00');
INSERT INTO `schedule_job_log` VALUES (7, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 15:30:00');
INSERT INTO `schedule_job_log` VALUES (8, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 16:00:00');
INSERT INTO `schedule_job_log` VALUES (9, 1, 'testTask', 'renren', 0, NULL, 0, '2019-08-13 16:30:00');
INSERT INTO `schedule_job_log` VALUES (10, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 17:00:00');
INSERT INTO `schedule_job_log` VALUES (11, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 17:30:00');
INSERT INTO `schedule_job_log` VALUES (12, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-13 22:00:00');
INSERT INTO `schedule_job_log` VALUES (13, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-14 13:00:00');
INSERT INTO `schedule_job_log` VALUES (14, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-14 13:30:00');
INSERT INTO `schedule_job_log` VALUES (15, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-14 21:00:00');
INSERT INTO `schedule_job_log` VALUES (16, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-14 21:30:00');
INSERT INTO `schedule_job_log` VALUES (17, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-14 22:00:00');
INSERT INTO `schedule_job_log` VALUES (18, 1, 'testTask', 'renren', 0, NULL, 1, '2019-08-14 22:30:00');
INSERT INTO `schedule_job_log` VALUES (19, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-16 22:30:00');
INSERT INTO `schedule_job_log` VALUES (20, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-16 23:00:00');
INSERT INTO `schedule_job_log` VALUES (21, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-17 10:00:00');
INSERT INTO `schedule_job_log` VALUES (22, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-18 18:00:00');
INSERT INTO `schedule_job_log` VALUES (23, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-18 18:30:00');
INSERT INTO `schedule_job_log` VALUES (24, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-18 19:00:00');
INSERT INTO `schedule_job_log` VALUES (25, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-18 19:30:00');
INSERT INTO `schedule_job_log` VALUES (26, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-18 20:00:00');
INSERT INTO `schedule_job_log` VALUES (27, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-18 20:30:00');
INSERT INTO `schedule_job_log` VALUES (28, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-18 21:00:00');
INSERT INTO `schedule_job_log` VALUES (29, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 27, '2019-08-21 21:00:00');
INSERT INTO `schedule_job_log` VALUES (30, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-22 19:30:00');
INSERT INTO `schedule_job_log` VALUES (31, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-22 20:00:00');
INSERT INTO `schedule_job_log` VALUES (32, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-22 20:30:00');
INSERT INTO `schedule_job_log` VALUES (33, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-22 21:00:00');
INSERT INTO `schedule_job_log` VALUES (34, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-22 21:30:00');
INSERT INTO `schedule_job_log` VALUES (35, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-22 22:00:00');
INSERT INTO `schedule_job_log` VALUES (36, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-22 22:30:00');
INSERT INTO `schedule_job_log` VALUES (37, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-22 23:00:00');
INSERT INTO `schedule_job_log` VALUES (38, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-22 23:30:00');
INSERT INTO `schedule_job_log` VALUES (39, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 177, '2019-08-23 00:00:00');
INSERT INTO `schedule_job_log` VALUES (40, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 00:30:00');
INSERT INTO `schedule_job_log` VALUES (41, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 01:00:00');
INSERT INTO `schedule_job_log` VALUES (42, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 01:30:00');
INSERT INTO `schedule_job_log` VALUES (43, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 02:00:00');
INSERT INTO `schedule_job_log` VALUES (44, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 02:30:00');
INSERT INTO `schedule_job_log` VALUES (45, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-23 03:00:00');
INSERT INTO `schedule_job_log` VALUES (46, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 03:30:00');
INSERT INTO `schedule_job_log` VALUES (47, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-23 04:00:00');
INSERT INTO `schedule_job_log` VALUES (48, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 04:30:00');
INSERT INTO `schedule_job_log` VALUES (49, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 05:00:00');
INSERT INTO `schedule_job_log` VALUES (50, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-23 05:30:00');
INSERT INTO `schedule_job_log` VALUES (51, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-23 06:00:00');
INSERT INTO `schedule_job_log` VALUES (52, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-25 10:30:00');
INSERT INTO `schedule_job_log` VALUES (53, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-25 11:00:00');
INSERT INTO `schedule_job_log` VALUES (54, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-25 11:30:00');
INSERT INTO `schedule_job_log` VALUES (55, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-25 12:00:13');
INSERT INTO `schedule_job_log` VALUES (56, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-25 12:30:00');
INSERT INTO `schedule_job_log` VALUES (57, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-25 13:00:00');
INSERT INTO `schedule_job_log` VALUES (58, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 47, '2019-08-26 21:00:00');
INSERT INTO `schedule_job_log` VALUES (59, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-26 21:30:00');
INSERT INTO `schedule_job_log` VALUES (60, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-26 22:00:00');
INSERT INTO `schedule_job_log` VALUES (61, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-26 23:00:00');
INSERT INTO `schedule_job_log` VALUES (62, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-26 23:30:00');
INSERT INTO `schedule_job_log` VALUES (63, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-27 16:30:00');
INSERT INTO `schedule_job_log` VALUES (64, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-27 17:00:00');
INSERT INTO `schedule_job_log` VALUES (65, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-27 17:30:00');
INSERT INTO `schedule_job_log` VALUES (66, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-27 18:00:00');
INSERT INTO `schedule_job_log` VALUES (67, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-27 18:30:00');
INSERT INTO `schedule_job_log` VALUES (68, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-27 19:00:00');
INSERT INTO `schedule_job_log` VALUES (69, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 4, '2019-08-27 20:30:00');
INSERT INTO `schedule_job_log` VALUES (70, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-27 21:00:00');
INSERT INTO `schedule_job_log` VALUES (71, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-27 21:30:00');
INSERT INTO `schedule_job_log` VALUES (72, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-27 22:00:00');
INSERT INTO `schedule_job_log` VALUES (73, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-27 22:30:00');
INSERT INTO `schedule_job_log` VALUES (74, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-27 23:00:00');
INSERT INTO `schedule_job_log` VALUES (75, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 16, '2019-08-28 20:30:00');
INSERT INTO `schedule_job_log` VALUES (76, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-28 21:00:00');
INSERT INTO `schedule_job_log` VALUES (77, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-28 21:30:00');
INSERT INTO `schedule_job_log` VALUES (78, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-28 22:00:00');
INSERT INTO `schedule_job_log` VALUES (79, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-28 22:30:00');
INSERT INTO `schedule_job_log` VALUES (80, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-28 23:00:00');
INSERT INTO `schedule_job_log` VALUES (81, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-29 20:30:00');
INSERT INTO `schedule_job_log` VALUES (82, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 5, '2019-08-29 21:00:00');
INSERT INTO `schedule_job_log` VALUES (83, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-29 21:30:00');
INSERT INTO `schedule_job_log` VALUES (84, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-29 22:00:00');
INSERT INTO `schedule_job_log` VALUES (85, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-29 22:30:00');
INSERT INTO `schedule_job_log` VALUES (86, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 5, '2019-08-29 23:00:00');
INSERT INTO `schedule_job_log` VALUES (87, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-30 21:00:00');
INSERT INTO `schedule_job_log` VALUES (88, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-30 21:30:00');
INSERT INTO `schedule_job_log` VALUES (89, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 4, '2019-08-30 22:00:00');
INSERT INTO `schedule_job_log` VALUES (90, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-30 22:30:00');
INSERT INTO `schedule_job_log` VALUES (91, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-30 23:00:00');
INSERT INTO `schedule_job_log` VALUES (92, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-30 23:30:00');
INSERT INTO `schedule_job_log` VALUES (93, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 7, '2019-08-31 00:00:00');
INSERT INTO `schedule_job_log` VALUES (94, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-08-31 16:00:00');
INSERT INTO `schedule_job_log` VALUES (95, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-31 16:30:00');
INSERT INTO `schedule_job_log` VALUES (96, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-31 17:00:00');
INSERT INTO `schedule_job_log` VALUES (97, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-31 17:30:00');
INSERT INTO `schedule_job_log` VALUES (98, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-31 18:00:00');
INSERT INTO `schedule_job_log` VALUES (99, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-31 18:30:00');
INSERT INTO `schedule_job_log` VALUES (100, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-31 20:00:00');
INSERT INTO `schedule_job_log` VALUES (101, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-08-31 20:30:00');
INSERT INTO `schedule_job_log` VALUES (102, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-31 21:00:00');
INSERT INTO `schedule_job_log` VALUES (103, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-31 21:30:00');
INSERT INTO `schedule_job_log` VALUES (104, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-31 22:00:00');
INSERT INTO `schedule_job_log` VALUES (105, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-08-31 22:30:00');
INSERT INTO `schedule_job_log` VALUES (106, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-08-31 23:00:00');
INSERT INTO `schedule_job_log` VALUES (107, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-09-01 09:30:00');
INSERT INTO `schedule_job_log` VALUES (108, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 10:00:00');
INSERT INTO `schedule_job_log` VALUES (109, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 10:30:00');
INSERT INTO `schedule_job_log` VALUES (110, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-09-01 11:00:00');
INSERT INTO `schedule_job_log` VALUES (111, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 14:00:00');
INSERT INTO `schedule_job_log` VALUES (112, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 14:30:00');
INSERT INTO `schedule_job_log` VALUES (113, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 15:00:00');
INSERT INTO `schedule_job_log` VALUES (114, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-01 15:30:00');
INSERT INTO `schedule_job_log` VALUES (115, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 16:00:00');
INSERT INTO `schedule_job_log` VALUES (116, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-09-01 16:30:00');
INSERT INTO `schedule_job_log` VALUES (117, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 9, '2019-09-01 17:00:00');
INSERT INTO `schedule_job_log` VALUES (118, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 17:30:00');
INSERT INTO `schedule_job_log` VALUES (119, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-01 20:30:00');
INSERT INTO `schedule_job_log` VALUES (120, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 4, '2019-09-01 21:00:00');
INSERT INTO `schedule_job_log` VALUES (121, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-09-01 21:30:00');
INSERT INTO `schedule_job_log` VALUES (122, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-01 22:00:00');
INSERT INTO `schedule_job_log` VALUES (123, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-01 22:30:00');
INSERT INTO `schedule_job_log` VALUES (124, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-01 23:00:00');
INSERT INTO `schedule_job_log` VALUES (125, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-01 23:30:00');
INSERT INTO `schedule_job_log` VALUES (126, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 6, '2019-09-02 00:00:00');
INSERT INTO `schedule_job_log` VALUES (127, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-04 20:00:00');
INSERT INTO `schedule_job_log` VALUES (128, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-04 20:30:00');
INSERT INTO `schedule_job_log` VALUES (129, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-04 21:00:00');
INSERT INTO `schedule_job_log` VALUES (130, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-04 21:30:00');
INSERT INTO `schedule_job_log` VALUES (131, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-04 22:00:00');
INSERT INTO `schedule_job_log` VALUES (132, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-04 22:30:00');
INSERT INTO `schedule_job_log` VALUES (133, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 16, '2019-09-05 23:00:00');
INSERT INTO `schedule_job_log` VALUES (134, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-05 23:30:00');
INSERT INTO `schedule_job_log` VALUES (135, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 5, '2019-09-06 00:00:00');
INSERT INTO `schedule_job_log` VALUES (136, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 9, '2019-09-06 09:00:00');
INSERT INTO `schedule_job_log` VALUES (137, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-06 09:30:00');
INSERT INTO `schedule_job_log` VALUES (138, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-06 10:00:00');
INSERT INTO `schedule_job_log` VALUES (139, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-06 10:30:00');
INSERT INTO `schedule_job_log` VALUES (140, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-06 11:00:00');
INSERT INTO `schedule_job_log` VALUES (141, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-06 19:00:00');
INSERT INTO `schedule_job_log` VALUES (142, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-06 19:30:00');
INSERT INTO `schedule_job_log` VALUES (143, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-06 20:00:00');
INSERT INTO `schedule_job_log` VALUES (144, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-06 20:30:00');
INSERT INTO `schedule_job_log` VALUES (145, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-06 21:00:00');
INSERT INTO `schedule_job_log` VALUES (146, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-06 21:30:00');
INSERT INTO `schedule_job_log` VALUES (147, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-06 22:00:00');
INSERT INTO `schedule_job_log` VALUES (148, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-09-06 22:30:00');
INSERT INTO `schedule_job_log` VALUES (149, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-06 23:00:00');
INSERT INTO `schedule_job_log` VALUES (150, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 32, '2019-09-07 10:00:00');
INSERT INTO `schedule_job_log` VALUES (151, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-07 10:30:00');
INSERT INTO `schedule_job_log` VALUES (152, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-07 20:30:00');
INSERT INTO `schedule_job_log` VALUES (153, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-07 21:00:00');
INSERT INTO `schedule_job_log` VALUES (154, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-07 21:30:00');
INSERT INTO `schedule_job_log` VALUES (155, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-07 22:00:00');
INSERT INTO `schedule_job_log` VALUES (156, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-07 22:30:00');
INSERT INTO `schedule_job_log` VALUES (157, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-07 23:00:00');
INSERT INTO `schedule_job_log` VALUES (158, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-07 23:30:00');
INSERT INTO `schedule_job_log` VALUES (159, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-08 10:00:00');
INSERT INTO `schedule_job_log` VALUES (160, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 10:30:00');
INSERT INTO `schedule_job_log` VALUES (161, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-09-08 11:00:00');
INSERT INTO `schedule_job_log` VALUES (162, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 11:30:00');
INSERT INTO `schedule_job_log` VALUES (163, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 12:00:00');
INSERT INTO `schedule_job_log` VALUES (164, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-08 12:30:00');
INSERT INTO `schedule_job_log` VALUES (165, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-08 13:00:06');
INSERT INTO `schedule_job_log` VALUES (166, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 13:30:00');
INSERT INTO `schedule_job_log` VALUES (167, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 14:00:00');
INSERT INTO `schedule_job_log` VALUES (168, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 0, '2019-09-08 14:30:00');
INSERT INTO `schedule_job_log` VALUES (169, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 15:00:00');
INSERT INTO `schedule_job_log` VALUES (170, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-08 15:30:00');
INSERT INTO `schedule_job_log` VALUES (171, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 16:30:00');
INSERT INTO `schedule_job_log` VALUES (172, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-08 17:00:00');
INSERT INTO `schedule_job_log` VALUES (173, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 3, '2019-09-08 17:30:00');
INSERT INTO `schedule_job_log` VALUES (174, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-08 19:00:00');
INSERT INTO `schedule_job_log` VALUES (175, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 2, '2019-09-08 19:30:00');
INSERT INTO `schedule_job_log` VALUES (176, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 20:00:00');
INSERT INTO `schedule_job_log` VALUES (177, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 20:30:00');
INSERT INTO `schedule_job_log` VALUES (178, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 21:00:00');
INSERT INTO `schedule_job_log` VALUES (179, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 21:30:00');
INSERT INTO `schedule_job_log` VALUES (180, 1, 'testTask', 'renren', 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available', 1, '2019-09-08 22:00:00');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `param_key`(`param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统配置信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '人人开源集团', 0, 0);
INSERT INTO `sys_dept` VALUES (2, 1, '长沙分公司', 1, -1);
INSERT INTO `sys_dept` VALUES (3, 1, '上海分公司', 2, -1);
INSERT INTO `sys_dept` VALUES (4, 3, '技术部', 0, -1);
INSERT INTO `sys_dept` VALUES (5, 3, '销售部', 1, -1);
INSERT INTO `sys_dept` VALUES (6, 0, '第一人民医院', 1, 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典码',
  `value` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典值',
  `order_num` int(11) NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `type`(`type`, `code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '性别', 'sex', '0', '女', 0, NULL, 0);
INSERT INTO `sys_dict` VALUES (2, '性别', 'sex', '1', '男', 1, NULL, 0);
INSERT INTO `sys_dict` VALUES (3, '性别', 'sex', '2', '未知', 2, NULL, 0);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[1]', 19, '0:0:0:0:0:0:0:1', '2019-08-13 10:44:05');
INSERT INTO `sys_log` VALUES (2, 'admin', '立即执行任务', 'io.renren.modules.job.controller.ScheduleJobController.run()', '[1]', 16, '0:0:0:0:0:0:0:1', '2019-08-13 10:44:20');
INSERT INTO `sys_log` VALUES (3, 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"menuId\":41,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"保洁系统\",\"url\":\"www.baidu.com\",\"type\":1,\"icon\":\" fa-lg\",\"orderNum\":0}', 5, '0:0:0:0:0:0:0:1', '2019-08-13 10:47:42');
INSERT INTO `sys_log` VALUES (4, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '41', 9, '0:0:0:0:0:0:0:1', '2019-08-13 13:24:48');
INSERT INTO `sys_log` VALUES (5, 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '{\"userId\":2,\"username\":\"pjq\",\"password\":\"d2c5d4c174d4a7ed11db99cd1e66f3f9dac8defc50b414b0a144676747a2f9e9\",\"salt\":\"EQ0M0Rzdt57i31CXK4gk\",\"email\":\"1@qq.com\",\"mobile\":\"13871030919\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Aug 13, 2019 1:41:50 PM\",\"deptId\":1,\"deptName\":\"人人开源集团\"}', 77, '0:0:0:0:0:0:0:1', '2019-08-13 13:41:50');
INSERT INTO `sys_log` VALUES (6, 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"管理员\",\"deptId\":4,\"deptName\":\"技术部\",\"menuIdList\":[1,4,23,24,25,26],\"deptIdList\":[],\"createTime\":\"Aug 13, 2019 1:43:05 PM\"}', 27, '0:0:0:0:0:0:0:1', '2019-08-13 13:43:05');
INSERT INTO `sys_log` VALUES (7, 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '{\"userId\":2,\"username\":\"pjq\",\"salt\":\"EQ0M0Rzdt57i31CXK4gk\",\"email\":\"1@qq.com\",\"mobile\":\"13871030919\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Aug 13, 2019 1:41:50 PM\",\"deptId\":1,\"deptName\":\"人人开源集团\"}', 12, '0:0:0:0:0:0:0:1', '2019-08-13 13:43:18');
INSERT INTO `sys_log` VALUES (8, 'pjq', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":2,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"管理员管理\",\"url\":\"modules/sys/user.html\",\"type\":1,\"icon\":\"fa fa-newspaper-o\",\"orderNum\":1}', 11, '0:0:0:0:0:0:0:1', '2019-08-13 16:54:29');
INSERT INTO `sys_log` VALUES (9, 'admin', '修改密码', 'io.renren.modules.sys.controller.SysUserController.password()', '\"1\"', 11, '0:0:0:0:0:0:0:1', '2019-08-13 17:26:47');
INSERT INTO `sys_log` VALUES (10, 'admin', '修改密码', 'io.renren.modules.sys.controller.SysUserController.password()', '\"admin\"', 8, '0:0:0:0:0:0:0:1', '2019-08-13 17:26:52');
INSERT INTO `sys_log` VALUES (11, 'admin', '删除用户', 'io.renren.modules.sys.controller.SysUserController.delete()', '[2]', 9, '0:0:0:0:0:0:0:1', '2019-08-13 17:27:17');
INSERT INTO `sys_log` VALUES (12, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '30', 0, '0:0:0:0:0:0:0:1', '2019-08-13 21:24:21');
INSERT INTO `sys_log` VALUES (13, 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '30', 0, '0:0:0:0:0:0:0:1', '2019-08-13 21:25:12');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'fa fa-cog', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员管理', 'modules/sys/user.html', NULL, 1, 'fa fa-newspaper-o', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'modules/sys/role.html', NULL, 1, 'fa fa-user-secret', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'modules/sys/menu.html', NULL, 1, 'fa fa-th-list', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'druid/sql.html', NULL, 1, 'fa fa-bug', 4);
INSERT INTO `sys_menu` VALUES (6, 1, '定时任务', 'modules/job/schedule.html', NULL, 1, 'fa fa-tasks', 5);
INSERT INTO `sys_menu` VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:perms', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:perms', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'fa fa-sun-o', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'modules/sys/log.html', 'sys:log:list', 1, 'fa fa-file-text-o', 7);
INSERT INTO `sys_menu` VALUES (31, 1, '部门管理', 'modules/sys/dept.html', NULL, 1, 'fa fa-file-code-o', 1);
INSERT INTO `sys_menu` VALUES (32, 31, '查看', NULL, 'sys:dept:list,sys:dept:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (33, 31, '新增', NULL, 'sys:dept:save,sys:dept:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (34, 31, '修改', NULL, 'sys:dept:update,sys:dept:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (35, 31, '删除', NULL, 'sys:dept:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (36, 0, '民宿系统', NULL, NULL, 0, NULL, 0);
INSERT INTO `sys_menu` VALUES (38, 36, '运营者信息', '/modules/homestay/homestayList.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (39, 36, '保洁阿姨信息', '/modules/homestay/staffList.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (40, 36, '房间保洁记录', '/modules/homestay/roomCleanList.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (41, 36, '房间信息', '/modules/homestay/roomList.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (42, 36, '预排单', '/modules/homestay/preparOrder.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (43, 36, '派单', '/modules/homestay/sendOrder.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (44, 36, '会员充值', '/modules/homestay/charge.html', NULL, 1, NULL, 0);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', NULL, 4, '2019-08-13 13:43:05');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与部门对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 4);
INSERT INTO `sys_role_menu` VALUES (3, 1, 23);
INSERT INTO `sys_role_menu` VALUES (4, 1, 24);
INSERT INTO `sys_role_menu` VALUES (5, 1, 25);
INSERT INTO `sys_role_menu` VALUES (6, 1, 26);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '63e89f967920e659c226441b21b3701f707c02d0b6ee7e1f52c24ded62cb0dbe', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', 1, 1, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
