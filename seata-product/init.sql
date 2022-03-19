CREATE TABLE `t_product`
(
    product_id bigint unsigned not null
        primary key,
    count      int             null,
    version    int default 0   null,
    total      int             null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO t_product(product_id, count,version,total)
VALUES (5001, 0,0,10);