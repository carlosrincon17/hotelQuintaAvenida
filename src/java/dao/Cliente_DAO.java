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
    
    public static boolean editar(Cliente_DTO cliente){
    
        String sql ="UPDATE cliente SET nombre_empresa='"+cliente.getEmpresa()+"' WHERE id_cliente='"+cliente.getDocumento()+"'";

        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static ArrayList<Cliente_DTO> getAll(){
        ArrayList<Cliente_DTO> lista = new ArrayList<Cliente_DTO>();
        String sql = "SELECT * FROM cliente inner join persona ON cliente.id_cliente = persona.cedula";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
             while(rs.next()){
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
        } catch (Exception e) {
        }
        
        return lista;
    }
    
    public static boolean create(Cliente_DTO cliente) {
        
        String sql = "INSERT INTO cliente VALUES ('"+cliente.getDocumento()+"','"+cliente.getEmpresa()+"')";
        if(Persona_DAO.create(cliente))
            return BaseDeDatos.ejecutarActualizacionSQL(sql);
        
        return false;
    }
    
    public static Cliente_DTO cargarCliente(Cliente_DTO cliente){
        Persona_DAO.read(cliente);
        if(cliente==null) return null;
        return cliente;
    }
    
    public static Cliente_DTO read(String id){

        return Persona_DAO.read(new Cliente_DTO(id));
    
    }
    
}
