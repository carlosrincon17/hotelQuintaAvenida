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
public class ReservaSalon_DTO extends Reserva_DTO {
    private int abonoReserva;
    private Salon_DTO salon;
    private String descripcion;
    private boolean pago;
    private int duracion;
    private int hora;
    private int total;
    
    
    public ReservaSalon_DTO(Salon_DTO salon , String fechaReserva, Date fechaActual, 
             Empleado_DTO empleado , Cliente_DTO cliente , int abono, String descripcion, int duracion, int hora){ 
        super(fechaReserva, cliente, fechaActual, empleado);
        this.salon=salon;
        this.abonoReserva=abono;
        this.descripcion=descripcion;
        this.duracion=duracion;
        this.hora=hora;
    }

    public ReservaSalon_DTO(int abonoReserva, String descripcion, Cliente_DTO cliente, Date fechareserva, Date fechaSolicitud, boolean pago) {
        super(cliente, fechareserva, fechaSolicitud);
        this.abonoReserva = abonoReserva;
        this.descripcion = descripcion;
        this.pago=pago;
    }

    public ReservaSalon_DTO(int abonorReserva, Salon_DTO salon, String descripcion) {
        this.abonoReserva = abonorReserva;
        this.salon = salon;
        this.descripcion = descripcion;
    }

    public ReservaSalon_DTO() {
    }

    public ReservaSalon_DTO(Cliente_DTO cliente, Date fechareserva, Date fechaSolicitud) {
        super(cliente, fechareserva, fechaSolicitud);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAbonoReserva() {
        return abonoReserva;
    }

    public void setAbonoReserva(int abonorReserva) {
        this.abonoReserva = abonorReserva;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    

    public Salon_DTO getSalon() {
        return salon;
    }

    public void setSalon(Salon_DTO salon) {
        this.salon = salon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ReservaSalon_DTO{" + "abonoReserva=" + abonoReserva + ", salon=" + salon + ", descripcion=" + descripcion + ", pago=" + pago + ", duracion=" + duracion + ", hora=" + hora + ", total=" + total + '}';
    }
    
    
    
}
