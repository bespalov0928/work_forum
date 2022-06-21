create table if not exists posts
(
    id          serial primary key,
    name        varchar(2000),
    description text,
    created     timestamp without time zone not null default now(),
    discussion  text
);

-- CREATE TABLE if not exists roles
-- (
--     id serial primary key,
--     name  VARCHAR(50) NOT NULL
--
-- );
CREATE TABLE if not exists authorities
(
    id serial primary key,
--     name  VARCHAR(50) NOT NULL
    authority  VARCHAR(50) NOT NULL

);

CREATE TABLE if not exists users
(
    id serial primary key,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  boolean default true,
    authority_id INTEGER REFERENCES authorities(id)
);



-- CREATE TABLE if not exists roles_users
-- (
--     role_id INTEGER   REFERENCES roles (id),
--     user_id INTEGER REFERENCES users (id)
--
-- );