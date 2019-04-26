import React from 'react';
import { BrowserRouter, Link } from 'react-router-dom';

import Routes from './Routes';
import Navbar from './containers/Navbar';
import Home from './containers/Home';


const App = () => (
  <BrowserRouter>
    <div>    
          
          <Navbar/>
          <Home/>
            
      <Routes />
    </div>
  </BrowserRouter>
);

export default App;
