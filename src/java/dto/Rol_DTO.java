/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import java.util.ArrayList;
/**
 *
 * @author Jorge
 */
public class Rol_DTO {
    
    private int id;
    private String nombre;
    private ArrayList<Privilegio_DTO> privilegios;
    private String descripcion;

    public Rol_DTO() {
        
    }
    
    public Rol_DTO(int id){
    this.id = id;
    }

    public Rol_DTO(int id, String nombre, ArrayList<Privilegio_DTO> privilegios) {
        this.id = id;
        this.nombre = nombre;
        this.privilegios = privilegios;
    }
    
    public Rol_DTO(String nombre, String descripcion){
        
        this.nombre = nombre;
        this.descripcion = descripcion;
    
    }

    public Rol_DTO(String nombre) {
        this.nombre = nombre;
    }
        
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Privilegio_DTO> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(ArrayList<Privilegio_DTO> privilegios) {
        this.privilegios = privilegios;
    }

    @Override
    public String toString() {
        return "Rol_DTO{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

    
    
    
    
}
