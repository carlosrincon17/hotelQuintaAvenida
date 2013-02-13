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
public class ServicioHabitacion_DTO {
   private Date fecha;
   private int importe;
   private Servicio_DTO servicio;
   private ArticuloMinibar_DTO consumido;
   private int cantidad;

    public ServicioHabitacion_DTO() {
    }

    public ServicioHabitacion_DTO(Date fecha, int importe, Servicio_DTO servicio, int cantidad) {
        this.fecha = fecha;
        this.importe = importe;
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    

    public ServicioHabitacion_DTO(Date fecha, int importe, ArticuloMinibar_DTO consumido, int cantidad) {
        this.fecha = fecha;
        this.importe = importe;
        this.servicio = null;
        this.consumido = consumido;
        this.cantidad = cantidad;
    }

    

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public Servicio_DTO getServicio() {
        return servicio;
    }

    public void setServicio(Servicio_DTO servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ArticuloMinibar_DTO getConsumido() {
        return consumido;
    }

    public void setConsumido(ArticuloMinibar_DTO consumido) {
        this.consumido = consumido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   
   
}
