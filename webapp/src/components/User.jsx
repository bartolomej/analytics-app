import React from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from "@material-ui/core/es/Button/Button";


const useStyles = makeStyles(theme => ({
  container: {
    margin: '10',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    flexWrap: 'wrap',
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 200,
  },
  dense: {
    marginTop: 19,
  },
  menu: {
    width: 200,
  },
}));

export default ({uid, username, password, email, role, created}) => {
  const classes = useStyles();

  const handleChange = name => event => {
    console.log('change ', event.target.value);
  };

  return (
    <form className={classes.container} noValidate autoComplete="off">
      <TextField
        id="standard-name"
        label="Uid"
        className={classes.textField}
        value={uid}
        onChange={handleChange('name')}
        margin="normal"/>
      <TextField
        id="standard-name"
        label="Username"
        className={classes.textField}
        value={username}
        onChange={handleChange('name')}
        margin="normal"/>
      <TextField
        id="standard-name"
        label="Password"
        className={classes.textField}
        value={password}
        onChange={handleChange('name')}
        margin="normal"/>
      <TextField
        id="standard-name"
        label="Email"
        className={classes.textField}
        value={email}
        onChange={handleChange('name')}
        margin="normal"/>
      <TextField
        id="standard-name"
        label="Role"
        className={classes.textField}
        value={role}
        onChange={handleChange('name')}
        margin="normal"/>
      {/*<Button
        type="submit"
        fullWidth
        variant="contained"
        color="primary"
        className={classes.submit}
        onClick={() => console.log("clicked")}>
        Submit
      </Button>*/}
    </form>
  );
}
