create table clients
(
    client_id   varchar(255) not null,
    client_name varchar(255) unique,
    password    varchar(255),
    is_active   boolean,
    primary key (client_id)
);
