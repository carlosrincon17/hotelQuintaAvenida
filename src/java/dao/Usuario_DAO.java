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
    public static int validar(String id, String password) throws Exception {

        String sql = "SELECT id_rol FROM usuario WHERE id_usuario = ? AND password = ?";
        Object[] p = new Object[2];
        p[0] = id;
        p[1] = password;

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        int rol = -1;
        if (rs.next()) {
            rol = rs.getInt(1);
        }
        return rol;
    }
    
    
    public static boolean create(Empleado_DTO persona) throws Exception{
        
        int id_rol = Rol_DAO.getIdRol(new Rol_DTO(persona.getFuncion()));
        System.out.println(id_rol);
       // String sql = "insert into usuario values('"+persona.getDocumento()+"',"+id_rol+",'hotel"+persona.getDocumento()+"')";
        String sql = "insert into usuario values(?,?,?)";
        Object[] p = new Object[3];
        p[0] = persona.getDocumento();
        p[1] = id_rol;
        p[2] = "hotel" +persona.getDocumento();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static boolean enable(Empleado_DTO empleado) throws Exception{
        
        int id_rol = Funcion_empleado_DAO.getFuncionByCedula(empleado.getDocumento());
        String sql = "insert into usuario values(?,?,?)";
        Object[] p = new Object[3];
        p[0] = empleado.getDocumento();
        p[1] = id_rol;
        p[2] = "hotel" +empleado.getDocumento(); 
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static boolean create(Cliente_DTO persona) throws Exception{
        
        int id_rol = Rol_DAO.getIdRol(new Rol_DTO("cliente"));
        System.out.println("ssss "+id_rol);
        String sql = "INSERT INTO usuario VALUES(?,?,?)";
        Object[] p = new Object[3];
        p[0] = persona.getDocumento();
        p[1] = id_rol;
        p[2] = "hotel" +persona.getDocumento();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static boolean deshabilitar(Empleado_DTO empleado) throws Exception{
        String sql = "delete from usuario where id_usuario = ?";
        Object[] p = new Object[1];
        p[0] = empleado.getDocumento();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }   
}
