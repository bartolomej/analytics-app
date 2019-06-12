import React from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Apps from '../../components/Apps';
import Logs from '../../components/Logs';
import Nodes from '../../components/Nodes';
import {useStyles} from "../../styles/dashboard";
import * as AdminApi from "../../api/AdminApi";


// Generate Order Data
function createUserData(uid, email, username, password, role, created) {
  return {uid, email, username, password, role, created};
}

function createNodeData(uid, url, app, created, edges) {
  return { uid, url, app, created, edges };
}

function createAppData(name, url, description, created) {
  return {name, url, description, created};
}


function createLogData(type, datetime, message, extra, node, edges) {
  return {type, datetime, message, extra, node, edges};
}

const userData = [
  createUserData('db8dfc5-6bd7-4a61-987c-ad62cbe8c5ad', 'someuser@gmail.com', 'kiko', 'vsdfvfd', 'developer', '2019-01-02'),
  createUserData('db8dfc5-6bd7-4a61-987c-rqwrdsadwdas', 'otheruser@mail.com', 'markkk', 'casdcsd', 'developer', '2019-02-05'),
];

const appData = [
  createAppData('CryptoExchange', 'exchange.com', 'Best crypto exchange app ', '16 Mar, 2019'),
  createAppData('SomeApp', 'someApp.com', 'Best random app ever ', '16 Mar, 2019'),
];

const logData = [
  createLogData('ERROR', '16 Mar, 2019', 'Order cannot be fullfilled ', 'GET /admin/login', 'bestcryptoexchange.com ', 312.44),
  createLogData('APP', '16 Mar, 2019', 'Request from 12.124.412 ', 'POST /admin/login', 'bestcryptoexchange.com', 866.99),
  createLogData('APP', '16 Mar, 2019', 'Order cannot be fullfilled ', 'PUT /admin/admin', 'bestcryptoexchange.com ', 100.81),
  createLogData('INFO', '16 Mar, 2019', 'Request from 12.124.412 ', 'GET /admin/login', 'bestcryptoexchange.com ', 654.39),
  createLogData('ERROR', '15 Mar, 2019', 'Order cannot be fullfilled ', 'GET /admin/user', 'bestcryptoexchange.com' , 212.79),
  createLogData('ERROR', '16 Mar, 2019', 'Order cannot be fullfilled ', 'GET /admin/login', 'bestcryptoexchange.com ', 312.44),
  createLogData('APP', '16 Mar, 2019', 'Request from 12.124.412 ', 'POST /admin/login', 'bestcryptoexchange.com', 866.99),
  createLogData('APP', '16 Mar, 2019', 'Order cannot be fullfilled ', 'PUT /admin/admin', 'bestcryptoexchange.com ', 100.81),
  createLogData('INFO', '16 Mar, 2019', 'Request from 12.124.412 ', 'GET /admin/login', 'bestcryptoexchange.com ', 654.39),
  createLogData('ERROR', '15 Mar, 2019', 'Order cannot be fullfilled ', 'GET /admin/user', 'bestcryptoexchange.com' , 212.79),
  createLogData('ERROR', '16 Mar, 2019', 'Order cannot be fullfilled ', 'GET /admin/login', 'bestcryptoexchange.com ', 312.44),
  createLogData('APP', '16 Mar, 2019', 'Request from 12.124.412 ', 'POST /admin/login', 'bestcryptoexchange.com', 866.99),
  createLogData('APP', '16 Mar, 2019', 'Order cannot be fullfilled ', 'PUT /admin/admin', 'bestcryptoexchange.com ', 100.81),
  createLogData('INFO', '16 Mar, 2019', 'Request from 12.124.412 ', 'GET /admin/login', 'bestcryptoexchange.com ', 654.39),
  createLogData('ERROR', '15 Mar, 2019', 'Order cannot be fullfilled ', 'GET /admin/user', 'bestcryptoexchange.com' , 212.79),
];

const nodeData = [
  createNodeData("db8dfc5-6bd7-4a61-987c-ad62cbe8c5ad", 'someurl.com', 'CryptoExchange', '2019-01-02', ['dasd', 'sdas']),
  createNodeData("db8dfc5-6bd7-4a61-987c-ad62cbe8c5ad", 'someurl.com', 'CryptoExchange', '2019-01-02', ['adas']),
  createNodeData("db8dfc5-6bd7-4a61-987c-ad62cbe8c5ad", 'someurl.com', 'CryptoExchange', '2019-01-02', [])
];

export default () => {
  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  (async function () {
    console.log(await AdminApi.getUsers("ed715a73-4f35-4be2-b9ed-3b922850cbf6"));
  })();

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Apps title={'Apps'} data={appData}/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Logs title={'Logs'} data={logData}/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Nodes title={'Nodes'} data={nodeData}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}