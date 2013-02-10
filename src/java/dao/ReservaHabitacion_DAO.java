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
    
    /*public static void main(String[] args){
        BaseDeDatos.conectar();
        
        int n = ReservaHabitacion_DAO.getReservasByEstadoMes("espera", "08", "2012");
        System.out.println("r "+n);
        BaseDeDatos.desconectar();
    }*/
    
    public static boolean existeHabitacion(ReservaHabitacion_DTO reserva) throws Exception{
        ArrayList<Integer> ids= buscarIds(reserva);
        if(ids.isEmpty()) return false;
        for(int id:ids){
            if(buscarReservas(id,reserva))return true;
        }
        return false;  
    }

    
    private static ArrayList<Integer> buscarIds(ReservaHabitacion_DTO reserva) throws Exception{
        
        ArrayList<Integer> ids = new ArrayList<>();
        String sql = "Select id_reserva_habitacion from reserva_habitacion where id_habitacion = ?";
        Object[] p = new Object[1];
        p[0] = reserva.getHabitacion().getNumero();

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        while (rs.next()) {
            ids.add(rs.getInt(1));
        }
        return ids;
    }

    
    private static boolean buscarReservas(int id, ReservaHabitacion_DTO reserva) throws Exception{
        
        Date f = reserva.getFechareserva();
        String fecha=f.getYear()+"-"+f.getMonth()+"-"+f.getDate();
        String sql = "Select * from reserva where id_reserva = ? and fecha_reserva = ?";
        Object[] p = new Object[2];
        p[0] = id;
        p[1] = fecha;
        
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        if(rs.next()) return true;
        return false;
    }

    
    public static boolean insertReserva(ReservaHabitacion_DTO reserva) throws Exception{
        Date f= reserva.getFechareserva();
        String fecha=f.getYear()+"-"+f.getMonth()+"-"+f.getDate(); 
        int id= Reserva_DAO.guardarReserva(fecha, reserva.getFechaSolicitud(), reserva.getCliente().getDocumento());
        if(id==-1)
            return false;
        return agregarReserva(reserva, id);
    }

    
    private static boolean agregarReserva(ReservaHabitacion_DTO reserva, int id) throws Exception{
       String sql = "Insert into reserva_habitacion values (?,?,?)";
       Object[] p = new Object[3];
       p[0] = id;
       p[1] = reserva.getHabitacion().getNumero();
       p[0] = reserva.getDescripcion();
       return(BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p));
    }

    
    public static ArrayList<ReservaHabitacion_DTO> getReservas(Cliente_DTO cliente) throws Exception {

        ArrayList<ReservaHabitacion_DTO> reserva = new ArrayList<>();
        //String sql="select * from reserva where id_cliente='"+cliente.getDocumento()+"'";
        String sql = "select * from reserva inner join reserva_habitacion on reserva.id_reserva=reserva_habitacion.id_reserva_habitacion where reserva.id_cliente = ? AND estado='Espera'";
        Object[] p = new Object[1];
        p[0] = cliente.getDocumento();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        while (rs.next()) {
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

    
    public static ArrayList<ReservaHabitacion_DTO> getReservasByFecha(String fecha) throws Exception {

        ArrayList<ReservaHabitacion_DTO> reserva = new ArrayList<>();
        String sql = "Select * from reserva where fecha_reserva = ? and activa = 1";
        Object[] p = new Object[1];
        p[0] = fecha;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        while (rs.next()) {
            reserva.add(new ReservaHabitacion_DTO(rs.getInt(1), rs.getDate(3), rs.getDate(2),
                    Cliente_DAO.cargarCliente(new Cliente_DTO(rs.getString(2)))));
            obtenerReserva(reserva.get(reserva.size() - 1));
        }
        return reserva;
    }
    
    
    public static void obtenerReserva(ReservaHabitacion_DTO reserva) throws Exception {

        String sql = "Select * from reserva_habitacion where id_reserva_habitacion = ?";
        Object[] p = new Object[1];
        p[0] = reserva.getId();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        while (rs.next()) {
            reserva.setDescripcion(rs.getString(3));
            reserva.getHabitacion().setNumero(rs.getString(2));
        }
    }

    
    public static int getReservasByEstadoMes(String estado, String mes, String agno) throws Exception {

        String sql;
        Object[] p;
        
        if (Integer.parseInt(mes) < 12) {
            sql = "select count(*) from reserva_habitacion inner join reserva on id_reserva_habitacion=id_reserva"
                    + " where reserva.estado = ? and (reserva.fecha_reserva between ?-?-01' and ?-?-01')";
            p = new Object[5];
            p[0] = estado;
            p[1] = agno;
            p[2] = mes;
            p[3] = agno;
            p[4] = Integer.parseInt(mes) + 1;
        } 
        else {
            sql = "select count(*) from reserva_habitacion inner join reserva on id_reserva_habitacion=id_reserva"
                    + " where reserva.estado = ? and (reserva.fecha_reserva between ?-?-01' and ?-01-01')";
            p = new Object[4];
            p[0] = estado;
            p[1] = agno;
            p[2] = mes;
            p[3] = Integer.parseInt(agno) + 1;
        }

        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        int res = 0;
        if (rs.next()) {
            res = rs.getInt(1);
        }
        return res;
    }
    
    
}
