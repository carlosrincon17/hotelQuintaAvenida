/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Servicio_DAO;
import dto.Servicio_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorge
 */
class Servicio_negocio {

    public static boolean registrar(String nombre, float precio) {
        try {
            return Servicio_DAO.create(new Servicio_DTO(precio, nombre));
        } catch (Exception ex) {
            Logger.getLogger(Servicio_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public static ArrayList<Servicio_DTO> listar(){
        try {
            return Servicio_DAO.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Servicio_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public static boolean editar(String nombre, float cantidad){
        try {
            return Servicio_DAO.editar(new Servicio_DTO(cantidad,nombre));
        } catch (Exception ex) {
            Logger.getLogger(Servicio_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    public static boolean editar(String nombreNuevo, String anterior, float cantidad){
        try {
            return Servicio_DAO.editar(new Servicio_DTO(cantidad,nombreNuevo), anterior);
        } catch (Exception ex) {
            Logger.getLogger(Servicio_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
