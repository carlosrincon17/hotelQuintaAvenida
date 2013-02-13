/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.ServicioHabitacion_DAO;
import dto.Habitacion_DTO;
import dto.ServicioHabitacion_DTO;
import java.util.ArrayList;
import java.util.Date;
import util.BaseDeDatos;

/**
 *
 * @author Carlos
 */
public class ServicioHabitacion_negocio {

    public static ArrayList<ServicioHabitacion_DTO> getServicios(Habitacion_DTO myHab) throws Exception {
        
        ArrayList<ServicioHabitacion_DTO> myServicios= ServicioHabitacion_DAO.getServicios(myHab);
        System.out.print("Aca funciona esta maricada");
        return myServicios;
       
        
    }

    static String agregarServicio(String hospedaje, String servicio, String cantidad, Date fecha) throws Exception {
        if(ServicioHabitacion_DAO.agregarServicio(hospedaje,servicio,cantidad,fecha))
            return "p";
        return "Error en los datos, intente de nuevo";
    }
    
}
