/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Privilegio_DTO;
import dto.Rol_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.BaseDeDatos;

/**
 *
 * @author CONNORS
 */
public class Rol_DAO {
    
    /**
     * Metodo que obtiene todos los roles del sistema
     * @return ArrayList<Rol_DTO> con todos los roles del sistema
     */
    public static ArrayList<Rol_DTO> readAll(){
        
        String sql ="SELECT * FROM rol";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        ArrayList<Rol_DTO> roles = new ArrayList<Rol_DTO>();
        try {
            while(rs.next()){
                Rol_DTO nuevo = new Rol_DTO();
                nuevo.setId(rs.getInt(1));
                nuevo.setNombre(rs.getString(2));
                nuevo.setDescripcion(rs.getString(3));
                roles.add(nuevo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rol_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }
    
    public static int getIdRol(Rol_DTO nuevo){
    
        String sql = "SELECT id_rol FROM rol WHERE nombre='"+nuevo.getNombre()+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        int i = -1;
        try{ 
            if(rs.next())
            i = rs.getInt(1);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return i;
    }
    
    
    public static Rol_DTO getDatosRol(String nombre){
    
        String sql = "SELECT * FROM rol WHERE nombre='"+nombre+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        Rol_DTO nuevo = new Rol_DTO();
        try{ 
            rs.next();
            nuevo.setId(rs.getInt(1));
            nuevo.setNombre(rs.getString(2));
            nuevo.setDescripcion(rs.getString(3));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return nuevo;
    }
    public static boolean actualizarRol(Rol_DTO nuevo){
    
        nuevo.setId(Rol_DAO.getIdRol(nuevo));
        
        String sql = "UPDATE rol SET nombre='"+nuevo.getNombre()+"', descripcion='"+nuevo.getDescripcion()
                +"' WHERE id_rol="+nuevo.getId();
        
        boolean sePudo = true;
            if(BaseDeDatos.ejecutarActualizacionSQL(sql)){
            
            sql="DELETE FROM privilegio WHERE id_rol="+nuevo.getId();
            
            if(!BaseDeDatos.ejecutarActualizacionSQL(sql))
            sePudo = false;
        
        }
            else
                return false;
            
        for( Privilegio_DTO p : nuevo.getPrivilegios()){
                    
            if(!asignarPrivilegioARol(p,nuevo))
                 return false;       
            }
        
        return sePudo;
    }
    
    public static boolean crearRol(Rol_DTO nuevo){
     
        String sql = "INSERT INTO rol (nombre, descripcion) VALUES ('"+
                     nuevo.getNombre() + "', '" +
                     nuevo.getDescripcion()+ "')";
        
        boolean sePudo = true;
        if(BaseDeDatos.ejecutarActualizacionSQL(sql)){
            
            Funcion_empleado_DAO.crear(nuevo);
            
        nuevo.setId(Rol_DAO.getIdRol(nuevo));
        
            for( Privilegio_DTO p : nuevo.getPrivilegios()){
                    
                if(!asignarPrivilegioARol(p,nuevo))
                sePudo = false;
                        
            }
            return sePudo;
            
        }
        else 
            return false;
    }
    
    public static boolean asignarPrivilegioARol(Privilegio_DTO privilegio, Rol_DTO rol){
    
                String sql = "INSERT INTO privilegio (id_rol, id_comportamiento) VALUES ( "+
                        rol.getId()+","+
                        Integer.parseInt(privilegio.getId())+")";    
                
                return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
}
