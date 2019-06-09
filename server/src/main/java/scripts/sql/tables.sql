USE analytics;

CREATE TABLE user (
    uid varchar(100) primary key,
    username varchar(30),
    password varchar(100),
    created datetime,
    email varchar(50),
    role varchar(30)
);

CREATE TABLE app (
    name varchar(30) primary key,
    url varchar(100),
    description varchar(200),
    created datetime
);

CREATE TABLE node (
    uid varchar(100) primary key,
    url varchar(200),
    created datetime,
    app varchar(30),
    FOREIGN KEY(app) REFERENCES app(name)
);


CREATE TABLE ownership (
    id int auto_increment primary key,
    user varchar(100) not null,
    app varchar(100) not null,
    added datetime,
    FOREIGN KEY(user) REFERENCES user(uid),
    FOREIGN KEY(app) REFERENCES app(name)
);

CREATE TABLE log (
    id int auto_increment primary key,
    type varchar(50),
    datetime datetime,
    message varchar(100),
    extra varchar(1000),
    node varchar(100),
    FOREIGN KEY(node) REFERENCES node(uid)
);

CREATE TABLE admin (
    uid varchar(100) primary key,
    username varchar(30),
    password varchar(100),
    created datetime
);

CREATE TABLE graph (
    id int auto_increment primary key,
    from_node varchar(100),
    to_node varchar(100),
    created datetime,
    FOREIGN KEY(from_node) REFERENCES node(uid),
    FOREIGN KEY(to_node) REFERENCES node(uid)
);