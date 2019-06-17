import React, {useEffect, useState} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Apps from '../../components/Apps';
import Logs from '../../components/Logs';
import Nodes from '../../components/Nodes';
import {useStyles} from "../../styles/dashboard";
import {getUser, getApps, getCoworkers} from "../../api/AdminApi";
import Users from "../../components/Users";
import User from "../../components/User";


export default ({match}) => {
  const [apps, setApps] = useState({loading: true, error: null, data: []});
  const [user, setUser] = useState({loading: true, error: null, data: []});
  const [coworkers, setCoworkers] = useState({loading: true, error: null, data: []});

  const classes = useStyles();

  useEffect(() => {
    const uid = 'ed715a73-4f35-4be2-b9ed-3b922850cbf6';
    const userUid = match.params.id;
    const fetchData = async () => {
      const appsRes = await getApps(uid, userUid)
        .catch(e => setApps({loading: false, error: e, data: []}));
      const userRes = await getUser(uid, userUid)
        .catch(e => setApps({loading: false, error: e, data: []}));
      const coworkersRes = await getCoworkers(uid, userUid)
        .catch(e => setApps({loading: false, error: e, data: []}));

      if (appsRes !== undefined) setApps({loading: false, error: null, data: appsRes});
      if (coworkersRes !== undefined) setCoworkers({loading: false, error: null, data: coworkersRes});
      if (userRes !== undefined) setUser({loading: false, error: null, data: userRes});
    };
    fetchData();
  }, []);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* User profile */}
        <User
          uid={user.data.uid}
          username={user.data.username}
          password={user.data.password}
          email={user.data.email}
          role={user.data.role}
        />
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Apps title={'Apps'} data={apps.data}/>
          </Paper>
        </Grid>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Users title={'Coworkers'} data={coworkers.data}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}