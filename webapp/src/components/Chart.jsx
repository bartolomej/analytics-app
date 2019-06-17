import React from 'react';
import { LineChart, Line, XAxis, YAxis, Label, ResponsiveContainer } from 'recharts';
import Title from './Title';
import {makeStyles} from "@material-ui/core/styles/index";
import CircularProgress from '@material-ui/core/CircularProgress';
import Typography from '@material-ui/core/Typography';


const useStyles = makeStyles(theme => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
  progress: {
    align: 'center',
    margin: theme.spacing(2),
  },
}));

export default function Chart({title, data, yText, loading, error}) {
  const classes = useStyles();

  if (loading) return (
    <CircularProgress className={classes.progress} />
  );
  if (error) return (
    <div className={classes.root}>
      <Typography variant="h5" component="h3">
        {error.name}
      </Typography>
      <Typography component="p">
        {error.message}
      </Typography>
    </div>
  );

  return (
    <React.Fragment>
      <Title>{title}</Title>
      <ResponsiveContainer>
        <LineChart
          data={data}
          margin={{
            top: 16,
            right: 16,
            bottom: 0,
            left: 24,
          }}>
          <XAxis dataKey="time" />
          <YAxis>
            <Label angle={270} position="left" style={{ textAnchor: 'middle' }}>
              {yText}
            </Label>
          </YAxis>
          <Line type="monotone" dataKey="amount" stroke="#556CD6" dot={false} />
        </LineChart>
      </ResponsiveContainer>
    </React.Fragment>
  );
}
