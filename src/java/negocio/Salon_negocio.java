/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dto.Salon_DTO;
import dao.Salon_DAO;
import java.util.ArrayList;
/**
 *
 * @author jorge
 */
public class Salon_negocio {

    public static boolean registrar(String nombre, float precio, int capacidad, String estado) {
        return Salon_DAO.registrarSalon(new Salon_DTO(nombre, precio, capacidad, estado));
    }

    public static ArrayList<Salon_DTO> cargarSalones() {
        return Salon_DAO.cargarSalones();
    }
    
    public static String editar( String nombre, float precio, int capacidad, String estado){
        if(Salon_DAO.actualizarSalon(new Salon_DTO(nombre, precio,capacidad, estado))) 
            return "El salon se Actualizo exitosamente";
        return "No se pudo efectua la Actualización";
    }

    static Salon_DTO cargarSalon(String nombre) {
        return Salon_DAO.cargarSalon(nombre, new Salon_DTO());
    }
}
