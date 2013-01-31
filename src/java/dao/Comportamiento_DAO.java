/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.ResultSet;
import util.BaseDeDatos;

/**
 *
 * @author jorge
 */
public class Comportamiento_DAO {
    
    public static boolean insertar(){
        String sql ="INSERT INTO comportamiento (id_comportamiento, nombre, enlace) VALUES (NULL, 'crear rol', 'crear_rol.jsp')";
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static void main(String args[]){
        
        if(insertar()) System.out.println("hecho");
        else System.out.println("pailas");
    }
}
