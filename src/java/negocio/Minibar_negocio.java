/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dao.Articulo_minibar_DAO;
import dao.Articulo_DAO;
import dto.Minibar_DTO;
import dto.Articulo_DTO;
import dao.Minibar_DAO;
import dto.ArticuloMinibar_DTO;
import java.util.ArrayList;
/**
 *
 * @author jorge
 */
public class Minibar_negocio {
    
    /**
     * 
     * @param id
     * @param marca
     * @param modelo
     * @return true si logra registrar un nuevo minibar
     * 
     * al crearse el minibar no tiene una lista de articulos asociados
     */
    public static boolean registrar(String id, String marca, String modelo){
        return Minibar_DAO.create( new Minibar_DTO(id,marca,modelo));
        
    }
    
    public static ArrayList<Minibar_DTO> listar(){
        return Minibar_DAO.getAll();
    }

    
    /**
     * 
     * @param idMinibar
     * @param idArticulo
     * @param cantidad
     * @return true si se puede agregar el articulo en la cantidad indicada
     */
    static boolean agregarArticulo(String idMinibar, String idArticulo, int cantidad) {
        Minibar_DTO mn = new Minibar_DTO(idMinibar);
        Articulo_DTO ar = new Articulo_DTO(idArticulo);
        int bodega = Articulo_DAO.getCantidadArticulo(ar);
        if(bodega>cantidad){
            Articulo_DAO.update(ar, (bodega-cantidad));
            return Articulo_minibar_DAO.registrar(mn,ar,cantidad);
        }
        
        return false;
    }
    
    static ArrayList<ArticuloMinibar_DTO> getArticulos(String id_minibar) {
        return Articulo_minibar_DAO.getArticulosDeMinibar(new Minibar_DTO(id_minibar));
    }
}
