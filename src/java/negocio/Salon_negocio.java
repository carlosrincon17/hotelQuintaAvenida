/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Salon_DAO;
import dto.Salon_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorge
 */
public class Salon_negocio {

    public static boolean registrar(String nombre, float precio, int capacidad, String estado) {
        try {
            return Salon_DAO.registrarSalon(new Salon_DTO(nombre, precio, capacidad, estado));
        } catch (Exception ex) {
            Logger.getLogger(Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public static ArrayList<Salon_DTO> cargarSalones() {
        try {
            return Salon_DAO.cargarSalones();
        } catch (Exception ex) {
            Logger.getLogger(Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public static String editar( String nombre, float precio, int capacidad, String estado){
        try {
            if(Salon_DAO.actualizarSalon(new Salon_DTO(nombre, precio,capacidad, estado)))
                return "El salon se Actualizo exitosamente";
        } catch (Exception ex) {
            Logger.getLogger(Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No se pudo efectua la Actualización";
    }

    
    public static Salon_DTO cargarSalon(String nombre) {
        try {
            return Salon_DAO.cargarSalon(nombre, new Salon_DTO());
        } catch (Exception ex) {
            Logger.getLogger(Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
