/* eslint-disable no-script-url */

import React from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Loading from '../components/Loading';
import Error from '../components/Error';
import Title from './Title';


const useStyles = makeStyles(theme => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
}));

export default ({title, loading, error, data, seeMore = true}) => {
  const classes = useStyles();

  if (loading) return <Loading/>;
  if (error) return <Error error={error}/>;

  return (
    <React.Fragment>
      <Title>{title}</Title>
      <Table size="big">
        <TableHead>
          <TableRow>
            <TableCell>Type</TableCell>
            <TableCell>Datetime</TableCell>
            <TableCell>Message</TableCell>
            <TableCell>Extra</TableCell>
            <TableCell>Node</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map(row => (
            <TableRow key={row.id}>
              <TableCell>{row.type}</TableCell>
              <TableCell>{new Date(row.datetime).toLocaleString()}</TableCell>
              <TableCell>{row.message}</TableCell>
              <TableCell>{row.extra}</TableCell>
              <TableCell>{row.node}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <div className={classes.seeMore}>
        {seeMore &&
        <Link color="primary" href="javascript:;">
          See more activity
        </Link>
        }
      </div>
    </React.Fragment>
  );
}
