import React from 'react';

const Category = () => (
  <div className="container-fluid">
    
        <div className="py-4"></div>  
                <h5>Categorias</h5>
    <div className="py-2"></div>  

<div className="row">

  <div className="col-1">
  </div>
  <div className="col-11">
 
  
<table className="table">
  <thead>
    <tr className ="txt-openSans">
      <th scope="col">Nombre</th>
      <th scope="col">Descripcion</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <th className="txt-roboto">Automatizacion</th>
      <td className="txt-roboto">Categoria orientadaa Formulario</td>
      
      
    </tr>
    <tr>
      <th className="txt-roboto">Tipo Formulario</th>
      <td className="txt-roboto">Categoria orientada tipo archivo</td>
      
      
    </tr>
    <tr>
      <th className="txt-roboto">Tipo Archivo</th>
      <td className="txt-roboto">Categoria orientadaa Automatizacion</td>
      
      
    </tr>
  </tbody>
</table>
</div>
</div>

  </div>
);

export default Category;
