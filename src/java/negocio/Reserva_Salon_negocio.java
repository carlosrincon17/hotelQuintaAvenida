/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Cliente_DAO;
import dao.ReservaSalon_DAO;
import dto.Cliente_DTO;
import dto.Empleado_DTO;
import dto.ReservaSalon_DTO;
import dto.Salon_DTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Carlos
 */
public class Reserva_Salon_negocio {
    
    public static ArrayList<ReservaSalon_DTO> listarReservas(String salon){
        try {
            return   ReservaSalon_DAO.listarReservas(salon);
        } catch (Exception ex) {
            Logger.getLogger(Reserva_Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public static boolean exiteReserva(ReservaSalon_DTO reserva) {
        try {
            return ReservaSalon_DAO.existeReserva(reserva);
        } catch (Exception ex) {
            Logger.getLogger(Reserva_Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public static String insertReserva(String salon, String fechaReserva, Date fechaActual,
            String idEmpleado, String idCliente, int abono, String descripcion, int duracion, int hora) {

        try {
            Salon_DTO mySalon = Salon_negocio.cargarSalon(salon);
            ReservaSalon_DTO reserva = new ReservaSalon_DTO(mySalon, fechaReserva, fechaActual,
                    new Empleado_DTO(idEmpleado), new Cliente_DTO(idCliente), abono, descripcion, duracion, hora);

            int aPagar = (int) (mySalon.getPrecioHora() * reserva.getDuracion() * .4);
            if (aPagar > reserva.getAbonoReserva()) {
                return "No se puede realizar la reserva. El abono debe ser mayor a: <b>$" + aPagar + "</b>.";
            }
            if (Reserva_Salon_negocio.exiteReserva(reserva)) {
                return "El salon ya ha sido reservado para estas horas";
            }

            if (ReservaSalon_DAO.insertReserva(reserva)) {
                return "Se ha guardado la Reserva Exitosamente";
            }
        } catch (Exception ex) {
            Logger.getLogger(Reserva_Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Error al Hacer la Reserva. Intente mas tarde";
    }

    
    public static ArrayList<ReservaSalon_DTO> getReservasByID(String cedula) {
        try {
            Cliente_DTO cliente = new Cliente_DTO(cedula);
            cliente = Cliente_DAO.cargarCliente(cliente);
            return ReservaSalon_DAO.getReservas(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Reserva_Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public static int[] getEstadisticasMes(String mes, String agno) {
        int[] estadistica = new int[3];
        try {
            estadistica[0] = ReservaSalon_DAO.getReservasByEstadoMes("Espera", mes, agno);
            estadistica[1] = ReservaSalon_DAO.getReservasByEstadoMes("Hecha", mes, agno);
            estadistica[2] = ReservaSalon_DAO.getReservasByEstadoMes("Cancelada", mes, agno);
            return estadistica;
        } catch (Exception ex) {
            Logger.getLogger(Reserva_Salon_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return estadistica;
        }
    }
    
}

    
