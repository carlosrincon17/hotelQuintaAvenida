/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Empleado_DAO;
import dao.Funcion_empleado_DAO;
import dto.Empleado_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class Empleado_negocio {

    public static String getFuncionListaHTML() {
        try {
            ArrayList<String> funciones = Funcion_empleado_DAO.getFunciones();
            String msj = "";
            for(String m: funciones){
                msj+="<option>"+m+"</option>";
                System.out.println(m);
            }
            return msj;
        } catch (Exception ex) {
            Logger.getLogger(Empleado_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return "error :(";
        }
    }
    
    
    public static ArrayList<String[]> getArrayFunciones(){
        try {
            return Funcion_empleado_DAO.getArrayFunciones();
        } catch (Exception ex) {
            Logger.getLogger(Empleado_negocio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error :(");
            return null;
        }
    }
    
    
    public static boolean registrar(String nombre,String apellido,String cedula, String fecha_nto,String numero_ss,String direccion,String telefono,String correo,String funcion){
        try {
            return Empleado_DAO.create(new Empleado_DTO(nombre, apellido, cedula, direccion,  fecha_nto, telefono, correo,numero_ss, funcion));
        } catch (Exception ex) {
            System.err.println("error, no se pudo registrar empleado");     
            Logger.getLogger(Empleado_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public static ArrayList<Empleado_DTO> listar() {
        try {
            return Empleado_DAO.getAll();
        } catch (Exception ex) {
            System.err.println("error, no se pudo listar empleados");      
            Logger.getLogger(Empleado_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public static boolean deshabilitar(String cedula) {
        try {
            return Empleado_DAO.disable(new Empleado_DTO(cedula));
        } catch (Exception ex) {
            Logger.getLogger(Empleado_negocio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error, no se pudo deshabilitar");
            return false;
        }
    }
    
    
    public static boolean habilitar(String cedula){
        try {
            return Empleado_DAO.enable(new Empleado_DTO(cedula));
        } catch (Exception ex) {
            System.err.println("error, no se pudo hablitar el empleado");      
            Logger.getLogger(Empleado_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public static boolean editarEmpleado(String cedula, String funcion, String telefono, String correo, String direccion, String seguro){
        try {
            return Empleado_DAO.update(new Empleado_DTO(cedula,funcion,telefono,correo,direccion,seguro));
        } catch (Exception ex) {
            System.err.println("error, no se pudo editar empleado");      
            Logger.getLogger(Empleado_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
