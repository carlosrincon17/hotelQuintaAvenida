/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Habitacion_DTO;
import dto.ServicioHabitacion_DTO;
import dto.Servicio_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import util.BaseDeDatos;

/**
 *
 * @author Carlos
 */
public class ServicioHabitacion_DAO {

    public static ArrayList<ServicioHabitacion_DTO> getServicios(Habitacion_DTO myHab) throws Exception {
        
        String sql="Select fecha, total, cantidad, id_servicio from servicio_hospedaje where id_hospedaje=?";
        Object[] p = new Object[1];
        p[0] = myHab.getNumero();
        ResultSet rs= BaseDeDatos.getInstance().ejecutarSQL(sql,p);
        ArrayList<ServicioHabitacion_DTO> myServicios= new ArrayList<>();
       try{
           while (rs.next()){
              Date fecha= rs.getDate(1);
              int total= rs.getInt(2);
              int  cantidad = rs.getInt(3);
              String servicio= rs.getString(4);
              Servicio_DTO mySer= Servicio_DAO.getServicio(servicio);
              
              ServicioHabitacion_DTO myServ= new ServicioHabitacion_DTO(fecha, total, mySer, cantidad); 
              myServicios.add(myServ);
           }
       }
       catch(Exception e){
       
       }
        return myServicios;
    }

    public static boolean agregarServicio(String hospedaje, String servicio, String cantidad, Date fecha) throws Exception {
        Date hoy= fecha;
        Servicio_DTO ser= Servicio_DAO.getServicio(servicio);
        int total= (int) (Integer.parseInt(cantidad)* ser.getPrecio());
        String fecha2 = (hoy.getYear() + 1900) + "-" + (hoy.getMonth() + 1) + "-" + Calendar.DAY_OF_MONTH;
        String sql="Insert into servicio_hospedaje (id_servicio, id_hospedaje, cantidad, total, fecha ) values (?,?,?,?,?)";
        Object[] p = new Object[5];
        p[0] = ser.getId();
        p[1] = hospedaje;
        p[2] = cantidad;
        p[3] = total;
        p[4] = fecha2;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);

    }

   
    
}
