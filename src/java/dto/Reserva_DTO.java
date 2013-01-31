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
public abstract class Reserva_DTO {
    
    private Empleado_DTO empleado;
    private Cliente_DTO cliente;
    private Date fechareserva;
    private Date fechaSolicitud;
    private int hora;
    private boolean estado;
    private int Id;
    
    public Reserva_DTO(Cliente_DTO cliente, Date fechareserva, Date fechaSolicitud) {
        this.cliente = cliente;
        this.fechareserva = fechareserva;
        this.fechaSolicitud = fechaSolicitud;
        
        this.estado=false;
    }
    public Reserva_DTO(int id, Cliente_DTO cliente){
        this.cliente=cliente;
        this.Id=id;
    }
    
    
    public Reserva_DTO(String fecha, Cliente_DTO cliente,Date fechaSolicitud, Empleado_DTO empleado){
        String [] fechas=fecha.split("-");
        Date myFecha=new Date(Integer.parseInt(fechas[0]),Integer.parseInt(fechas[1]),Integer.parseInt(fechas[2]));
        this.empleado=empleado;
        this.cliente=cliente;
        this.fechareserva=myFecha;
        this.fechaSolicitud=fechaSolicitud;
        
    }
   
    public Reserva_DTO(Empleado_DTO empleado, Cliente_DTO cliente, Date fechareserva, Date fechaSolicitud, int hora) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.fechareserva = fechareserva;
        this.fechaSolicitud = fechaSolicitud;
        this.hora = hora;
        this.estado=false;
    }

    public Reserva_DTO() {
    }
    
    private Date obtenerFecha(String fecha) {

        String[] fechita = fecha.split("-");
        System.out.println(fechita);
        Date nuevo = new Date(Integer.parseInt(fechita[0]), Integer.parseInt(fechita[1]), Integer.parseInt(fechita[2]));

        return nuevo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
    public Cliente_DTO getCliente() {
        return cliente;
    }

    public void setCliente(Cliente_DTO cliente) {
        this.cliente = cliente;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public Empleado_DTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado_DTO empleado) {
        this.empleado = empleado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
