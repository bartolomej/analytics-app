import React from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Logs from '../../components/Logs';
import {useStyles} from "../../styles/dashboard";


// Generate Order Data
function createLogData(type, datetime, message, extra, node) {
  return {type, datetime, message, extra, node};
}

function createChartData(time, amount) {
  return { time, amount };
}

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

const chartData = [
  createChartData('00:00', 0),
  createChartData('03:00', 300),
  createChartData('06:00', 600),
  createChartData('09:00', 800),
  createChartData('12:00', 1500),
  createChartData('15:00', 2000),
  createChartData('18:00', 2400),
  createChartData('21:00', 2400),
  createChartData('24:00', undefined),
];

export default () => {
  const classes = useStyles();

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Logs title={'Platform logs'} data={logData}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}