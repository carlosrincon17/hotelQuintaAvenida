package util;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Un objeto JDBCMiddler permite abstraer cualquier conexion JDBC. 
 * La conexion a una base de datos con JDBC requiere dos pasos fundamentales: 
 * 1. Registrar el controlador 
 * 2. Establecer la conexion
 * Para esto es necesario tener los controladores, la URL de recurso de base de 
 * datos, el usuario y su clave.
 * Esta clase permite encapsular todo el trabajo y la informacion de una Base de
 * Datos, en un unico objeto dentro de una aplicacion.
 */
public class JDBCMiddler {

    /**
     * Objeto singleton, implementado de la forma de iniciación diferida y hilo seguro
     */
    private static JDBCMiddler INSTANCE = null; 
    /**
     * Una cadena con la ubicacion del controlador JDBC, en la forma
     * paquete.subpaquetes.DriverClass Por defecto toma el valor
     * sun.jdbc.odbc.JdbcOdbcDriver.
     */
    protected String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
    /**
     * Una cadena con la ubicacion del recurso de base de datos en la forma
     * protocolo:subprotocolo:nombrerecurso. El protocolo por lo general
     * es jdbc.fabricante, el subprotocolo depende del controlador e igualmente
     * nombrederecurso.
     */
    protected String url = "jdbc.odbc.default";
    /**
     * Una referencia al objeto Connection de la base de datos
     */
    protected Connection conexion;
    /**
     * Una cadena con el nombre de usuario(Login)
     */
    protected String usuario;
    /**
     * Una cadena con la clave (password)
     */
    protected String clave = new String();
    /**
     * Una cadena SQL
     */
    protected String SQL;
    
    

    //  -  C O N S T R U C T O R E S -> 
    
    /**
     * Crea un objeto JDBCMiddler vacio sin parametros de conexion. Constructor
     * por defecto.
     */
    private JDBCMiddler() {
        System.out.println("new EJB[" + this.hashCode() + "]");
    }

    /**
     * Crea un objeto JDBCMiddler, que encapsula toda la informacion y metodos
     * de acceso a una base de datos dentro de una aplicacion en el contexto      * JDBC.
     * @param	controlador	Una cadena con el controlador JDBC a emplear
     * @param	url	Una cadena de conexion JDBC a la Base de Datos
     */
    private JDBCMiddler(String controlador, String url) {
        this.controlador = controlador;
        this.url = url;
    }

    /**
     * Crea un objeto JDBCMiddler, que encapsula toda la informacion y metodos
     * de acceso a una base de datos dentro de una aplicacion en el contexto
     * JDBC.
     * @param	controlador	Una cadena con el controlador JDBC a emplear
     * @param	url	Una cadena de conexion JDBC a la Base de Datos
     * @param   usuario	Una cadena con el login
     * @param	clave	Una cadena con la clave de acceso
     */
    private JDBCMiddler(String controlador, String url, String usuario, String clave) {
        this.controlador = controlador;
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }

    
    //  - H A C E R  C O N E X I O N  ->  
    
    /**
     * Averigua si la conexion con la Base de Datos está disponible.
     * @return	Regresa verdadero (true) si la conexion está disponible. La
     * conexión está disponible cuando conexión != null y !conexión.isClosed()
     */
    protected boolean hayConexion() {
        return this.conexion != null;
    }

    /**
     * Establece una conexion con la base de datos. Si existen parametros de
     * conexion los usa y se conecta de la manera tradicional.
     * @return	Regresa verdadero (true) si pudo establecer la conexion de lo
     * contrario regresa falso (false).
     * @exception Lanza un error si algo extraño sucede :)
     */
    protected boolean conectar() throws Exception {    
        if (!hayConexion()) {
            return conectar(this.usuario, this.clave);
        }
        return true;
    }

    /**
     * Se conecta a un servicio JDBC usando java.naming. Los parametros de
     * configuracion se manejan para el contexto de la aplicacion, permitiendo
     * un pool de conexiones persistentes disponibles para toda la aplicacion.
     * Tomcat proporciona este servicio configurandolo en el archivo web.xml o
     * server.xml
     * @param	servicio	Una cadena como "java:comp/env/servicio"
     */
    protected boolean conectar(String servicio) throws Exception {

        /*
         * Para conectarse con Tomcat en el archivo de coniguracion se
         * especifican los parametros de conexion.
         */
        long t = System.currentTimeMillis();
        //Context es un objeto que encapsula el contexto de la aplicacion
        Context ctx = new InitialContext();
        //DataSource es el origen de datos, 
        //un servicio JDBC proporcionado mediante java naming
        //El nombre del servicio deberia ser recibido como
        //argumento
        DataSource ds = (DataSource) ctx.lookup(servicio);

        //Ahora si obtiene la conexion
        this.conexion = ds.getConnection();

        return this.conexion != null;
    }

    /**
     * Establece una conexion con la base de datos, usando el usuario y clave
     * especificados. Si ya hay una conexion, esta es cerrada.
     *
     * @param	usuario	Una cadena con el nombre de usuario
     * @param   clave	Una cadena con la clave
     * @return	Regresa verdadero (true) si pudo establecer la conexion de lo
     * contrario regresa falso (false).
     */
    protected boolean conectar(String usuario, String clave) throws Exception {

        //Registra el controlador de manera implicita
        Class.forName(controlador).newInstance();
        //Obtiene la conexion
        System.err.println(url + "," + usuario + "," + clave + ":ON!!!");
        this.conexion = DriverManager.getConnection(url, usuario, clave);
        //Actualiza usuario y clave del middler
        this.usuario = usuario;
        this.clave = clave;
        return this.conexion != null;
    }
    
    /**
     * Cierra la conexion con la base de datos
     */
    protected void desconectar() throws Exception {
        if (this.hayConexion()) {
            this.conexion.close();
            this.conexion = null;
            System.err.println(url + "," + usuario + "," + clave + ":OFF!!!");
        }
    }

    
    // - C O N S U L T A R -> 
    
    /**
     * Ejecuta una sentencia SQL y regresa como resultado un objeto ResultSet
     * @param	consultaSQL	Cadena que contiene una sentencia de consulta SQL:
     * SELECT listaCampos FROM listaTablas WHERE listaCondiciones
     * @return	Regresa un objeto ResulSet con el resultado de la consulta
     */
    protected ResultSet ejecutarSQL(String consultaSQL) throws Exception {
        return this.ejecutarSQL(consultaSQL, null);
    }

    protected boolean ejecutarActualizacionSQL(String comandoSQL) throws Exception {
        return this.ejecutarActualizacionSQL(comandoSQL, null);
    }
    
    protected ArrayList<String> getSQL(String SQL) throws Exception {
        return this.getSQL(SQL, null);
    }

    
    
    //  ==  C O N S U L T A S  P A R A M E T R I Z A D A S ==
    
    
     /**
     * Ejecuta una sentencia SQL. La sentencia requiere de arametros en tiempo 
     * de ejecucion.
     * La consulta es preparada porque requiere de parametros
     * por ejemplo:
     * delete from producto where precio=?
     * insert into producto values (?,?,?,?,?)
     * los ? indican parametros ordenados por posicion
     * @param String consultaSQL	Cadena que contiene una sentencia
     * @param Object[] Un arreglo de parametros de la consulta sql.
     * @return	falso o verdadero si pudo ejecutar la consulta
     */
    protected boolean ejecutarActualizacionSQL(String comandoSQL, Object[] param) throws Exception {

        boolean ok;
        if (this.conectar()) {
            try (PreparedStatement sql = this.conexion.prepareStatement(comandoSQL)) {
                if (param != null) {    // carga los parametros en la consulta
                    cargarParametros(sql, param);
                }
                ok = sql.executeUpdate() != 0;
            }
            this.desconectar();
            return ok;
        } 
        return false;
    }
    
    /**
     * Ejecuta una sentencia SQL y regresa como resultado un objeto ResultSet
     * @param String consultaSQL Cadena que contiene una sentencia de consulta SQL
     * SELECT listaCampos FROM listaTablas WHERE listaCondiciones
     * @return	ResulrSet Regresa un objeto con el resultado de la consulta
     */
    protected ResultSet ejecutarSQL(String consultaSQL, Object[] param) throws Exception {
        
        ResultSet rs = null;
        if (this.conectar()) {
              PreparedStatement sql = this.conexion.prepareStatement(consultaSQL);
              if(param != null){    cargarParametros(sql, param);   }
              rs = sql.executeQuery();
        } 
        return rs;
    }

    /**
     * Método para consultar una base de datos y obtener el resultado ordenado en 
     * ArrayList cada nodo tiene los valores de los campos de un registro concatenados.
     * @param SQL String con la consulta parametrizada
     * @param param Object[] arreglo que tiene el valor de los parametros
     * @return ArrayList<String> con los datos correspondientes a la consulta
     */
    protected ArrayList<String> getSQL(String SQL, Object[] param) throws Exception {
        
        ArrayList<String> v = new ArrayList<>();

        if (conectar()) {
            PreparedStatement ps = this.conexion.prepareStatement(SQL);
            if(param != null) {         // cargar parametros al sql precompilado         
                cargarParametros(ps, param);
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();

            while (rs.next()) {
                String r = "";
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    r += rs.getString(i) + "-";
                }
                v.add(r);
            }
            desconectar();
        }
        return v;
    } 

    
    // -  V A R I O S ->
    
    public static JDBCMiddler getInstance(String controlador, String url, String usuario, String clave){
        crearInstancia(controlador, url, usuario, clave);
        return INSTANCE;
    }
    
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private static void crearInstancia(String controlador, String url, String usuario, String clave){    
        synchronized(JDBCMiddler.class){
            // En la zona sincronizada sería necesario volver
            // a comprobar que no se ha creado la instancia
            if (INSTANCE == null) {
                INSTANCE = new JDBCMiddler(controlador, url, usuario, clave);
            }
        }
    } 
    
     /**
     * Servicio que permite Leer los parametros de entrada desde un archivo
     */
    protected static String[] leerParametros(String rutaArchivo) throws Exception {
        
        String[] parametros = new String[5];
        try (java.io.BufferedReader flujoE = new java.io.BufferedReader(
                     new java.io.FileReader(rutaArchivo))) {
            parametros[0] = flujoE.readLine();
            parametros[1] = flujoE.readLine();
            parametros[2] = flujoE.readLine();
            parametros[3] = flujoE.readLine();
            parametros[4] = flujoE.readLine();
        }
        return parametros;
    }
        
    /**
     * Método para asignarle los valores correspondientes a los ? de la consulta
     * precompilada
     * @param sql PreparedStatement la consulta precompilada
     * @param parametros Object[] arreglo con los valores de los parametros
     */
    protected void cargarParametros(PreparedStatement sql, Object[] parametros) throws Exception{
        /*
         Hay que tener en cuenta cuando se envié dentro del arreglo de 
         parametros un valor null, la pregunta es si en algún momento se quiere
         que un campo de una tabla sea null.... 
         */
        String clase;
        for (int i = 1; i <= parametros.length; i++) {
            
            
            clase = parametros[i - 1].getClass().getName();   // nombre de la clase
            switch (clase) {
                case "java.lang.String":
                    sql.setString(i, (String) parametros[i - 1]);
                    break;
                case "java.lang.Integer":
                    sql.setInt(i, (Integer) parametros[i - 1]);
                    break;
                case "java.lang.Float":
                    sql.setFloat(i, (Float) parametros[i - 1]);
                    break; 
            }
        }
    }
    
    
    
    /*
     * M E T O D O S  D E  A C C E S O -
     */
    
    protected String getUsuario() {
        return this.usuario;
    }
    
    protected String getClave() {
        return this.clave;
    }

    protected String getUrl() {
        return this.url;
    }
    
    protected String getControlador() {
        return this.controlador;
    }

    
    /**
     *  M E T O D O S  S E T - 
     */
    
    protected void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    protected void setClave(String clave) {
        this.clave = clave;
    }
    
    protected void setUrl(String url) {
        this.url = url;
    }

    protected void setControlador(String controlador) {
        this.controlador = controlador;
    }

    protected void setSQL(String SQL) {
        this.SQL = SQL;
    }

    
    /**
     * Metodo de prueba Recibe como argumento el nombre del archivo de
     * configuracion. Para usarlo: java JDBCMiddler archivo.conf
     */
    protected static void main(String args[]) throws Exception {
       
        //Se recibe como argumento del main el archivo de 
        //configuracion que contiene el driver
        //la url, el login y la clave
        String parametros[] = leerParametros(args[0]);
        int n = 1;
        JDBCMiddler middler = new JDBCMiddler(parametros[0],
                parametros[1],
                parametros[2],
                parametros[3]);
        if (middler.conectar()) {
            System.out.println(parametros[4]);
            ResultSet rs = middler.ejecutarSQL(parametros[4]);
            while (rs.next()) {
                ResultSetMetaData rsm = rs.getMetaData();
                System.out.println("****************************");
                System.out.println("Registro: " + (n++));
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    System.out.print(rsm.getColumnName(i) + ": ");
                    System.out.println(rs.getString(i));
                }
            }
            middler.desconectar();
            System.out.println("todo bien");
        }
    }
}