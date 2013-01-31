/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Salon_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.BaseDeDatos;

/**
 *
 * @author Carlos
 */
public class Salon_DAO {
    
    
    
    public static  boolean registrarSalon(Salon_DTO salon){
        
       String sql = "INSERT INTO salon (nombre, capacidad, precio_hora, estado)"+
               "VALUES ('"+salon.getNombre()+"',"+salon.getCapacidad()+","+salon.getPrecioHora()+",'"+salon.getEstado()+"')";
        
        return  BaseDeDatos.ejecutarActualizacionSQL(sql) ;
    }

    public static ArrayList<Salon_DTO> cargarSalones() {
        ArrayList<Salon_DTO> salones= new ArrayList<Salon_DTO>();
        String sql="Select * from salon ";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
                Salon_DTO nuevo = new Salon_DTO();
                nuevo.setNombre(rs.getString(2));
                nuevo.setCapacidad(rs.getInt(3));
                nuevo.setPrecioHora(rs.getFloat(4));
                nuevo.setEstado(rs.getString(5));
                salones.add(nuevo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salon_DAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return salones;
    }

    public static Salon_DTO cargarSalon(String id, Salon_DTO salon) {
        String sql="select * from salon where nombre='"+id+"'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            if(rs.next()){
            salon.setID(rs.getString(1));    
            salon.setNombre(rs.getString(2));
            salon.setEstado(rs.getString(5));
            salon.setCapacidad(rs.getInt(3));
            salon.setPrecioHora(rs.getFloat(4));
            }
            return salon;
            
        }
        catch(Exception e){
            return null;
        }
    }

    public static boolean actualizarSalon(Salon_DTO salon) {
        String sql="update salon set nombre='"+salon.getNombre()+"', capacidad="+salon.getCapacidad()+
                " , precio_hora="+salon.getPrecioHora()+", estado='"+salon.getEstado()+"' where nombre='"+salon.getNombre()+"'";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    public static Salon_DTO leerSalon(String salon) {
        
        String sql="Select * from salon where nombre='"+salon+"'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            
        if(rs.next()){
            Salon_DTO mySalon= new Salon_DTO();
            mySalon.setID(rs.getString(1));
            mySalon.setNombre(rs.getString(2));
            mySalon.setCapacidad(rs.getInt(3));
            mySalon.setPrecioHora(rs.getFloat(4));
            mySalon.setEstado(rs.getString(5));
            return mySalon;
            }
        
        }
        catch (Exception e){
        }
        return null;
        
    }

    public static Salon_DTO cargarSalonByID(int id) {
        String sql="Select * from salon where id_salon="+id+"";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            
        if(rs.next()){
            Salon_DTO mySalon= new Salon_DTO();
            mySalon.setID(rs.getString(1));
            mySalon.setNombre(rs.getString(2));
            mySalon.setCapacidad(rs.getInt(3));
            mySalon.setPrecioHora(rs.getFloat(4));
            mySalon.setEstado(rs.getString(5));
            return mySalon;
            }
        
        }
        catch (Exception e){
        }
        return null;
        
    }

    

   
}
