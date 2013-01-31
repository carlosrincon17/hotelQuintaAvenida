/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Persona_DTO {

    private String nombre;
    private String apellido;
    private String direccion;
    private String documento;
    private Date fechaNacimiento;
    private Date fechaInscripcion;
    private String telefono;
    private String correo;
    private Rol_DTO rol;

    public Persona_DTO(String nombre, String apellido, String direccion, String documento, String fechaNacimiento, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.fechaNacimiento = obtenerFecha(fechaNacimiento);//cambiar a date
        this.telefono = telefono;
        this.correo = correo;
        this.fechaInscripcion = new Date();
    }
    
    public Persona_DTO(String cedula, String correo, String direccion, String telefono){

        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.documento = cedula;
    }
    
    public Persona_DTO(String documento) {
        this.documento = documento;
    }

    public Persona_DTO() {
        
    }

    public String getFechaInscripcion() {
        return fechaInscripcion.getYear()+"-"+fechaInscripcion.getMonth()+"-"+fechaInscripcion.getDate();
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Rol_DTO getRol() {
        return rol;
    }

    public void setRol(Rol_DTO rol) {
        this.rol = rol;
    }

    
    private Date obtenerFecha(String fecha) {

        String[] fechita = fecha.split("-");
        System.out.println(fechita);
        Date nuevo = new Date(Integer.parseInt(fechita[0]), Integer.parseInt(fechita[1]), Integer.parseInt(fechita[2]));

        return nuevo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento.getYear()+"-"+fechaNacimiento.getMonth()+"-"+fechaNacimiento.getDate();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        
        this.fechaNacimiento = this.obtenerFecha(fechaNacimiento);
    }
    public void setFechaInscripcion(String fechaInscripcion) {
        
        this.fechaInscripcion = this.obtenerFecha(fechaInscripcion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
