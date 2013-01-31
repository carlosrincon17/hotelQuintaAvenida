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
    public static ArrayList<String> getFunciones() {
        String sql = "select nombre from funcion_empleado";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        
        ArrayList<String> funciones = new ArrayList<String>();
        try {
            while(rs.next()){
            funciones.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funcion_empleado_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funciones;
    }
    /**
     * Metodo que obtiene las funciones de los empleados con sus ID
     * @return Una Lista con vectores donde la posicion [0] es el id de la funcion
     * y la posicion [1] es el nombre de tal funcion
     */
    public static ArrayList<String[]> getArrayFunciones() {
        String sql = "select * from funcion_empleado";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        
        ArrayList<String[]> funciones = new ArrayList<String[]>();
        try {
            while(rs.next()){
                String[] funcion = new String[2];
                funcion[0] = String.valueOf(rs.getInt(1));
                funcion[1] = rs.getString(2);
                funciones.add(funcion);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return funciones;
    }
    
    public static String getNombrePorId(int id){
        String sql = "select nombre from funcion_empleado where id_funcion="+id;
        ArrayList<String> rs = BaseDeDatos.getConsultaSQL(sql);
        return rs.get(0);
    }
    
    public static int getFuncionByCedula(String cedula){
    
        String sql = "SELECT id_funcion FROM empleado WHERE id_empleado='"+cedula+"'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        int id = -1;
        try {
            if(rs.next())
                id = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static int getIdPorNombre(String nombre){
        String sql = "select id_funcion from funcion_empleado where nombre='"+nombre+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            if(rs.next())
                return rs.getInt(1);
        } catch (Exception e) {
        }
        return 0;
    }
    
    public static boolean crear(Rol_DTO rol){
    
        String sql="INSERT INTO funcion_empleado (nombre) VALUES ( '"+rol.getNombre()+"')";
        
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
}
