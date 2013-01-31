/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Cliente_DAO;
import dao.ReservaHabitacion_DAO;
import dao.ReservaSalon_DAO;
import dto.Cliente_DTO;
import dto.Empleado_DTO;
import dto.ReservaSalon_DTO;
import dto.Salon_DTO;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Carlos
 */
public class Reserva_Salon_negocio {
    
    public static ArrayList<ReservaSalon_DTO> listarReservas(String salon){
     return   ReservaSalon_DAO.listarReservas(salon);
    }

    

    public static boolean exiteReserva(ReservaSalon_DTO reserva) {
        return ReservaSalon_DAO.existeReserva(reserva);
    }

    public static String insertReserva(String salon, String fechaReserva, Date fechaActual,
            String idEmpleado, String idCliente, int abono, String descripcion, int duracion, int hora) {
        
        Salon_DTO mySalon= Salon_negocio.cargarSalon(salon);
        ReservaSalon_DTO reserva=  new ReservaSalon_DTO(mySalon, fechaReserva, fechaActual, 
             new Empleado_DTO(idEmpleado), new Cliente_DTO(idCliente), abono, descripcion, duracion, hora);
        
            int aPagar=(int)(mySalon.getPrecioHora()*reserva.getDuracion()*.4);
            if(aPagar>reserva.getAbonoReserva())
                return "No se puede realizar la reserva. El abono debe ser mayor a: <b>$"+aPagar+"</b>.";
            if(Reserva_Salon_negocio.exiteReserva(reserva)) 
                return "El salon ya ha sido reservado para estas horas";
            if(ReservaSalon_DAO.insertReserva(reserva))
                return "Se ha guardado la Reserva Exitosamente";
            
     return "Error al Hacer la Reserva. Intente mas tarde";
     
    }

    static ArrayList<ReservaSalon_DTO> getReservasByID(String cedula) {
        Cliente_DTO cliente= new Cliente_DTO(cedula);
        cliente=Cliente_DAO.cargarCliente(cliente);
        return ReservaSalon_DAO.getReservas(cliente);
    }
    
    public static int[] getEstadisticasMes(String mes,String agno){
        int[] estadistica = new int[3];
        estadistica[0]=ReservaSalon_DAO.getReservasByEstadoMes("Espera", mes, agno);
        estadistica[1]=ReservaSalon_DAO.getReservasByEstadoMes("Hecha", mes, agno);
        estadistica[2]=ReservaSalon_DAO.getReservasByEstadoMes("Cancelada", mes, agno);
        return estadistica;
    }
    
}

    
