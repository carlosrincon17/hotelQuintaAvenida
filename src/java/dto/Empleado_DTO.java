/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Jorge
 */
public class Empleado_DTO extends Persona_DTO{
    private String numeroSS;
    private String funcion;
    private boolean estado;

    public Empleado_DTO() {
        super();
    }

    @Override
    public String toString() {
        return "Empleado_DTO{" + "numeroSS=" + numeroSS + ", funcion=" + funcion + ", estado=" + estado + '}';
    }
    
    public Empleado_DTO(String documento){
        super(documento);
    }
    
    public Empleado_DTO(String nombre, String apellidos, String documento, String direccion, String fecha_nto, String telefono, String correo, String numeroSS, String funcion) {
        super(nombre, apellidos, direccion, documento, fecha_nto, telefono, correo);
        this.numeroSS = numeroSS;
        this.funcion = funcion;
        this.estado = true;
    }
    
    public Empleado_DTO(String cedula, String funcion, String telefono, String correo, String direccion, String seguro){
        super(cedula, correo, direccion, telefono);
        this.numeroSS = seguro;
        this.funcion = funcion;
    }
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }
     
    

    
}
