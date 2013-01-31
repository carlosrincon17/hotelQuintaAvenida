/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente_DTO;
import dto.Empleado_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.BaseDeDatos;
/**
 *
 * @author jorge
 */
public class Persona_DAO {

    public static boolean create(Empleado_DTO persona) {
        String sql = "insert into persona values('"+persona.getDocumento()+"','"+persona.getNombre()+"', '"+persona.getApellido()+
                "','"+persona.getCorreo()+"','"+persona.getDireccion()+"','"+persona.getTelefono()+"','"+persona.getFechaInscripcion()+"','"+persona.getFechaNacimiento()+"')";
        
        if(BaseDeDatos.ejecutarActualizacionSQL(sql))
            return Usuario_DAO.create(persona);
        return false;
    }
    
    
    public static boolean create(Cliente_DTO persona) {
        String sql = "insert into persona values('"+persona.getDocumento()+"','"+persona.getNombre()+"', '"+persona.getApellido()+
                "','"+persona.getCorreo()+"','"+persona.getDireccion()+"','"+persona.getTelefono()+"','"+persona.getFechaInscripcion()+"','"+persona.getFechaNacimiento()+"')";
        
        if(BaseDeDatos.ejecutarActualizacionSQL(sql))
            return Usuario_DAO.create(persona);
        
        return false;
    }
    
    public static boolean editar(Cliente_DTO cliente){
        String sql = "UPDATE persona SET correo='"+cliente.getCorreo()+"', direccion='"+cliente.getDireccion()+"', telefono='"+cliente.getTelefono()
                +"' WHERE cedula="+cliente.getDocumento();    
    
        if(Cliente_DAO.editar(cliente))
            return BaseDeDatos.ejecutarActualizacionSQL(sql);
        
        return false;
    }
    
    public static boolean update(Empleado_DTO empleado){
    
            String sql = "UPDATE persona SET correo='"+empleado.getCorreo()+"', direccion='"+empleado.getDireccion()+"', telefono='"+empleado.getTelefono()
                       + "' WHERE cedula='"+empleado.getDocumento()+"'";
            
            return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static Cliente_DTO read(Cliente_DTO cliente){
    
        String sql = "SELECT * FROM cliente INNER JOIN persona ON cliente.id_cliente = persona.cedula WHERE cliente.id_cliente = '"+cliente.getDocumento()+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            if(rs.next()){
               cliente.setEmpresa(rs.getString(2)); 
               cliente.setNombre(rs.getString(4));
               cliente.setApellido(rs.getString(5));
               cliente.setCorreo(rs.getString(6));
               cliente.setDireccion(rs.getString(7));
               cliente.setTelefono(rs.getString(8));
               cliente.setFechaNacimiento(rs.getString(9));
               cliente.setFechaInscripcion(rs.getString(10));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cliente;
    }
    
}
