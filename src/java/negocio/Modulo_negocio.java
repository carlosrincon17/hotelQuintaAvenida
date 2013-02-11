/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Modulo_DAO;
import dto.Modulo_DTO;
import dto.Rol_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CONNORS
 */
public class Modulo_negocio {
    
    public static ArrayList<Modulo_DTO> getMenuRolXModulos(int rol) {
        try {
            return Modulo_DAO.readAll(new Rol_DTO(rol));
        } catch (Exception ex) {
            Logger.getLogger(Modulo_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
