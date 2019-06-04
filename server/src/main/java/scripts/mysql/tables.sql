USE analytics;

CREATE TABLE user (
    uid varchar(100) primary key,
    username varchar(30),
    password varchar(100),
    created date,
    email varchar(50),
    role varchar(30)
);

CREATE TABLE app (
    name varchar(10) primary key,
    url varchar(50),
    created date
);

CREATE TABLE ownership (
    id int auto_increment primary key,
    user varchar(100) not null,
    app varchar(10) not null,
    added date,
    FOREIGN KEY(user) REFERENCES user(uid),
    FOREIGN KEY(app) REFERENCES app(name)
);

CREATE TABLE log (
    id int auto_increment primary key,
    type varchar(50),
    datetime date,
    message varchar(50),
    extra varchar(100),
    node varchar(100)
);

CREATE TABLE admin (
    uid varchar(100) primary key,
    username varchar(30),
    password varchar(100),
    created date
);

CREATE TABLE node (
    uid varchar(100) primary key,
    url varchar(30),
    created date
);

CREATE TABLE graph (
    uid varchar(100) primary key,
    name varchar(50),
    from_node varchar(100),
    to_node varchar(100),
    created date,
    FOREIGN KEY(from_node) REFERENCES node(uid),
    FOREIGN KEY(to_node) REFERENCES node(uid)
);