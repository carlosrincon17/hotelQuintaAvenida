/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Carlos
 */
public class ConsumoRestaurante_DTO extends Servicio_DTO {
    
    private String descripcion;

    public ConsumoRestaurante_DTO() {
    }

    public ConsumoRestaurante_DTO(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
    
}
