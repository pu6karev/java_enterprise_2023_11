create table users (
                       id bigint not null,
                       created_at timestamp,
                       modified_at timestamp,
                       enabled boolean,
                       username varchar(255),
                       password varchar(255),
                       full_name varchar(255),
                       primary key (id)
);

create table authorities (
                             id bigint not null,
                             user_id bigint,
                             authority varchar(255)
);