/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Servicio_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author jorge
 */
public class Servicio_DAO {

    public static boolean create(Servicio_DTO servicio) {
        String sql = "insert into servicio values(null,'"+servicio.getTipo()+"', "+ servicio.getPrecio()+")";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    
    public static ArrayList<Servicio_DTO> getAll(){
        String sql = "select tipo,precio from servicio";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
       ArrayList<Servicio_DTO> lista = new ArrayList<Servicio_DTO>();
        try {
            while(rs.next()){
           Servicio_DTO nuevo = new Servicio_DTO();
           nuevo.setTipo(rs.getString(1));
           nuevo.setPrecio(rs.getFloat(2));
           lista.add(nuevo);
       }
        } catch (Exception e) {
        }
       
       return lista;
    }
    public static boolean editar(Servicio_DTO servicio){
    
        String sql = "UPDATE servicio SET precio="+servicio.getPrecio()+" WHERE tipo='"+servicio.getTipo()+"'";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    
    }
    
    public static boolean editar(Servicio_DTO servicio, String nombre){
    
        String sql = "UPDATE servicio SET precio="+servicio.getPrecio()+", tipo='"+servicio.getTipo()+"' WHERE tipo='"+nombre+"'";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    
    }
    
}
