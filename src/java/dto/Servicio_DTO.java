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

    public Servicio_DTO() {
    }

    public Servicio_DTO( float precio,String tipo) {
        
        this.precio = precio;
        this.tipo=tipo;
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
