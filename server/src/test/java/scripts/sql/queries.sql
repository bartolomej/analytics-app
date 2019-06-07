-- THIS QUERIES DEPEND ON TEST DATA IN FILE data.sql --


-- query all users --

SELECT * FROM user;


-- query user by uid --

SELECT * FROM user
WHERE user.uid = '1';


-- query admin by uid --

SELECT * FROM admin
WHERE admin.uid = '1';


-- query user apps --

SELECT * FROM app a
INNER JOIN ownership o
ON o.name = o.app
WHERE o.user = '1';


-- query app nodes --

SELECT * FROM node
WHERE node.app = 'testApp1';


-- query all app logs --

SELECT * FROM log l
INNER JOIN node n
ON n.uid = l.node
WHERE n.app = '1';


-- query app logs from date --

SELECT * FROM log l
INNER JOIN node n
ON n.uid = l.node
WHERE n.app = '1'
AND l.datetime > '2018-01-01';


-- query node logs --

SELECT * FROM log l
WHERE l.node = '1';