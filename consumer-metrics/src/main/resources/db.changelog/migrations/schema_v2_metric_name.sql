-- liquibase formatted sql

-- changeset Andrey:1

CREATE TABLE t1_kafka.metric_names
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

