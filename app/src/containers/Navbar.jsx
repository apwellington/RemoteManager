import React from 'react';
import {Link } from 'react-router-dom';

const Navbar = () => (
   <div>
      <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-danger">
            <Link className="navbar-toggler" to="/">Home</Link>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
        
        <div className="collapse navbar-collapse" id="navbarCollapse">
        
        <ul className="navbar-nav mr-auto">
           
           <li className="nav-item active">
              <Link className="nav-link" to="/robots">Robots <span className="sr-only">(current)</span></Link>
           </li>
           <
             li className="nav-item active">
             <Link className="nav-link" to="/categories">Categorias <span className="sr-only">(current)</span></Link>
           </li>
            
            
        </ul>
                <li className="form-inline my-2 my-lg-0 ">
                
                    <Link className="nav-link" to="/login">
                      <button className="btn  text-white my-2 my-sm-0 border border-white">Login</button>
                    </Link>
                
                </li>
                
          
        </div>
      </nav>
  </div>
);

export default Navbar;
