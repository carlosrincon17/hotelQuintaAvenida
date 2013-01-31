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
    public static ArrayList<String> getAll() {
        String sql = "select nombre from estado_habitacion";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        ArrayList<String> l = new ArrayList<String>();
        try {
            while(rs.next()){
            l.add(rs.getString(1));
        }
        } catch (Exception e) {
        }
        return l;
    }
    
    public static int getIdporNombre(String nombre){
        String sql = "select id_estado from estado_habitacion where nombre='"+nombre+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        int x=0;
        try {
            if(rs.next())
                x=rs.getInt(1);
        } catch (Exception e) {
        }
        
        return x;
    }
}
