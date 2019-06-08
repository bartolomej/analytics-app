USE analytics;


-- USER INSERTS --

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('73383590-4ea4-43aa-9d19-2193a6ca2b53', 'bart', 'testPass1', '2019-01-01', 'bart.dev@mail.com', 'developer');

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('d2061265-ddbb-47f9-933f-1329190206b0', 'joshua', 'testPass2', '2019-10-02', 'joshua.dev@mail.com', 'developer');

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('6cfe737b-6147-4962-9e3c-9d6d52af8f45', 'alex', 'testPass3', '2014-01-03', 'alex.dev@mail.com', 'developer');

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('a2cb4e77-dea0-45b0-9091-662eefad669c', 'vitalik', 'testPass4', '2019-05-02', 'vitalik.buterin@mail.com', 'developer');

INSERT INTO user (uid, username, password, created, email, role)
VALUES ('4db8dfc5-6bd7-4a61-987c-ad62cbe8c5ad', 'casey', 'testPass5', '2012-01-01', 'casey.something@mail.com', 'manager');


-- APP INSERTS --

INSERT INTO app (name, url, description, created)
VALUES ('TestReactApp', 'reactapp.com', 'Test client UI application made with Reactjs', '2019-01-04');

INSERT INTO app (name, url, description, created)
VALUES ('CryptoExchange', 'bestcryptoexchange.com', 'Best crypto exchange of course', '2019-01-05');

INSERT INTO app (name, url, description, created)
VALUES ('SocialMediaApp', 'nextbigsocialmediaapp.com', 'Next generation of facebook #beatfb', '2018-01-06');


-- OWNERSHIP INSERTS --

INSERT INTO ownership (user, app, added)
VALUES ('73383590-4ea4-43aa-9d19-2193a6ca2b53', 'TestReactApp', '2019-01-02');

INSERT INTO ownership (user, app, added)
VALUES ('73383590-4ea4-43aa-9d19-2193a6ca2b53', 'CryptoExchange', '2019-01-03');

INSERT INTO ownership (user, app, added)
VALUES ('a2cb4e77-dea0-45b0-9091-662eefad669c', 'CryptoExchange', '2019-02-02');

INSERT INTO ownership (user, app, added)
VALUES ('d2061265-ddbb-47f9-933f-1329190206b0', 'CryptoExchange', '2019-01-02');

INSERT INTO ownership (user, app, added)
VALUES ('6cfe737b-6147-4962-9e3c-9d6d52af8f45', 'CryptoExchange', '2019-01-02');

INSERT INTO ownership (user, app, added)
VALUES ('d2061265-ddbb-47f9-933f-1329190206b0', 'SocialMediaApp', '2019-01-02');


-- NODE INSERTS --

INSERT INTO node (uid, url, created, app)
VALUES ('402665f2-489f-4434-b3e4-1a163702a944', 'api.bestcryptoexchange.com/admin', '2018-01-01', 'CryptoExchange');

INSERT INTO node (uid, url, created, app)
VALUES ('f4a51be0-2504-48ea-993d-554d8e9077b2', 'api.bestcryptoexchange.com/platform', '2018-01-02', 'CryptoExchange');

INSERT INTO node (uid, url, created, app)
VALUES ('1a3c5403-1f2d-49a3-b9ae-90062c3290ba', 'bestcryptoexchange.com', '2018-01-03', 'CryptoExchange');

INSERT INTO node (uid, url, created, app)
VALUES ('9063bc21-848a-4ee5-a657-4e9045659901', 'api.reactapp.com', '2018-01-03', 'TestReactApp');

INSERT INTO node (uid, url, created, app)
VALUES ('8b5bc1ea-a109-41a1-ad1a-72c2f558501f', 'api.nextbigsocialmediaapp.com', '2018-01-03', 'SocialMediaApp');

INSERT INTO node (uid, url, created, app)
VALUES ('31d1e46d-34ad-462c-a091-a6df40a66809', 'nextbigsocialmediaapp.com', '2018-01-03', 'SocialMediaApp');


-- GRAPH INSERTS --

INSERT INTO graph (from_node, to_node, created)
VALUES ('402665f2-489f-4434-b3e4-1a163702a944', 'f4a51be0-2504-48ea-993d-554d8e9077b2', '2019-01-01');

INSERT INTO graph (from_node, to_node, created)
VALUES ('1a3c5403-1f2d-49a3-b9ae-90062c3290ba', 'f4a51be0-2504-48ea-993d-554d8e9077b2', '2019-01-03');

INSERT INTO graph (from_node, to_node, created)
VALUES ('31d1e46d-34ad-462c-a091-a6df40a66809', '8b5bc1ea-a109-41a1-ad1a-72c2f558501f', '2019-01-02');


-- LOG INSERTS --

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:11:01', 'Request from 12.124.412', 'GET /admin/login', '402665f2-489f-4434-b3e4-1a163702a944');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('ERROR', '2019-01-01 10:11:42', 'Admin with username superSuperAdmin doesnt exist', 'POST /admin/login', '402665f2-489f-4434-b3e4-1a163702a944');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:12:32', 'Request from 12.124.41.32', 'GET /admin/login', '402665f2-489f-4434-b3e4-1a163702a944');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:01', 'Request from 12.124.21', 'GET /admin/login', '402665f2-489f-4434-b3e4-1a163702a944');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('ERROR', '2019-01-01 10:10:42', 'Password incorrect', 'POST /admin/login', '402665f2-489f-4434-b3e4-1a163702a944');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:32', 'Request from 192.124.41.32', 'GET /admin/login', '402665f2-489f-4434-b3e4-1a163702a944');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:11:01', 'Request from 12.124.412', 'GET /login', 'f4a51be0-2504-48ea-993d-554d8e9077b2');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('ERROR', '2019-01-01 10:11:42', 'User with username bartolomej doesnt exist', 'POST /login', 'f4a51be0-2504-48ea-993d-554d8e9077b2');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:12:32', 'Request from 12.124.41.32', 'POST /login', 'f4a51be0-2504-48ea-993d-554d8e9077b2');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:01', 'Request from 12.124.21', 'GET /dashboard', 'f4a51be0-2504-48ea-993d-554d8e9077b2');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('ERROR', '2019-01-01 10:10:42', 'Order cannot be fullfilled', 'POST /order', 'f4a51be0-2504-48ea-993d-554d8e9077b2');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:32', 'Request from 192.124.41.32', 'GET /dashboard', 'f4a51be0-2504-48ea-993d-554d8e9077b2');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:01', 'Request from 12.124.21', 'GET /profile', '8b5bc1ea-a109-41a1-ad1a-72c2f558501f');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('ERROR', '2019-01-01 10:10:42', 'Cannot update password', 'POST /profile', '8b5bc1ea-a109-41a1-ad1a-72c2f558501f');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:32', 'Request from 192.124.41.32', 'GET /profile', '8b5bc1ea-a109-41a1-ad1a-72c2f558501f');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:32', 'Request from 192.124.41.32', 'GET /test', '9063bc21-848a-4ee5-a657-4e9045659901');

INSERT INTO log (type, datetime, message, extra, node)
VALUES ('APP', '2019-01-01 10:10:32', 'Request from 192.124.41.32', 'GET /test', '9063bc21-848a-4ee5-a657-4e9045659901');


-- ADMIN INSERTS --

INSERT INTO admin (uid, username, password, created)
VALUES ('ed715a73-4f35-4be2-b9ed-3b922850cbf6', 'superadmin', 'superAdminPass', '2019-01-02');

INSERT INTO admin (uid, username, password, created)
VALUES ('6aaf0de5-3a45-4e7c-9ff0-931d9dbf873a', 'admin', 'adminPass', '2019-01-03');