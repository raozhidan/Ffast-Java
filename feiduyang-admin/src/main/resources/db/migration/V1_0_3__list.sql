-- -----------------------------------------------------
-- Table `ffast`.`t_product_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `t_product_info`;
CREATE TABLE  `ffast`.`t_product_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_name` VARCHAR(45) NULL,
  `product_expiration_date` TINYINT(4) NULL COMMENT '有效期限（单位：月）',
  `product_price` DECIMAL(6,2) NULL COMMENT '产品价格（元）',
  `business_id` BIGINT(20) NULL COMMENT '所属商户',
  `product_type` TINYINT(4) NULL COMMENT '产品类型',
  `point_id` BIGINT(20) NULL COMMENT '所属点位',
  `product_discount` DECIMAL(3,2) NULL DEFAULT 1.00 COMMENT '产品折扣',
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '产品信息'
DEFAULT CHARACTER SET = utf8mb4
KEY_BLOCK_SIZE = 4;


-- -----------------------------------------------------
-- Table `ffast`.`t_business_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `t_business_info`;
CREATE TABLE  `ffast`.`t_business_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `business_no` VARCHAR(45) NULL COMMENT '商户编号',
  `business_name` VARCHAR(45) NULL COMMENT '商户名称',
  `business_person_name` VARCHAR(25) NULL COMMENT '商户联系人',
  `business_phone` VARCHAR(45) NULL COMMENT '商户联系电话',
  `business_channel_id` BIGINT(20) NULL COMMENT '商户所属渠道',
  `business_address` VARCHAR(45) NULL COMMENT '商户地址',
  `business_society_code` VARCHAR(45) NULL COMMENT '商户信用代码',
  `business_address_code` VARCHAR(20) NULL COMMENT '商户所在地区编码',
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `business_status` TINYINT(4) NULL COMMENT '商户状态',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '商户信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_point_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `t_point_info`;
CREATE TABLE  `ffast`.`t_point_info` (
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
  `point_charge_company` VARCHAR(45) NULL COMMENT '点位所属单位',
  `point_capacity` INT NULL COMMENT '点位规模（有多少辆车）',
  `point_status` TINYINT(4) NULL COMMENT '点位状态',
  `point_temporary_fee` DECIMAL(4,2) NULL COMMENT '点位临时停车费用',
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '商户的点位信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_channel_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `t_channel_info`;
CREATE TABLE  `ffast`.`t_channel_info` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `channel_name` VARCHAR(45) NULL COMMENT '渠道名称',
  `channel_no` VARCHAR(45) NULL COMMENT '渠道编号',
  `channe_rate` DECIMAL(4,2) NULL COMMENT '渠道费率（百分单位）',
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
 `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '渠道信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_rfid_tag_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `t_rfid_tag_info`;
CREATE TABLE  `ffast`.`t_rfid_tag_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tag_no` VARCHAR(45) NULL COMMENT '标签编号',
  `tag_reg_point_id` BIGINT(20) NULL COMMENT '标签注册点位',
  `tag_epc_code` VARCHAR(45) NULL COMMENT '标签EPC区码',
  `tag_tid_code` VARCHAR(45) NULL COMMENT '标签TID码',
  `tag_user_code` VARCHAR(45) NULL COMMENT '标签用户区码',
  `tag_reg_ip_address` VARCHAR(45) NULL COMMENT '标签注册ip',
  `tag_status` TINYINT(4) NULL COMMENT '标签状态',
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = 'RFID标签信息';


-- -----------------------------------------------------
-- Table `ffast`.`t_non_motorized_vehicle_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `t_non_motorized_vehicle_info`;
CREATE TABLE  `ffast`.`t_non_motorized_vehicle_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
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
DROP TABLE IF EXISTS `t_vehicle_owner_info`;
CREATE TABLE  `ffast`.`t_vehicle_owner_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
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
DROP TABLE IF EXISTS `t_vehicle_check_in_out_flow`;
CREATE TABLE  `ffast`.`t_vehicle_check_in_out_flow` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
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
DROP TABLE IF EXISTS `t_owner_product_info`;
CREATE TABLE  `ffast`.`t_owner_product_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
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
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE  `ffast`.`t_orders` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
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
DROP TABLE IF EXISTS `t_pay_flow`;
CREATE TABLE  `ffast`.`t_pay_flow` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creator_id` BIGINT(20) NULL COMMENT '创建人',
  `last_modifier_id` BIGINT(20) NULL COMMENT '更新人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `order_id` BIGINT(20) NULL COMMENT '订单id',
  `order_no` VARCHAR(45) NULL COMMENT '订单编号',
  `pay_money` DECIMAL(10,2) NULL COMMENT '支付金额',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '支付流水信息';
