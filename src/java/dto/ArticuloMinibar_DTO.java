/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Carlos
 */
public class ArticuloMinibar_DTO {
    
    private Articulo_DTO articulo;
    private int cantidad;

    public ArticuloMinibar_DTO(Articulo_DTO articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public ArticuloMinibar_DTO() {
    }

    public Articulo_DTO getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo_DTO articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
