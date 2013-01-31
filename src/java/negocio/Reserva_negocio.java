/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Reserva_DAO;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Reserva_negocio {

    public static int guardarReserva(String fechaReserva, Date fechaActual, String idCliente) {
        return Reserva_DAO.guardarReserva(fechaReserva, fechaActual, idCliente);
    }
    
    public static String cancelarReserva(String idReserva) {
        if(Reserva_DAO.cancelarReserva(idReserva))
            return "La Reserva fue Cancelada";
        else return "Error al Cancerla Reserva";
    }
}
