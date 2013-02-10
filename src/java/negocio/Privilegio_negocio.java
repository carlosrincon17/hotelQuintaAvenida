/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Privilegio_DAO;
import dto.Privilegio_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CONNORS
 */
public class Privilegio_negocio {
    
    private static Privilegio_DTO privilegio;
    
    public Privilegio_negocio(){
    
    }
    
    
    public static ArrayList<Privilegio_DTO> readAll(){
        try {
            return Privilegio_DAO.readAll();
        } catch (Exception ex) {
            Logger.getLogger(Privilegio_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
