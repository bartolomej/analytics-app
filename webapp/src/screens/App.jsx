import React from 'react';
import { BrowserRouter, Route, Link } from "react-router-dom";
import AdminApp from "./admin/Router";
import UserApp from './user/Router';
import SignIn from './SignIn';

export default () => {
  return (
    <div>
      <BrowserRouter>
        <Link to="/auth"/>
        <Link to="/admin"/>
        <Link to="/user"/>

        <Route path="/auth" component={SignIn}/>
        <Route path="/admin" component={AdminApp}/>
        <Route path="/user" component={UserApp}/>
      </BrowserRouter>
    </div>
  )
}