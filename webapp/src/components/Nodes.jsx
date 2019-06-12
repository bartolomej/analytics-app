/* eslint-disable no-script-url */

import React from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Title from './Title';


const useStyles = makeStyles(theme => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
}));

export default ({title, data}) => {
  const classes = useStyles();
  return (
    <React.Fragment>
      <Title>{title}</Title>
      <Table size="big">
        <TableHead>
          <TableRow>
            <TableCell>uid</TableCell>
            <TableCell>Url</TableCell>
            <TableCell>App</TableCell>
            <TableCell>Created</TableCell>
            <TableCell>Connections</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map(row => (
            <TableRow key={row.uid}>
              <TableCell>{row.uid}</TableCell>
              <TableCell>{row.url}</TableCell>
              <TableCell>{row.app}</TableCell>
              <TableCell>{row.created}</TableCell>
              <TableCell>{row.edges.length}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <div className={classes.seeMore}>
        <Link color="primary" href="javascript:;">
          See more activity
        </Link>
      </div>
    </React.Fragment>
  );
}
