/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Jorge
 */
public class ItemFactura_DTO {
    private String descripcion;
    private long importe;

    public ItemFactura_DTO() {
    }

    public ItemFactura_DTO(String descripcion, long importe) {
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getImporte() {
        return importe;
    }

    public void setImporte(long importe) {
        this.importe = importe;
    }
    
    
}
