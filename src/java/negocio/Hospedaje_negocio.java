/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Habitacion_DAO;
import dao.Hospedaje_DAO;
import dto.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
class Hospedaje_negocio {

    public static String registrar(String id_cliente, String id_habitacion) {
        System.out.print(id_cliente + "- " + id_habitacion +"\n" );
        java.util.Date actual = new Date();
        Hospedaje_DTO nuevo = new Hospedaje_DTO();
        nuevo.setHuesped(new Cliente_DTO(id_cliente));
        Habitacion_DTO hab = new Habitacion_DTO(id_habitacion);
        System.out.print(id_cliente + "- " + id_habitacion +"\n" );
        nuevo.setHabitacion(hab);
        System.out.print(nuevo.getHuesped().getDocumento() + "  - "+nuevo.getHabitacion().getNumero()+" \n");
        nuevo.setHabitacion(hab);
        nuevo.setFechaInicio(actual);
        try {
            if(Hospedaje_DAO.create(nuevo)){
                Habitacion_negocio.cambiarEstado(hab.getNumero(), "1");
                return "Se registro el hospedaje con exito";}
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No se pudo registrar el hospedaje";
    }

    
    public static String registrar(String id_cliente, int id_reserva) {
        ArrayList<ReservaHabitacion_DTO> reservas = new ArrayList<ReservaHabitacion_DTO>();
        java.util.Date actual = new Date();
        Hospedaje_DTO nuevo = new Hospedaje_DTO();
        nuevo.setFechaInicio(actual);
        try {
            if(Hospedaje_DAO.create(nuevo,reservas.get(0))){
                Habitacion_negocio.cambiarEstado(reservas.get(0).getHabitacion().getNumero(), "ocupada");
                return "Se registro el hospedaje con exito";
            }
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "No se pudo registrar el hospedaje";
        
    }
    public static ArrayList<Hospedaje_DTO> listarDisponibles(){
        try {
            return Hospedaje_DAO.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ArrayList<Hospedaje_DTO> listar(){
        try {
            return Hospedaje_DAO.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public static ArrayList<ServicioHabitacion_DTO> getConsumos(String id_cliente, String id_habitacion) {
        Hospedaje_DTO h = new Hospedaje_DTO(new Cliente_DTO(id_cliente),new Habitacion_DTO(id_habitacion));
        try {  
            return Hospedaje_DAO.getConsumos(h);
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public static boolean entregar(String id_habitacion) {
        java.util.Date fecha = new Date();
        Habitacion_DTO hab = new Habitacion_DTO(id_habitacion);
        try { 
            return Hospedaje_DAO.entregar(hab, fecha) && Habitacion_negocio.cambiarEstado(id_habitacion,"sucia");
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public static String terminarHospedaje(int hospedaje, int habitacion) throws Exception {
        Habitacion_DTO myHab=new Habitacion_DTO(String.valueOf(habitacion));
        ArrayList<ServicioHabitacion_DTO> myServicios = ServicioHabitacion_negocio.getServicios(myHab);
        String msj= Habitacion_negocio.cargarServicios(String.valueOf(hospedaje));
        msj+="<br><br><br>";
        int total= sumarTotalServicios(myServicios);
        Hospedaje_DTO hosp= new Hospedaje_DTO(hospedaje);
        Habitacion_DTO hab= new Habitacion_DTO(String.valueOf(habitacion));
        int precioHab;
        try {
            msj+= "<table class='table table-hover'><thead><th>Total Servicios</th><th>"
                    + "Dias Hospedaje</th> <th>Total Hospedaje</th> <th>Precio a Pagar</th></thead>";
            precioHab = Habitacion_DAO.cambiarEstado2(hab);
            int dias = Hospedaje_DAO.terminarHospedaje(hosp);
            int precioFinal= precioHab*dias;
            int totalisimo= precioFinal + total;
            msj+="<tr><td>"+total+"</td><td>"+dias+"</td><td>"+precioFinal+"</td><td>"+totalisimo+"</td></tr>";
            
            return msj+="</table>";
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
            
            return "";
            
        } 
    }
    
    
    public static int[] getHospedajes3Mes() {

        int[] est = new int[3];
        Date ahora = new Date();
        int mes = ahora.getMonth();
        String mes1 = String.valueOf((12 + (mes + 1)) / 12);
        String mes2 = String.valueOf((12 + (mes + 1 - 1)) / 12);
        String mes3 = String.valueOf((12 + (mes + 1 - 2)) / 12);
        int agno = ahora.getYear();
        try {
            est[0] = Hospedaje_DAO.getHospedajesMes(mes1, String.valueOf(agno));
            switch (mes) {
                case 0:
                    est[1] = Hospedaje_DAO.getHospedajesMes(mes2, String.valueOf((agno - 1)));
                    est[2] = Hospedaje_DAO.getHospedajesMes(mes3, String.valueOf((agno - 1)));
                    break;
                case 1:
                    est[1] = Hospedaje_DAO.getHospedajesMes(mes2, String.valueOf(agno));
                    est[2] = Hospedaje_DAO.getHospedajesMes(mes3, String.valueOf((agno - 1)));
                    break;
                default:
                    est[1] = Hospedaje_DAO.getHospedajesMes(mes2, String.valueOf(agno));
                    est[2] = Hospedaje_DAO.getHospedajesMes(mes3, String.valueOf(agno));
                    break;
            }

            return est;
        } catch (Exception ex) {
            Logger.getLogger(Hospedaje_negocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static int sumarTotalServicios(ArrayList<ServicioHabitacion_DTO> myServicios) {
        int suma=0;
        for(ServicioHabitacion_DTO myser: myServicios){
            suma+=myser.getImporte();
        }
        return suma;
    }

    
    
}
