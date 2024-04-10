/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 50743
 Source Host           : localhost:3306
 Source Schema         : clubms

 Target Server Type    : MySQL
 Target Server Version : 50743
 File Encoding         : 65001

 Date: 10/04/2024 00:12:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `club_id` int(11) NULL DEFAULT NULL COMMENT '所属社团id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动描述',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_activity_club`(`club_id`) USING BTREE,
  INDEX `idx_activity_id_club_id_activityName`(`id`, `club_id`, `name`) USING BTREE,
  CONSTRAINT `fk_activity_club` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, 3, '每天一觉', '人不能不睡觉，到点了，该睡了', '2024-04-07 19:49:14', '2099-04-30 21:58:18');
INSERT INTO `activity` VALUES (2, 3, '早起计划', '早上八点前起来', '2024-04-06 21:59:07', '2024-06-15 21:59:14');
INSERT INTO `activity` VALUES (3, 3, '洛杉矶计划', '你见过凌晨四点的洛杉矶吗', '2024-04-06 21:59:47', '2024-07-28 21:59:52');
INSERT INTO `activity` VALUES (4, 4, '肯德基投资活动', 'VO50,带你走向共同富裕', '2024-04-06 22:02:01', '2024-06-23 22:02:05');
INSERT INTO `activity` VALUES (5, 5, '推歌活动', '在活动期间听的歌挑一首最好听的出来分享', '2024-04-06 22:03:14', '2024-05-19 22:03:18');
INSERT INTO `activity` VALUES (6, 1, '全国第二十届数学竞赛', '激发青年人的数学才能；引起青年对数学的兴趣；发现科技人才的后备军；促进各国数学教育的交流与发展。', '2023-11-11 03:11:11', '2063-11-11 03:11:11');

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `activity_id` int(11) NULL DEFAULT NULL COMMENT '活动id',
  `state` int(255) NULL DEFAULT 0 COMMENT '签到状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_attendance_user`(`user_id`) USING BTREE,
  INDEX `fk_attendance_activity`(`activity_id`) USING BTREE,
  CONSTRAINT `fk_attendance_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_attendance_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (1, 4, 1, 0);
INSERT INTO `attendance` VALUES (2, 5, 3, 1);
INSERT INTO `attendance` VALUES (3, 5, 4, 0);
INSERT INTO `attendance` VALUES (4, 5, 1, 1);

-- ----------------------------
-- Table structure for club
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社团名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社团简介',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动地点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_club_clubId_clubName`(`id`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES (1, '数学社', '探讨数学的奥妙，就加入数学社', '123456@qq.com', '数信学院院楼');
INSERT INTO `club` VALUES (2, '天文社', '去看星星，去看外星人', '654321@qq.com', '天文学院院楼');
INSERT INTO `club` VALUES (3, '睡教', '人一天应该睡多少小时才合适，快来加入我们探讨这个问题吧', '321789@qq.com', '广厦千万间');
INSERT INTO `club` VALUES (4, '金钱教', '宜家唔系我去揾钱，系钱来揾我', '1010101@qq.com', '金融学院对面的天桥底第二个摊位');
INSERT INTO `club` VALUES (5, '音乐社', '世界不能没有音乐', '0101010@qq.com', '音乐学院院楼');
INSERT INTO `club` VALUES (6, '电竞社', 'LOL、魔兽世界、星际争霸、CSGO、永杰无间', '12345678@qq.com', '电竞学院院楼532');
INSERT INTO `club` VALUES (7, '魔法社', '看过哈利波特吗，在我们这里人人都是hp', '5647281@qq.com', '霍格沃兹');
INSERT INTO `club` VALUES (8, '哲学社', '孟德斯鸠、拉康、海德格尔、黑格尔、加缪、尼采', '2332222@qq.com', '人文学院院楼323');
INSERT INTO `club` VALUES (9, '体育社', '感受运动的魅力', '23232323@qq.com', '泰山运动场');
INSERT INTO `club` VALUES (10, '旅游社', '这里有非常好看的小哥哥小姐姐，拥有良好的社团文化，每年还有三次旅游福利', '12121233@qq.com', '人文学院2222');
INSERT INTO `club` VALUES (11, '电影社', '这里聚集了许多热爱电影艺术的同学，有兴趣的同学过来看一下', '33333333@qq.com', '艺术学院2233');
INSERT INTO `club` VALUES (12, '向区基速石', '业入品克热花问正当当引标专行。党军油列又题此全文主所状单类。且件且史气派酸果米律美与最拉。精风图市七口切本改原本组由老面第易。住主之走组也利管本技年做六市研又大重。心打机则运议基格就更比民等联养。', 'f.wbjstob@qq.com', 'SCAU');
INSERT INTO `club` VALUES (13, '随便起的的社团', '和的南可响斗拉统院比支因将安线形称。便除今铁五满法引工持文往始结党斗住九。海展土美能治则现圆质世接民求。年说老前同将效和较要接信意者识。热候增局查干光干三参二力北月。', 'g.xtcpxbbd@qq.com', '随便');
INSERT INTO `club` VALUES (16, '测试添加社团4', '着成通第地响义五约识战铁条形际研几。命复切增处路许需土几往张角关。布更美儿都所包示全强内给老必铁名科。何称色各六万然是品同通称车文参段龙严。事的集马比速开置正社油素金严品反。为产来百毛西维圆利切即清记持始照。资高说起列心北土市着育百特而。', 'y.bsdbxr@qq.com', '14栋888');

-- ----------------------------
-- Table structure for clubapplication
-- ----------------------------
DROP TABLE IF EXISTS `clubapplication`;
CREATE TABLE `clubapplication`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL COMMENT '创建者',
  `club_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社团名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社团简介',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社团地点',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `state` int(11) NULL DEFAULT NULL COMMENT '0未审核 1 未通过 2通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clubapplication
-- ----------------------------

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `activity_id` int(11) NULL DEFAULT NULL COMMENT '活动id',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '缴费金额',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_payment_user`(`user_id`) USING BTREE,
  INDEX `fk_payment_activity`(`activity_id`) USING BTREE,
  CONSTRAINT `fk_payment_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_payment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (1, 5, 5, 5.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` int(11) NULL DEFAULT NULL COMMENT '角色（0普通用户，1管理员，2超级管理员）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_username`(`username`) USING BTREE,
  INDEX `idx_user_userId_username`(`id`, `username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'superAdmin', '123456', 2);
INSERT INTO `user` VALUES (2, 'admin1', '123456', 1);
INSERT INTO `user` VALUES (3, 'admin2', '123456', 1);
INSERT INTO `user` VALUES (4, 'Lnn', '123456', 0);
INSERT INTO `user` VALUES (5, 'Ljt', '123456', 0);
INSERT INTO `user` VALUES (6, 'LLL', '1234567', 0);
INSERT INTO `user` VALUES (7, 'LLL111', '1234567', 0);
INSERT INTO `user` VALUES (8, 'admin', '123456', 0);
INSERT INTO `user` VALUES (9, 'LLL11dqwwqdqw1', '12345dwqdwqd67', 0);
INSERT INTO `user` VALUES (10, 'LLLdqw1', '12345dwqdwqd67', 0);
INSERT INTO `user` VALUES (11, 'admin20', '123', 0);

-- ----------------------------
-- Table structure for user-activity
-- ----------------------------
DROP TABLE IF EXISTS `user-activity`;
CREATE TABLE `user-activity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `activity_id` int(11) NULL DEFAULT NULL COMMENT '活动id',
  `state` int(11) NULL DEFAULT 0 COMMENT '报名状态(0未审核，1未通过，2已通过)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user-activity_activity`(`activity_id`) USING BTREE,
  INDEX `idx_ua_userId_activityId`(`user_id`, `activity_id`) USING BTREE,
  CONSTRAINT `fk_user-activity_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user-activity_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user-activity
-- ----------------------------
INSERT INTO `user-activity` VALUES (1, 4, 4, 0);
INSERT INTO `user-activity` VALUES (2, 4, 3, 1);
INSERT INTO `user-activity` VALUES (3, 4, 1, 2);
INSERT INTO `user-activity` VALUES (4, 5, 3, 2);
INSERT INTO `user-activity` VALUES (5, 5, 4, 2);
INSERT INTO `user-activity` VALUES (6, 5, 1, 2);
INSERT INTO `user-activity` VALUES (7, 4, 6, 0);

-- ----------------------------
-- Table structure for user-club
-- ----------------------------
DROP TABLE IF EXISTS `user-club`;
CREATE TABLE `user-club`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `club_id` int(11) NULL DEFAULT NULL COMMENT '社团id',
  `authority` int(255) NULL DEFAULT 0 COMMENT '权限(二进制表示，0位查看成员信息，1位审核成员申请，2位活动全权管理)',
  `role` int(255) NULL DEFAULT NULL COMMENT '0社员，1社长',
  `state` int(11) NULL DEFAULT 0 COMMENT '(0未审核，1未通过，2通过)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user-club_club`(`club_id`) USING BTREE,
  INDEX `idx_uc_userId_clubId`(`user_id`, `club_id`) USING BTREE,
  CONSTRAINT `fk_user-club_club` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user-club_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user-club
-- ----------------------------
INSERT INTO `user-club` VALUES (1, 3, 1, 7, 0, 2);
INSERT INTO `user-club` VALUES (2, 5, 3, 13, 1, 2);
INSERT INTO `user-club` VALUES (3, 5, 5, 3, 0, 2);
INSERT INTO `user-club` VALUES (4, 5, 2, 1, 0, 0);
INSERT INTO `user-club` VALUES (5, 4, 4, 15, 1, 2);
INSERT INTO `user-club` VALUES (6, 4, 5, 15, 1, 2);
INSERT INTO `user-club` VALUES (7, 4, 6, 15, 1, 2);
INSERT INTO `user-club` VALUES (8, 5, 7, 9, 1, 2);
INSERT INTO `user-club` VALUES (9, 5, 8, 15, 1, 2);
INSERT INTO `user-club` VALUES (10, 6, 9, 15, 1, 2);
INSERT INTO `user-club` VALUES (11, 6, 10, 15, 1, 2);
INSERT INTO `user-club` VALUES (12, 1, 3, 1, 0, 2);
INSERT INTO `user-club` VALUES (13, 2, 3, 3, 0, 2);
INSERT INTO `user-club` VALUES (14, 3, 3, 3, 0, 2);
INSERT INTO `user-club` VALUES (15, 4, 3, 5, 0, 2);
INSERT INTO `user-club` VALUES (16, 6, 3, 7, 0, 2);
INSERT INTO `user-club` VALUES (17, 4, 13, 15, 1, 2);
INSERT INTO `user-club` VALUES (19, 5, 1, 15, 1, 2);
INSERT INTO `user-club` VALUES (21, 5, 16, 15, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
