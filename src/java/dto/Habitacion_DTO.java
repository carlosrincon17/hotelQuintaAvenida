/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Habitacion_DTO {
    private String estado;
    private String numero;
    private float precio;
    private String tipo;
    private Minibar_DTO minibar;

    public Habitacion_DTO(String estado, String numero, float precio, String tipo) {
        this.estado = estado;
        this.numero = numero;
        this.precio = precio;
        this.tipo = tipo;
        this.minibar= null;

    }

    public Habitacion_DTO(String numero, String tipo) {
        this.tipo = tipo;
        this.numero = numero;
    }

    
    
    
    public Habitacion_DTO(String habitacion){
        this.numero= habitacion;
    }

    public Habitacion_DTO() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    @Override
    public String toString() {
        return "Habitacion_DTO{" + "estado=" + estado + ", numero=" + numero + ", tipo=" + tipo + '}';
    }
    
    
    
}