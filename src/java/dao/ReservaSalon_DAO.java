/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente_DTO;
import dto.Habitacion_DTO;
import dto.ReservaHabitacion_DTO;
import dto.ReservaSalon_DTO;
import dto.Salon_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.BaseDeDatos;

        
        
/**
 *
 * @author Carlos
 */
public class ReservaSalon_DAO {
    
    
    
    public static ArrayList<ReservaSalon_DTO> listarReservas(String salon) {
        Salon_DTO mySalon=Salon_DAO.leerSalon(salon);
        
        ArrayList<ReservaSalon_DTO> reservas= new ArrayList<ReservaSalon_DTO>();
        String sql="SELECT * FROM reserva INNER JOIN reserva_salon ON reserva.id_reserva ="+
                "reserva_salon.id_reserva_salon WHERE reserva_salon.id_salon ="+mySalon.getID()+" AND activa =1";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            while(rs.next()){
               ReservaSalon_DTO reserva= new ReservaSalon_DTO();
               reserva.setCliente(Cliente_DAO.read(rs.getString(2)));
               reserva.setId(rs.getInt(1));
               reserva.setFechaSolicitud(rs.getDate(3));
               reserva.setFechareserva(rs.getDate(4));
               reserva.setSalon(mySalon);
               reserva.setDescripcion(rs.getString(8));
               reserva.setAbonoReserva(rs.getInt(9));
               reserva.setHora(rs.getInt(10));
               reserva.setDuracion(rs.getInt(11)-rs.getInt(10));
               reserva.setTotal(rs.getInt(12));
               reservas.add(reserva);
            }
        }
        catch (Exception e){
            
        }
        return reservas;
    }

    private static int getID(String salon) {
        
        String sql="Select * from salon where nombre='"+salon+"'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try {
            if(rs.next())
            return(rs.getInt(1));
        }
        catch(Exception e){
        
        }
        return -1;
    }

       
    private static boolean buscarReservas(int id, ReservaSalon_DTO reserva) {
        
        int horafin=reserva.getHora()+reserva.getDuracion();
        String sql="Select * from reserva_salon where id_reserva_salon="+id+" and ((hora_inicio<"+reserva.getHora()+
                " and hora_fin>"+reserva.getHora()+") or (hora_inicio<"+horafin+" and hora_fin>"+horafin+"))";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            if(rs.next()) return true;          
        }
    
        catch(Exception e){
        }
        return false;
        
    }
    public static boolean existeReserva(ReservaSalon_DTO reserva){
        int id= getID(reserva.getSalon().getNombre());
        ArrayList<Integer> ids= buscarIds(reserva);
        if(ids.isEmpty()) return false;
        for(int pos:ids){
            if(buscarReservas(pos,reserva))return true;
        }
        return false;
        
     }
    
    private static ArrayList<Integer> buscarIds(ReservaSalon_DTO reserva) {
        Date f= reserva.getFechareserva();
        String fecha=f.getYear()+"-"+f.getMonth()+"-"+f.getDate(); 
        ArrayList<Integer> ids= new ArrayList<Integer>();
        String sql="Select id_reserva from reserva where fecha_reserva="+fecha+"";
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

    public static boolean insertReserva(ReservaSalon_DTO reserva) {
        Date f= reserva.getFechareserva();
        String fecha=f.getYear()+"-"+f.getMonth()+"-"+f.getDate(); 
        int id= Reserva_DAO.guardarReserva(fecha, reserva.getFechaSolicitud(), reserva.getCliente().getDocumento());
        if(id==-1)
            return false;
        return agregarReserva(reserva, id);
    }

    private static boolean agregarReserva(ReservaSalon_DTO reserva, int id) {
     int total=(int)(reserva.getSalon().getPrecioHora()*reserva.getDuracion());   
     String sql="Insert into reserva_salon (id_empleado, hora_fin, hora_inicio, abono, id_salon, descripcion, id_reserva_salon, total)"+
                "values ('"+reserva.getEmpleado().getDocumento()+"', "+(reserva.getHora()+reserva.getDuracion())+
                ","+reserva.getHora()+","+reserva.getAbonoReserva()+", "+reserva.getSalon().getID()+",'"+
                reserva.getDescripcion()+"',"+id+","+total+" )";   
     return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<ReservaSalon_DTO> getReservas(Cliente_DTO cliente) { 
        ArrayList<ReservaSalon_DTO> reservas= new ArrayList<ReservaSalon_DTO>();
        
        //String sql="select * from reserva where id_cliente='"+cliente.getDocumento()+"'";
        String sql = "select * from reserva inner join reserva_salon on reserva.id_reserva="+
                "reserva_salon.id_reserva_salon where reserva.id_cliente='"+cliente.getDocumento()+
                "' and estado'Espera'";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            while(rs.next()){
               ReservaSalon_DTO reserva= new ReservaSalon_DTO();
               Salon_DTO mySalon= Salon_DAO.cargarSalonByID(rs.getInt(7));
               reserva.setCliente(Cliente_DAO.read(rs.getString(2)));
               reserva.setId(rs.getInt(1));
               reserva.setFechaSolicitud(rs.getDate(3));
               reserva.setFechareserva(rs.getDate(4));
               reserva.setSalon(mySalon);
               reserva.setDescripcion(rs.getString(8));
               reserva.setAbonoReserva(rs.getInt(9));
               reserva.setHora(rs.getInt(10));
               reserva.setDuracion(rs.getInt(11)-rs.getInt(10));
               reserva.setTotal(rs.getInt(12));
               reservas.add(reserva);
                
            }
            return reservas;
        }
        catch(Exception e){
            
        }
        return reservas;
    }
    
    
    public static int getReservasByEstadoMes(String estado,String mes, String agno){
        String sql="";
        if(Integer.parseInt(mes)<12)
            sql="select count(*) from reserva_salon inner join reserva on id_reserva_salon=id_reserva"+
                " where reserva.estado='"+estado+
                "' and (reserva.fecha_reserva between '"+agno+"-"+mes+"-01' and '"+agno+"-"+
                (Integer.parseInt(mes)+1)+"-01')";
        else
            sql="select count(*) from reserva_salon inner join reserva on id_reserva_salon=id_reserva"+
                " where reserva.estado='"+estado+
                "' and (reserva.fecha_reserva between '"+agno+"-"+mes+"-01' and '"+(Integer.parseInt(agno)+1)+"-"+
                "01-01')";
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
   
    

