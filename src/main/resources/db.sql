CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table public.departments(
                                   unique_id              bigserial constraint departments_pkey primary key,
                                   uuid                   uuid                     default uuid_generate_v4()    not null,
                                   created_timestamp      timestamp with time zone default statement_timestamp() not null,
                                   modified_timestamp     timestamp with time zone default statement_timestamp() not null,
                                   title         varchar(50) not null,
                                   leader        varchar(50) not null,
                                   is_deleted             boolean                  default false                 not null
);

create table public.students(
                                unique_id              bigserial constraint students_pkey primary key,
                                uuid                   uuid                     default uuid_generate_v4()    not null,
                                created_timestamp      timestamp with time zone default statement_timestamp() not null,
                                modified_timestamp     timestamp with time zone default statement_timestamp() not null,
                                first_name    varchar(50) not null,
                                last_name     varchar(50) not null,
                                department_id bigint not null,
                                is_deleted             boolean                  default false                 not null,
                                FOREIGN KEY(department_id) REFERENCES departments(unique_id)
);

create table public.log_event
(
    unique_id              bigserial constraint log_event_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    event_type               varchar                                              not null,
    table_name               varchar                                              not null,
    description              varchar
);



create table public.mail_condition
(
    unique_id              bigserial constraint mail_condition_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    address               varchar                                                 not null,
    condition             varchar                                                 not null
);