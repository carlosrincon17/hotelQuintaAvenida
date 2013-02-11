/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Minibar_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;
/**
 *
 * @author jorge
 */
public class Minibar_DAO {
    
    
    public static boolean create(Minibar_DTO minibar) throws Exception{
        String sql = "INSERT INTO minibar VALUES (?, ? ,?)";
        Object[] p = new Object[3];
        p[0] = minibar.getId();
        p[1] = minibar.getMarca();
        p[2] = minibar.getModelo();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static ArrayList<Minibar_DTO> getAll() throws Exception {

        String sql = "select * from minibar";
        ArrayList<Minibar_DTO> lista = new ArrayList<>();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        while (rs.next()) {
            Minibar_DTO nuevo = new Minibar_DTO();
            nuevo.setId(rs.getString(1));
            nuevo.setMarca(rs.getString(2));
            nuevo.setModelo(rs.getString(3));
            lista.add(nuevo);
        }
        return lista;
    }
    
}
