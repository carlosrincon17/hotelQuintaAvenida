/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ReservaHabitacion_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import util.BaseDeDatos;

    
/**
 *
 * @author Carlos
 */
public class Reserva_DAO {

    public static int guardarReserva(String fechaReserva, Date fechaActual, String idCliente) {
        
        java.util.Calendar algo;
        
        
        String fecha1= fechaReserva;
        Date hoy=new Date();
        String fecha2= (hoy.getYear()+1900)+"-"+(hoy.getMonth()+1)+"-"+Calendar.DAY_OF_MONTH;
        System.out.print(fecha1+"\n");
        System.out.print(fecha2+"\n");
        String sql = "INSERT INTO reserva (fecha_reserva, fecha_solicitud, id_cliente, estado)"+
               "VALUES ('"+fecha1+"','"+fecha2+"',"+"'"+idCliente+"','Espera')";
        
       if(BaseDeDatos.ejecutarActualizacionSQL(sql)) {
           
           return getUltimo();
       
       }
        return -1;
    }

    private static int getUltimo() {
        String sql="SELECT MAX(id_reserva) from reserva";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            if(rs.next())
                return rs.getInt(1);                
        }
        catch(Exception e){
            return -1;
        
        }
        return -1;
    }

    public static ArrayList<Integer> getIds(String fecha) {
        String sql="Select id_reserva from reserva where fecha_reserva='"+fecha+"'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        ArrayList<Integer> reservas=new ArrayList<Integer>();
        try{
            while (rs.next()) reservas.add(rs.getInt(1));
            
        }
        catch (Exception e){
            
        }
        return reservas;
    }

    static void cargarReserva(ReservaHabitacion_DTO reserva) {
        String sql="Select * from reserva where id_reserva="+reserva.getId()+"";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            if(rs.next()){
                reserva.setFechaSolicitud(rs.getDate(3));
                reserva.setFechareserva(rs.getDate(4));
                reserva.setEstado(rs.getBoolean(5));
            }
        }
        catch(Exception e){
        
        }
    }

    public static boolean cancelarReserva(String idReserva) {
        String sql= "Update reserva set estado='Cancelada' where id_reserva="+idReserva;
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    
}
