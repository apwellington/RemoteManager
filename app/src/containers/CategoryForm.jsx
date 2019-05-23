import React,{Component} from 'react';
import axios from 'axios';

const BASE_URL = "http://localhost:8080";

class CategoryForm extends Component {


  constructor() {
    super();
    this.state = {
      name: '',
      description: '',
      
    };
  
    this.handleClick = this.handleClick.bind(this)
  }

handleClick(event){
      
      var self = this;
      var payload = {
      "name": this.state.name
      
    }

    axios.post( BASE_URL+'/api/category/save', {
                name: payload.name
                
    })
  .then(function (response) {
       console.log(response);
   })
   .catch(function (error) {
       console.log(error);
     });

console.log(payload)
}   


 handleSubmit = event => {
    event.preventDefault();
  }


handleChange = event => {
    this.setState({
      [event.target.id]: event.target.value,
    
    });

    
  }

  executeRobotForm () {
  axios.get('https://api.github.com/users/maecapozzi')
    .then(response => console.log(response))

}


validateForm() {
    return this.state.name.length > 0 && this.state.description.length > 0;
  }

  
  render(){

     const { name, description  } = this.state;

    return(
      <div className="container-fluid">

    <div className="py-4"></div>     
    
    <h4>Agregar Cateforia</h4>
    <div className="py-2"></div>    
 
        <div className="row">
            
            <div className="p-3"></div> 
            <div className="col-4">
        
                
                    
                <div className="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="name" id="name" value={this.state.name} onChange={this.handleChange} className="form-control" />
                </div> 

              

                
            <button type="button" className="btn btn-danger text-white" onClick={this.handleClick} >Ejecutar</button>   
            </div>

       
            
        </div>




                

  </div>

    )


  }
  

}



export default CategoryForm;
