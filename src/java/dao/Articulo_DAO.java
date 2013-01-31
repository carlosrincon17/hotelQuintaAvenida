/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.ResultSet;
import util.BaseDeDatos;
import dto.Articulo_DTO;
import java.util.ArrayList;
/**
 *
 * @author jorge
 */
public class Articulo_DAO {
    public static boolean create(Articulo_DTO art){
        String sql = "INSERT INTO articulo (id_articulo, nombre, precio,cantidad) VALUES (NULL, '"+art.getNombre()+"', '"+art.getPrecio()+"','"+art.getCantidad()+"')";
        
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static ArrayList<Articulo_DTO> getAll(){
        ArrayList<Articulo_DTO> l = new ArrayList<Articulo_DTO>();
        //aqui va la logica de la dao
        String sql= "select * from articulo";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
                Articulo_DTO nuevo= new Articulo_DTO();
                nuevo.setId(rs.getString(1));
                nuevo.setNombre(rs.getString(2));
                nuevo.setPrecio(rs.getFloat(3));
                nuevo.setCantidad(rs.getInt(4));
                l.add(nuevo);
            }
        } catch (Exception e) {
        }
        
        return l;
    }

    public static boolean update(Articulo_DTO art, int nuevo) {
        
        String sql = "update articulo set cantidad = "+nuevo+" where id_articulo = "+art.getId()+"";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static int getCantidadArticulo(Articulo_DTO art){
        String sql1 = "SELECT cantidad FROM articulo WHERE id_articulo = "+art.getId()+"";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql1);
        int saldo = 0;
        try {
            if(rs.next())
                saldo = rs.getInt(1);
            else
                saldo = -1;
        } catch (Exception e) {
            saldo = 0;
        }
        
        return saldo;
    }
}
