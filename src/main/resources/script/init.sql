create table IF NOT EXISTS user
(
    id         char(64) unique     not null,
    name       varchar(255) unique not null,
    password   varchar(256)        not null,
    createTime timestamp           not null,
    lastModify timestamp           not null,
    PRIMARY KEY (id)
) engine = InnoDB;

create table if not exists tomato
(
    id         char(64) unique not null,
    createTime timestamp       not null,
    lastModify timestamp       not null,
    start      timestamp       not null,
    end        timestamp       not null,
    userId     char(64)        not null,
    statue     char(30)        not null,
    timeLength int unsigned default 0,
    primary key (id)
) engine = InnoDB;

create table if not exists plan
(
    id         char(64) unique not null,
    createTime timestamp       not null,
    lastModify timestamp       not null,
    finish     timestamp       not null,
    userId     char(64)        not null,
    subject    tinytext        not null,
    statue     char(30)        not null,
    primary key (id)
) engine = InnoDB;





