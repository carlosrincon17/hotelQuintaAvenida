/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import util.*;

/**
 *
 * @author jorge
 */
public class Hospedaje_DAO {
    
    public static void main(String[] args){
        BaseDeDatos.conectar();
        int n = Hospedaje_DAO.getHospedajesMes("07", "2012");
        System.out.println("n es "+n);
        BaseDeDatos.desconectar();
    }
    

    public static boolean create(Hospedaje_DTO nuevo) {
        String fecha= (nuevo.getFechaInicio().getYear()+1900)+"-"+(nuevo.getFechaInicio().getMonth()+1)+"-"+nuevo.getFechaInicio().getDate();
        String sql = "insert into hospedaje values(null,'"+nuevo.getHabitacion().getNumero()+"','"+nuevo.getHuesped().getDocumento()+"','"+fecha+"',null,null)";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    public static boolean create(Hospedaje_DTO nuevo, ReservaHabitacion_DTO reserva) {
        // Con ID String sql = "insert into hospedaje values(null,'"+reserva.getHabitacion().getNumero()+"','"+reserva.getCliente().getDocumento()+"','"+nuevo.getFechaInicio()+"',null,"reserva.getId()")";
        String sql = "insert into hospedaje values(null,'"+reserva.getHabitacion().getNumero()+"','"+reserva.getCliente().getDocumento()+"','"+nuevo.getFechaInicio()+"',null,null)";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<Hospedaje_DTO> getAll() {
        ArrayList<Hospedaje_DTO> lista= new ArrayList<Hospedaje_DTO>();
        String sql = "select id_hospedaje,id_habitacion,cedula,fecha_inicio from hospedaje inner join persona on hospedaje.id_cliente=persona.cedula where fecha_fin is null";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
                Hospedaje_DTO nuevo = new Hospedaje_DTO();
                nuevo.setID(rs.getInt(1));
                nuevo.setHabitacion(new Habitacion_DTO(rs.getString(2)));
                nuevo.setHuesped(new Cliente_DTO(rs.getString(3)));
                nuevo.setFechaInicio(rs.getDate(4));
                lista.add(nuevo);               
            }
            
        } catch (Exception e) {
        }
        
        return lista;
    }

    public static ArrayList<ServicioHabitacion_DTO> getConsumos(Hospedaje_DTO h) {
        ArrayList<ServicioHabitacion_DTO> lista = new ArrayList<ServicioHabitacion_DTO>();
        String sql="select servicio.tipo,servicio.precio,servicio_habitacion.cantidad from hospedaje inner join servicio_habitacion on hospeda.id_hospedaje=servicio_habitacion.id_hospedaje inner join servicio on servicio_habitacion.id_servicio=servicio.id_servicio where hospedaje.fecha_fin is null and hospedaje.id_habitacion ='"+h.getHabitacion().getNumero()+"' and hospedaje.id_cliente='"+h.getHuesped().getDocumento()+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
                ServicioHabitacion_DTO nuevo = new ServicioHabitacion_DTO();
                nuevo.setServicio(new Servicio_DTO(((float)(rs.getInt(2))),rs.getString(1)));
                nuevo.setCantidad(rs.getInt(3));
                lista.add(nuevo);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public static boolean entregar(Habitacion_DTO hab, Date fecha) {
        String sql = "update hospedaje set fecha_fin = '"+fecha+"'";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    public static int terminarHospedaje(Hospedaje_DTO hospedaje) {
        Date hoy= new Date();
        String fecha= (hoy.getYear()+1900)+"-"+(hoy.getMonth()+1)+"-"+hoy.getDate();
        String sql="Select fecha_inicio from hospedaje where id_hospedaje="+hospedaje.getID();
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            if(rs.next()){
                Date fin= rs.getDate(1);
                if(terminar(hospedaje, fecha))
                    return fin.getDate()-hoy.getDate()+1;
                
            }
        }
        catch (Exception e){
            
        }
        return -1;
    }

    private static boolean terminar(Hospedaje_DTO hospedaje, String fecha) {
        String Sql= "Update hopedaje set fecha_fin="+fecha+" where id_hospedaje="+hospedaje.getID()+"";
        return BaseDeDatos.ejecutarActualizacionSQL(Sql);
    }
    
    public static int getHospedajesMes(String mes,String agno){
        int n=0;
        String sql="select count(*) from hospedaje where year(fecha_inicio)="+agno+
                " and month(fecha_inicio)="+mes+"";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        
        try {
            if(rs.next())
                n = rs.getInt(1);
        } catch (Exception e) {
        }
        
        return n;
    }
    
    
    
    
}
