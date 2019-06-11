import React from 'react';
import ReactDOM from 'react-dom';
import './styles/index.css';
import * as serviceWorker from './serviceWorker';
import * as AdminApi from "./api/AdminApi";
import './styles/App.css';
import 'typeface-roboto';
import Dashboard from './screens/admin/Dashboard';
import Apps from './screens/admin/Apps';
import Logs from './screens/admin/Logs'
import Users from './screens/admin/Users';
import UserScreen from './screens/UserScreen';
import Router from './screens/admin/Router';

/* TODO:
 * -> https://www.npmjs.com/package/material-table
 */

const App = () => {
  return (
    <Dashboard/>
  )
};

ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
