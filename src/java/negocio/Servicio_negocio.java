/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Servicio_DAO;
import dto.Servicio_DTO;
import java.util.ArrayList;
/**
 *
 * @author jorge
 */
class Servicio_negocio {

    public static boolean registrar(String nombre, float precio) {
        return Servicio_DAO.create(new Servicio_DTO(precio, nombre));
    }
    
    public static ArrayList<Servicio_DTO> listar(){
        return Servicio_DAO.getAll();
    }
    
    public static boolean editar(String nombre, float cantidad){
    
        return Servicio_DAO.editar(new Servicio_DTO(cantidad,nombre));
        
    }
    
    public static boolean editar(String nombreNuevo, String anterior, float cantidad){
    
        return Servicio_DAO.editar(new Servicio_DTO(cantidad,nombreNuevo), anterior);
    }
}
