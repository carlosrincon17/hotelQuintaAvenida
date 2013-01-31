/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Carlos
 */
public class Llamada_DTO  extends Servicio_DTO {
    
    private String destino;
    private int duracion;
    private String tipo;

    public Llamada_DTO(String destino, int duracion, String tipo) {
        this.destino = destino;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public Llamada_DTO() {
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
