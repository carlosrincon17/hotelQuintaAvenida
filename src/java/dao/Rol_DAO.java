/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Privilegio_DTO;
import dto.Rol_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CONNORS
 */
public class Rol_DAO {
    
    /**
     * Metodo que obtiene todos los roles del sistema
     * @return ArrayList<Rol_DTO> con todos los roles del sistema
     */
    public static ArrayList<Rol_DTO> readAll() throws Exception{

        String sql = "SELECT * FROM rol";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        ArrayList<Rol_DTO> roles = new ArrayList<>();

        while (rs.next()) {
            Rol_DTO nuevo = new Rol_DTO();
            nuevo.setId(rs.getInt(1));
            nuevo.setNombre(rs.getString(2));
            nuevo.setDescripcion(rs.getString(3));
            roles.add(nuevo);
        }
        return roles;
    }
    
    
    public static int getIdRol(Rol_DTO nuevo) throws Exception {

        String sql = "SELECT id_rol FROM rol WHERE nombre = ?";
        Object[] p = new Object[1];
        p[0] = nuevo.getNombre();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        int i = -1;
        if (rs.next()) {
            i = rs.getInt(1);
        }
        return i;
    }
    
    
    public static Rol_DTO getDatosRol(String nombre) throws Exception {

        String sql = "SELECT * FROM rol WHERE nombre = ?";
        Object[] p = new Object[1];
        p[0] = nombre;

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        Rol_DTO nuevo = new Rol_DTO();

        rs.next();
        nuevo.setId(rs.getInt(1));
        nuevo.setNombre(rs.getString(2));
        nuevo.setDescripcion(rs.getString(3));
        return nuevo;
    }
    
    
    public static boolean actualizarRol(Rol_DTO nuevo) throws Exception{
    
        nuevo.setId(Rol_DAO.getIdRol(nuevo));
        
        String sql = "UPDATE rol SET nombre = ?, descripcion = ? WHERE id_rol = ?";
        Object[] pa = new Object[3];
        pa[0] = nuevo.getNombre();
        pa[1] = nuevo.getDescripcion();
        pa[2] = nuevo.getId();
        
        boolean sePudo = true;
        if (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, pa)) { 
            sql = "DELETE FROM privilegio WHERE id_rol = ?";
            Object[] s = new Object[1];
            s[0] = nuevo.getNombre();
            if (!BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, s)) {
                sePudo = false;
            }
        }
        else
            return false;
            
        for (Privilegio_DTO p : nuevo.getPrivilegios()) {
            if (!asignarPrivilegioARol(p, nuevo)) 
                return false;
        }
        return sePudo;
    }
    
    
    public static boolean crearRol(Rol_DTO nuevo) throws Exception{
     
        String sql = "INSERT INTO rol VALUES (?, ?)";
        Object[] x = new Object[2];
        x[0] = nuevo.getNombre();
        x[1] = nuevo.getDescripcion();
        
        boolean sePudo = true;
        
        if(BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, x)){
            Funcion_empleado_DAO.crear(nuevo);    
            nuevo.setId(Rol_DAO.getIdRol(nuevo));

            for(Privilegio_DTO p : nuevo.getPrivilegios()){
                if(!asignarPrivilegioARol(p,nuevo))
                sePudo = false;        
            }
            return sePudo;
        }
        else 
            return false;
    }
    
    
    public static boolean asignarPrivilegioARol(Privilegio_DTO privilegio, Rol_DTO rol) throws Exception {
        //                String sql = "INSERT INTO privilegio (id_rol, id_comportamiento) VALUES ( "+
        //                      rol.getId()+","+
        //                      Integer.parseInt(privilegio.getId())+")";    

        String sql = "INSERT INTO privilegio (id_rol, id_comportamiento) VALUES (?,?)";
        Object[] p = new Object[2];
        p[0] = rol.getId();
        p[1] = Integer.parseInt(privilegio.getId());
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

}
