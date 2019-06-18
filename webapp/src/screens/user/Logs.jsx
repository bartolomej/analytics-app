import React, {useEffect, useState} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Logs from '../../components/Logs';
import {useStyles} from "../../styles/dashboard";
import {getCoworkers, getAllLogs} from "../../api/UserApi";


export default () => {
  const classes = useStyles();

  const [logs, setLogs] = useState({loading: true, error: null, data: []});

  useEffect(() => {
    const uid = '73383590-4ea4-43aa-9d19-2193a6ca2b53';
    const fetchData = async () => {
      const userRes = await getAllLogs(uid, 10)
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
            <Logs title={'Platform logs'} data={logs.data}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}