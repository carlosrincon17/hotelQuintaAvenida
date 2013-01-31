/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Modulo_DTO;
import dto.Rol_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CONNORS
 */
public class Modulo_DAO {
    
    public static ArrayList<Modulo_DTO> readAll(Rol_DTO rol){
    
        String sql = "SELECT DISTINCT modulo.nombre FROM privilegio INNER JOIN comportamiento ON privilegio.id_comportamiento = comportamiento.id_comportamiento "
                + "INNER JOIN modulo ON comportamiento.id_modulo = modulo.id_modulo WHERE privilegio.id_rol = 1";
        
        
        ArrayList<Modulo_DTO> modulos = new ArrayList<Modulo_DTO>();
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try{
            while(rs.next()){
                Modulo_DTO modulo = new Modulo_DTO(rs.getString(1));
                modulo.setComportamientos(Privilegio_DAO.getPrivilegiosRol(modulo, rol));
                modulos.add(modulo);
            }
        
        }catch(Exception e){
        e.printStackTrace();
        }
        
        return modulos;
    }
    
}
