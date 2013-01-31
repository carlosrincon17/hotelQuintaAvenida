/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Modulo_DTO;
import dto.Privilegio_DTO;
import dto.Rol_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CONNORS
 */
public class Privilegio_DAO {
    
    /**
     * Metodo que permite obtener los privilegios de un rol dado un Objeto de tipo Rol_DTO,
     * Que puede contener el nombre del rol o el ID del rol
     * @param rol El Objeto Rol_DTO del del cual se desean obtener los Privilegios
     * @return ArrayList<Privilegio_DTO> con los privilegios del Rol dado
     */
    
    public static ArrayList<Privilegio_DTO> getPrivilegiosRol(Modulo_DTO modulo , Rol_DTO rol){
    
        String sql="SELECT comportamiento.nombre, enlace FROM privilegio "
                + "INNER JOIN comportamiento ON privilegio.id_comportamiento = comportamiento.id_comportamiento "
                + "INNER JOIN modulo ON comportamiento.id_modulo = modulo.id_modulo     "
                + "WHERE modulo.nombre = '"+modulo.getNombre()+"' AND privilegio.id_rol = '"+rol.getId()+"' ORDER BY comportamiento.id_comportamiento"; 
        
        ArrayList<Privilegio_DTO> privilegios = new ArrayList<Privilegio_DTO>();
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
            Privilegio_DTO privilegio = new Privilegio_DTO();
            privilegio.setNombre(rs.getString(1));
            privilegio.setEnlace(rs.getString(2));
            privilegios.add(privilegio);
            }
        } catch (Exception e) {
        }
        
        return privilegios;
    }
    
    public static ArrayList<Privilegio_DTO> getPrivilegiosRol(Rol_DTO rol)
    {
        
        String sql="";
        if(rol.getId()==0)
        sql="SELECT id_privilegio, nombre, enlace FROM privilegio NATURAL JOIN comportamiento WHERE privilegio.id_rol ="
                + "(SELECT id_rol FROM rol WHERE nombre='"+rol.getNombre()+"') ORDER BY comportamiento.id_modulo";
        
        else if(rol.getNombre() == null)
        sql="SELECT id_privilegio, nombre, enlace FROM privilegio NATURAL JOIN comportamiento WHERE privilegio.id_rol = "+rol.getId()+" ORDER BY comportamiento.id_modulo";  
        
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        ArrayList<Privilegio_DTO> privilegios = new ArrayList<Privilegio_DTO>();

        try{
            while(rs.next()){
                Privilegio_DTO privilegio = new Privilegio_DTO();
                privilegio.setId(String.valueOf(rs.getInt(1)));
                privilegio.setNombre(rs.getString(2));
                privilegio.setEnlace(rs.getString(3));
                privilegios.add(privilegio);
            }
        }catch(Exception e){
            System.out.println("error  : "+e.toString());
        }
        
        return privilegios;
    }
    
    public static ArrayList<Privilegio_DTO> readAll(){
    
        
        String sql ="SELECT * FROM comportamiento";
        
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        ArrayList<Privilegio_DTO> privilegios = new ArrayList<Privilegio_DTO>();
        
        try{
            while (rs.next()){
                
                Privilegio_DTO privilegio = new Privilegio_DTO();
                privilegio.setId(String.valueOf(rs.getInt(1)));
                privilegio.setNombre(rs.getString(2));
                privilegio.setEnlace(rs.getString(3));
                privilegios.add(privilegio);
                
            }
        }catch(Exception e){}
        
     return privilegios;   
    }
    
}
