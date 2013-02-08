/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.ArticuloMinibar_DTO;
import dto.Articulo_DTO;
import dto.Minibar_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;
/**
 *
 * @author jorge
 */
public class Articulo_minibar_DAO {

    public static boolean registrar(Minibar_DTO mn, Articulo_DTO ar, int cantidad) {
        //String sql = "INSERT INTO articulo_minibar (id_articulo_minibar, id_articulo, id_minibar, cantidad) VALUES (NULL, '"+ar.getId()+"', '"+mn.getId()+"','"+cantidad+"');";
        String sql = "INSERT INTO articulo_minibar VALUES (?, ?, ?,?)";
        Object [] param = new Object[4];
        param[0] = 
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    public static ArrayList<ArticuloMinibar_DTO> getArticulosDeMinibar(Minibar_DTO mn ) {
        ArrayList<ArticuloMinibar_DTO> lista = new ArrayList<ArticuloMinibar_DTO>();
        String sql ="select articulo.nombre,articulo.precio,articulo_minibar.cantidad from articulo_minibar inner join articulo on articulo_minibar.id_articulo=articulo.id_articulo where id_minibar='"+mn.getId()+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
                Articulo_DTO art = new Articulo_DTO();
                art.setNombre(rs.getString(1));
                art.setPrecio(rs.getFloat(2));
                ArticuloMinibar_DTO nuevo = new ArticuloMinibar_DTO(art, rs.getInt(3));
                lista.add(nuevo);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
}
