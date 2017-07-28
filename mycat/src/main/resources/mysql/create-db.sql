DROP TABLE IF EXISTS `travelrecord`;
CREATE TABLE `travelrecord` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `traveldate` date DEFAULT NULL COMMENT '交易日期',
  `fee` decimal(10,0) DEFAULT NULL COMMENT '费用',
  `days` int(11) DEFAULT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;