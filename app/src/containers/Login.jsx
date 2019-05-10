import React,{Component} from 'react';
import axios from 'axios';

class Login extends Component {



  loginProcess () {
  axios.get('https://api.github.com/users/maecapozzi')
    .then(response => console.log(response))

}

   render(){
    return(

      <div className="container">
               
        <div className="p-4"></div>
        {/*<h2>Login</h2>*/}
        <div className="p-4"></div>
         
        <div className="card">
  <div className="card-header">
    Login
  </div>
  <div className="card-body">
    
    
              <div className="form-group">
                
                <input type="email" className="form-control" id="exampleInputEmail1" 
                aria-describedby="emailHelp" placeholder="Enter email"/>
                
              </div>
              
              <div className="form-group">
                
                <input type="password" className="form-control" id="exampleInputPassword1" placeholder="Password"/>
              </div>
             
              <div className="form-group form-check">
                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                <label className="form-check-label">Check me out</label>
              </div>
              <button className="btn btn-danger" onClick={this.loginProcess }>Submit</button>
        

    
    
  </div>
</div>
        
      </div>

    )
   }
}

export default Login;