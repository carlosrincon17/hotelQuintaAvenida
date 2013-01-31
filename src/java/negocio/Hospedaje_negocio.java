/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Habitacion_DAO;
import java.util.Date;
import dto.Hospedaje_DTO;
import dto.Cliente_DTO;
import dto.Habitacion_DTO;
import dto.ReservaHabitacion_DTO;
import dao.Hospedaje_DAO;
import dto.*;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
class Hospedaje_negocio {

    public static String registrar(String id_cliente, String id_habitacion) {
        java.util.Date actual = new Date();
        Hospedaje_DTO nuevo = new Hospedaje_DTO();
        nuevo.setHuesped(new Cliente_DTO(id_cliente));
        Habitacion_DTO hab = new Habitacion_DTO(id_habitacion);
        nuevo.setHabitacion(hab);
        nuevo.setFechaInicio(actual);
        if(Hospedaje_DAO.create(nuevo)){
            Habitacion_negocio.cambiarEstado(hab.getNumero(), "ocupada");
            return "Se registro el hospedaje con exito";}
        
        return "No se pudo registrar el hospedaje";
    }

    public static String registrar(String id_cliente, int id_reserva) {
        ArrayList<ReservaHabitacion_DTO> reservas = new ArrayList<ReservaHabitacion_DTO>();
        java.util.Date actual = new Date();
        Hospedaje_DTO nuevo = new Hospedaje_DTO();
        nuevo.setFechaInicio(actual);
        if(Hospedaje_DAO.create(nuevo,reservas.get(0))){
            Habitacion_negocio.cambiarEstado(reservas.get(0).getHabitacion().getNumero(), "ocupada");
            return "Se registro el hospedaje con exito";
        }
        
        return "No se pudo registrar el hospedaje";
        
    }
    
    public static ArrayList<Hospedaje_DTO> listar(){
        return Hospedaje_DAO.getAll();
    }

    public static ArrayList<ServicioHabitacion_DTO> getConsumos(String id_cliente, String id_habitacion) {
        Hospedaje_DTO h = new Hospedaje_DTO(new Cliente_DTO(id_cliente),new Habitacion_DTO(id_habitacion));
        
        return Hospedaje_DAO.getConsumos(h);
        
    }

    static boolean entregar(String id_habitacion) {
        java.util.Date fecha = new Date();
        Habitacion_DTO hab = new Habitacion_DTO(id_habitacion);
       return Hospedaje_DAO.entregar(hab, fecha) && Habitacion_negocio.cambiarEstado(id_habitacion,"sucia"); 
    }

    static String terminarHospedaje(int hospedaje, int habitacion) {
        Hospedaje_DTO hosp= new Hospedaje_DTO(hospedaje);
        Habitacion_DTO hab= new Habitacion_DTO(String.valueOf(habitacion));
        int precioHab= Habitacion_DAO.cambiarEstado2(hab);
        int dias= Hospedaje_DAO.terminarHospedaje(hosp);
        return (precioHab*dias)+"";
    }
    
    public static int[] getHospedajes3Mes(){
        int[] est = new int[3];
        Date ahora = new Date();
        int mes = ahora.getMonth();
        String mes1 = String.valueOf((12+(mes+1))/12);
        String mes2 = String.valueOf((12+(mes+1-1))/12);
        String mes3 = String.valueOf((12+(mes+1-2))/12);
        int agno = ahora.getYear();
        
        est[0] = Hospedaje_DAO.getHospedajesMes(mes1, String.valueOf(agno));
        switch(mes){
            case 0:
                est[1] = Hospedaje_DAO.getHospedajesMes(mes2, String.valueOf((agno-1)));
                est[2] = Hospedaje_DAO.getHospedajesMes(mes3, String.valueOf((agno-1)));
                break;
            case 1 :
                est[1] = Hospedaje_DAO.getHospedajesMes(mes2, String.valueOf(agno));
                est[2] = Hospedaje_DAO.getHospedajesMes(mes3, String.valueOf((agno-1)));
                break;
            default:
                est[1] = Hospedaje_DAO.getHospedajesMes(mes2, String.valueOf(agno));
                est[2] = Hospedaje_DAO.getHospedajesMes(mes3, String.valueOf(agno));
                break;
        }
        
        return est;
    }
    
}
