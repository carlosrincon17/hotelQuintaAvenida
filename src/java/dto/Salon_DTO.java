/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Carlos
 */
public class Salon_DTO {
    
    private String nombre;
    private float precioHora;
    private int capacidad;
    private String estado;
    private String ID;
    private String descripcion;
    private String imagen;
    
    public Salon_DTO() {
    }

    public Salon_DTO(String nombre, float precioHora, int capacidad, String estado) {
        this.nombre = nombre;
        this.precioHora = precioHora;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    
    public Salon_DTO(String nombre){
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    
    
    
}


