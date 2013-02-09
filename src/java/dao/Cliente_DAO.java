/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CONNORS
 */
public class Cliente_DAO {
    
    
    public static boolean editar(Cliente_DTO cliente) throws Exception{
        String sql = "UPDATE cliente SET nombre_empresa= ? WHERE id_cliente = ?";
        Object [] param = new Object[2];
        param[0] = cliente.getEmpresa();
        param[1] = cliente.getDocumento();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    
    public static ArrayList<Cliente_DTO> getAll() throws Exception {
        
        ArrayList<Cliente_DTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente inner join persona ON cliente.id_cliente = persona.cedula";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        
        while (rs.next()) {
            Cliente_DTO nuevo = new Cliente_DTO();
            nuevo.setEmpresa(rs.getString(2));
            nuevo.setDocumento(rs.getString(3));
            nuevo.setNombre(rs.getString(4));
            nuevo.setApellido(rs.getString(5));
            nuevo.setCorreo(rs.getString(6));
            nuevo.setDireccion(rs.getString(7));
            nuevo.setTelefono(rs.getString(8));
            nuevo.setFechaNacimiento(rs.getDate(9));
            lista.add(nuevo);
        }
        return lista;
    }
    
        
    public static boolean create(Cliente_DTO cliente) throws Exception{
        
        String sql = "INSERT INTO cliente VALUES (?, ?)";
        Object[] p = new Object[2];
        p[0] = cliente.getDocumento();
        p[1] = cliente.getEmpresa();
        
        if(Persona_DAO.create(cliente))
            return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
        return false;
    }
    
    
    public static Cliente_DTO cargarCliente(Cliente_DTO cliente) throws Exception{
        Persona_DAO.read(cliente);
        if(cliente == null) 
            return null;
        return cliente;
    }
    
    
    public static Cliente_DTO read(String id) throws Exception{
        return Persona_DAO.read(new Cliente_DTO(id));
    }
    
}
