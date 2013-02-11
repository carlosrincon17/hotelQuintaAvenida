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

    public static boolean create(Servicio_DTO servicio) throws Exception{
        
        String sql = "insert into servicio values(?,?)";
        Object[] p = new Object[2];
        p[0] = servicio.getTipo();
        p[1] = servicio.getPrecio();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static ArrayList<Servicio_DTO> getAll() throws Exception {

        String sql = "select tipo,precio from servicio";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        ArrayList<Servicio_DTO> lista = new ArrayList<>();

        while (rs.next()) {
            Servicio_DTO nuevo = new Servicio_DTO();
            nuevo.setTipo(rs.getString(1));
            nuevo.setPrecio(rs.getFloat(2));
            lista.add(nuevo);
        }

        return lista;
    }
    
    
    public static boolean editar(Servicio_DTO servicio) throws Exception{
        
        String sql = "UPDATE servicio SET precio = ? WHERE tipo = ?";
        Object[] p = new Object[2];
        p[0] = servicio.getPrecio();
        p[1] = servicio.getTipo();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static boolean editar(Servicio_DTO servicio, String nombre) throws Exception{
    
        String sql = "UPDATE servicio SET precio = ?, tipo = ? WHERE tipo = ?";
        Object[] p = new Object[3];
        p[0] = servicio.getPrecio();
        p[1] = servicio.getTipo();
        p[0] = nombre;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);    
    }
    
}
