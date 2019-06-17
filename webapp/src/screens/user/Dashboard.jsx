import React, {useEffect, useState} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from '../../components/Chart';
import Logs from '../../components/Logs';
import {useStyles} from "../../styles/dashboard";
import {getRecentLogs, getInternalLogStats} from '../../api/AdminApi';


export default () => {
  const [logs, setLogs] = useState({loading: true, error: null, data: []});
  const [stats, setStats] = useState({loading: true, error: null, data: []});

  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  useEffect(() => {
    const uid = 'ed715a73-4f35-4be2-b9ed-3b922850cbf6';
    const fetchData = async () => {
      const logs = await getRecentLogs(uid, 10)
        .catch(e => setLogs({loading: false, error: e, data: []}));
      const stats = await getInternalLogStats(uid, 'minute')
        .catch(e => setStats({loading: false, error: e, data: []}));
      if (logs !== undefined) setLogs({loading: false, error: null, data: logs});
      if (stats !== undefined) setStats({loading: false, error: null, data: stats});
    };
    fetchData();
  }, []);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Chart */}
        <Grid item xs={12} >
          <Paper className={fixedHeightPaper}>
            <Chart
              data={stats.data}
              title="Internal Log statistics"
              yText="count"
              loading={stats.loading}
              error={stats.error}/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Logs
              title={'Recent activity'}
              loading={logs.loading}
              error={logs.error}
              data={logs.data}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}