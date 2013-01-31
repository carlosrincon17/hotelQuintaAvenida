/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.ResultSet;
import util.BaseDeDatos;
import java.util.ArrayList;
import dto.Minibar_DTO;
/**
 *
 * @author jorge
 */
public class Minibar_DAO {
    
    public static boolean create(Minibar_DTO minibar){
        String sql = "INSERT INTO minibar (id_minibar, marca, modelo) VALUES ('"+minibar.getId()+"', '"+minibar.getMarca()+"', '"+minibar.getModelo()+"');";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static ArrayList<Minibar_DTO> getAll(){
        String sql = "select * from minibar";
        ArrayList<Minibar_DTO> lista= new ArrayList<Minibar_DTO>();
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
            Minibar_DTO nuevo = new Minibar_DTO();
            nuevo.setId(rs.getString(1));
            nuevo.setMarca(rs.getString(2));
            nuevo.setModelo(rs.getString(3));
            lista.add(nuevo);
            }
        } catch (Exception e) {
        }
        
        return lista;
    }
    
}
