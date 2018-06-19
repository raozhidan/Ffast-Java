
-- -----------------------------------------------------
-- Table `ffast`.`t_flyway_schema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_flyway_schema` (
  `installed_rank` INT(11) NOT NULL,
  `version` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `script` VARCHAR(1000) NOT NULL,
  `checksum` INT(11) NULL DEFAULT NULL,
  `installed_by` VARCHAR(100) NOT NULL,
  `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` INT(11) NOT NULL,
  `success` TINYINT(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  INDEX `t_flyway_schema_s_idx` (`success` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_attach`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_attach` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `path` VARCHAR(200) NOT NULL COMMENT '路径',
  `name` VARCHAR(50) NOT NULL COMMENT '附件名',
  `size` BIGINT(20) NULL DEFAULT NULL COMMENT '文件大小',
  `extention` VARCHAR(50) NULL DEFAULT NULL COMMENT '文件后缀',
  `count` INT(11) NULL DEFAULT '0' COMMENT '引用计数',
  `note` VARCHAR(200) NULL DEFAULT NULL COMMENT '备注',
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY USING BTREE (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '系统_附件'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_dict`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_dict` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `dict_type_id` BIGINT(20) NOT NULL COMMENT '类型ID',
  `code` VARCHAR(50) NULL DEFAULT NULL COMMENT '编号',
  `name` VARCHAR(50) NOT NULL COMMENT '名称',
  `parent_id` BIGINT(20) NULL DEFAULT NULL COMMENT '父节点',
  `is_sys` TINYINT(4) NULL DEFAULT NULL COMMENT '是否系统内置【是1、否0】',
  `weight` INT(11) NULL DEFAULT NULL COMMENT '排序',
  `note` VARCHAR(200) NULL DEFAULT NULL COMMENT '备注',
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY USING BTREE (`id`),
  INDEX `AK_uk_dict` USING BTREE (`dict_type_id` ASC, `code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '字典'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_dict_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_dict_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '字典类型id',
  `identity` VARCHAR(50) NOT NULL COMMENT '字典标识符',
  `code` VARCHAR(50) NULL DEFAULT NULL COMMENT '编号',
  `name` VARCHAR(50) NOT NULL COMMENT '名称',
  `array` INT(11) NULL DEFAULT NULL COMMENT '排序',
  `parent_id` BIGINT(20) NULL DEFAULT NULL COMMENT '父分类',
  `is_tree` TINYINT(4) NULL DEFAULT NULL COMMENT '是否为树',
  `is_sys` TINYINT(4) NULL DEFAULT NULL COMMENT '是否系统内置【是1、否0】',
  `weight` INT(11) NULL DEFAULT NULL,
  `note` VARCHAR(200) NULL DEFAULT NULL COMMENT '备注',
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY USING BTREE (`id`),
  INDEX `AK_uk_dict` USING BTREE (`identity` ASC, `code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '基础字典类型'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_log` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operation` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '用户操作',
  `content` VARCHAR(5000) CHARACTER SET 'utf8' NOT NULL DEFAULT '' COMMENT '日志内容',
  `creator_id` BIGINT(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户ID',
  `create_time` VARCHAR(50) CHARACTER SET 'utf8' NOT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL,
  `last_modify_time` VARCHAR(50) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1691
DEFAULT CHARACTER SET = utf8mb4
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_res`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_res` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(50) NOT NULL COMMENT '标题',
  `identity` VARCHAR(50) NULL DEFAULT NULL COMMENT '资源标识符',
  `url` VARCHAR(200) NULL DEFAULT NULL COMMENT '菜单url',
  `parent_id` BIGINT(20) NULL DEFAULT NULL COMMENT '父资源',
  `parent_ids` VARCHAR(200) NULL DEFAULT NULL COMMENT '父路径',
  `weight` INT(11) NULL DEFAULT NULL COMMENT '菜单权重',
  `icon` VARCHAR(50) NULL DEFAULT NULL COMMENT '菜单图标',
  `status` TINYINT(4) NULL DEFAULT NULL COMMENT '资源类型（1=显示2禁止0=隐藏）',
  `res_type` TINYINT(4) NOT NULL COMMENT '资源类型（1=菜单2=权限）',
  `note` VARCHAR(255) NULL DEFAULT NULL,
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `AK_U` USING BTREE (`identity` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 232
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '系统_资源'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(50) NOT NULL COMMENT '角色名称',
  `role` VARCHAR(50) NULL DEFAULT NULL COMMENT '角色标识',
  `description` VARCHAR(200) NOT NULL COMMENT '角色描述',
  `status` TINYINT(4) NOT NULL COMMENT '角色状态',
  `is_sys` TINYINT(4) NULL DEFAULT NULL COMMENT '是否内置',
  `main` VARCHAR(20) NULL DEFAULT NULL COMMENT '角色主页面',
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE INDEX `AK_U_Name` USING BTREE (`name` ASC),
  UNIQUE INDEX `AK_U_Role` USING BTREE (`role` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '系统_角色'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_role_res`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_role_res` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role_id` BIGINT(20) NOT NULL,
  `res_id` BIGINT(20) NOT NULL,
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE INDEX `AK_U` USING BTREE (`role_id` ASC, `res_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 61
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '系统_角色资源'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `name` VARCHAR(20) NULL DEFAULT NULL COMMENT '姓名',
  `status` INT(11) NOT NULL DEFAULT '1' COMMENT '用户状态【1启用、0禁用】',
  `pwd` VARCHAR(100) NOT NULL COMMENT '密码',
  `email` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
  `tel` VARCHAR(20) NULL DEFAULT NULL COMMENT '手机号码',
  `is_lock` TINYINT(4) NULL DEFAULT NULL COMMENT '是否锁定【1是、0否】',
  `lock_time` DATETIME NULL DEFAULT NULL COMMENT '锁定时间',
  `login_count` BIGINT(20) NULL DEFAULT NULL COMMENT '登录次数',
  `login_failure_count` BIGINT(20) NULL DEFAULT NULL COMMENT '失败次数',
  `login_ip` VARCHAR(100) NULL DEFAULT NULL COMMENT '登录Ip',
  `login_time` VARCHAR(50) NULL DEFAULT NULL COMMENT '登录时间',
  `note` VARCHAR(200) NULL DEFAULT NULL COMMENT '备注',
  `salt` VARCHAR(50) NULL DEFAULT NULL,
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY USING BTREE (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 70
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '系统_用户'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_sys_user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_sys_user_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` BIGINT(20) NOT NULL COMMENT '角色id',
  `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE INDEX `AK_U` USING BTREE (`role_id` ASC, `user_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '系统_用户角色'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `ffast`.`t_work_backlog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_work_backlog` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(50) NULL DEFAULT NULL COMMENT '名称',
  `content` VARCHAR(2000) NULL DEFAULT NULL COMMENT '内容',
  `pictures` VARCHAR(100) NULL DEFAULT NULL COMMENT '图片',
  `start_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '待办开始时间',
  `finish_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '待办完成时间',
  `from_module` TINYINT(4) NULL DEFAULT NULL COMMENT '来源模块',
  `from_id` BIGINT(20) NULL DEFAULT NULL COMMENT '来源id',
  `priority` TINYINT(4) NULL DEFAULT '0' COMMENT '优先级（0=一般1=重要）',
  `user_ids` VARCHAR(100) NULL DEFAULT NULL COMMENT '待办用户',
  `status` TINYINT(4) NULL DEFAULT '0' COMMENT '状态(0=未完成1=已完成)',
  `inform_days` INT(11) NULL DEFAULT NULL COMMENT '提前多少天提醒',
  `inform_enable` TINYINT(4) NULL DEFAULT '1' COMMENT '开启提醒',
  `inform_type` VARCHAR(20) NULL DEFAULT NULL COMMENT '通知渠道',
  `inform_status` TINYINT(4) NULL DEFAULT NULL COMMENT '通知状态（0=未通知1=已通知2=已提前通知）',
  `note` VARCHAR(50) NULL DEFAULT NULL COMMENT '备注',
  `creator_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` VARCHAR(20) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '待办事项';


-- -----------------------------------------------------
-- Table `ffast`.`t_product_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_product_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_name` VARCHAR(45) NULL,
  `product_expiration_date` TINYINT(4) NULL COMMENT '有效期限（单位：月）',
  `product_price` DECIMAL(6,2) NULL COMMENT '产品价格（元）',
  `business_id` BIGINT(20) NULL COMMENT '所属商户',
  `product_type` TINYINT(4) NULL COMMENT '产品类型',
  `point_id` BIGINT(20) NULL COMMENT '所属点位',
  `product_discount` DECIMAL(3,2) NULL DEFAULT 1.00 COMMENT '产品折扣',
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '产品信息'
DEFAULT CHARACTER SET = utf8mb4
KEY_BLOCK_SIZE = 4;


-- -----------------------------------------------------
-- Table `ffast`.`t_business_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_business_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `business_no` VARCHAR(45) NULL COMMENT '商户编号',
  `business_name` VARCHAR(45) NULL COMMENT '商户名称',
  `business_person_name` VARCHAR(25) NULL COMMENT '商户联系人',
  `business_phone` VARCHAR(45) NULL COMMENT '商户联系电话',
  `business_channel_id` BIGINT(20) NULL COMMENT '商户所属渠道',
  `business_address` VARCHAR(45) NULL COMMENT '商户地址',
  `business_society_code` VARCHAR(45) NULL COMMENT '商户信用代码',
  `business_address_code` VARCHAR(20) NULL COMMENT '商户所在地区编码',
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `business_status` TINYINT(4) NULL COMMENT '商户状态',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '商户信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_point_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_point_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `t_point_infocol1` VARCHAR(45) NULL,
  `point_name` VARCHAR(45) NULL COMMENT '点位名称',
  `point_no` VARCHAR(45) NULL COMMENT '点位编号',
  `point_address` VARCHAR(45) NULL COMMENT '点位地址',
  `point_address_code` VARCHAR(45) NULL COMMENT '点位地址编码',
  `point_device_no` VARCHAR(45) NULL COMMENT '点位设备编号',
  `point_business_id` BIGINT(20) NULL COMMENT '点位所属商户',
  `point_maintenance_person` VARCHAR(20) NULL COMMENT '点位维护人员',
  `point_maintenance_person_phone` VARCHAR(15) NULL COMMENT '点位维护人员电话',
  `point_charg_company` VARCHAR(45) NULL COMMENT '点位所属单位',
  `point_capacity` INT NULL COMMENT '点位规模（有多少辆车）',
  `point_status` TINYINT(4) NULL COMMENT '点位状态',
  `point_temporary_fee` DECIMAL(4,2) NULL COMMENT '点位临时停车费用',
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '商户的点位信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_channel_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_channel_info` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `channel_name` VARCHAR(45) NULL COMMENT '渠道名称',
  `channel_no` VARCHAR(45) NULL COMMENT '渠道编号',
  `channe_rate` DECIMAL(4,2) NULL COMMENT '渠道费率（百分单位）',
  `create_by` BIGINT(20) NULL COMMENT '创建人',
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` BIGINT(20) NULL COMMENT '更新人',
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '渠道信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_rfid_tag_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_rfid_tag_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tag_no` VARCHAR(45) NULL COMMENT '标签编号',
  `tag_reg_point_id` BIGINT(20) NULL COMMENT '标签注册点位',
  `tag_epc_code` VARCHAR(45) NULL COMMENT '标签EPC区码',
  `tag_tid_code` VARCHAR(45) NULL COMMENT '标签TID码',
  `tag_user_code` VARCHAR(45) NULL COMMENT '标签用户区码',
  `tag_reg_ip_address` VARCHAR(45) NULL COMMENT '标签注册ip',
  `tag_status` TINYINT(4) NULL COMMENT '标签状态',
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = 'RFID标签信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_non_motorized_vehicle_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_non_motorized_vehicle_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `vehicle_no` VARCHAR(45) NULL COMMENT '车辆编号',
  `vehicle_card_no` VARCHAR(45) NULL COMMENT '车牌号',
  `vehicle_tag_id` BIGINT(20) NULL COMMENT '车辆绑定的标签信息',
  `vehicle_owner_id` BIGINT(20) NULL COMMENT '所属车主',
  `vehicle_tag_no` VARCHAR(45) NULL COMMENT '绑定的标签编号',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '非机动车信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_vehicle_owner_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_vehicle_owner_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `owner_name` VARCHAR(25) NULL COMMENT '车主姓名',
  `owner_phone` VARCHAR(15) NULL COMMENT '车主电话',
  `owner_card_no` VARCHAR(18) NULL COMMENT '车主证件号',
  `owner_status` TINYINT(4) NULL COMMENT '车主状态',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '车主信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_vehicle_check_in_out_flow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_vehicle_check_in_out_flow` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `vehicle_id` BIGINT(20) NULL COMMENT '车辆id',
  `point_id` BIGINT(20) NULL COMMENT '进入场地id',
  `check_type` TINYINT(2) NULL COMMENT '进场还是出场（0 进场，1 出场）',
  `check_in_time` DATETIME NULL COMMENT '进场时间',
  `check_out_time` DATETIME NULL COMMENT '出场时间',
  `check_use_product_id` BIGINT(20) NULL DEFAULT 0 COMMENT '该车辆该次所使用的产品id（0 默认为不使用，即为临时停车）',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '车辆进出流水信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_owner_product_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_owner_product_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `point_id` BIGINT(20) NULL COMMENT '点位id',
  `product_id` BIGINT(20) NULL COMMENT '产品id',
  `vehicle_id` BIGINT(20) NULL COMMENT '车辆id',
  `owner_id` BIGINT(20) NULL COMMENT '车主id',
  `product_expiration_time` DATETIME NULL COMMENT '产品过期时间',
  `owner_product_status` TINYINT(4) NULL COMMENT '状态',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '车主购买的套餐产品信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_orders` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `order_no` VARCHAR(45) NULL COMMENT '订单编号',
  `product_id` BIGINT(20) NULL COMMENT '产品id',
  `product_name` VARCHAR(45) NULL COMMENT '产品名称',
  `order_status` TINYINT(4) NULL COMMENT '订单状态',
  `order_price` DECIMAL(10,2) NULL COMMENT '订单价格',
  `product_num` INT NULL COMMENT '产品数量',
  `owner_id` BIGINT(20) NULL COMMENT '购买用户',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '订单信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_pay_flow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`t_pay_flow` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `order_id` BIGINT(20) NULL COMMENT '订单id',
  `order_no` VARCHAR(45) NULL COMMENT '订单编号',
  `pay_money` DECIMAL(10,2) NULL COMMENT '支付金额',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '支付流水信息';


-- -----------------------------------------------------
-- Table `ffast`.`template 4`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ffast`.`template 4` (
  `create_by` BIGINT(20) NULL,
  `update_by` BIGINT(20) NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
