/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase que permite conectar con una Base De datos Mysql; sin embargo,
 * con solo cambiar el atributo controlador puede usarse para cualquier motor de base de datos
 * @author madarm
 */
public class BaseDeDatos {
    
    
    private static BaseDeDatos INSTANCE = new BaseDeDatos();
    
    private String bd = "ufps_41";
    private String login = "ufps_41";
    private String password = "ufps_ab";
    private String url = "jdbc:mysql://sandbox2.ufps.edu.co/"+bd+"?useServerPrepStmts=true";
    private String controlador = "com.mysql.jdbc.Driver";
    private JDBCMiddler jdbc;

    
    // Constructor privado para el patron singleton
    private BaseDeDatos(){
    }
    
    public static BaseDeDatos getInstance(){
        //Calendar ahora = Calendar.getInstance();
        //System.out.println("BaseDedatos-> " +INSTANCE.hashCode()+ " -> " +ahora.getTimeInMillis());
        return INSTANCE;
    }
    
    
    /**
     * 
     * @return boolean true si hay conexión
     */
    public boolean hayConexion() {
        return (jdbc != null && jdbc.hayConexion());
    }

    /**
     *
     */
    public void conectar() throws Exception{
        jdbc = JDBCMiddler.getInstance(controlador, url, login, password);
        //Calendar ahora = Calendar.getInstance();
        //System.out.println("jdbc-> " +jdbc.hashCode()+ " -> " +ahora.getTimeInMillis());
        //jdbc = new JDBCMiddler(controlador, url, login, password);
       // System.err.println("hashCode de JDBCMiddler ->> " + jdbc.hashCode());        
        jdbc.conectar();
    }
    
        
    /**
     *
     */
    public void desconectar() throws Exception{
        jdbc.desconectar(); 
    }

    
    //  == P A R A M E T R I Z A D A S ==
    
    
    /**
     * Metodo para ejecutar consultas parametrizadas en la base de datos
     * @param String sql con la con la consulta parametrizada
     * @param Object[] param arreglo de tamaño igual al numero de ? en la
     * consulta parametrizada y en cada posición guarda el dato correspondiente.
     * @return boolean si es verdad que se pudo ejecutar la consulta
     */
    public boolean ejecutarActualizacionSQL(String sql, Object[] param) throws Exception {

        if (param == null) {
            return (jdbc.ejecutarActualizacionSQL(sql));
        } 
        return (jdbc.ejecutarActualizacionSQL(sql, param));
        
    }

    /**
     * Metodo para ejecutar consultas parametrizadas en la base de datos
     * @param String sql con la con la consulta parametrizada
     * @param Object[] param arreglo de tamaño igual al numero de ? en la
     * consulta parametrizada y en cada posición guarda el dato correspondiente.
     * @return ResultSet objeto que contiene los datos de la consulta
     */
    public ResultSet ejecutarSQL(String consultaSQL, Object[] param) throws Exception {
        if (param == null) {
            return jdbc.ejecutarSQL(consultaSQL);
        }
        return jdbc.ejecutarSQL(consultaSQL, param);
    }

    
    /**
     * Metodo para ejecutar consultas parametrizadas en la base de datos
     * @param String sql con la con la consulta parametrizada
     * @param Object[] param arreglo de tamaño igual al numero de ? en la
     * consulta parametrizada y en cada posición guarda el dato correspondiente.
     * @return ArrayLis<String> contiene los datos de la consulta, cada nodo
     * equivale a un registro, los datos de los campos están concatenados
     */
    public ArrayList<String> getConsultaSQL(String sql, Object[] param) throws Exception{
        return jdbc.getSQL(sql, param);  
    }
    
    //  == F I N == 

       

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        if (BaseDeDatos.getInstance().hayConexion()) {
            System.out.println("Ya hay conexion");
        } else {
            System.out.println("Intentando conectar con la base de datos...");
            try{    BaseDeDatos.getInstance().conectar();     }
            catch(Exception e){
                System.err.println("SQL Error:" + e.getMessage());
            }
            if (BaseDeDatos.getInstance().hayConexion()) {
                System.out.println("Base de datos conectada.");
            }else  System.out.println("Base de datos NO conectada.");
        }
        
    }


}
