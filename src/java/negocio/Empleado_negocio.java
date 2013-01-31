/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Empleado_DAO;
import dao.Funcion_empleado_DAO;
import dao.Usuario_DAO;
import dto.Empleado_DTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class Empleado_negocio {

    public static String getFuncionListaHTML() {
        ArrayList<String> funciones = Funcion_empleado_DAO.getFunciones();
        String msj = "";
        for(String m: funciones){
            msj+="<option>"+m+"</option>";
            System.out.println(m);
        }
        return msj;
    }
    
    public static ArrayList<String[]> getArrayFunciones(){
    
        return Funcion_empleado_DAO.getArrayFunciones();
    }
    
    public static boolean registrar(String nombre,String apellido,String cedula, String fecha_nto,String numero_ss,String direccion,String telefono,String correo,String funcion){
        
        return Empleado_DAO.create(new Empleado_DTO(nombre, apellido, cedula, direccion,  fecha_nto, telefono, correo,numero_ss, funcion));
    }

    static ArrayList<Empleado_DTO> listar() {
        return Empleado_DAO.getAll();
    }

    public static boolean deshabilitar(String cedula) {
        return Empleado_DAO.disable(new Empleado_DTO(cedula));
    }
    
    public static boolean habilitar(String cedula){
        return Empleado_DAO.enable(new Empleado_DTO(cedula));
    }
    
    public static boolean editarEmpleado(String cedula, String funcion, String telefono, String correo, String direccion, String seguro){
    
        return Empleado_DAO.update(new Empleado_DTO(cedula,funcion,telefono,correo,direccion,seguro));
    }
    
}
