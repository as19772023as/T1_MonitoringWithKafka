-- liquibase formatted sql

-- changeset Andrey:1

CREATE TABLE if not exists t1_kafka.base_unit
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);