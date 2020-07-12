create table if not exists `sync_table_conf`(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `ant_id`      VARCHAR(64)         NOT NULL DEFAULT '' COMMENT 'account id',
    `ant_name`    VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '账户名称',
    `balance`     BIGINT(20)          NOT NULL DEFAULT 0  COMMENT '账户余额',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='账户表';

create table if not exists `sync_database_conf`(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `ant_id`      VARCHAR(64)         NOT NULL DEFAULT '' COMMENT 'account id',
    `ant_name`    VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '账户名称',
    `balance`     BIGINT(20)          NOT NULL DEFAULT 0  COMMENT '账户余额',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='账户表';


create table if not exists `sync_instance_conf`(
   `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
   `ant_id`      VARCHAR(64)         NOT NULL DEFAULT '' COMMENT 'account id',
   `ant_name`    VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '账户名称',
   `balance`     BIGINT(20)          NOT NULL DEFAULT 0  COMMENT '账户余额',
   PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='账户表';