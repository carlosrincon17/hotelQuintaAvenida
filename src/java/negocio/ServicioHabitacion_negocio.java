/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.ServicioHabitacion_DAO;
import dto.Habitacion_DTO;
import dto.ServicioHabitacion_DTO;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author Carlos
 */
public class ServicioHabitacion_negocio {

    public static ArrayList<ServicioHabitacion_DTO> getServicios(Habitacion_DTO myHab) throws Exception {
        
        ArrayList<ServicioHabitacion_DTO> myServicios= ServicioHabitacion_DAO.getServicios(myHab);
        return myServicios;
        
        
    }
    
}
