-- auto-generated definition
create table t_order
(
    id         int auto_increment
        primary key,
    product_id int null,
    constraint t_order_id_uindex
        unique (id)
);

-- auto-generated definition
create table undo_log
(
    id            bigint auto_increment
        primary key,
    branch_id     bigint       not null,
    xid           varchar(100) not null,
    context       varchar(128) not null,
    rollback_info longblob     not null,
    log_status    int          not null,
    log_created   datetime     not null,
    log_modified  datetime     not null,
    ext           varchar(100) null,
    constraint ux_undo_log
        unique (xid, branch_id)
)
    charset = utf8;