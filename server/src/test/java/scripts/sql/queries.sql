# oldest user by creation date
SELECT * FROM user
WHERE created = (
    select min(created)
    from user
);

# counts app logs from all nodes
SELECT app, count(*) AS logs
FROM log
INNER JOIN node
ON node.uid = log.node
INNER JOIN app
ON app.name = node.app
GROUP BY app;

# computes average number of logs per node per minute
SELECT node, avg(logs)
FROM (
  SELECT node, count(*) as logs
  FROM log
  GROUP BY node, MINUTE(datetime)
) as stats
GROUP BY node;

# counts number of logs of some type for every node
SELECT node, type, count(*)
FROM log
GROUP BY node, type
HAVING type = 'APP';

# query user apps --
SELECT * FROM app a
INNER JOIN ownership o
ON o.name = o.app
WHERE o.user = '1';

# query app logs from date --
SELECT * FROM log
INNER JOIN node
ON node.uid = log.node
WHERE node.app = '1'
AND log.datetime > '2018-01-01';