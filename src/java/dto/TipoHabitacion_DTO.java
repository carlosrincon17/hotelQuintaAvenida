/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Carlos
 */
public class TipoHabitacion_DTO {
    
    String nombre;
    String precio;
    String descripcion;
    String imgUrl;

    public TipoHabitacion_DTO(String nombre, String precio, String descripción, String imgUrl) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripción;
        this.imgUrl = imgUrl;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripción) {
        this.descripcion = descripción;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    
    
    
}
