/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author jorge
 */
public class Estado_habitacion_DAO {
    
    public static ArrayList<String> getAll() throws Exception {

        String sql = "select nombre from estado_habitacion";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        ArrayList<String> l = new ArrayList<>();
        while (rs.next()) {
            l.add(rs.getString(1));
        }
        return l;
    }
    
    
    public static int getIdporNombre(String nombre) throws Exception{
        
        String sql = "select id_estado from estado_habitacion where nombre = ?";
        Object[] p = new Object[1];
        p[0] = nombre;

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        int x = 0;
        if (rs.next()) {
            x = rs.getInt(1);
        }
        return x;
    }
}
