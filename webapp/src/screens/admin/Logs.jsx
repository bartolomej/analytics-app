import React, {useState, useEffect} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Logs from '../../components/Logs';
import {useStyles} from "../../styles/dashboard";
import {getUserRegistrationStats, getInternalLogs} from "../../api/AdminApi";


export default () => {
  const [logs, setLogs] = useState({loading: true, error: null, data: []});

  const classes = useStyles();

  useEffect(() => {
    const uid = 'ed715a73-4f35-4be2-b9ed-3b922850cbf6';
    const fetchData = async () => {
      const userRes = await getInternalLogs(uid, 10)
        .catch(e => setLogs({loading: false, error: e, data: []}));
      if (userRes !== undefined) setLogs({loading: false, error: null, data: userRes});
    };
    fetchData();
  }, []);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Logs title={'Platform logs'} seeMore={false} data={logs.data}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}