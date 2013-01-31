/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author CONNORS
 */
public class Modulo_DTO {
    
    private ArrayList<Privilegio_DTO> comportamientos;
    private String nombre;

    public Modulo_DTO(ArrayList<Privilegio_DTO> comportamientos, String nombre) {
        this.comportamientos = comportamientos;
        this.nombre = nombre;
    }
    
    public Modulo_DTO(String nombre){
        this.nombre = nombre;
    }

    public ArrayList<Privilegio_DTO> getComportamientos() {
        return comportamientos;
    }

    public void setComportamientos(ArrayList<Privilegio_DTO> comportamientos) {
        this.comportamientos = comportamientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      
}
