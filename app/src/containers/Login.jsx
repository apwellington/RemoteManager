import React,{Component} from 'react';
import axios from 'axios';


const BASE_URL_TOKEN = "http://localhost:8080/oauth/token";
const BASE_URL = "http://localhost:8080";

const BASE_USER = {

    "username":"rpa-client",
    "password":"rpa-secret"

} 

     let headers = {
          'Content-Type': 'application/x-www-form-urlencoded',
          //'Authorization':'Basic cnBhLWNsaWVudDpycGEtc2VjcmV0',
          'Accept': 'application/json'
      }
    

    let body = {
               "password": "Passw0rd!",
                "username": "ieuser"
                
            }

 const TOKEN = "";


class Login extends Component {
  
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: ""
    };

   this.handleClick = this.handleClick.bind(this)
    
      
  }

   validateForm() {
    return this.state.email.length > 0 && this.state.password.length > 0;
  }


 handleSubmit = event => {
    event.preventDefault();
  }


   handleChange = event => {
    this.setState({
      [event.target.id]: event.target.value,
    
    });

    
  }

 handleClick(event){
      
      var self = this;
      var payload = {
      "email": this.state.email,
      "password": this.state.password
    }
/*
     console.log(axios.post("http://localhost:8080/oauth/token",
       {headers: {
           "Accept":"application/json",
           "Content-Type":"application/x-www-form-urlencoded",
           'Authorization':'Basic cnBhLWNsaWVudDpycGEtc2VjcmV0'
            }
       },
       {data: {
           "grant_type": "password",
           "client_id": "rpa-client",
           "client_secret": "rpa-secret",
           "scope": "read write",
           "username": "ieuser",
           "password": "Passw0rd!"
        }
       }));
*/

      //console.log(axios.post("http://localhost:8080/oauth/token"));

     /* return axios.get(`${BASE_URL}/oauth/token`,
            { headers: { authorization: this.createBasicAuthToken(this.state.email, this.state.password) } })*/

            axios.request({
            url: "/oauth/token",
            method: "post",
            baseURL: "http://localhost:8080",
            headers: {
                "Access-Control-Allow-Origin": '*',
                "authorization": "Basic cnBhLWNsaWVudDpycGEtc2VjcmV0",
                "accept": "application/json",
                "content-type": "application/x-www-form-urlencoded",
                "cache-control": "no-cache",
            },
            auth: {
            username: "rpa-client", // This is the client_id
            password: "rpa-secret", // This is the client_secret
            },
            data: {
                "grant_type": "password",
                "client_id": "rpa-client",
                "client_secret": "rpa-secret",
                "scope": "write",
                "username": "ieuser",
                "password": "Passw0rd!"
            }
            }).then(respose => {
            console.log(respose);
            }).catch((error)=>{
                console.log(error);
            });

 }


  createBasicAuthToken(username, password) {
        return 'Basic ' + window.btoa(username + ":" + password)
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
                
                <input type="email" name="email" id="email" className="form-control"  
                aria-describedby="emailHelp" placeholder="Enter email" 
                value={this.state.email} onChange={this.handleChange}/>
                
              </div>
              
              <div className="form-group">
                
                <input type="password" name="password" id="password"  className="form-control" placeholder="Password"
                  value={this.state.password} onChange={this.handleChange}/>
              </div>
            
              <button className="btn btn-danger" disabled={!this.validateForm()} onClick={this.handleClick}>Login</button>
        

    
    
  </div>
</div>
        
      </div>

    )
   }
}

export default Login;