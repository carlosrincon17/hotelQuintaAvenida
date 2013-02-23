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
    
    
    
    public static boolean registrarSalon(Salon_DTO salon) throws Exception{
       
       String sql = "INSERT INTO salon (nombre, capacidad, precio_hora, estado) VALUES (?,?,?,?)";
       Object[] p = new Object[4];
       p[0] = salon.getNombre();
       p[1] = salon.getCapacidad();
       p[2] = salon.getPrecioHora();
       p[3] = salon.getEstado();
       return  BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p) ;
    }

    
    public static ArrayList<Salon_DTO> cargarSalones() throws Exception {

        ArrayList<Salon_DTO> salones = new ArrayList<>();
        String sql = "Select * from salon ";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);

        while (rs.next()) {
            Salon_DTO nuevo = new Salon_DTO();
            nuevo.setNombre(rs.getString(2));
            nuevo.setCapacidad(rs.getInt(3));
            nuevo.setPrecioHora(rs.getFloat(4));
            nuevo.setEstado(rs.getString(5));
            salones.add(nuevo);
        }
        return salones;
    }
    

    public static Salon_DTO cargarSalon(String id, Salon_DTO salon) throws Exception {

        String sql = "select * from salon where nombre = ?";
        Object[] p = new Object[1];
        p[0] = id;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        if (rs.next()) {
            salon.setID(rs.getString(1));
            salon.setNombre(rs.getString(2));
            salon.setEstado(rs.getString(5));
            salon.setCapacidad(rs.getInt(3));
            salon.setPrecioHora(rs.getFloat(4));
            return salon;
        }
        return null;
    }

    
    public static boolean actualizarSalon(Salon_DTO salon) throws Exception{
        
        /*
          esta consulta es rara, porque quiere actualizar el nombre de un salon buscandolo
          precisamente por el nombre.
         */
        
      //  String sql="update salon set nombre='"+salon.getNombre()+"', capacidad="+salon.getCapacidad()+
      //          " , precio_hora="+salon.getPrecioHora()+", estado='"+salon.getEstado()+"' where nombre='"+salon.getNombre()+"'";
        String sql = "update salon set nombre = ?, capacidad = ?, precio_hora = ?, estado = ? where nombre = ?";
        Object[] p = new Object[5];
        p[0] = salon.getNombre();
        p[1] = salon.getCapacidad();
        p[2] = salon.getPrecioHora();
        p[3] = salon.getEstado();
        p[4] = salon.getNombre();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static Salon_DTO leerSalon(String salon) throws Exception {

        String sql = "Select * from salon where nombre = ?";
        Object[] p = new Object[1];
        p[0] = salon;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        if (rs.next()) {
            Salon_DTO mySalon = new Salon_DTO();
            mySalon.setID(rs.getString(1));
            mySalon.setNombre(rs.getString(2));
            mySalon.setCapacidad(rs.getInt(3));
            mySalon.setPrecioHora(rs.getFloat(4));
            mySalon.setEstado(rs.getString(5));
            return mySalon;
        }
        return null;
    }

    
    public static Salon_DTO cargarSalonByID(int id) throws Exception {

        String sql = "Select * from salon where id_salon = ?";
        Object[] p = new Object[1];
        p[0] = id;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        if (rs.next()) {
            Salon_DTO mySalon = new Salon_DTO();
            mySalon.setID(rs.getString(1));
            mySalon.setNombre(rs.getString(2));
            mySalon.setCapacidad(rs.getInt(3));
            mySalon.setPrecioHora(rs.getFloat(4));
            mySalon.setEstado(rs.getString(5));
            return mySalon;
        }
        return null;

    }
    
    public static ArrayList<Salon_DTO> listarMovil() throws Exception {
        ArrayList<Salon_DTO> salones= new ArrayList<>();
        String sql="Select * from salon ";
        ResultSet rs= BaseDeDatos.getInstance().ejecutarSQL(sql,null);
        try {
            while(rs.next()){
                Salon_DTO nuevo = new Salon_DTO();
                nuevo.setNombre(rs.getString(2));
                nuevo.setCapacidad(rs.getInt(3));
                nuevo.setPrecioHora(rs.getFloat(4));
                nuevo.setEstado(rs.getString(5));
                nuevo.setDescripcion(rs.getString(6));
                nuevo.setImagen(rs.getString(7));
                salones.add(nuevo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salon_DAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return salones;
        
    }
   
}
