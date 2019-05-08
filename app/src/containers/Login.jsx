import React,{Component} from 'react';


class Login extends Component {

   render(){
    return(

      <div className="container">
               
        <div className="p-4"></div>
        {/*<h2>Login</h2>*/}
        <div className="p-4"></div>
         
        <div class="card">
  <div class="card-header">
    Login
  </div>
  <div class="card-body">
    
    <form>
              <div class="form-group">
                
                <input type="email" class="form-control" id="exampleInputEmail1" 
                aria-describedby="emailHelp" placeholder="Enter email"/>
                
              </div>
              
              <div class="form-group">
                
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
              </div>
             
              <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
              </div>
              <button type="submit" class="btn btn-danger">Submit</button>
        </form>

    
    
  </div>
</div>
        
      </div>

    )
   }
}

export default Login;