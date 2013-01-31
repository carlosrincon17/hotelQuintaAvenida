/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Modulo_DAO;
import dto.Modulo_DTO;
import dto.Rol_DTO;
import java.util.ArrayList;

/**
 *
 * @author CONNORS
 */
public class Modulo_negocio {
    
    public static ArrayList<Modulo_DTO> getMenuRolXModulos(int rol){
    
        return Modulo_DAO.readAll(new Rol_DTO(rol));
    }
    
}
