/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Carlos
 */
public class Cliente_DTO extends Persona_DTO{
 
    private String empresa;

    public Cliente_DTO() {
    }
    public Cliente_DTO(String cedula){
    super(cedula);
    }
    public Cliente_DTO(String cedula, String nombre, String apellido, String correo, String direccion, String telefono, String fechaNto, String empresa) {
        super(nombre, apellido, direccion, cedula, fechaNto, telefono,correo);
        this.empresa = empresa;
    }

    public Cliente_DTO(String cedula, String correo, String direccion, String telefono, String fechaNto, String empresa){
        super(cedula,correo,direccion,telefono);
        this.empresa = empresa;
    }
    public String getEmpresa() {
        return empresa; 
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
 
}
