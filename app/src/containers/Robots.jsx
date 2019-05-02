import React,{Component} from 'react';
import axios from 'axios';


class Robots extends Component {
  

  handleClick () {
  axios.get('https://api.github.com/users/maecapozzi')
    .then(response => console.log(response))
}
  
  
  render(){
    return(
      <div className="container-fluid">

    <div className="py-3">
     
    <h2>Lista de Robots</h2>
    </div> 

<div className="row">

  <div className="col-1">
  </div>
  <div className="col-11">
 
  
<table className="table">
  <thead>
    <tr>
      <th scope="col">Nombre</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Ejecucion</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Robot 1</th>
      <td>Procesar servicios</td>
      <td><button type="button" className="btn btn-danger">Ejecutar</button></td>
      
    </tr>
    <tr>
      <th scope="row">Robot 2</th>
      <td>Robot que controla app m58etc</td>
      <td><button type="button" className="btn btn-danger">Ejecutar</button></td>
      
    </tr>
    <tr>
      <th scope="row">Robot 3</th>
      <td>Ejecutar</td>
      <td>
        <button type="button" className="btn btn-danger" onClick={this.handleClick}>Ejecutar</button>
        <button type="button" className="btn btn-danger" onClick={this.handleClick}>Info</button>
        <button type="button" className="btn btn-danger" onClick={this.handleClick}>Ver</button>
      </td>
      
    </tr>
  </tbody>
</table>
</div>
</div>

  </div>

    )


  }
  

}



export default Robots;
