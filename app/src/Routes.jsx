import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { Home, Robots, Category, Login, FileUpload,Form } from './containers';

const Routes = () => (
  <Switch>
    <Route exact path="/" component={Home} />
    <Route path="/robots" component={Robots} />
    <Route path="/categories" component={Category} />
    <Route path="/login" component={Login} />
    <Route path="/fileUpload" component={FileUpload} />
    <Route path="/form" component={Form} />
  </Switch>
);

export default Routes;
