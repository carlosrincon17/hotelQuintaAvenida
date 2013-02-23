/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente_DTO;
import dto.Empleado_DTO;
import dto.Persona_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.BaseDeDatos;
/**
 *
 * @author jorge
 */
public class Persona_DAO {

    public static boolean create(Empleado_DTO persona) throws Exception{
        
        String sql = "insert into persona values(?,?,?,?,?,?,?,?)";
        Object[] p = new Object[8];
        p[0] = persona.getDocumento();
        p[1] = persona.getNombre();
        p[2] = persona.getApellido();
        p[3] = persona.getCorreo();
        p[4] = persona.getDireccion();
        p[5] = persona.getTelefono();
        p[6] = persona.getFechaNacimiento();
        p[7] = persona.getFechaInscripcion();
        
        System.err.println(persona.toString());
        
        if(BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p)){
            return Usuario_DAO.create(persona);}
        return false;
    }
    
    
    public static boolean create(Cliente_DTO persona) throws Exception{
       
       /* 
        tal vez haya problema con guardar las fechas ... porque son string en java
        pero en la base de datos son de tipo date
        */ 
        
       String sql = "insert into persona values(?,?,?,?,?,?,?,?)";
        Object[] p = new Object[8];
        p[0] = persona.getDocumento();
        p[1] = persona.getNombre();
        p[2] = persona.getApellido();
        p[3] = persona.getCorreo();
        p[4] = persona.getDireccion();
        p[5] = persona.getTelefono();
        p[6] = persona.getFechaInscripcion();
        p[7] = persona.getFechaNacimiento();
        
        if(BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p))
            return Usuario_DAO.create(persona);
        return false;
    }
    
    
    public static boolean editar(Cliente_DTO cliente) throws Exception{
       
        String sql = "UPDATE persona SET correo = ?, direccion = ?, telefono = ? WHERE cedula = ?";    
        Object[] p = new Object[4];
        p[0] = cliente.getCorreo();
        p[1] = cliente.getDireccion();
        p[2] = cliente.getTelefono();
        p[3] = cliente.getDocumento();
        
        if(Cliente_DAO.editar(cliente))
            return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
        return false;
    }
    
    
    public static boolean update(Empleado_DTO empleado) throws Exception{
    
        String sql = "UPDATE persona SET correo = ?, direccion = ?, telefono = ? WHERE cedula = ?";
        Object[] p = new Object[4];
        p[0] = empleado.getCorreo();
        p[1] = empleado.getDireccion();
        p[2] = empleado.getTelefono();
        p[3] = empleado.getDocumento();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static Cliente_DTO read(Cliente_DTO cliente) throws Exception {

        String sql = "SELECT * FROM cliente INNER JOIN persona ON cliente.id_cliente = persona.cedula WHERE cliente.id_cliente = ?";
        Object[] p = new Object[1];
        p[0] = cliente.getDocumento();

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        if (rs.next()) {
            cliente.setEmpresa(rs.getString(2));
            cliente.setNombre(rs.getString(4));
            cliente.setApellido(rs.getString(5));
            cliente.setCorreo(rs.getString(6));
            cliente.setDireccion(rs.getString(7));
            cliente.setTelefono(rs.getString(8));
            cliente.setFechaNacimiento(rs.getString(9));
            cliente.setFechaInscripcion(rs.getString(10));
        }
        return cliente;
    }
    public static Persona_DTO getPersona(String usuario) throws Exception {
        String sql = "Select nombre, apellido , correo, direccion, fecha_nto, fecha_inscripcion, telefono from persona "
                + "where cedula='"+usuario+"'";
        Object[] para= new Object[1];
        para[0]=usuario;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        Cliente_DTO myCliente = new Cliente_DTO();
        try{
            if(rs.next()){
                myCliente.setNombre(rs.getString(1) ); 
                myCliente.setApellido(rs.getString(2));
                myCliente.setCorreo(rs.getString(3));
                myCliente.setDireccion(rs.getString(4));
                myCliente.setFechaNacimiento(rs.getString(5));
                myCliente.setFechaInscripcion(rs.getString(6));
                myCliente.setTelefono(rs.getString(7));
                myCliente.setDocumento(usuario);
             
                
                return myCliente;
            }
            return null;
        }
        catch (Exception e){
            return null;
        }   
    
}
}
