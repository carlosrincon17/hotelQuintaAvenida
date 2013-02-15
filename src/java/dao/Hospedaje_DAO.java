/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import util.*;

/**
 *
 * @author jorge
 */
public class Hospedaje_DAO {
   /* 
    public static void main(String[] args){
        BaseDeDatos.conectar();
        int n = Hospedaje_DAO.getHospedajesMes("07", "2012");
        System.out.println("n es "+n);
        BaseDeDatos.desconectar();
    }
    */

    public static boolean create(Hospedaje_DTO nuevo) throws Exception{
        String fecha= (nuevo.getFechaInicio().getYear()+1900)+"-"+(nuevo.getFechaInicio().getMonth()+1)+"-"+nuevo.getFechaInicio().getDate();
        String sql = "insert into hospedaje (id_habitacion, id_cliente, fecha_inicio) values (?,?,?)";
        Object[] p = new Object[3];
        p[0] = nuevo.getHabitacion().getNumero(); 
        p[1] = nuevo.getHuesped().getDocumento();
        p[2] = fecha;
        System.out.print(p[0]+" - " +p[1]+" - "+ p[2]);
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static boolean create(Hospedaje_DTO nuevo, ReservaHabitacion_DTO reserva) throws Exception{
        // Con ID String sql = "insert into hospedaje values(null,'"+reserva.getHabitacion().getNumero()+"','"+reserva.getCliente().getDocumento()+"','"+nuevo.getFechaInicio()+"',null,"reserva.getId()")";
        String sql = "insert into hospedaje (id_habitacion, id_cliente, fecha_inicio) values (?,?,?)";
        Object[] p = new Object[3];
        p[0] = reserva.getHabitacion().getNumero(); 
        p[0] = reserva.getCliente().getDocumento();
        p[0] = nuevo.getFechaInicio();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static ArrayList<Hospedaje_DTO> getAll() throws Exception{
        
        ArrayList<Hospedaje_DTO> lista= new ArrayList<>();
        String sql = "select id_hospedaje,id_habitacion,cedula,fecha_inicio from hospedaje inner join persona on hospedaje.id_cliente=persona.cedula where fecha_fin is null ";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);

        while (rs.next()) {
            Hospedaje_DTO nuevo = new Hospedaje_DTO();
            nuevo.setID(rs.getInt(1));
            nuevo.setHabitacion(new Habitacion_DTO(rs.getString(2)));
            nuevo.setHuesped(new Cliente_DTO(rs.getString(3)));
            nuevo.setFechaInicio(rs.getDate(4));
            lista.add(nuevo);
        }        
        return lista;
    }

    
    public static ArrayList<ServicioHabitacion_DTO> getConsumos(Hospedaje_DTO h) throws Exception {

        ArrayList<ServicioHabitacion_DTO> lista = new ArrayList<>();
        String sql = "select servicio.tipo,servicio.precio,servicio_habitacion.cantidad from hospedaje inner join servicio_habitacion on hospeda.id_hospedaje=servicio_habitacion.id_hospedaje inner join servicio on servicio_habitacion.id_servicio=servicio.id_servicio where hospedaje.fecha_fin is null and hospedaje.id_habitacion = ? and hospedaje.id_cliente = ?";
        Object[] p = new Object[2];
        p[0] = h.getHabitacion().getNumero();
        p[1] = h.getHuesped().getDocumento();

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        while (rs.next()) {
            ServicioHabitacion_DTO nuevo = new ServicioHabitacion_DTO();
            nuevo.setServicio(new Servicio_DTO(((float) (rs.getInt(2))), rs.getString(1)));
            nuevo.setCantidad(rs.getInt(3));
            lista.add(nuevo);
        }
        return lista;
    }

    
    /* creo que este metodo no funciona, si la idea es entregar la habitación no 
     * le dice que hábitación entregar
     */
    public static boolean entregar(Habitacion_DTO hab, Date fecha) throws Exception{
        //String sql = "update hospedaje set fecha_fin = '"+fecha+"'";
        String sql = "update hospedaje set fecha_fin = ?";
        Object[] p = new Object[1];
        p[0] = fecha;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static int terminarHospedaje(Hospedaje_DTO hospedaje) throws Exception {
        System.out.print(hospedaje.getID());
        Date hoy = new Date();
        String fecha = (hoy.getYear() + 1900) + "-" + (hoy.getMonth() + 1) + "-" + hoy.getDate();
        String sql = "Select fecha_inicio from hospedaje where id_hospedaje= ?";
        Object[] p = new Object[1];
        p[0] = hospedaje.getID();
        System.out.print("aca va bien!!!");
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        if (rs.next()) {
            Date fin = rs.getDate(1);
            if (terminar(hospedaje, fecha)) 
                return fin.getDate() - hoy.getDate() + 1;
        }
        return -1;
    }

    
    private static boolean terminar(Hospedaje_DTO hospedaje, String fecha) throws Exception{
        String Sql= "Update hospedaje set fecha_fin = ? where id_hospedaje = ?";
        Object[] p = new Object[2];
        p[0] = fecha;
        p[1] = hospedaje.getID();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(Sql, p);
    }
    
    
    public static int getHospedajesMes(String mes, String agno) throws Exception {
        int n = 0;
        String sql = "select count(*) from hospedaje where year(fecha_inicio) = ? and month(fecha_inicio) = ?";
        Object[] p = new Object[2];
        p[0] = agno;
        p[1] = mes;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        if (rs.next()) {
            n = rs.getInt(1);
        }
        return n;
    }

   
    
    
    
    
}
