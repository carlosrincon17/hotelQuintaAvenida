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
    private ArrayList<ServicioHabitacion_DTO> myServicios;

    public Habitacion_DTO(String estado, String numero, float precio, String tipo) {
        this.estado = estado;
        this.numero = numero;
        this.precio = precio;
        this.tipo = tipo;
        this.minibar= null;
        this.myServicios= new ArrayList<>();
        

    }

    public Habitacion_DTO(String numero, String tipo) {
        this.tipo = tipo;
        this.numero = numero;
        this.myServicios= new ArrayList<>();
    }

    
    
    
    public Habitacion_DTO(String habitacion){
        this.numero= habitacion;
        this.myServicios= new ArrayList<>();
    }

    public Habitacion_DTO() {
        this.myServicios= new ArrayList<>();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<ServicioHabitacion_DTO> getMyServicios() {
        return myServicios;
    }

    public void setMyServicios(ArrayList<ServicioHabitacion_DTO> myServicios) {
        this.myServicios = myServicios;
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