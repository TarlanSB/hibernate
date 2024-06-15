CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    firstname  VARCHAR(128),
    lastname   VARCHAR(128),
    birth_date DATE,
    username   VARCHAR(128) UNIQUE,
    role       VARCHAR(32),
    info       JSONB,
    company_id INT REFERENCES company (id)
);

CREATE TABLE company
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE SEQUENCE users_id_seq
    owned by users.id;

DROP SEQUENCE users_id_seq;

DROP TABLE IF EXISTS users;

CREATE TABLE all_sequence
(
    table_name VARCHAR(32) PRIMARY KEY,
    pk_value   BIGINT NOT NULL
);

