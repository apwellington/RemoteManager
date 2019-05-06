import React,{Component} from 'react';
import axios from 'axios';


class FileUpload extends Component {
  
  render(){
    return(
      <div className="container">

    <div className="py-4"></div>     
    
    <h4>Archivo</h4>
    

    <div className="input-group">
  <div className="custom-file">
    <input type="file" className="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"/>
    <label className="custom-file-label" for="inputGroupFile04">Subir Archivo</label>
  </div>
  <div class="input-group-append">
    <button className="btn  bg-info " type="button" id="inputGroupFileAddon04">Subir</button>
  </div>

    </div> 

  </div>

    )


  }
  

}



export default FileUpload;
