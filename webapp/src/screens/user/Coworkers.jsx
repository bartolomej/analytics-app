import React, {useEffect, useState} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from '../../components/Chart';
import Users from '../../components/Users';
import {useStyles} from "../../styles/dashboard";
import {getCoworkers} from "../../api/UserApi";


export default () => {
  const [users, setUsers] = useState({loading: true, error: null, data: []});

  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  useEffect(() => {
    const uid = '73383590-4ea4-43aa-9d19-2193a6ca2b53';
    const fetchData = async () => {
      const userRes = await getCoworkers(uid, 10)
        .catch(e => setUsers({loading: false, error: e, data: []}));
      if (userRes !== undefined) setUsers({loading: false, error: null, data: userRes});
    };
    fetchData();
  }, []);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Users title={'Coworkers'} data={users.data} edit={false}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}