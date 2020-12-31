/*
Navicat MySQL Data Transfer

Source Server         : 118.31.187.222
Source Server Version : 50505
Source Host           : 118.31.187.222:3306
Source Database       : szcp_project

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-12-31 22:07:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `db_admin_user`;
CREATE TABLE `db_admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '所属角色（外键）',
  `organ_id` int(11) DEFAULT NULL COMMENT '机构(外键)',
  `admin_name` varchar(20) NOT NULL COMMENT '管理员名称',
  `admin_fullname` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `admin_phone` varchar(20) NOT NULL COMMENT '管理员手机号',
  `admin_password` varchar(200) NOT NULL COMMENT '管理员密码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `delete_status` int(2) DEFAULT 0 COMMENT '是否删除0: 未删除, 1表示删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_admin_user_id_uindex` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='管理用户信息表';

-- ----------------------------
-- Records of db_admin_user
-- ----------------------------
INSERT INTO `db_admin_user` VALUES ('1', '1', '1', 'administrator', '超级管理员', '17673132955', '69ea9e9cdafc9ed19beccc993e1da9b4', '2019-10-04 11:18:13', '2020-12-31 21:03:12', '2019-10-04 11:18:32', '0');
INSERT INTO `db_admin_user` VALUES ('2', '2', '1', 'admin', '杨永生', '18616959965', 'def0e4568a393af9aca7bfa3d54c5147', '2019-10-04 11:18:17', '2019-11-12 10:33:25', '2020-01-11 13:42:12', '0');

-- ----------------------------
-- Table structure for db_log
-- ----------------------------
DROP TABLE IF EXISTS `db_log`;
CREATE TABLE `db_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) NOT NULL COMMENT '管理端用户名',
  `operation` varchar(50) NOT NULL COMMENT '操作',
  `method` varchar(100) DEFAULT NULL COMMENT '执行方法',
  `params` varchar(500) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '操作时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_log_id_uindex` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_log
-- ----------------------------

-- ----------------------------
-- Table structure for db_menu
-- ----------------------------
DROP TABLE IF EXISTS `db_menu`;
CREATE TABLE `db_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT '父节点',
  `title` varchar(20) NOT NULL COMMENT '菜单名',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `href` varchar(100) DEFAULT NULL COMMENT '资源地址',
  `perms` varchar(500) DEFAULT NULL COMMENT '权限',
  `spread` varchar(10) DEFAULT NULL COMMENT 'true：展开，false：不展开',
  `sorting` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` int(2) DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_menus_id_uindex` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_menu
-- ----------------------------
INSERT INTO `db_menu` VALUES ('1', '0', '系统管理', 'ios-cog-outline', null, null, 'true', '1', '2019-06-26 12:27:52', '2020-02-04 23:02:05', '0');
INSERT INTO `db_menu` VALUES ('2', '1', '系统人员', 'ios-contacts-outline', 'sys/adminUser', null, 'true', '98', '2019-06-26 12:34:35', '2019-10-03 14:59:48', '0');
INSERT INTO `db_menu` VALUES ('3', '1', '菜单管理', 'ios-options', 'sys/menu', 'sys:menu', 'true', '97', '2019-06-26 12:39:28', '2019-08-04 10:38:36', '0');
INSERT INTO `db_menu` VALUES ('4', '1', '角色管理', 'logo-instagram', 'sys/role', 'sys:role', 'true', '96', '2019-06-26 12:41:50', '2019-08-04 10:41:23', '0');
INSERT INTO `db_menu` VALUES ('5', '1', '机构管理', 'md-keypad', 'sys/organ', null, 'true', '95', '2019-06-26 12:43:18', '2019-10-03 14:31:09', '0');
INSERT INTO `db_menu` VALUES ('6', '0', '首页', 'md-home', 'home', null, 'true', '9999', '2019-06-26 15:12:20', '2020-02-04 23:01:35', '0');
INSERT INTO `db_menu` VALUES ('7', '1', '图标查看', 'md-paper', 'sys/icon', null, 'true', '94', '2019-06-30 04:26:36', '2019-06-30 04:26:40', '0');
INSERT INTO `db_menu` VALUES ('8', '3', '查看', 'ios-apps', 'sys/menu/findMenuByMyRoleId', 'sys:menu:list', null, '100', '2019-06-30 17:28:29', '2019-08-04 11:31:02', '0');
INSERT INTO `db_menu` VALUES ('9', '3', '编辑', 'ios-apps', 'sys/menu/updateMenu', 'sys:menu:updateMenu', null, '80', '2019-06-30 18:36:32', '2019-08-04 11:15:35', '0');
INSERT INTO `db_menu` VALUES ('10', '2', '查看', 'ios-contacts-outline', 'sys/admin/findAdminUserList', 'sys:adminUser:list', null, '100', '2019-07-04 14:38:51', '2019-08-04 11:49:47', '0');
INSERT INTO `db_menu` VALUES ('11', '3', '添加', 'md-add-circle', 'sys/menu/addMenu', 'sys:menu:addMenu', null, '90', '2019-08-04 10:37:34', '2019-08-04 10:46:33', '0');
INSERT INTO `db_menu` VALUES ('12', '4', '查看', 'ios-apps', 'sys/role/findRoleList', 'sys:role:list', null, '100', '2019-08-04 10:41:13', '2019-08-04 11:45:31', '0');
INSERT INTO `db_menu` VALUES ('13', '4', '添加', 'md-add-circle', 'sys/role/addRole', 'sys:role:addRole', null, '90', '2019-08-04 10:46:02', '2019-08-04 10:46:17', '0');
INSERT INTO `db_menu` VALUES ('14', '2', '添加', '', 'sys/admin/addAdminUser', 'sys:admin:addAdminUser', null, '90', '2019-08-04 11:09:14', '2019-08-04 11:09:14', '0');
INSERT INTO `db_menu` VALUES ('15', '5', '查看', null, 'sys/organ/findOrganTree', 'sys:organ:list', null, '100', '2019-08-04 11:10:46', '2019-08-04 11:36:32', '0');
INSERT INTO `db_menu` VALUES ('16', '5', '添加', '', 'sys/organ/addOrgan', 'sys:organ:addOrgan', null, '90', '2019-08-04 11:11:12', '2019-08-04 11:11:12', '0');
INSERT INTO `db_menu` VALUES ('17', '5', '编辑', '', 'sys/organ/updateOrgan', 'sys:organ:updateOrgan', null, '80', '2019-08-04 11:12:11', '2019-08-04 11:12:11', '0');
INSERT INTO `db_menu` VALUES ('18', '4', '编辑', '', 'sys/role/updateRole', 'sys:role:updateRole', null, '80', '2019-08-04 11:18:37', '2019-08-04 11:18:37', '0');
INSERT INTO `db_menu` VALUES ('19', '4', '权限菜单', null, 'sys/menu/findMenuByRoleId', 'sys:menu:roleMenuList', null, '50', '2019-08-04 11:41:23', '2019-08-04 15:36:33', '0');
INSERT INTO `db_menu` VALUES ('20', '5', '删除', null, 'sys/organ/deleteOrgan', 'sys:organ:deleteOrgan', null, '70', '2019-08-04 11:43:16', '2019-08-04 15:46:46', '0');
INSERT INTO `db_menu` VALUES ('21', '2', '角色列表', '', 'sys/role/findRoleAllList', 'sys:role:allList', null, '50', '2019-08-04 11:48:14', '2019-08-04 11:48:14', '0');
INSERT INTO `db_menu` VALUES ('22', '4', '添加编辑菜单', '', 'sys/menu/addOrEditRoleMenuByIdArray', 'sys:menu:addOrEdit', null, '40', '2019-08-04 11:52:44', '2019-08-04 11:52:44', '0');
INSERT INTO `db_menu` VALUES ('23', '3', '删除', '', 'sys/menu/deleteMenu', 'sys:menu:deleteMenu', null, '70', '2019-08-04 11:53:41', '2019-08-04 11:53:41', '0');
INSERT INTO `db_menu` VALUES ('24', '2', '删除', '', 'sys/admin/deleteAdminUser', 'sys:admin:deleteAdminUser', null, '70', '2019-08-04 11:55:05', '2019-08-04 11:55:05', '0');
INSERT INTO `db_menu` VALUES ('25', '4', '删除', '', 'sys/role/deleteRole', 'sys:role:deleteRole', null, '70', '2019-08-04 11:56:04', '2019-08-04 11:56:04', '0');
INSERT INTO `db_menu` VALUES ('26', '2', '编辑', '', 'sys/admin/updateAdminUser', 'sys:admin:updateAdminUser', null, '80', '2019-08-04 11:56:55', '2019-08-04 11:56:55', '0');
INSERT INTO `db_menu` VALUES ('27', '2', '密码初始化', '', 'sys/admin/updatePasswordAdminUserInit', 'sys:admin:updatePasswordAdminUserInit', null, '40', '2019-09-26 20:10:55', '2019-09-26 20:10:55', '0');
INSERT INTO `db_menu` VALUES ('28', '2', '获取所有用户', '', 'sys/admin/findAllAdminUserList', 'sys:admin:findAllAdminUserList', null, '20', '2019-10-03 12:03:34', '2019-10-03 12:03:34', '0');
INSERT INTO `db_menu` VALUES ('29', '2', '修改密码', '', 'sys/admin/updatePasswordAdminUser', 'sys:admin:updatePasswordAdminUser', null, '10', '2020-01-09 17:20:56', '2020-01-09 17:20:56', '0');
INSERT INTO `db_menu` VALUES ('30', '2', '获取用户机构树', '', 'sys/organ/findOrganUserTree', 'sys:organ:findOrganUserTree', null, '10', '2020-01-09 17:20:56', '2020-01-09 17:20:56', '0');
INSERT INTO `db_menu` VALUES ('31', '2', '获取机构树上的用户', '', 'sys/admin/findAdminUserListByOrganId', 'sys:admin:findAdminUserListByOrganId', null, '10', '2020-01-09 17:20:56', '2020-01-09 17:20:56', '0');

-- ----------------------------
-- Table structure for db_organ
-- ----------------------------
DROP TABLE IF EXISTS `db_organ`;
CREATE TABLE `db_organ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父级ID',
  `organ_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `remake` varchar(255) DEFAULT NULL COMMENT '备注',
  `sorting` int(11) DEFAULT NULL COMMENT '排序',
  `level` int(2) DEFAULT NULL COMMENT '代表层次关系: 0 表示总节点',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` int(2) DEFAULT 0 COMMENT '是否删除 0 未删除 1 表示已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_organ_id_uindex` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_organ
-- ----------------------------
INSERT INTO `db_organ` VALUES ('1', null, '中国总部', null, '25', '0', '2019-06-26 12:45:54', '2020-12-31 20:30:45', '0');
INSERT INTO `db_organ` VALUES ('26', '1', '都是', '是', '1', null, '2020-12-30 00:01:14', '2020-12-30 00:13:16', '1');
INSERT INTO `db_organ` VALUES ('27', '1', '发送到', '的', '2', null, '2020-12-30 00:03:11', '2020-12-30 00:12:58', '1');
INSERT INTO `db_organ` VALUES ('28', '26', '认为', '的', '2', null, '2020-12-30 00:13:08', '2020-12-30 00:13:08', '0');
INSERT INTO `db_organ` VALUES ('29', '1', '上海分部', null, '1', null, '2020-12-31 20:13:44', '2020-12-31 20:30:54', '0');

-- ----------------------------
-- Table structure for db_role
-- ----------------------------
DROP TABLE IF EXISTS `db_role`;
CREATE TABLE `db_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_name` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '角色名称',
  `remark` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` int(2) DEFAULT 0 COMMENT '是否删除 0 未删除 1表示已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_role_ID_index` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='管理端角色表';

-- ----------------------------
-- Records of db_role
-- ----------------------------
INSERT INTO `db_role` VALUES ('1', '超级管理员', '管理员测试', '2019-10-03 02:10:27', '2019-10-03 02:10:24', '0');
INSERT INTO `db_role` VALUES ('2', '普通管理员', '配置管理菜单', '2019-10-03 02:10:29', '2020-12-31 20:32:05', '0');
INSERT INTO `db_role` VALUES ('4', '治安部', '环境配置', '2020-12-29 21:29:26', '2020-12-31 20:34:05', '0');
INSERT INTO `db_role` VALUES ('5', '普通用户', '普通用户', '2020-12-31 20:34:45', '2020-12-31 20:34:45', '0');

-- ----------------------------
-- Table structure for db_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `db_role_menu`;
CREATE TABLE `db_role_menu` (
  `menu_id` int(11) NOT NULL,
  `role_id` int(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_role_menu
-- ----------------------------
INSERT INTO `db_role_menu` VALUES ('1', '1');
INSERT INTO `db_role_menu` VALUES ('1', '2');
INSERT INTO `db_role_menu` VALUES ('1', '4');
INSERT INTO `db_role_menu` VALUES ('2', '1');
INSERT INTO `db_role_menu` VALUES ('2', '2');
INSERT INTO `db_role_menu` VALUES ('2', '4');
INSERT INTO `db_role_menu` VALUES ('3', '1');
INSERT INTO `db_role_menu` VALUES ('3', '2');
INSERT INTO `db_role_menu` VALUES ('3', '4');
INSERT INTO `db_role_menu` VALUES ('4', '1');
INSERT INTO `db_role_menu` VALUES ('4', '2');
INSERT INTO `db_role_menu` VALUES ('4', '4');
INSERT INTO `db_role_menu` VALUES ('5', '1');
INSERT INTO `db_role_menu` VALUES ('5', '2');
INSERT INTO `db_role_menu` VALUES ('5', '4');
INSERT INTO `db_role_menu` VALUES ('6', '1');
INSERT INTO `db_role_menu` VALUES ('6', '2');
INSERT INTO `db_role_menu` VALUES ('6', '4');
INSERT INTO `db_role_menu` VALUES ('6', '5');
INSERT INTO `db_role_menu` VALUES ('7', '1');
INSERT INTO `db_role_menu` VALUES ('7', '2');
INSERT INTO `db_role_menu` VALUES ('7', '4');
INSERT INTO `db_role_menu` VALUES ('8', '1');
INSERT INTO `db_role_menu` VALUES ('8', '2');
INSERT INTO `db_role_menu` VALUES ('8', '4');
INSERT INTO `db_role_menu` VALUES ('9', '1');
INSERT INTO `db_role_menu` VALUES ('9', '2');
INSERT INTO `db_role_menu` VALUES ('9', '4');
INSERT INTO `db_role_menu` VALUES ('10', '1');
INSERT INTO `db_role_menu` VALUES ('10', '2');
INSERT INTO `db_role_menu` VALUES ('10', '4');
INSERT INTO `db_role_menu` VALUES ('11', '1');
INSERT INTO `db_role_menu` VALUES ('11', '2');
INSERT INTO `db_role_menu` VALUES ('11', '4');
INSERT INTO `db_role_menu` VALUES ('12', '1');
INSERT INTO `db_role_menu` VALUES ('12', '2');
INSERT INTO `db_role_menu` VALUES ('12', '4');
INSERT INTO `db_role_menu` VALUES ('13', '1');
INSERT INTO `db_role_menu` VALUES ('13', '2');
INSERT INTO `db_role_menu` VALUES ('13', '4');
INSERT INTO `db_role_menu` VALUES ('14', '1');
INSERT INTO `db_role_menu` VALUES ('14', '2');
INSERT INTO `db_role_menu` VALUES ('14', '4');
INSERT INTO `db_role_menu` VALUES ('15', '1');
INSERT INTO `db_role_menu` VALUES ('15', '2');
INSERT INTO `db_role_menu` VALUES ('15', '4');
INSERT INTO `db_role_menu` VALUES ('16', '1');
INSERT INTO `db_role_menu` VALUES ('16', '2');
INSERT INTO `db_role_menu` VALUES ('16', '4');
INSERT INTO `db_role_menu` VALUES ('17', '1');
INSERT INTO `db_role_menu` VALUES ('17', '2');
INSERT INTO `db_role_menu` VALUES ('17', '4');
INSERT INTO `db_role_menu` VALUES ('18', '1');
INSERT INTO `db_role_menu` VALUES ('18', '2');
INSERT INTO `db_role_menu` VALUES ('18', '4');
INSERT INTO `db_role_menu` VALUES ('19', '1');
INSERT INTO `db_role_menu` VALUES ('19', '2');
INSERT INTO `db_role_menu` VALUES ('19', '4');
INSERT INTO `db_role_menu` VALUES ('20', '1');
INSERT INTO `db_role_menu` VALUES ('20', '2');
INSERT INTO `db_role_menu` VALUES ('20', '4');
INSERT INTO `db_role_menu` VALUES ('21', '1');
INSERT INTO `db_role_menu` VALUES ('21', '2');
INSERT INTO `db_role_menu` VALUES ('21', '4');
INSERT INTO `db_role_menu` VALUES ('22', '1');
INSERT INTO `db_role_menu` VALUES ('22', '2');
INSERT INTO `db_role_menu` VALUES ('22', '4');
INSERT INTO `db_role_menu` VALUES ('23', '1');
INSERT INTO `db_role_menu` VALUES ('23', '2');
INSERT INTO `db_role_menu` VALUES ('23', '4');
INSERT INTO `db_role_menu` VALUES ('24', '1');
INSERT INTO `db_role_menu` VALUES ('24', '2');
INSERT INTO `db_role_menu` VALUES ('24', '4');
INSERT INTO `db_role_menu` VALUES ('25', '1');
INSERT INTO `db_role_menu` VALUES ('25', '2');
INSERT INTO `db_role_menu` VALUES ('25', '4');
INSERT INTO `db_role_menu` VALUES ('26', '1');
INSERT INTO `db_role_menu` VALUES ('26', '2');
INSERT INTO `db_role_menu` VALUES ('26', '4');
INSERT INTO `db_role_menu` VALUES ('27', '1');
INSERT INTO `db_role_menu` VALUES ('27', '2');
INSERT INTO `db_role_menu` VALUES ('27', '4');
INSERT INTO `db_role_menu` VALUES ('28', '1');
INSERT INTO `db_role_menu` VALUES ('28', '2');
INSERT INTO `db_role_menu` VALUES ('28', '4');
INSERT INTO `db_role_menu` VALUES ('29', '1');
INSERT INTO `db_role_menu` VALUES ('29', '2');
INSERT INTO `db_role_menu` VALUES ('29', '4');
INSERT INTO `db_role_menu` VALUES ('30', '1');
INSERT INTO `db_role_menu` VALUES ('30', '2');
INSERT INTO `db_role_menu` VALUES ('30', '4');
INSERT INTO `db_role_menu` VALUES ('31', '1');
INSERT INTO `db_role_menu` VALUES ('31', '2');
INSERT INTO `db_role_menu` VALUES ('31', '4');
INSERT INTO `db_role_menu` VALUES ('32', '2');
INSERT INTO `db_role_menu` VALUES ('33', '2');
