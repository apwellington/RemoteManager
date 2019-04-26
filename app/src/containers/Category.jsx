import React from 'react';

const Category = () => (
  <div className="container-fluid">

    <div className="py-3">
     
    <h2>Categorias</h2>
    </div> 

<div className="row">

  <div className="col-1">
  </div>
  <div className="col-11">
 
  
<table class="table">
  <thead>
    <tr>
      <th scope="col">Nombre</th>
      <th scope="col">Descripcion</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Automatizacion</th>
      <td>Categoria orientadaa Formulario</td>
      
      
    </tr>
    <tr>
      <th scope="row">Tipo Formulario</th>
      <td>Categoria orientada tipo archivo</td>
      
      
    </tr>
    <tr>
      <th scope="row">Tipo Archivo</th>
      <td>Categoria orientadaa Automatizacion</td>
      
      
    </tr>
  </tbody>
</table>
</div>
</div>

  </div>
);

export default Category;
