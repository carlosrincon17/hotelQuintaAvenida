/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TipoHabitacion_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;
/**
 *
 * @author jorge
 */
public class Tipo_habitacion_DAO {
    
    
    static int getIdPorNombre(String tipo) throws Exception {
        
        //String sql = "select id_tipo from tipo_habitacion where nombre='"+tipo+"'";
        String sql = "SELECT id_tipo FROM tipo_habitacion WHERE nombre = ?";
        Object[] p = new Object[1];
        p[0] = tipo;

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        int x;

        if (rs.next()) {
            System.out.println(rs.getInt(1));
        }
        x = rs.getInt(1);
        return x;
    }

    
    public static ArrayList<String> getAll() throws Exception {

        String sql = "select nombre from tipo_habitacion";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        ArrayList<String> l = new ArrayList<>();
        while (rs.next()) {
            l.add(rs.getString(1));
        }
        return l;
    }
    public static ArrayList<TipoHabitacion_DTO> listarMovil() throws Exception{
    String sql= "select nombre, precio, descripcion, imagen from tipo_habitacion";
    ResultSet rs= BaseDeDatos.getInstance().ejecutarSQL(sql, null);
    ArrayList<TipoHabitacion_DTO> listaHabitaciones= new ArrayList<>();
    try{
        while(rs.next()){
            listaHabitaciones.add(new TipoHabitacion_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
    }
    catch(Exception e){
        System.out.println("Error");
    }
    return listaHabitaciones;     
}
    
}
