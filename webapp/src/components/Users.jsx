import React from 'react';
import Link from '@material-ui/core/Link';
import EditIcon from '@material-ui/icons/Edit';
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

export default ({title, data, edit = true}) => {
  const classes = useStyles();
  return (
    <React.Fragment>
      <Title>{title}</Title>
      <Table size="big">
        <TableHead>
          <TableRow>
            <TableCell>uid</TableCell>
            <TableCell>Email</TableCell>
            <TableCell>Username</TableCell>
            <TableCell>Password</TableCell>
            <TableCell>Role</TableCell>
            <TableCell>Created</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map(row => (
            <TableRow key={row.uid}>
              <TableCell>{row.uid}</TableCell>
              <TableCell>{row.email}</TableCell>
              <TableCell>{row.username}</TableCell>
              <TableCell>{row.password}</TableCell>
              <TableCell>{row.role}</TableCell>
              <TableCell>{new Date(row.created).toLocaleString()}</TableCell>
              {edit && <TableCell><a href={`/admin/user/${row.uid}`}><EditIcon/></a></TableCell>}
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <div className={classes.seeMore}>
        <Link color="primary" href="javascript:;">
          View more users
        </Link>
      </div>
    </React.Fragment>
  );
}
