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
public class ReservaHabitacion_DTO extends Reserva_DTO{
  
    private String descripcion;  
    private Habitacion_DTO habitacion;
    private int id;
    
    public ReservaHabitacion_DTO(String descripcion, Habitacion_DTO habitacion) {
        this.descripcion = descripcion;
        this.habitacion = habitacion;
    }
    
    public ReservaHabitacion_DTO(int id, Date fechaReseva, Date fechaSoliitud, Cliente_DTO cliente){
    super(cliente, fechaReseva, fechaSoliitud);
    this.id=id;
    }
    
    public ReservaHabitacion_DTO(Habitacion_DTO habitacion, String fecha, Cliente_DTO cliente, Date fechaActual, 
            Empleado_DTO empleado, String descripcion){
        super(fecha, cliente, fechaActual, empleado);
        this.habitacion=habitacion;
        this.descripcion=descripcion;
        
    }

    public ReservaHabitacion_DTO(int id, Habitacion_DTO habitacion, String descripcion, Cliente_DTO cliente) {
        super(id,cliente);
        this.habitacion=habitacion;
        this.descripcion=descripcion;
        
        
    }
    
    
    
    public ReservaHabitacion_DTO() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Habitacion_DTO getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion_DTO habitacion) {
        this.habitacion = habitacion;
    }
    
    
}
