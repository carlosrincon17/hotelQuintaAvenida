/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Cliente_DTO;
import dto.Empleado_DTO;
import dto.Rol_DTO;
import java.sql.ResultSet;
import util.BaseDeDatos;


/**
 *
 * @author Jorge
 */
public class Usuario_DAO {
     
    /*
     * Metodo que valida si un id y contraseña corresponden a un usuario
     * del sistema
     * Si el usuario existe retorna el id de su rol
     * sino retorna -1
     */
    public static int validar(String id, String password){

        String sql = "SELECT id_rol FROM usuario WHERE id_usuario = '" +id+ "' AND password = '"+password+"'";
        
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        int rol = -1;
        try{ 
            if(rs.next())
            rol = rs.getInt(1);
            
        }catch(Exception ex){
            rol = -1;
        }
        
        return rol;
    }
    static boolean create(Empleado_DTO persona) {
        
        int id_rol = Rol_DAO.getIdRol(new Rol_DTO(persona.getFuncion()));
        System.out.println(id_rol);
        String sql = "insert into usuario values('"+persona.getDocumento()+"',"+id_rol+",'hotel"+persona.getDocumento()+"')";
        
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static boolean enable(Empleado_DTO empleado){
        int id_rol = Funcion_empleado_DAO.getFuncionByCedula(empleado.getDocumento());
        String sql = "insert into usuario values('"+empleado.getDocumento()+"',"+id_rol+",'hotel"+empleado.getDocumento()+"')";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    static boolean create(Cliente_DTO persona) {
        int id_rol = Rol_DAO.getIdRol(new Rol_DTO("cliente"));
        System.out.println("ssss "+id_rol);
        String sql = "INSERT INTO usuario VALUES('"+persona.getDocumento()+"',"+id_rol+",'hotel"+persona.getDocumento()+"')";
        
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    public static boolean deshabilitar(Empleado_DTO empleado) {
        String sql = "delete from usuario where id_usuario="+empleado.getDocumento()+"";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }   
}
