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

    public static int guardarReserva(String fechaReserva, Date fechaActual, String idCliente) throws Exception {

        /*
         este metodo me parece que tiene mal la consulta comentariada
         */
        
        java.util.Calendar algo;
        String fecha1 = fechaReserva;
        Date hoy = new Date();
        String fecha2 = (hoy.getYear() + 1900) + "-" + (hoy.getMonth() + 1) + "-" + Calendar.DAY_OF_MONTH;
        //String sql = "INSERT INTO reserva (fecha_reserva, fecha_solicitud, id_cliente, estado)"+
        //       "VALUES ('"+fecha1+"','"+fecha2+"',"+"'"+idCliente+"','Espera')";
        String sql = "INSERT INTO reserva (id_cliente, fecha_solicitud, fecha_reserva, activa) VALUES (?,?,?,1)";
        Object[] p = new Object[3];
        
        p[0] = idCliente;
        p[1] = fecha1;
        p[2] = fecha2;
        if (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p)) {
            return getUltimo();
        }
        return -1;
    }

    
    private static int getUltimo() throws Exception{

        String sql = "SELECT MAX(id_reserva) from reserva";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
    

    public static ArrayList<Integer> getIds(String fecha) throws Exception {

        String sql = "Select id_reserva from reserva where fecha_reserva = ?";
        Object[] p = new Object[1];
        p[0] = fecha;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        ArrayList<Integer> reservas = new ArrayList<>();

        while (rs.next()) {
            reservas.add(rs.getInt(1));
        }
        return reservas;
    }

    
    public static void cargarReserva(ReservaHabitacion_DTO reserva) throws Exception {

        String sql = "Select * from reserva where id_reserva = ?";
        Object[] p = new Object[1];
        p[0] = reserva.getId();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        if (rs.next()) {
            reserva.setFechaSolicitud(rs.getDate(3));
            reserva.setFechareserva(rs.getDate(4));
            reserva.setEstado(rs.getBoolean(5));
        }
    }

    
    public static boolean cancelarReserva(String idReserva) throws Exception{
        String sql= "Update reserva set activa=0 where id_reserva = ?";
         Object[] p = new Object[1];
        p[0] = idReserva;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
}
