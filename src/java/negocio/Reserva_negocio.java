/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Reserva_DAO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Reserva_negocio {

    public static int guardarReserva(String fechaReserva, Date fechaActual, String idCliente) {
        try {
            return Reserva_DAO.guardarReserva(fechaReserva, fechaActual, idCliente);
        } catch (Exception ex) {
            Logger.getLogger(Reserva_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    
    public static String cancelarReserva(String idReserva) {
        try {
            if(Reserva_DAO.cancelarReserva(idReserva))
                return "La Reserva fue Cancelada";
            else return "Error al Cancerla Reserva";
        } catch (Exception ex) {
            Logger.getLogger(Reserva_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
