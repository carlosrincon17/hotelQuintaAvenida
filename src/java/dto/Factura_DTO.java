/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Factura_DTO {
    
    private ReservaSalon_DTO evento;
    private Date fechaFactura;
    private Hospedaje_DTO hospedaje;
    private int numeroFactura;
    private ArrayList<ItemFactura_DTO> items;
    

    public Factura_DTO(ReservaSalon_DTO evento, Date fechaFactura, Hospedaje_DTO hospedaje, int numeroFactura) {
        this.evento = evento;
        this.fechaFactura = fechaFactura;
        this.hospedaje = hospedaje;
        this.numeroFactura = numeroFactura;
    }

    public Factura_DTO() {
    }

    public ReservaSalon_DTO getEvento() {
        return evento;
    }

    public void setEvento(ReservaSalon_DTO evento) {
        this.evento = evento;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Hospedaje_DTO getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(Hospedaje_DTO hospedaje) {
        this.hospedaje = hospedaje;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public ArrayList<ItemFactura_DTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemFactura_DTO> items) {
        this.items = items;
    }
    
    
    
}
