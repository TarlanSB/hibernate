DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS company;

DROP TABLE IF EXISTS profile;

DROP TABLE IF EXISTS users_chat;

CREATE TABLE chat
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE users_chat
(
    id BIGSERIAL PRIMARY KEY ,
    user_id BIGINT REFERENCES users (id),
    chat_id BIGINT REFERENCES chat (id),
    created_at TIMESTAMP NOT NULL ,
    created_by VARCHAR(128) NOT NULL
);

CREATE TABLE profile
(
    id BIGSERIAL PRIMARY KEY ,
    user_id BIGINT NOT NULL UNIQUE REFERENCES users (id),
    street VARCHAR(128),
    language CHAR(2)
);

CREATE TABLE profile
(
    id BIGSERIAL PRIMARY KEY ,
    user_id BIGINT NOT NULL UNIQUE REFERENCES users (id),
    street VARCHAR(128),
    language CHAR(2)
);

CREATE TABLE company
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

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

CREATE SEQUENCE users_id_seq
    owned by users.id;

DROP SEQUENCE users_id_seq;

CREATE TABLE all_sequence
(
    table_name VARCHAR(32) PRIMARY KEY,
    pk_value   BIGINT NOT NULL
);

