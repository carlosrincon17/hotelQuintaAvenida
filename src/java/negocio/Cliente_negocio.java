/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Cliente_DAO;
import dao.Persona_DAO;
import dto.Cliente_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CONNORS
 */
class Cliente_negocio {
    
    public static boolean crearCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono, String fechaNto, String empresa){
        try {
            Cliente_DTO cliente = new Cliente_DTO(cedula, nombre, apellido, correo, direccion, telefono, fechaNto, empresa);
            return Cliente_DAO.create(cliente);
        } catch (Exception ex) {
            System.err.println("error, no se pudo crear cliente");                        
            Logger.getLogger(Cliente_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public static boolean editarCliente(String cedula, String correo, String direccion, String telefono, String fechaNto, String empresa){
        try {
            Cliente_DTO cliente = new Cliente_DTO(cedula, correo, direccion, telefono, fechaNto, empresa);
                return Persona_DAO.editar(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Cliente_negocio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error, no se pudo editar cliente");
            return false;
        }
    }
    
    
    public static ArrayList<Cliente_DTO> getAll(){
        try {
            return Cliente_DAO.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Cliente_negocio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error, no se pudo obtener todos los cliente");
            return null;
        }
    }
}