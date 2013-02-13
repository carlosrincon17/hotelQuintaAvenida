/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Estado_habitacion_DAO;
import dao.Habitacion_DAO;
import dao.Tipo_habitacion_DAO;
import dto.Habitacion_DTO;
import dto.ServicioHabitacion_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorge
 */
public class Habitacion_negocio{

    public static ArrayList<String> getListaTipos() {
        try {
            return Tipo_habitacion_DAO.getAll();
        } catch (Exception ex) {
            System.out.println("Error, no se pudo listar los tipos de habitación");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public static ArrayList<String> getListaEstados() {
        try {
            return Estado_habitacion_DAO.getAll();
        } catch (Exception ex) {
            System.out.println("Error, no se pudo listar el estado de las habitaciones");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    

    public static ArrayList<Habitacion_DTO> listarDisponibles(){
        try {
            return Habitacion_DAO.getDisponibles();
        } catch (Exception ex) {
            System.out.println("Error, no se pudo listar habitaciones disponibles");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
    
    
    public static String getEstado(String habitacion) {
        try {
            return Habitacion_DAO.getEstado(new Habitacion_DTO(habitacion));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo obtener el estado de la habitación");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    static String cargarServicios(String habitacion) throws Exception {
        String msj="";
        Habitacion_DTO myHab= new Habitacion_DTO();
        myHab.setNumero(habitacion);
        myHab.setMyServicios(ServicioHabitacion_negocio.getServicios(myHab));
        msj="<br><h2> Listado de Servicio </h2>";
        if(myHab.getMyServicios().isEmpty()){
            msj+="<p>Aun no Exiten Servicios para esta habitación.</p>";
        }
        else{
            msj+="<table class='table table-hover'>";
            msj+="<th><td>Fecha</td><td>Servicio</td><td>Cantidad</td><td>Total</td></th>";
            for(ServicioHabitacion_DTO myServicio:myHab.getMyServicios()){
                msj+="<tr><td>"+myServicio.getFecha()+"</td><td>"+myServicio.getServicio().getTipo()+"</td>"+
                        "<td>"+ myServicio.getCantidad()+"</td><td>"+myServicio.getImporte()+"</td></tr>";
            }
            msj+="</table>";
        }
        msj+="<br><br>";
        return msj;
        
    }

    
    public Habitacion_negocio(){
    }
    
    public static boolean crear(String habitacion,String tipo){
        try {
            return Habitacion_DAO.create(new Habitacion_DTO(habitacion,tipo));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo crear habitación");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public static ArrayList<Habitacion_DTO> listar(){
        try {
            return Habitacion_DAO.getAll();
        } catch (Exception ex) {
            System.out.println("Error, no se pudo listar las habitaciones");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public static String getTipo(String habitacion){
        try {
            return Habitacion_DAO.getTipo(new Habitacion_DTO(habitacion));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo obtener el tipo");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    
    public static boolean editar(String hab, String tipo){
        try {
            return Habitacion_DAO.update(new Habitacion_DTO(hab, tipo));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo editar la habitación");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public static boolean cambiarEstado(String hab, String estado){
        try {
            Habitacion_DTO h = new Habitacion_DTO(hab);
            h.setEstado(estado);
            return Habitacion_DAO.cambiarEstado(h);
        } catch (Exception ex) {
            System.out.println("Error, no se pudo cambiar el estado de la habitación");
            Logger.getLogger(Habitacion_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
