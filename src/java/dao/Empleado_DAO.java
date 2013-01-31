/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Empleado_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/*
 *
 * @author Jorge
 */
public class Empleado_DAO {

    

    public static boolean create(Empleado_DTO empleado) {
        
        int id_funcion = Funcion_empleado_DAO.getIdPorNombre(empleado.getFuncion());
        String sql = "INSERT INTO empleado VALUES ('"+empleado.getDocumento()+"','"+empleado.getNumeroSS()+"',"+id_funcion+", 1)";
        if(Persona_DAO.create(empleado))
            return BaseDeDatos.ejecutarActualizacionSQL(sql);
        
        return false;
    }
    
    /**
     * Metodo que Obtiene todos los Empleados de la base de datos
     * @return  Una Lista de Empleado_DTO
     */
    public static ArrayList<Empleado_DTO> getAll(){
        
        ArrayList<Empleado_DTO> lista = new ArrayList<Empleado_DTO>();
        String sql = "SELECT * FROM empleado INNER JOIN persona ON empleado.id_empleado = persona.cedula INNER JOIN funcion_empleado ON empleado.id_funcion = funcion_empleado.id_funcion";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        
        try {
             while(rs.next()){
                 
            Empleado_DTO nuevo = new Empleado_DTO();
            nuevo.setDocumento(rs.getString(1));
            nuevo.setNumeroSS(rs.getString(2));
            nuevo.setEstado(rs.getBoolean(4));
            nuevo.setNombre(rs.getString(6));
            nuevo.setApellido(rs.getString(7));
            nuevo.setCorreo(rs.getString(8));
            nuevo.setDireccion(rs.getString(9));
            nuevo.setTelefono(rs.getString(10));
            nuevo.setFechaNacimiento(rs.getString(11));
            nuevo.setFechaInscripcion(rs.getString(12));
            nuevo.setFuncion(rs.getString(14));
            lista.add(nuevo);
            
        }
            } catch (Exception e) {
                e.printStackTrace();
        }
        System.err.println("hay  "+lista.size());
        return lista;
    }
    public static boolean disable(Empleado_DTO  empleado){
    
        String sql = "UPDATE empleado SET estado=0 WHERE id_empleado='"+empleado.getDocumento()+"'";
        if(Usuario_DAO.deshabilitar(empleado))
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
        
        else
            return false;
    }
    
    public static boolean enable(Empleado_DTO empleado){
        
        String sql = "UPDATE empleado SET estado=1 WHERE id_empleado='"+empleado.getDocumento()+"'";
        if(Usuario_DAO.enable(empleado))
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
        
        else
            return false;
        }
    
    public static boolean update(Empleado_DTO empleado){
    
        String sql = "UPDATE empleado SET NumeroSS='"+empleado.getNumeroSS()+"', id_funcion="+empleado.getFuncion()
                +" WHERE id_empleado='"+empleado.getDocumento()+"'";  
        
        if(Persona_DAO.update(empleado))
            return BaseDeDatos.ejecutarActualizacionSQL(sql);
        
        return false;
        }
    
}
