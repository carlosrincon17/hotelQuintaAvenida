/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Cliente_DAO;
import dao.Persona_DAO;
import dto.Cliente_DTO;
import java.util.ArrayList;

/**
 *
 * @author CONNORS
 */
class Cliente_negocio {
    
    public static boolean crearCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono, String fechaNto, String empresa){
        
        Cliente_DTO cliente = new Cliente_DTO(cedula, nombre, apellido, correo, direccion, telefono, fechaNto, empresa);
        return Cliente_DAO.create(cliente);
    }
    
    public static boolean editarCliente(String cedula, String correo, String direccion, String telefono, String fechaNto, String empresa){
    
    Cliente_DTO cliente = new Cliente_DTO(cedula, correo, direccion, telefono, fechaNto, empresa);
        return Persona_DAO.editar(cliente);
    }
    
    public static ArrayList<Cliente_DTO> getAll(){
    
        return Cliente_DAO.getAll();
    }
}