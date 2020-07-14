CREATE DATABASE IF NOT EXISTS blog CHARACTER SET utf8;
USE blog;

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(512) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `content` TEXT COLLATE utf8mb4_unicode_ci COMMENT '内容描述',
  `summary` TEXT COLLATE utf8mb4_unicode_ci,
  `icon` VARCHAR(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `post_count` INT(11) UNSIGNED DEFAULT '0' COMMENT '该分类的内容数量',
  `order_num` INT(11) DEFAULT NULL COMMENT '排序编码',
  `parent_id` BIGINT(32) UNSIGNED DEFAULT NULL COMMENT '父级分类的ID',
  `meta_keywords` VARCHAR(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'SEO关键字',
  `meta_description` VARCHAR(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'SEO描述内容',
  `created` DATETIME DEFAULT NULL COMMENT '创建日期',
  `modified` DATETIME DEFAULT NULL,
  `status` TINYINT(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '提问', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, '0');
INSERT INTO `category` VALUES ('2', '分享', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, '0');
INSERT INTO `category` VALUES ('3', '讨论', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, '0');
INSERT INTO `category` VALUES ('4', '建议', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, '0');

-- ----------------------------
-- Table structure for m_comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `content` LONGTEXT COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论的内容',
  `parent_id` BIGINT(32) DEFAULT NULL COMMENT '回复的评论ID',
  `post_id` BIGINT(32) NOT NULL COMMENT '评论的内容ID',
  `user_id` BIGINT(32) NOT NULL COMMENT '评论的用户ID',
  `vote_up` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '“顶”的数量',
  `vote_down` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '“踩”的数量',
  `level` TINYINT(2) UNSIGNED NOT NULL DEFAULT '0' COMMENT '置顶等级',
  `status` TINYINT(2) DEFAULT NULL COMMENT '评论的状态',
  `created` DATETIME NOT NULL COMMENT '评论的时间',
  `modified` DATETIME DEFAULT NULL COMMENT '评论的更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_comment
-- ----------------------------

-- ----------------------------
-- Table structure for m_post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` VARCHAR(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `content` LONGTEXT COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `edit_mode` VARCHAR(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '编辑模式：html可视化，markdown ..',
  `category_id` BIGINT(32) DEFAULT NULL,
  `user_id` BIGINT(32) DEFAULT NULL COMMENT '用户ID',
  `vote_up` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '支持人数',
  `vote_down` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '反对人数',
  `view_count` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '访问量',
  `comment_count` INT(11) NOT NULL DEFAULT '0' COMMENT '评论数量',
  `recommend` TINYINT(1) DEFAULT NULL COMMENT '是否为精华',
  `level` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '置顶等级',
  `status` TINYINT(2) DEFAULT NULL COMMENT '状态',
  `created` DATETIME DEFAULT NULL COMMENT '创建日期',
  `modified` DATETIME DEFAULT NULL COMMENT '最后更新日期',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_post
-- ----------------------------
INSERT INTO `post` VALUES ('1', 'Github上最值得学习的100个Java开源项目，涵盖各种技术栈！', ' 你有多久没好好学习一个开源项目了？\n\n你是否经常为找不到好的开源项目而烦恼？\n\n你是否为不知道怎么入手去看一个开源项目？\n\n你是否想看别人的项目学习笔记？\n\n你是否想跟着别人的项目搭建过程一步一步跟着做项目？\n\n为了让更多Java的开发者能更容易找到值得学习的开源项目，我搭建了这个Java开源学习网站，宗旨梳理Java知识，共享开源项目笔记。来瞧一瞧：\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/473f73a3eb6f471e8154620a9c1d5306.png] \n\n网站截图中可以看出，点击筛选条件组合之后，再点击搜索就会搜索出对应的开源项目。\n\n比如打开renren-fast项目，可以看到具体项目的信息，以及模块解析。\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/f74740692dab4d9c937cd56336ead1b4.png]\n\n这样，学习一个开源项目就不再费劲，每天学习一个开源项目，在不知不觉中提升技术水平！目前网站已经收录了近100个开源项目，让Java不再难懂！\n\n直接扫公众号下方的二维码，回复关键字【网站】即可获得网站的域名地址！\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/f58f7c6d038c4dfb99bd9cf40935392e.png]\n\n关注上方的公众号二维码\n\n回复【网站】即可获取项目域名地址。\n', '0', '1', '1', '0', '0', '5', '0', '1', '1', NULL, '2020-04-28 14:41:41', '2020-04-28 14:41:41');
INSERT INTO `post` VALUES ('2', '关注公众号：MarkerHub，一起学习Java', '关注学习：\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/f58f7c6d038c4dfb99bd9cf40935392e.png] ', '0', '1', '1', '0', '0', '3', '0', '1', '1', NULL, '2020-04-28 14:55:16', '2020-04-28 14:55:16');
INSERT INTO `post` VALUES ('3', '111111111111', '1222222222222222', '0', '1', '1', '0', '0', '1', '0', '0', '0', NULL, '2020-04-28 14:55:48', '2020-04-28 14:55:48');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` VARCHAR(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
  `password` VARCHAR(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `email` VARCHAR(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮件',
  `mobile` VARCHAR(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机电话',
  `point` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '积分',
  `sign` VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '个性签名',
  `gender` VARCHAR(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `wechat` VARCHAR(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信号',
  `vip_level` INT(32) DEFAULT NULL COMMENT 'vip等级',
  `birthday` DATETIME DEFAULT NULL COMMENT '生日',
  `avatar` VARCHAR(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
  `post_count` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '内容数量',
  `comment_count` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '评论数量',
  `status` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `lasted` DATETIME DEFAULT NULL COMMENT '最后的登陆时间',
  `created` DATETIME NOT NULL COMMENT '创建日期',
  `modified` DATETIME DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'MarkerHub', '96e79218965eb72c92a549dd5a330112', '11111@qq.com', NULL, '0', '关注公众号：MarkerHub，一起学Java！！', '0', NULL, '0', NULL, '/res/images/avatar/default.png', '0', '0', '0', '2020-04-28 14:54:11', '2020-04-28 14:37:24', NULL);
INSERT INTO `user` VALUES ('2', 'test007', '96e79218965eb72c92a549dd5a330112', '1111@qq.com', NULL, '0', NULL, '0', NULL, '0', NULL, '/res/images/avatar/default.png', '0', '0', '0', NULL, '2020-04-28 14:45:07', NULL);
INSERT INTO `user` VALUES ('3', 'test004', '96e79218965eb72c92a549dd5a330112', '144d11@qq.com', NULL, '0', NULL, '0', NULL, '0', NULL, '/res/images/avatar/default.png', '0', '0', '0', NULL, '2020-04-28 14:48:26', NULL);
INSERT INTO `user` VALUES ('4', 'test005', '96e79218965eb72c92a549dd5a330112', '144d15@qq.com', NULL, '0', NULL, '0', NULL, '0', NULL, '/res/images/avatar/default.png', '0', '0', '0', NULL, '2020-04-28 14:48:26', NULL);
INSERT INTO `user` VALUES ('5', 'test00756', '96e79218965eb72c92a549dd5a330112', '45454541@qq.com', NULL, '0', NULL, '0', NULL, '0', NULL, '/res/images/avatar/default.png', '0', '0', '0', NULL, '2020-04-28 14:53:49', NULL);

-- ----------------------------
-- Table structure for m_user_action
-- ----------------------------
DROP TABLE IF EXISTS `user_action`;
CREATE TABLE `user_action` (
  `id` VARCHAR(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `user_id` VARCHAR(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户ID',
  `action` VARCHAR(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '动作类型',
  `point` INT(11) DEFAULT NULL COMMENT '得分',
  `post_id` VARCHAR(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联的帖子ID',
  `comment_id` VARCHAR(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联的评论ID',
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_user_action
-- ----------------------------

-- ----------------------------
-- Table structure for m_user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NOT NULL,
  `post_id` BIGINT(20) NOT NULL,
  `post_user_id` BIGINT(20) NOT NULL,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_user_collection
-- ----------------------------

-- ----------------------------
-- Table structure for m_user_message
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `from_user_id` BIGINT(20) NOT NULL COMMENT '发送消息的用户ID',
  `to_user_id` BIGINT(20) NOT NULL COMMENT '接收消息的用户ID',
  `post_id` BIGINT(20) DEFAULT NULL COMMENT '消息可能关联的帖子',
  `comment_id` BIGINT(20) DEFAULT NULL COMMENT '消息可能关联的评论',
  `content` TEXT COLLATE utf8mb4_unicode_ci,
  `type` TINYINT(2) DEFAULT NULL COMMENT '消息类型',
  `created` DATETIME NOT NULL,
  `modified` DATETIME DEFAULT NULL,
  `status` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_user_message
-- ----------------------------
-- 签到表  ID username 签到时间
CREATE TABLE usersign (
	id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	USER VARCHAR(50) NOT NULL COMMENT '用户名',
	signTime DATE NOT NULL COMMENT '签到时间'
	) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT '签到表';
-- 登录表  ID username 登陆时间
CREATE TABLE userlog (
	id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	USER VARCHAR(50) NOT NULL COMMENT '用户名',
	logTime TIMESTAMP NOT NULL COMMENT '登陆时间'
	) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT '登录表';