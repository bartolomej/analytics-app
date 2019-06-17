import React, {useEffect, useState} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from '../../components/Chart';
import Users from '../../components/Users';
import {useStyles} from "../../styles/dashboard";
import {getUsers, getUserRegistrationStats} from "../../api/AdminApi";


export default () => {
  const [users, setUsers] = useState({loading: false, error: null, data: []});
  const [userStats, setUserStats] = useState({loading: false, error: null, data: []});

  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
/*
  useEffect(() => {
    const uid = 'ed715a73-4f35-4be2-b9ed-3b922850cbf6';
    const fetchData = async () => {
      const userRes = await getUsers(uid, 10)
        .catch(e => setUsers({loading: false, error: e, data: []}));
      const statsRes = await getUserRegistrationStats(uid, 'minute')
        .catch(e => setUserStats({loading: false, error: e, data: []}));
      if (userRes !== undefined) setUsers({loading: false, error: null, data: userRes});
      if (statsRes !== undefined) setUserStats({loading: false, error: null, data: statsRes});
    };
    fetchData();
  }, []);
*/
  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Chart */}
        <Grid item xs={12}>
          <Paper className={fixedHeightPaper}>
            <Chart
              data={userStats.data}
              title="User registrations"
              yText="count"
              loading={userStats.loading}
              error={userStats.error}/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Users title={'Regestered users'} data={users.data}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}