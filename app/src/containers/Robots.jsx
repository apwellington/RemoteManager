import React,{Component} from 'react';
import axios from 'axios';
import {Link } from 'react-router-dom';

class Robots extends Component {
  

  handleClick () {
  axios.get('https://api.github.com/users/maecapozzi')
    .then(response => console.log(response))

}

///Hola esto es un comentario

  render(){
    return(
      <div className="container-fluid">

    <div className="py-4"></div>
    <h5>Lista de Robots</h5>
    <div className="py-2"></div>

        <div className="row">

          <div className="col-1">
          </div>
          <div className="col-11">


              <table className="table">
                <thead>
                  <tr  className ="txt-openSans">
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Ejecucion</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th className="txt-roboto">Robot 1</th>
                    <td className="txt-roboto">Procesar Registros</td>
                    <td className="txt-roboto">Tipo Formulario</td>
                    <td ><button type="button" className="btn btn-danger"><Link className="text-white" to="/form">Ejecutar</Link></button></td>

                  </tr>
                  <tr>
                    <th className="txt-roboto">Robot 2</th>
                    <td className="txt-roboto">Procesar Registros</td>
                    <td className="txt-roboto">Tipo Archivo</td>
                    <td ><button type="button" className="btn btn-danger"><Link className="text-white" to="/fileUpload">Ejecutar</Link></button></td>

                  </tr>
                  <tr>
                    <th className="txt-roboto">Robot 3</th>
                    <td className="txt-roboto">Procesar Registros</td>
                    <td className="txt-roboto">Tipo Ejecucion</td>
                    <td><button type="button" className="btn btn-danger" onClick={this.handleClick}>Ejecutar</button></td>

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
