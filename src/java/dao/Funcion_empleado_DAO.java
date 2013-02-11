/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Rol_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.BaseDeDatos;

/**
 *
 * @author jorge
 */
public class Funcion_empleado_DAO {
    
    
    public static ArrayList<String> getFunciones() throws Exception {

        String sql = "select nombre from funcion_empleado";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        ArrayList<String> funciones = new ArrayList<>();
        
        while (rs.next()) {
            funciones.add(rs.getString(1));
        }
        return funciones;
    }
    
    
    /**
     * Metodo que obtiene las funciones de los empleados con sus ID
     * @return Una Lista con vectores donde la posicion [0] es el id de la funcion
     * y la posicion [1] es el nombre de tal funcion
     */
    public static ArrayList<String[]> getArrayFunciones() throws Exception {

        String sql = "select * from funcion_empleado";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        ArrayList<String[]> funciones = new ArrayList<>();

        while (rs.next()) {
            String[] funcion = new String[2];
            funcion[0] = String.valueOf(rs.getInt(1));
            funcion[1] = rs.getString(2);
            funciones.add(funcion);
        }
        return funciones;
    }

        
    public static String getNombrePorId(int id) throws Exception{
        
        String sql = "select nombre from funcion_empleado where id_funcion = ?";
        Object[] p = new Object[1];
        p[0] = id;
        ArrayList<String> rs = BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        return rs.get(0);
    }
    
    
    public static int getFuncionByCedula(String cedula) throws Exception{
    
        String sql = "SELECT id_funcion FROM empleado WHERE id_empleado = ?";
        Object[] p = new Object[1];
        p[0] = cedula;

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        int id = -1;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
    
    
    public static int getIdPorNombre(String nombre) throws Exception{
        
        String sql = "select id_funcion from funcion_empleado where nombre = ?";
        Object[] p = new Object[1];
        p[0] = nombre;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        if (rs.next())
            return rs.getInt(1);
        return 0;
    }
    
    
    public static boolean crear(Rol_DTO rol) throws Exception{
    
        //String sql="INSERT INTO funcion_empleado (nombre) VALUES ( '"+rol.getNombre()+"')";
        String sql = "INSERT INTO funcion_empleado (nombre) VALUES (?)";
        Object[] p = new Object[1];
        p[0] = rol.getNombre();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
}
