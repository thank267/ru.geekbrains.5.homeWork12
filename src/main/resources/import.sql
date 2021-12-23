DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int NOT NULL , title VARCHAR(255) NOT NULL, PRIMARY KEY (id));

INSERT INTO products (title, cost) VALUES ( 'Apple', 10 );
INSERT INTO products (title, cost) VALUES ( 'Banana', 20 );
INSERT INTO products (title, cost) VALUES ( 'Watermelon', 8 );
INSERT INTO products (title, cost) VALUES ( 'Orange', 12 );
INSERT INTO products (title, cost) VALUES ( 'Lemon', 13 );
INSERT INTO products (title, cost) VALUES ( 'Dragon fruit', 20 );
INSERT INTO products (title, cost) VALUES ( 'Blueberries', 15 );
INSERT INTO products (title, cost) VALUES ( 'Raspberry', 21 );
INSERT INTO products (title, cost) VALUES ( 'Strawberry', 18 );
INSERT INTO products (title, cost) VALUES ( 'Blackberry', 17 );
INSERT INTO products (title, cost) VALUES ( 'Apple x 2', 20 );
INSERT INTO products (title, cost) VALUES ( 'Banana x 2', 40 );
INSERT INTO products (title, cost) VALUES ( 'Watermelon x 2', 16 );
INSERT INTO products (title, cost) VALUES ( 'Orange x 2', 24 );
INSERT INTO products (title, cost) VALUES ( 'Lemon x 2', 26 );
INSERT INTO products (title, cost) VALUES ( 'Dragon fruit x 2', 40 );
INSERT INTO products (title, cost) VALUES ( 'Blueberries x 2', 30 );
INSERT INTO products (title, cost) VALUES ( 'Raspberry x 2', 42 );
INSERT INTO products (title, cost) VALUES ( 'Strawberry x 2', 36 );
INSERT INTO products (title, cost) VALUES ( 'Blackberry x 2', 34 );

DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE IF NOT EXISTS users (id bigserial, username varchar(30) NOT NULL UNIQUE, password varchar(80) NOT NULL, email varchar(50) UNIQUE, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS roles (id serial, name varchar(50) NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS users_roles (user_id bigint not null, role_id int not null, primary key (user_id, role_id), foreign key (user_id) references users (id), foreign key (role_id) references roles (id));

insert into roles (name) values ('ROLE_MANAGER'), ('ROLE_ADMIN'), ('ROLE_SUPER_ADMIN');

insert into users (username, password, email) values ('user', '$2a$12$.i4z6yExuo/tknIyX6WEtuvYBjW01hw5XctetihgvN7gR6JsuxXKi', 'user@gmail.com');
insert into users (username, password, email) values ('admin', '$2a$12$.i4z6yExuo/tknIyX6WEtuvYBjW01hw5XctetihgvN7gR6JsuxXKi', 'admin@gmail.com');
insert into users (username, password, email) values ('sadmin', '$2a$12$.i4z6yExuo/tknIyX6WEtuvYBjW01hw5XctetihgvN7gR6JsuxXKi', 'sadmin@gmail.com');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);
insert into users_roles (user_id, role_id) values (3, 3);
