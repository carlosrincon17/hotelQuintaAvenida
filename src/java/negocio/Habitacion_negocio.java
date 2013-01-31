/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Estado_habitacion_DAO;
import dao.Habitacion_DAO;
import dao.Tipo_habitacion_DAO;
import dto.Habitacion_DTO;
import java.util.ArrayList;
/**
 *
 * @author jorge
 */
public class Habitacion_negocio{

    public static ArrayList<String> getListaTipos() {
        return Tipo_habitacion_DAO.getAll();
        
    }

    public static ArrayList<String> getListaEstados() {
        return Estado_habitacion_DAO.getAll();
    }

    public static ArrayList<Habitacion_DTO> listarDisponibles(){
        return Habitacion_DAO.getDisponibles();
    }    
    public static String getEstado(String habitacion) {
        return Habitacion_DAO.getEstado(new Habitacion_DTO(habitacion));
    }

    public Habitacion_negocio(){
    }
    
    public static boolean crear(String habitacion,String tipo){
        return Habitacion_DAO.create(new Habitacion_DTO(habitacion,tipo));
    }
    
    public static ArrayList<Habitacion_DTO> listar(){
        return Habitacion_DAO.getAll();
    }
    
    public static String getTipo(String habitacion){
        return Habitacion_DAO.getTipo(new Habitacion_DTO(habitacion));
    }
    
    public static boolean editar(String hab, String tipo){
        return Habitacion_DAO.update(new Habitacion_DTO(hab, tipo));
    }
    
    public static boolean cambiarEstado(String hab, String estado){
        Habitacion_DTO h = new Habitacion_DTO(hab);
        h.setEstado(estado);
        return Habitacion_DAO.cambiarEstado(h);
    }
}
