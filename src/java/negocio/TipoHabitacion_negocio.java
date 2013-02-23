/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Tipo_habitacion_DAO;
import dto.TipoHabitacion_DTO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class TipoHabitacion_negocio {
    
    public static String listaHabitaciones() throws Exception{
         String msj="<div  data-role='collapsible-set' data-theme='b' data-content-theme='b'>";
         
          ArrayList<TipoHabitacion_DTO> listaHabitaciones = Tipo_habitacion_DAO.listarMovil();
          for(TipoHabitacion_DTO myHab : listaHabitaciones){
             
              msj+="<div data-role='collapsible'> <h3>"+myHab.getNombre()+"</h3>" 
              + "<p style='text-align:left;' ><img src='"+myHab.getImgUrl()+"' alt='descripción' style='margin:5px 18px 10px 0; width:100%;'/><br><br>"+myHab.getDescripcion()+"<br><br><b>Precio:  </b> $ "+myHab.getPrecio()+"</p>"
              + "</div> \n";
          }
          System.out.print(msj);
          return msj+="</div>";
    }
    
}
