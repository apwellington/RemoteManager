import React,{Component} from 'react';
import axios from 'axios';


class Form extends Component {



  executeRobotForm () {
  axios.get('https://api.github.com/users/maecapozzi')
    .then(response => console.log(response))

}
  
  render(){
    return(
      <div className="container-fluid">

    <div className="py-4"></div>     
    
    <h4>Formulario</h4>
    <div className="py-2"></div>    
 
        <div className="row">
            
            <div className="p-3"></div> 
            <div className="col-4">
        
                
                    
                <div className="form-group">
                    <label>Nombre:</label>
                    <input type="email" className="form-control" placeholder="Nombre"/>
                </div> 

                    <div className="form-group">
                    <label>Departamento:</label>
                    <input type="email" className="form-control"  placeholder="Departamento"/>
                </div>
                <div className="form-group">
                    <label>Ubicacion:</label>
                    <input type="email" className="form-control"  placeholder="Ubicacion"/>
                </div>
                
                <div className="form-group">
                    <label>Descripcion</label>
                    <textarea className="form-control" id="" rows="3"></textarea>
                </div>

                
  
            </div>

        <div className="col-4">

                                
                <div className="form-group">
                    <label >Status:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1" />
                </div>

                <div className="form-group">
                    <label>Sistema:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1"  />
                </div>

                <div className="form-group">
                    <label>Version:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1"  />
                </div>

                    <button type="button" className="btn btn-danger text-white" onClick={this.executeRobotForm} >Ejecutar</button>

            </div>    
            
        </div>




                

  </div>

    )


  }
  

}



export default Form;
