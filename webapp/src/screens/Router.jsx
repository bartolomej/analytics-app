import React from 'react';
import { BrowserRouter, Route, Link } from "react-router-dom";
import AdminApp from "./admin/App";
import SignIn from './SignIn';

export default () => {

  return (
    <div>
      <BrowserRouter>
        <Link to="/auth"/>
        <Link to="/admin"/>

        <Route path="/auth" component={SignIn}/>
        <Route path="/admin" component={AdminApp}/>
      </BrowserRouter>
    </div>
  )
}