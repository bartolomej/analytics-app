import React, {useEffect, useState} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from '../../components/Chart';
import Apps from '../../components/Apps';
import {useStyles} from "../../styles/dashboard";
import {getAppsStats, getAllApps} from "../../api/AdminApi";


export default () => {
  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  const [apps, setApps] = useState({loading: true, error: null, data: []});
  const [appStats, setAppStats] = useState({loading: true, error: null, data: []});

  useEffect(() => {
    const uid = 'ed715a73-4f35-4be2-b9ed-3b922850cbf6';
    const fetchData = async () => {
      const appsRes = await getAllApps(uid)
        .catch(e => setApps({loading: false, error: e, data: []}));
      const statsRes = await getAppsStats(uid, 'day')
        .catch(e => setAppStats({loading: false, error: e, data: []}));
      console.log('appRes ', appsRes);
      if (appsRes !== undefined) setApps({loading: false, error: null, data: appsRes});
      if (statsRes !== undefined) setAppStats({loading: false, error: null, data: statsRes});
    };
    fetchData();
  }, []);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Chart */}
        <Grid item xs={12} >
          <Paper className={fixedHeightPaper}>
            <Chart data={appStats.data}/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Apps title={'Registered apps'} data={apps.data}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}
