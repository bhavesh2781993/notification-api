create sequence seq_templates start with 1 increment by 10;

create table templates
(
    template_id       bigint not null,
    name              varchar(255),
    body              varchar(255),
    body_vars         jsonb,
    template_owner_id varchar(255),
    created_at        timestamp(6),
    last_modified_at  timestamp(6),
    created_by        varchar(255),
    last_modified_by  varchar(255),
    primary key (template_id)
);

alter table if exists templates
    add constraint fk_template_owner_id
        foreign key (template_owner_id)
            references clients;