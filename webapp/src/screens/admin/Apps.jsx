import React from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from '../../components/Chart';
import Apps from '../../components/Apps';
import {useStyles} from "../../styles/dashboard";


// Generate Order Data
function createAppData(name, url, description, created) {
  return {name, url, description, created};
}

function createChartData(time, amount) {
  return { time, amount };
}

const appData = [
  createAppData('CryptoExchange', 'exchange.com', 'Best crypto exchange app ', '16 Mar, 2019'),
  createAppData('SomeApp', 'someApp.com', 'Best random app ever ', '16 Mar, 2019'),
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
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Chart */}
        <Grid item xs={12} >
          <Paper className={fixedHeightPaper}>
            <Chart data={chartData}/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Apps title={'Regestered apps'} data={appData}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}
