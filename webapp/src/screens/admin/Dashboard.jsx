import React, {useEffect, useState} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from '../../components/Chart';
import Logs from '../../components/Logs';
import {useStyles} from "../../styles/dashboard";
import {getRecentLogs, getInternalStats} from '../../api/AdminApi';

function createChartData(time, amount) {
  return { time, amount };
}

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
  const [logs, setLogs] = useState([{}]);
  const [stats, setStats] = useState([{time: 100, amount: 2}]);

  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  useEffect(() => {
    const fetchData = async () => {
      const logs = await getRecentLogs('ed715a73-4f35-4be2-b9ed-3b922850cbf6', 10);
      const stats = await getInternalStats('ed715a73-4f35-4be2-b9ed-3b922850cbf6', 'minute');
      setStats(stats);
      setLogs(logs);
    };
    fetchData();
  }, []);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Chart */}
        <Grid item xs={12} >
          <Paper className={fixedHeightPaper}>
            <Chart data={chartData} title="Log stats" yText="count"/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Logs title={'Recent activity'} data={logs}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}
