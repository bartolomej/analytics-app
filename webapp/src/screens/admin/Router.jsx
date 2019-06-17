import React from 'react';
import clsx from 'clsx';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import ListItem from '@material-ui/core/ListItem';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import BarChartIcon from '@material-ui/icons/BarChart';
import LogIcon from '@material-ui/icons/Security';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import AppIcon from '@material-ui/icons/Apps';
import ListItemText from '@material-ui/core/ListItemText';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import MenuIcon from '@material-ui/icons/Menu';
import Typography from '@material-ui/core/Typography';
import Badge from '@material-ui/core/Badge';
import NotificationsIcon from '@material-ui/icons/Notifications';
import Drawer from '@material-ui/core/Drawer';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import {useStyles} from "../../styles/dashboard";
import { BrowserRouter, Route, Link } from "react-router-dom";

import Dashboard from './Dashboard';
import Users from './Users';
import Apps from './Apps';
import Analytics from './Analytics';
import Logs from './Logs';
import UserScreen from "./UserScreen";

export default ({match, location}) => {
  console.log("LOCATION ", location);
  const classes = useStyles();
  const [open, setOpen] = React.useState(true);
  const [currentTab, setCurrentTab] = React.useState("Dashboard");
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
  const handleDrawerOpen = () => {
    setOpen(true);
  };
  const handleDrawerClose = () => {
    setOpen(false);
  };

  return (
    <BrowserRouter>
    <div className={classes.root}>
      <CssBaseline />
      <AppBar position="absolute" className={clsx(classes.appBar, open && classes.appBarShift)}>
        <Toolbar className={classes.toolbar}>
          <IconButton
            edge="start"
            color="inherit"
            aria-label="Open drawer"
            onClick={handleDrawerOpen}
            className={clsx(classes.menuButton, open && classes.menuButtonHidden)}>
            <MenuIcon />
          </IconButton>
          <Typography component="h1" variant="h6" color="inherit" noWrap className={classes.title}>
            {currentTab}
          </Typography>
          <IconButton color="inherit">
            <Badge badgeContent={4} color="secondary">
              <NotificationsIcon />
            </Badge>
          </IconButton>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        classes={{
          paper: clsx(
            classes.drawerPaper, !open &&
            classes.drawerPaperClose),
        }}
        open={open}>
        <div className={classes.toolbarIcon}>
          <IconButton onClick={handleDrawerClose}>
            <ChevronLeftIcon />
          </IconButton>
        </div>
        <Divider />
        <List>
          <div>
            <ListItem button component={Link} to={`${match.url}/`}>
              <ListItemIcon>
                <DashboardIcon />
              </ListItemIcon>
              <ListItemText primary="Dashboard" />
            </ListItem>
            <ListItem button component={Link} to={`${match.url}/users`}>
              <ListItemIcon>
                <PeopleIcon />
              </ListItemIcon>
              <ListItemText primary="Users" />
            </ListItem>
            <ListItem button component={Link} to={`${match.url}/apps`}>
              <ListItemIcon>
                <AppIcon />
              </ListItemIcon>
              <ListItemText primary="Apps" />
            </ListItem>
            <ListItem button component={Link} to={`${match.url}/analytics`}>
              <ListItemIcon>
                <BarChartIcon />
              </ListItemIcon>
              <ListItemText primary="Analytics" />
            </ListItem>
            <ListItem button component={Link} to={`${match.url}/logs`}>
              <ListItemIcon>
                <LogIcon />
              </ListItemIcon>
              <ListItemText primary="Logs" />
            </ListItem>
          </div>
        </List>
      </Drawer>
      <main className={classes.content}>
        <div className={classes.appBarSpacer} />
        <Container maxWidth="lg" className={classes.container}>
          <Route exact path={`${match.url}/`} component={() => {
            setCurrentTab("Dashboard");
            return Dashboard();
          }}/>
          <Route path={`${match.url}/users`} component={() => {
            setCurrentTab("Users");
            return Users();
          }}/>
          <Route path={`${match.url}/apps`} component={() => {
            setCurrentTab("Apps");
            return Apps();
          }} />
          <Route path={`${match.url}/analytics`} component={() => {
            setCurrentTab("Analytics");
            return Analytics();
          }} />
          <Route path={`${match.url}/logs`} component={() => {
            setCurrentTab("Logs");
            return Logs();
          }} />
          <Route path={`${match.url}/user/:id`} component={(match) => {
            setCurrentTab("User ");
            return UserScreen(match);
          }} />
        </Container>
      </main>
    </div>
    </BrowserRouter>
  );
}