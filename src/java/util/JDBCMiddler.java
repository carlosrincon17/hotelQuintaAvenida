package util;

import java.sql.*;
import java.util.Iterator;
import javax.naming.*;
import javax.sql.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Image;

/**
 *<P align='justify'>
 *Un <I>objeto</I> <B>JDBCMiddler</B> permite abstraer cualquier
 *conexi�n JDBC.
 *La conexion a una base de datos con JDBC requiere dos pasos
 *fundamentales:<BR>
 *1. Registrar el controlador<BR>
 *2. Establecer la conexion<BR>
 *Para esto es necesario tener los controladores,
 *la URL de recurso de base de datos,
 *el usuario y su clave.<BR>
 *
 *Esta clase permite encapsular todo el trabajo y la informacion
 *de una Base de Datos, en un unico objeto dentro de una aplicacion.
 *</P>
*/
class JDBCMiddler{
	
	/**
	 *Una cadena con la ubicacion del controlador JDBC, en la forma 
	 *<I>paquete.subpaquetes.DriverClass</I>
	 *Por defecto toma el valor sun.jdbc.odbc.JdbcOdbcDriver.
	*/
	protected String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
	
	/**Una cadena con la ubicacion del recurso de base de datos en la forma
	 *<I>protocolo:subprotocolo:nombrerecurso</I>. El protocolo por lo general
	 *es jdbc.fabricante, el subprotocolo depende del controlador e igualmente
	 *nombrederecurso.
	*/
	protected String url = "jdbc.odbc.default";
	
	/**Una referencia al objeto Connection de la base de datos*/
	protected Connection conexion;
	
	/**Una cadena con el nombre de usuario(Login)*/
	protected String usuario;
	
	/**Una cadena con la clave (password)*/
	protected String clave=new String();
	
	/**Una cadena SQL*/
	protected String SQL;
	
	/**
	 *Crea un objeto JDBCMiddler vacio sin parametros
	 *de conexion. Constructor por defecto.
	*/
	protected JDBCMiddler() {
	 System.out.println("new EJB["+this.hashCode()+"]");
	}//Fin Constructor Default JDBCMiddler
	
	/**
	 *Crea un objeto JDBCMiddler, que encapsula toda la informacion
	 *y metodos de acceso a una base de datos dentro de una aplicacion
	 *en el contexto JDBC.
	 *@param	controlador		Una cadena con el controlador JDBC a emplear
	 *@param	url				Una cadena de conexion JDBC a la Base de Datos	 
	*/
	protected JDBCMiddler(String controlador, String url) {
	  this.controlador = controlador;
	  this.url = url;
	}//Fin Constructor JDBCMiddler
	
	/**
	 *Crea un objeto JDBCMiddler, que encapsula toda la informacion
	 *y metodos de acceso a una base de datos dentro de una aplicacion
	 *en el contexto JDBC.
	 *@param	controlador		Una cadena con el controlador JDBC a emplear
	 *@param	url				Una cadena de conexion JDBC a la Base de Datos	 
	 *@param 	usuario			Una cadena con el login
	 *@param	clave			Una cadena con la clave de acceso
	*/
	protected JDBCMiddler(String controlador, String url, String usuario,
						String clave){
	 this.controlador = controlador;
	 this.url=url;
	 this.usuario=usuario;
	 this.clave=clave;
	}//Fin Constructor JDBCMiddler
	
	/**
	 *Averigua si la conexi�n con la Base de Datos est� disponible.
	 *@return	Regresa verdadero (true) si la conexi�n est� disponible.
	 *			La conexi�n est� disponible cuando conexi�n!=null y
	 * !conexi�n.isClosed()
	*/
	protected boolean hayConexion(){
	 return this.conexion!=null;
	}//Fin hayConexi�n	
	
	/**
	 *Establece una conexion con la base de datos.
	 *Si existen parametros de conexion los usa
	 *y se conecta de la manera tradicional.
	 *@return	Regresa verdadero (true) si pudo establecer la conexion
	 *			de lo contrario regresa falso (false).
	 *@exception Lanza un error si algo extra�o sucede :)
	*/
	protected boolean conectar() throws Exception{
		
	 if(!hayConexion())
	  return conectar(this.usuario, this.clave);
	 else
	  return true;
	}//Fin conectar
	
	/**
	 *Se conecta a un servicio JDBC usando java.naming.
	 *Los parametros de configuracion se manejan para
	 *el contexto de la aplicacion, permitiendo un 
	 *pool de conexiones persistentes disponibles
	 *para toda la aplicacion. Tomcat proporciona este
	 *servicio configurandolo en el archivo web.xml
	 *o server.xml
	 *@param	servicio	Una cadena como "java:comp/env/servicio"
	 *
	*/
	protected boolean conectar(String servicio) throws Exception{
		
	 /*
	   *Para conectarse con Tomcat
	   *en el archivo de coniguracion se especifican
	   *los parametros de conexion.
	  */
      long t = System.currentTimeMillis();
      //Context es un objeto que encapsula el contexto de la aplicacion
      Context ctx = new InitialContext();
      //DataSource es el origen de datos, 
      //un servicio JDBC proporcionado mediante java naming
      //El nombre del servicio deberia ser recibido como
      //argumento
      DataSource ds = (DataSource)ctx.lookup(servicio);

      //Ahora si obtiene la conexion
      this.conexion = ds.getConnection();
 
      return this.conexion != null;
	}//Fin conectar

	/**
	 *Establece una conexion con la base de datos, usando el usuario
	 *y clave especificados.
	 *Si ya hay una conexi�n, esta es cerrada.
	 *@param	usuario		Una cadena con el nombre de usuario
	 *@param 	clave	Una cadena con la clave
	 *@return	Regresa verdadero (true) si pudo establecer la conexion
	 *			de lo contrario regresa falso (false).
	*/
	protected boolean conectar(String usuario, String clave) throws Exception{
	 
	 //Registra el controlador de manera implicita
	 Class.forName(controlador).newInstance();
	 //Obtiene la conexion
	 System.err.println(url+","+usuario+","+clave+":ON!!!");
	 this.conexion = DriverManager.getConnection(url,usuario,clave);
	 //Actualiza usuario y clave del middler
	 this.usuario = usuario;
	 this.clave = clave;
     return this.conexion != null;
	}//Fin conectar

	/**Cierra la conexion con la base de datos*/
	protected void desconectar() throws Exception{
     if(this.hayConexion()){
       this.conexion.close();
       this.conexion=null;
       System.err.println(url+","+usuario+","+clave+":OFF!!!");
      }
	}//Fin desconectar
	
	/**
	 *Ejecuta una sentencia SQL y regresa como resultado un objeto
	 *ResultSet
	 *@param	consultaSQL	Cadena que contiene una sentencia de 
	 *                      consulta SQL:
	 * 						SELECT listaCampos 
	 *						FROM listaTablas 
	 *						WHERE listaCondiciones
	 *@return	Regresa un objeto ResulSet con el resultado de la consulta
	*/
	protected ResultSet ejecutarSQL(String consultaSQL) throws Exception{
     if(this.conectar()){
	   Statement sql= this.conexion.createStatement();
       return sql.executeQuery(consultaSQL);
     }
     else return null;
	}//Fin ejecutarSQL
    
	/**
	 *Ejecuta una sentencia SQL y regresa como resultado un objeto
	 *ResultSet. La Consulta requiere de parametros en tiempo de ejecuci�n.
	 *@param	consultaSQL	Cadena que contiene una sentencia de 
	 *                      consulta SQL:
	 * 						SELECT listaCampos FROM listaTablas 
	 *						WHERE listaCondiciones
	 *@param	parametros	Un Iterador de Parametros con los parametros 
	 *						de la consulta.
	 *@return	Regresa un objeto ResulSet con el resultado de la consulta
	 
	*/
	protected ResultSet ejecutarSQL(String consultaSQL, Iterator parametros)
					throws Exception{
     if(this.conectar()){
   	   PreparedStatement sql= this.conexion.prepareStatement(consultaSQL);
   	   
   	   //System.err.println(consultaSQL+"-->");
   	   for(int i=1;parametros.hasNext();i++){
   	   	String parametro= parametros.next().toString();
   	   	sql.setString(i,parametro);
   	   	//System.err.println("param["+i+"]="+parametro);
   	   }
   	   	   	   	
   	   return  sql.executeQuery();
      }
     else return null;
	}//Fin ejecutarSQL
	
	/**
	 *Ejecuta una sentencia SQL de insercion
	 *La sentencia requiere de parametros en tiempo de ejecuci�n.
	 *@param	consultaSQL	Cadena que contiene una sentencia de 
	 *                      insercion SQL:
	 * 						INSERT into table values (valores)
	 *@param	parametros	Un Iterador de Parametros con los parametros de la 
	 *						insercion.
	 *@return	falso o verdadero si pudo insertar
	 */
	protected boolean ejecutarActualizacionSQL(String comandoSQL,
					Iterator parametros) throws Exception{
	 boolean ok;
     if(this.conectar()){
   	   //La consulta es preparada porque requiere de parametros
   	   //por ejemplo:
   	   //delete from producto where precio=?
   	   //insert into producto values (?,?,?,?,?)
   	   //los ? indican parametros ordenados por posicion
   	   PreparedStatement sql= this.conexion.prepareStatement(comandoSQL);
   	   
   	   //System.err.println(comandoSQL+"-->");
   	   for(int i=1;parametros.hasNext();i++){
   	   	String parametro= parametros.next().toString();
   	   	sql.setString(i,parametro);
   	   	//System.err.println("param["+i+"]="+parametro);
   	   }
   	   
   	   ok = sql.executeUpdate()!=0;
   	   
   	   //importante cerrar la conexion
   	   sql.close();
   	   sql=null;
   	   this.desconectar();
   	   
   	   return ok;
      }
     else return false;
	}//Fin ejecutarSQL
	
	
	
	protected boolean ejecutarActualizacionSQL(String comandoSQL) throws Exception{
	 boolean ok;
     if(this.conectar()){
   	   //La consulta es preparada porque requiere de parametros
   	   //por ejemplo:
   	   //delete from producto where precio=?
   	   //insert into producto values (?,?,?,?,?)
   	   //los ? indican parametros ordenados por posicion
   	   PreparedStatement sql= this.conexion.prepareStatement(comandoSQL);
   	   
   	   //System.err.println(comandoSQL+"-->");
   	   /*for(int i=1;parametros.hasNext();i++){
   	   	String parametro= parametros.next().toString();
   	   	sql.setString(i,parametro);
   	   	//System.err.println("param["+i+"]="+parametro);
   	   }*/
   	   
   	   ok = sql.executeUpdate()!=0;
   	   
   	   //importante cerrar la conexion
   	   sql.close();
   	   sql=null;
   	   this.desconectar();
   	   
   	   return ok;
      }
     else return false;
	}//Fin ejecutarSQL
	
	
	
	
	
	
	
	
	
	/*-METODOS DE ACCESO-*/	
	
	/**Metodo de acceso a la propiedad usuario*/
	protected String getUsuario(){
	 return this.usuario;
	}//fin getUsuario
	
	/**Metodo de acceso a la propiedad clave*/
	protected String getClave(){
	 return this.clave;
	}//fin getClave
	
	/**Metodo de acceso a la propiedad url*/
	protected String getUrl(){
	 return this.url;
	}//fin getUrl
	
	/**Metodo de acceso a la propiedad controlador*/
	protected String getControlador(){
	 return this.controlador;
	}//fin getControlador
	
	/*-METODOS DE MODIFICACION-*/
	
	/**Metodo de modificacion a la propiedad usuario*/
	protected void setUsuario(String usuario){
	 this.usuario=usuario;
	}//fin setUsuario
	
	/**Metodo de modificacion a la propiedad clave*/
	protected void setClave(String clave){
	 this.clave = clave;
	}//fin setClave
	
	/**Metodo de modificacion a la propiedad url*/
	protected void setUrl(String url){
	 this.url=url;
	}//fin setUrl
	
	/**Metodo de modificacion a la propiedad controlador*/
	protected void setControlador(String controlador){
	 this.controlador = controlador;
	}//fin setControlador
	
	/**Metodo de modificacion a la propiedad consulta*/
	protected void setSQL(String SQL){
	 this.SQL = SQL;
	}//fin setSQL
	
	/**EJECUTA UNA CONSULTA Y GENERA LA TABLA HTML*/
    protected String getHTML(String SQL) throws Exception{
     StringBuffer html = new StringBuffer();
     html.append("<TABLE border='1'>");
     html.append("<TR>");
     
	 if(conectar()){
	  ResultSet rs = ejecutarSQL(SQL);
      ResultSetMetaData rsm = rs.getMetaData();
      html.append("<TR>");
   	  for(int i=1;i<=rsm.getColumnCount();i++){
       html.append("<TH>"+rsm.getColumnName(i)+"</TH>");
      }
      html.append("</TR>");
	  while(rs.next()){
       html.append("<TR>");
	   for(int i=1;i<=rsm.getColumnCount();i++){
	   	html.append("<TD>"+rs.getString(i)+".</TD>");
	   }
       html.append("</TR>");
	  }	 
	  desconectar();
	 }
     
     html.append("</TR>");
     html.append("</TABLE>");
     return html.toString();
    }//Fin getHTML
    
    
    
    protected ArrayList<String> getSQL(String SQL) throws Exception{
     StringBuffer html = new StringBuffer();
     ArrayList<String> v=new ArrayList<String>();
     
     
     
	 if(conectar()){
	  ResultSet rs = ejecutarSQL(SQL);
      ResultSetMetaData rsm = rs.getMetaData();
     
  
    while(rs.next()){
  String r="";
            for(int i=1;i<=rsm.getColumnCount();i++){
	   	r+=rs.getString(i)+"-";
	   }
       v.add(r);
	  }	 
	  desconectar();
	 }
     
     
     return v;
    }//Fin getHTML
    
    
    
    
    
    
	/**EJECUTA UNA CONSULTA Y GENERA XML*/
    protected String getXML() throws Exception{
     StringBuffer xml = new StringBuffer();
     xml.append("<registros>");
     
	 if(conectar()){
	  ResultSet rs = ejecutarSQL(this.SQL);
	  while(rs.next()){
       ResultSetMetaData rsm = rs.getMetaData();
       xml.append("<registro>");
   	   for(int i=1;i<=rsm.getColumnCount();i++){
        xml.append("<"+rsm.getColumnName(i)+">");
	   	xml.append(rs.getString(i));
	   	xml.append("</"+rsm.getColumnName(i)+">");
	   }
       xml.append("</registro>");
	  }	 
	  desconectar();
	 }
     
     xml.append("</registros>");
     return xml.toString();
    }//Fin getXML
	    
	
	/**
	 *M�todo de prueba
	 *Recibe como argumento el nombre del archivo de 
	 *configuracion.
	 *Para usarlo:
	 *java JDBCMiddler archivo.conf
	*/
	protected static void main(String args[]) throws Exception{
	 //Se recibe como argumento del main el archivo de 
	 //configuracion que contiene el driver
	 //la url, el login y la clave
	 String parametros[] = leerParametros(args[0]);
	 int n = 1;
	 JDBCMiddler middler = new JDBCMiddler(parametros[0],
	 									   parametros[1],
	 									   parametros[2],
	 									   parametros[3]);
	 if(middler.conectar()){
	  System.out.println(parametros[4]);
	  ResultSet rs = middler.ejecutarSQL(parametros[4]);
	  while(rs.next()){
	   ResultSetMetaData rsm = rs.getMetaData();
	   System.out.println("****************************");
	   System.out.println("Registro: "+(n++));
	   for(int i=1;i<=rsm.getColumnCount();i++){
	   	System.out.print(rsm.getColumnName(i)+": ");
	   	System.out.println(rs.getString(i));
	   }
	  }	 
	  middler.desconectar();
	  System.out.println("todo bien");
	 }
	}//fin main
	
	/**
	 *Servicio que permite Leer los parametros de entrada
    */   
    protected static String [] leerParametros (String rutaArchivo)
    					throws Exception{
  	 String [] parametros = new String[5];
  	 java.io.BufferedReader flujoE = new java.io.BufferedReader(
  	 								 new java.io.FileReader (rutaArchivo));
  	 parametros[0] = flujoE.readLine();
  	 parametros[1] = flujoE.readLine();
  	 parametros[2] = flujoE.readLine();
  	 parametros[3] = flujoE.readLine();
  	 parametros[4] = flujoE.readLine();
  	 flujoE.close();
  	 return parametros;
    }//fin leerParametros




	
	
}//Fin JDBCMiddler