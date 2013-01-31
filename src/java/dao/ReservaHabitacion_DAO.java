/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente_DTO;
import dto.Habitacion_DTO;
import dto.ReservaHabitacion_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import util.BaseDeDatos;

/**
 *
 * @author Carlos
 */
public class ReservaHabitacion_DAO {
    
    public static void main(String[] args){
        BaseDeDatos.conectar();
        
        int n = ReservaHabitacion_DAO.getReservasByEstadoMes("espera", "08", "2012");
        System.out.println("r "+n);
        BaseDeDatos.desconectar();
    }
    
    public static boolean existeHabitacion(ReservaHabitacion_DTO reserva){
        ArrayList<Integer> ids= buscarIds(reserva);
        if(ids.isEmpty()) return false;
        for(int id:ids){
            if(buscarReservas(id,reserva))return true;
        }
        return false;
        
        
    }

    private static ArrayList<Integer> buscarIds(ReservaHabitacion_DTO reserva) {
        ArrayList<Integer> ids= new ArrayList<Integer>();
        String sql="Select id_reserva_habitacion from reserva_habitacion where id_habitacion='"+reserva.getHabitacion().getNumero()+"'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            while(rs.next()){
                ids.add(rs.getInt(1));
            }
        }
        catch (Exception e){
        }
        return ids;
    }

    private static boolean buscarReservas(int id, ReservaHabitacion_DTO reserva) {
        Date f= reserva.getFechareserva();
        String fecha=f.getYear()+"-"+f.getMonth()+"-"+f.getDate(); 
        String sql="Select * from reserva where id_reserva="+id+" and fecha_reserva='"+fecha+"' ";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            if(rs.next()) return true;          
        }
    
        catch(Exception e){
        }
        return false;
        
    }

    public static boolean insertReserva(ReservaHabitacion_DTO reserva) {
        Date f= reserva.getFechareserva();
        String fecha=f.getYear()+"-"+f.getMonth()+"-"+f.getDate(); 
        int id= Reserva_DAO.guardarReserva(fecha, reserva.getFechaSolicitud(), reserva.getCliente().getDocumento());
        if(id==-1)
            return false;
        return agregarReserva(reserva, id);
    }

    private static boolean agregarReserva(ReservaHabitacion_DTO reserva, int id) {
        String sql="Insert into reserva_habitacion (id_reserva_habitacion, id_habitacion, descripcion) values ("+id+
                ","+reserva.getHabitacion().getNumero()+",'"+reserva.getDescripcion()+"')";
        return(BaseDeDatos.ejecutarActualizacionSQL(sql));
    }

    public static ArrayList<ReservaHabitacion_DTO> getReservas(Cliente_DTO cliente) {
        
        ArrayList<ReservaHabitacion_DTO> reserva= new ArrayList<ReservaHabitacion_DTO>();
        
        //String sql="select * from reserva where id_cliente='"+cliente.getDocumento()+"'";
        String sql = "select * from reserva inner join reserva_habitacion on reserva.id_reserva=reserva_habitacion.id_reserva_habitacion where reserva.id_cliente='"+cliente.getDocumento()+"' estado='Espera'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            while(rs.next()){
                ReservaHabitacion_DTO nueva = new ReservaHabitacion_DTO();
                nueva.setId(rs.getInt(1));
                nueva.setCliente(cliente);
                nueva.setFechaSolicitud(rs.getDate(3));
                nueva.setFechareserva(rs.getDate(4));
                nueva.setHabitacion(new Habitacion_DTO(rs.getString(7)));
                nueva.setDescripcion(rs.getString(8));
                reserva.add(nueva);
                /*
                 ReservaHabitacion_DTO myReserva=new ReservaHabitacion_DTO(rs.getInt(1),rs.getDate(3),rs.getDate(2),
                 Cliente_DAO.cargarCliente(new Cliente_DTO(rs.getString(2))));
                 obtenerReserva(myReserva);
                 reserva.add(myReserva);
                 System.out.println("aca llega \n");
                 System.out.println(myReserva.getId());*/
                
            }
            return reserva;
        }
        catch(Exception e){
            
        }
        return reserva;
    }

    public static ArrayList<ReservaHabitacion_DTO> getReservasByFecha(String fecha) {
        
        ArrayList<ReservaHabitacion_DTO> reserva= new ArrayList<ReservaHabitacion_DTO>();
        String sql="Select * from reserva where fecha_reserva='"+fecha+"' and activa=1";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            while(rs.next()){   
                reserva.add(new ReservaHabitacion_DTO(rs.getInt(1),rs.getDate(3),rs.getDate(2),
                        Cliente_DAO.cargarCliente(new Cliente_DTO(rs.getString(2)))));
                obtenerReserva(reserva.get(reserva.size()-1));
                
            } 
        }
        catch(Exception e){
        }
        return reserva;
    }
    
    public static void obtenerReserva(ReservaHabitacion_DTO reserva){
        String sql="Select * from reserva_habitacion where id_reserva_habitacion="+reserva.getId()+"";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            while(rs.next()){
                reserva.setDescripcion(rs.getString(3));
                reserva.getHabitacion().setNumero(rs.getString(2));
            } 
        }
        catch(Exception e){
        }
    }
    
    public static int getReservasByEstadoMes(String estado,String mes, String agno){
        String sql="";
        if(Integer.parseInt(mes)<12)
                sql="select count(*) from reserva_habitacion inner join reserva on id_reserva_habitacion=id_reserva"+
                " where reserva.estado='"+estado+
                "' and (reserva.fecha_reserva between '"+agno+"-"+mes+"-01' and '"+
                agno+"-"+(Integer.parseInt(mes)+1)+"-01')";
        else
            sql="select count(*) from reserva_habitacion inner join reserva on id_reserva_habitacion=id_reserva"+
                " where reserva.estado='"+estado+
                "' and (reserva.fecha_reserva between '"+agno+"-"+mes+"-01' and '"+
                (Integer.parseInt(agno)+1) +"-01-01')";
        
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        int res = 0;
        try {
            if(rs.next())
                res = rs.getInt(1);
        } catch (Exception e) {
        }
        return res;
    }
    
    
}
