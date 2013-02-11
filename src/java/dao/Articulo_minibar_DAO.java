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

    public static boolean registrar(Minibar_DTO mn, Articulo_DTO ar, int cantidad) throws Exception{
    
        String sql = "INSERT INTO articulo_minibar (id_articulo, id_minibar, cantidad) VALUES (?, ?,?)";
        Object [] param = new Object[3];
        param[0] = ar.getId();
        param[1] = mn.getId();
        param[2] = cantidad;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    public static ArrayList<ArticuloMinibar_DTO> getArticulosDeMinibar(Minibar_DTO mn) throws Exception {
        ArrayList<ArticuloMinibar_DTO> lista = new ArrayList<>();
        String sql = "SELECT articulo.nombre, articulo.precio, articulo_minibar.cantidad "
                + "FROM articulo_minibar inner join articulo on "
                + "articulo_minibar.id_articulo = articulo.id_articulo where id_minibar = ?";

        Object[] param = new Object[1];
        param[0] = mn.getId();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, param);

        while (rs.next()) {
            Articulo_DTO art = new Articulo_DTO();
            art.setNombre(rs.getString(1));
            art.setPrecio(rs.getFloat(2));
            ArticuloMinibar_DTO nuevo = new ArticuloMinibar_DTO(art, rs.getInt(3));
            lista.add(nuevo);
        }
        return lista;
    }
    
}
