import React from 'react';
import Typography from '@material-ui/core/Typography';
import {makeStyles} from "@material-ui/core/styles/index";

const useStyles = makeStyles(theme => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
  progress: {
    align: 'center',
    margin: theme.spacing(2),
  },
}));

export default error => {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Typography variant="h5" component="h3">
        {error.name}
      </Typography>
      <Typography component="p">
        {error.message}
      </Typography>
    </div>
  )
}