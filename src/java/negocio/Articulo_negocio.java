/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Articulo_DAO;
import dto.Articulo_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
class Articulo_negocio {

    
    public static boolean registrar(String nombre, String precio, String cantidad) {
        try {
            return Articulo_DAO.create(new Articulo_DTO(nombre, Float.parseFloat(precio), Integer.parseInt(cantidad)));
        } catch (Exception ex) {
            Logger.getLogger(Articulo_negocio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error, no se pudo registrar el artículo");
            return false;
        }
    }

    
    public static ArrayList<Articulo_DTO> listar(){
        try {
            return Articulo_DAO.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Articulo_negocio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error, no se pudo listar los artículos");
            return null;
        }
    }

    
    /*
     * trabajo 2 de agosto
     * jorge
     *
     */
    static boolean agregarCantidad(String idArticulo, int cantidad) {
        try {
            Articulo_DTO nuevo = new Articulo_DTO(idArticulo);
            int bodega = Articulo_DAO.getCantidadArticulo(nuevo);
            return Articulo_DAO.update(nuevo,(cantidad+bodega));
        } catch (Exception ex) {
            Logger.getLogger(Articulo_negocio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error, no se pudo agregar cantidad");
            return false;
        }
    }
    
    
    
}
