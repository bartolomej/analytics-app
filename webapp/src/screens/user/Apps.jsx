import React, {useState, useEffect} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from '../../components/Chart';
import Apps from '../../components/Apps';
import {useStyles} from "../../styles/dashboard";
import {getApps, getCoworkers} from "../../api/UserApi";


export default () => {
  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  const [apps, setApps] = useState({loading: true, error: null, data: []});

  useEffect(() => {
    const uid = '73383590-4ea4-43aa-9d19-2193a6ca2b53';
    const fetchData = async () => {
      const appsRes = await getApps(uid, 10)
        .catch(e => setApps({loading: false, error: e, data: []}));
      if (appsRes !== undefined) setApps({loading: false, error: null, data: appsRes});
    };
    fetchData();
  }, []);

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        {/* Recent Logs */}
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            <Apps title={'Your apps'} data={apps.data} enableGoTo={true}/>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
}
