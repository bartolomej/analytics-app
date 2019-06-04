USE analytics;


-- USER INSERTS --

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('1', 'testUser1', 'testPass1', '2019-01-01', 'test.user1@mail.com', 'dev');

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('2', 'testUser2', 'testPass2', '2019-01-02', 'test.user2@mail.com', 'dev');

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('3', 'testUser3', 'testPass3', '2019-01-03', 'test.user3@mail.com', 'dev');


-- APP INSERTS --

INSERT INTO app (name, url)
VALUES ('testApp1', 'testUrl1.com');

INSERT INTO app (name, url)
VALUES ('testApp2', 'testUrl2.com');


-- OWNERSHIP INSERTS --

INSERT INTO ownership (id, user, app, added)
VALUES ('1', '1', 'testApp1', '2019-01-01');

INSERT INTO ownership (id, user, app, added)
VALUES ('2', '2', 'testApp2', '2019-01-01');


-- NODE INSERTS --

INSERT INTO node (uid, url, created)
VALUES ('1', 'node1.com', "2018-01-01");

INSERT INTO node (uid, url, created)
VALUES ('2', 'node2.com', "2018-01-02");


-- GRAPH INSERTS --

INSERT INTO graph (uid, from_node, to_node, created)
VALUES ('1', '1', '2', '2019-01-01');


-- LOG INSERTS --

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01', 'Test app log for node 1', 'Test extra', '1');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('ERROR', '2019-01-01', 'Test error for node 1', 'Test extra', '1');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01', 'Test app log for node 2', 'Test extra', '2');


-- ADMIN INSERTS --

INSERT INTO admin (uid, username, password, created)
VALUES ('1', 'testAdmin1', 'testPass1', '2019-01-02');

INSERT INTO admin (uid, username, password, created)
VALUES ('2', 'testAdmin2', 'testPass2', '2019-01-02');