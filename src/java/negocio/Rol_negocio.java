/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Privilegio_DAO;
import dao.Rol_DAO;
import dto.Privilegio_DTO;
import dto.Rol_DTO;
import java.util.ArrayList;

/**
 *
 * @author CONNORS
 */
public class Rol_negocio {
    
    private static Rol_DTO rol;

    public Rol_negocio() {
    }

    public Rol_negocio(int id, String nombre, ArrayList<Privilegio_DTO> privilegios) {

        rol = new Rol_DTO(id, nombre, privilegios);
    }
    
    public Rol_negocio(int id){
    
        rol = new Rol_DTO();
        rol.setId(id);
        
    }
    
    public Rol_negocio(String nombre){
    
        rol = new Rol_DTO();
        rol.setNombre(nombre);
    }
    
    public Rol_negocio(String nombre, String[] privilegios, String descripcion){
    

        
    }
    public static boolean actualizarRol(String nombre, String[] privilegios, String descripcion){
        
        rol = new Rol_DTO(nombre,descripcion);
        
        ArrayList<Privilegio_DTO> myPrivilegios = new ArrayList<Privilegio_DTO>();
       
        for( String p : privilegios){
        
            Privilegio_DTO nuevo = new Privilegio_DTO(p);
            myPrivilegios.add(nuevo);
        }
        
        rol.setPrivilegios(myPrivilegios);
            return Rol_DAO.actualizarRol(rol);
    }
    
    public static boolean crearRol(String nombre, String[] privilegios, String descripcion){
        rol = new Rol_DTO(nombre, descripcion);
        ArrayList<Privilegio_DTO> myPrivilegios = new ArrayList<Privilegio_DTO>();
       
        for( String p : privilegios){
        
            Privilegio_DTO nuevo = new Privilegio_DTO(p);
            myPrivilegios.add(nuevo);
        }
        
        rol.setPrivilegios(myPrivilegios);
        return Rol_DAO.crearRol(rol);
    }
    
    /**
     * Obtiene los privilegios de un rol de acuerdo al id del rol
     * @return Un ArrayList de Privilegio_DTO con los privilegios del rol
     */
    public ArrayList<Privilegio_DTO> getPrivilegios(){
    
    return Privilegio_DAO.getPrivilegiosRol(rol);
    
    }
    
    /**
     * Metodo que devuelve todos los privilegios del sistema
     * @return Un ArrayList de Privilegio_DTO con todos los privilegios del sistema
     */
    public static ArrayList<Rol_DTO> readAll(){
    
        return Rol_DAO.readAll();
    }
    public Rol_DTO getDatos(){
    
        return Rol_DAO.getDatosRol(rol.getNombre());
    }
}
