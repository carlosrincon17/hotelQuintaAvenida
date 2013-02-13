/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


/**
 *
 * @author Carlos
 */
public class Servicio_DTO {
    private float precio;
    private String tipo;
    private String id;

    public Servicio_DTO() {
    }

    public Servicio_DTO( float precio,String tipo, String id) {
        
        this.precio = precio;
        this.tipo=tipo;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Servicio_DTO(float precio, String tipo) {
        this.precio = precio;
        this.tipo = tipo;
    }

    
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
