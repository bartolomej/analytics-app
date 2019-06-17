import React from 'react';
import {makeStyles} from "@material-ui/core/styles/index";
import CircularProgress from '@material-ui/core/CircularProgress';

const useStyles = makeStyles(theme => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
  progress: {
    align: 'center',
    margin: theme.spacing(2),
  },
}));

export default () => {
  const classes = useStyles();
  return <CircularProgress className={classes.progress} />;
}