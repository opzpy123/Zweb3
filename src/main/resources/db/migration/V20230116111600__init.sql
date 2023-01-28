create table ACT_USER
(
    ID            varchar(32),
    USER_NAME     varchar(255),
    USER_PASSWORD varchar(255),
    CREATE_DATE   DATETIME,
    CREATED_BY    varchar(32),
    UPDATE_DATE   DATETIME,
    UPDATED_BY    varchar(32),
    IS_DELETED    TINYINT(1) default 0,
    primary key (ID)
);

create table FILE_INFO
(
    ID               varchar(32),
    FILE_NAME        varchar(255),
    FILE_DESCRIPTION varchar(255),
    FILE_STORE_PATH  varchar(255),
    CREATE_DATE      DATETIME,
    CREATED_BY       varchar(32),
    UPDATE_DATE      DATETIME,
    UPDATED_BY       varchar(32),
    IS_DELETED       TINYINT(1) default 0,
    primary key (ID)
);