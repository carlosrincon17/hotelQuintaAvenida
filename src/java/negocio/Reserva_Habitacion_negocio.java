/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Cliente_DAO;
import dto.ReservaHabitacion_DTO;
import dao.ReservaHabitacion_DAO;
import dto.Cliente_DTO;
import dto.Empleado_DTO;
import dto.Habitacion_DTO;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Carlos
 */
class Reserva_Habitacion_negocio {
    
    public static void main(String args[]){
        int[] nuevo = getEstadisticasMes("08", "2012");
        for(int x: nuevo)
            System.out.println("estadistica "+x);
    }

    public static boolean existeReserva(ReservaHabitacion_DTO habitacion) {
        return ReservaHabitacion_DAO.existeHabitacion(habitacion);
    }

    
    static String insertReserva(String idHabitacion, String fechaReserva, Date fechaActual,
        String idCliente, String descripcion, String idEmpleado){
            ReservaHabitacion_DTO hab=new ReservaHabitacion_DTO(new Habitacion_DTO(idHabitacion), fechaReserva, 
                new Cliente_DTO(idCliente),fechaActual,new Empleado_DTO(idEmpleado),descripcion);
        if(Reserva_Habitacion_negocio.existeReserva(hab))
            return "No se puede efectuar la reserva. La habitacion ya esta reservada para este día";
        if(ReservaHabitacion_DAO.insertReserva(hab))
            return "Reserva Guardada Exitosamente";
            
        return "Error: No se pudo guardar la reserva. El cliente no Existe";  
    }

    public static ArrayList<ReservaHabitacion_DTO> getReservasByID(String cedula) {
        Cliente_DTO cliente= new Cliente_DTO(cedula);
        cliente=Cliente_DAO.cargarCliente(cliente);
        return ReservaHabitacion_DAO.getReservas(cliente);
    }

    public static ArrayList<ReservaHabitacion_DTO> getReservasByFecha(String fecha) {
        Cliente_DTO cliente= new Cliente_DTO();
        ReservaHabitacion_DTO reserva= new ReservaHabitacion_DTO();
        return ReservaHabitacion_DAO.getReservasByFecha(fecha);
    }
    
   
    public static int[] getEstadisticasMes(String mes,String agno){
        int[] estadistica = new int[3];
        estadistica[0]=ReservaHabitacion_DAO.getReservasByEstadoMes("Espera", mes, agno);
        estadistica[1]=ReservaHabitacion_DAO.getReservasByEstadoMes("Hecha", mes, agno);
        estadistica[2]=ReservaHabitacion_DAO.getReservasByEstadoMes("Cancelada", mes, agno);
        return estadistica;
    }
    
    
}
