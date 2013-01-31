/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dto.Articulo_DTO;
import dao.Articulo_DAO;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
class Articulo_negocio {

    public static boolean registrar(String nombre, String precio,String cantidad) {
        return Articulo_DAO.create(new Articulo_DTO(nombre,Float.parseFloat(precio),Integer.parseInt(cantidad)));
    }

    public static ArrayList<Articulo_DTO> listar(){
        
        return Articulo_DAO.getAll();
    }

    
    /*
     * trabajo 2 de agosto
     * jorge
     *
     */
    static boolean agregarCantidad(String idArticulo, int cantidad) {
        
        Articulo_DTO nuevo = new Articulo_DTO(idArticulo);
        int bodega = Articulo_DAO.getCantidadArticulo(nuevo);
        return Articulo_DAO.update(nuevo,(cantidad+bodega));
    }
    
    
    
}
