import React,{Component} from 'react';
import axios from 'axios';


class Form extends Component {
  
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
                    <label for="exampleFormControlInput1">Nombre:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1" placeholder="Nombre"/>
                </div> 

                    <div className="form-group">
                    <label for="exampleFormControlInput1">Departamento:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1" placeholder="Departamento"/>
                </div>
                <div className="form-group">
                    <label for="exampleFormControlInput1">Ubicacion:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1" placeholder="Ubicacion"/>
                </div>
                
                <div className="form-group">
                    <label for="exampleFormControlTextarea1">Descripcion</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>

                
  
            </div>

        <div className="col-4">

                                
                <div className="form-group">
                    <label for="exampleFormControlInput1">Status:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1" disabled="true" />
                </div>

                <div className="form-group">
                    <label for="exampleFormControlInput1">Sistema:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1"  />
                </div>

                <div className="form-group">
                    <label for="exampleFormControlInput1">Version:</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1"  />
                </div>


                <div className="form-group">
                    <label for="exampleFormControlSelect1">Example select</label>
                    <select className="form-control" id="exampleFormControlSelect1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    </select>
                </div>

            </div>    
            
        </div>




                

  </div>

    )


  }
  

}



export default Form;
