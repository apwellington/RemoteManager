import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { Home, Robots, Category } from './containers';

const Routes = () => (
  <Switch>
    <Route exact path="/" component={Home} />
    <Route path="/robots" component={Robots} />
    <Route path="/categories" component={Category} />
  </Switch>
);

export default Routes;
