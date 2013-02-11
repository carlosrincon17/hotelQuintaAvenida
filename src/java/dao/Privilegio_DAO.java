/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Modulo_DTO;
import dto.Privilegio_DTO;
import dto.Rol_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CONNORS
 */
public class Privilegio_DAO {
    
    /**
     * Metodo que permite obtener los privilegios de un rol dado un Objeto de tipo Rol_DTO,
     * Que puede contener el nombre del rol o el ID del rol
     * @param rol El Objeto Rol_DTO del del cual se desean obtener los Privilegios
     * @return ArrayList<Privilegio_DTO> con los privilegios del Rol dado
     */
    public static ArrayList<Privilegio_DTO> getPrivilegiosRol(Modulo_DTO modulo , Rol_DTO rol) throws Exception{
    
        String sql = "SELECT comportamiento.nombre, enlace FROM privilegio "
                + "INNER JOIN comportamiento ON privilegio.id_comportamiento = comportamiento.id_comportamiento "
                + "INNER JOIN modulo ON comportamiento.id_modulo = modulo.id_modulo     "
                + "WHERE modulo.nombre = ? AND privilegio.id_rol = ? ORDER BY comportamiento.id_comportamiento";

        Object[] p = new Object[2];
        p[0] = modulo.getNombre();
        p[1] = rol.getId();

        ArrayList<Privilegio_DTO> privilegios = new ArrayList<>();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        while (rs.next()) {
            Privilegio_DTO privilegio = new Privilegio_DTO();
            privilegio.setNombre(rs.getString(1));
            privilegio.setEnlace(rs.getString(2));
            privilegios.add(privilegio);
        }
        return privilegios;
    }
    
    
    public static ArrayList<Privilegio_DTO> getPrivilegiosRol(Rol_DTO rol) throws Exception{

        String sql = "";
        Object[] p = new Object[1];

        if (rol.getId() == 0) {
            sql = "SELECT id_privilegio, nombre, enlace FROM privilegio NATURAL JOIN comportamiento WHERE privilegio.id_rol ="
                    + "(SELECT id_rol FROM rol WHERE nombre= ?) ORDER BY comportamiento.id_modulo";
            p[0] = rol.getNombre();
        } 
        else if (rol.getNombre() == null) {
            sql = "SELECT id_privilegio, nombre, enlace FROM privilegio NATURAL JOIN comportamiento WHERE privilegio.id_rol = ? ORDER BY comportamiento.id_modulo";
            p[0] = rol.getId();
        }

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        ArrayList<Privilegio_DTO> privilegios = new ArrayList<>();

        while (rs.next()) {
            Privilegio_DTO privilegio = new Privilegio_DTO();
            privilegio.setId(String.valueOf(rs.getInt(1)));
            privilegio.setNombre(rs.getString(2));
            privilegio.setEnlace(rs.getString(3));
            privilegios.add(privilegio);
        }
        return privilegios;
    }
    
    
    public static ArrayList<Privilegio_DTO> readAll() throws Exception {

        String sql = "SELECT * FROM comportamiento";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        ArrayList<Privilegio_DTO> privilegios = new ArrayList<>();

        while (rs.next()) {
            Privilegio_DTO privilegio = new Privilegio_DTO();
            privilegio.setId(String.valueOf(rs.getInt(1)));
            privilegio.setNombre(rs.getString(2));
            privilegio.setEnlace(rs.getString(3));
            privilegios.add(privilegio);
        }
        return privilegios;
    }
}
