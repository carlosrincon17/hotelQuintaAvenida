/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.BaseDeDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author jorge
 */
public class Tipo_habitacion_DAO {
    
    

    static int getIdPorNombre(String tipo) {
        //String sql = "select id_tipo from tipo_habitacion where nombre='"+tipo+"'";
        String sql = "SELECT id_tipo FROM tipo_habitacion WHERE nombre='"+tipo+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        int x=0;
        try {
            if(rs.next())
                System.out.println(rs.getInt(1));
                x=rs.getInt(1);
        } catch (Exception e) {
        }
        
        return x;
    }

    public static ArrayList<String> getAll() {
        String sql = "select nombre from tipo_habitacion";
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
    
}
