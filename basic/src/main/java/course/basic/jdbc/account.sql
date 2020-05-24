CREATE TABLE `tb_user` (
`id`  bigint NOT NULL AUTO_INCREMENT ,
`name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`age`  int NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=DYNAMIC
;

insert into tb_user(`name`,`age`) values('zhang san',20),('li si',22),('wang wu',33),('zhao liu',44);

create table if not exists `tb_account`(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `account_id`      VARCHAR(64)         NOT NULL DEFAULT '' COMMENT 'account id',
    `account_name`    VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '账户名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='账户表';

insert into tb_account(`account_name`,`account_id`) values('ahahah','1111'),('BBBB','2222'),('ccccc','3333'),('dddddd','44444');