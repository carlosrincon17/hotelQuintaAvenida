/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Articulo_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;
/**
 *
 * @author jorge
 */

public class Articulo_DAO {
    
    public static boolean create(Articulo_DTO art) throws Exception{
        String sql = "INSERT INTO articulo VALUES (?, ?, ?, ?)";
        //String sql = "INSERT INTO articulo (id_articulo, nombre, precio,cantidad) VALUES (NULL, '"+art.getNombre()+"', '"+art.getPrecio()+"','"+art.getCantidad()+"')";
        Object param [] = new Object[4];
        param[0] = art.getId();
        param[1] = art.getNombre();
        param[2] = art.getPrecio();
        param[3] = art.getCantidad();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, null);
    }
    
    public static ArrayList<Articulo_DTO> getAll() throws Exception {
       
        ArrayList<Articulo_DTO> l = new ArrayList<>();
        String sql = "select * from articulo";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        while (rs.next()) {
            Articulo_DTO nuevo = new Articulo_DTO();
            nuevo.setId(rs.getString(1));
            nuevo.setNombre(rs.getString(2));
            nuevo.setPrecio(rs.getFloat(3));
            nuevo.setCantidad(rs.getInt(4));
            l.add(nuevo);
        }
        return l;
    }
    
    public static boolean update(Articulo_DTO art, int nuevo) throws Exception{    
        String sql = "UPDATE articulo SET cantidad = ? WHERE id_articulo = ?";
        Object [] param = new Object[2];
        param[0] = nuevo;
        param[1] = art.getId();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    public static int getCantidadArticulo(Articulo_DTO art) throws Exception{
        
        String sql1 = "SELECT cantidad FROM articulo WHERE id_articulo = ?";
        Object[] param = new Object[1];
        param[0] = art.getId();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql1, param);
        if(rs.next()) { return rs.getInt(1);    }
        return -1;
    }
}
