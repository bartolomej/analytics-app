import React from 'react';
import ReactDOM from 'react-dom';
import './styles/index.css';
import * as serviceWorker from './serviceWorker';
import './styles/App.css';
import 'typeface-roboto';
import AdminApp from './screens/admin/App';
import SignIn from './screens/SignIn';
import Router from './screens/Router';

const App = () => {
  return (
    <AdminApp/>
  )
};

ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
