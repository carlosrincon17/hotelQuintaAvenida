/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import util.BaseDeDatos;

/**
 *
 * @author jorge
 */
public class Comportamiento_DAO {
    
    public static boolean insertar() throws Exception{
        String sql ="INSERT INTO comportamiento (nombre, enlace) VALUES (?, ?)";
        Object[] p = new Object[2];
        p[0] = "crear rol";
        p[1] = "crear_rol.jsp";
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static void main(String args[]) throws Exception{
        
        if(insertar()) System.out.println("hecho");
        else System.out.println("pailas");
    }
}
