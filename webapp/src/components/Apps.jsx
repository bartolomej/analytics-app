import React from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import ArrowIcon from '@material-ui/icons/ArrowRight';
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

export default ({title, data, enableGoTo = false}) => {
  const classes = useStyles();
  return (
    <React.Fragment>
      <Title>{title}</Title>
      <Table size="big">
        <TableHead>
          <TableRow>
            <TableCell>Name</TableCell>
            <TableCell>Url</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Created</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map(row => (
            <TableRow href="#" key={row.name}>
              <TableCell>{row.name}</TableCell>
              <TableCell>{row.url}</TableCell>
              <TableCell>{row.description}</TableCell>
              <TableCell>{new Date(row.created).toLocaleString()}</TableCell>
              {enableGoTo && <TableCell><a href={`/admin/user/${row.uid}`}><ArrowIcon/></a></TableCell>}
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
