/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Hospedaje_DTO {
    private Date fechaFin;
    private Date FechaInicio;
    private Cliente_DTO huesped;
    private Habitacion_DTO habitacion;
    private ArrayList<ServicioHabitacion_DTO> servicio;
    private ReservaHabitacion_DTO reserva;
    private int ID;

    public Hospedaje_DTO(Date fechaFin, Date FechaInicio, Cliente_DTO huesped, Habitacion_DTO habitacion) {
        this.fechaFin = fechaFin;
        this.FechaInicio = FechaInicio;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.servicio = new ArrayList<ServicioHabitacion_DTO>();
    }

    public Hospedaje_DTO(int id){
        this.ID=id;
    }
    public Hospedaje_DTO(Date fechaFin, Date FechaInicio, ReservaHabitacion_DTO reserva) {
        this.fechaFin = fechaFin;
        this.FechaInicio = FechaInicio;
        this.huesped = null;
        this.habitacion = null;
        this.reserva = reserva;
    }

    public Hospedaje_DTO(Cliente_DTO huesped, Habitacion_DTO habitacion) {
        this.huesped = huesped;
        this.habitacion = habitacion;
    }
    
    
    
    

    public Hospedaje_DTO() {
        this.huesped=null;
        this.habitacion=null;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

   

    public void setHabitacion(Habitacion_DTO habitación) {
        this.habitacion = habitación;
    }

    public Cliente_DTO getHuesped() {
        return huesped;
    }

    public void setHuesped(Cliente_DTO huesped) {
        this.huesped = huesped;
    }

    public ArrayList<ServicioHabitacion_DTO> getServicio() {
        return servicio;
    }

    public void setServicio(ArrayList<ServicioHabitacion_DTO> servicio) {
        this.servicio = servicio;
    }

    public void setReserva(ReservaHabitacion_DTO reserva) {
        this.reserva = reserva;
    }

    public ReservaHabitacion_DTO getReserva() {
        return reserva;
    }

    public Habitacion_DTO getHabitacion() {
        return habitacion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    


    
    
}
