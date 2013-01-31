/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.ResultSet;

/**
 *Clase que permite conectar con una Base De datos Mysql; sin embargo,
 * con solo cambiar el atributo controlador puede usarse para cualquier motor de base de datos
 * @author madarme
 */
public class BaseDeDatos {


    
    private static String bd = "ufps_41";
    private static String login = "ufps_41";
    private static String password = "ufps_ab";
    private static String url = "jdbc:mysql://sandbox2.ufps.edu.co/"+bd;
    private static String controlador = "com.mysql.jdbc.Driver";
    private static JDBCMiddler jdbc;

    
    /**
     *
     * @return
     */
    public static boolean hayConexion() {
        return (jdbc != null && jdbc.hayConexion());
    }

    /**
     *
     */
    public static void conectar() {

        //BaseDeDatos.url = BaseDeDatos.url+BaseDeDatos.bd;
        jdbc = new JDBCMiddler(controlador, url, login, password);
        try {
            jdbc.conectar();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



    /**
     *
     * @param comandoSQL
     * @return
     */
    public static boolean ejecutarActualizacionSQL(String comandoSQL) {
        try {
            return (jdbc.ejecutarActualizacionSQL(comandoSQL));
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
            return (false);
        }
    }
    /**
     *
     */
    public static void desconectar() {
        
        try {
            jdbc.desconectar();
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());

        }
    }

    /**
     *
     * @param sql
     * @return
     */
    public static String getTablaHTML(String sql) {
        try {
            return (jdbc.getHTML(sql));
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
            return ("No se pudo crear la tabla");
        }


    }

    /**
     *
     * @param consultaSQL
     * @return
     */
    public static ResultSet ejecutarSQL(String consultaSQL) {
        try {
            return (jdbc.ejecutarSQL(consultaSQL));
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
            return (null);
        }
    }

    /**
     *
     * @param sql
     * @return
     */
    public static java.util.ArrayList<String> getConsultaSQL(String sql) {
        try {
            return (jdbc.getSQL(sql));
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
            return (null);
        }
    }


    



    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        if (BaseDeDatos.hayConexion()) {
            System.out.println("Ya hay conexion");
        } else {
            System.out.println("Intentando conectar con la base de datos...");
            BaseDeDatos.conectar();
            if (BaseDeDatos.hayConexion()) {
                System.out.println("Base de datos conectada.");
            }else  System.out.println("Base de datos NO conectada.");
        }
        
    }


}
