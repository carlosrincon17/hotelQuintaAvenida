/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente_DTO;
import dto.ReservaSalon_DTO;
import dto.Salon_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import util.BaseDeDatos;

        
        
/**
 *
 * @author Carlos
 */
public class ReservaSalon_DAO {
    
    
    
    public static ArrayList<ReservaSalon_DTO> listarReservas(String salon) throws Exception{

        Salon_DTO mySalon = Salon_DAO.leerSalon(salon);
        ArrayList<ReservaSalon_DTO> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva INNER JOIN reserva_salon ON reserva.id_reserva ="
                + "reserva_salon.id_reserva_salon WHERE reserva_salon.id_salon = ? AND activa =1";

        Object[] p = new Object[1];
        p[0] = mySalon.getID();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        while (rs.next()) {
            ReservaSalon_DTO reserva = new ReservaSalon_DTO();
            reserva.setCliente(Cliente_DAO.read(rs.getString(2)));
            reserva.setId(rs.getInt(1));
            reserva.setFechaSolicitud(rs.getDate(3));
            reserva.setFechareserva(rs.getDate(4));
            reserva.setSalon(mySalon);
            reserva.setDescripcion(rs.getString(8));
            reserva.setAbonoReserva(rs.getInt(9));
            reserva.setHora(rs.getInt(10));
            reserva.setDuracion(rs.getInt(11) - rs.getInt(10));
            reserva.setTotal(rs.getInt(12));
            reservas.add(reserva);
        }
        return reservas;
    }

    
    private static int getID(String salon) throws Exception {

        String sql = "Select * from salon where nombre = ?";
        Object[] p = new Object[1];
        p[0] = salon;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        if (rs.next()) 
            return (rs.getInt(1));
        return -1;
    }

       
    private static boolean buscarReservas(int id, ReservaSalon_DTO reserva) throws Exception {
        
        int horafin = reserva.getHora() + reserva.getDuracion();
        String sql = "Select * from reserva_salon where id_reserva_salon = ? "
                + "and ((hora_inicio < ? and hora_fin > ?) or (hora_inicio < ? and hora_fin > ?))";

        Object[] p = new Object[5];
        p[0] = id;
        p[1] = reserva.getHora();
        p[2] = reserva.getHora();
        p[3] = horafin;
        p[4] = horafin;
        
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        
        if (rs.next())
            return true;
        return false;
    }
    
    
    public static boolean existeReserva(ReservaSalon_DTO reserva) throws Exception {

        int id = getID(reserva.getSalon().getNombre());
        ArrayList<Integer> ids = buscarIds(reserva);
        if (ids.isEmpty()) {
            return false;
        }
        for (int pos : ids) {
            if (buscarReservas(pos, reserva)) {
                return true;
            }
        }
        return false;
    }
    
    
    private static ArrayList<Integer> buscarIds(ReservaSalon_DTO reserva) throws Exception {

        Date f = reserva.getFechareserva();
        String fecha = f.getYear() + "-" + f.getMonth() + "-" + f.getDate();
        ArrayList<Integer> ids = new ArrayList<>();
        
        String sql = "Select id_reserva from reserva where fecha_reserva = ?";
        Object[] p = new Object[1];
        p[0] = fecha;
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        while (rs.next()) {
            ids.add(rs.getInt(1));
        }
        return ids;
    }

    
    public static boolean insertReserva(ReservaSalon_DTO reserva) throws Exception{
        
        Date f= reserva.getFechareserva();
        String fecha=f.getYear()+"-"+f.getMonth()+"-"+f.getDate(); 
        int id= Reserva_DAO.guardarReserva(fecha, reserva.getFechaSolicitud(), reserva.getCliente().getDocumento());
        if(id==-1)
            return false;
        return agregarReserva(reserva, id);
    }

    
    private static boolean agregarReserva(ReservaSalon_DTO reserva, int id) throws Exception {

        int total = (int) (reserva.getSalon().getPrecioHora() * reserva.getDuracion());
        //  String sql="Insert into reserva_salon (id_empleado, hora_fin, hora_inicio, abono, id_salon, descripcion, id_reserva_salon, total)"+
        //              "values ('"+reserva.getEmpleado().getDocumento()+"', "+(reserva.getHora()+reserva.getDuracion())+
        //              ","+reserva.getHora()+","+reserva.getAbonoReserva()+", "+reserva.getSalon().getID()+",'"+
        //             reserva.getDescripcion()+"',"+id+","+total+" )";   

        String sql = "Insert into reserva_salon values (?,?,?,?,?,?,?,?,0)";

        Object[] p = new Object[8];
        p[0] = id;
        p[1] = reserva.getSalon().getID();
        p[2] = reserva.getDescripcion();
        p[3] = reserva.getAbonoReserva();
        p[4] = reserva.getHora();
        p[5] = reserva.getDuracion()+ reserva.getHora();
        p[6] = total;
        p[7] = reserva.getEmpleado().getDocumento();
        
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static ArrayList<ReservaSalon_DTO> getReservas(Cliente_DTO cliente) throws Exception {

        ArrayList<ReservaSalon_DTO> reservas = new ArrayList<>();
        //String sql="select * from reserva where id_cliente='"+cliente.getDocumento()+"'";
        String sql = "select * from reserva inner join reserva_salon on reserva.id_reserva="
                + "reserva_salon.id_reserva_salon where reserva.id_cliente = ? and reserva.activa='1'";

        Object[] p = new Object[1];
        p[0] = cliente.getDocumento();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        while (rs.next()) {
            ReservaSalon_DTO reserva = new ReservaSalon_DTO();
            Salon_DTO mySalon = Salon_DAO.cargarSalonByID(rs.getInt(7));
            reserva.setCliente(Cliente_DAO.read(rs.getString(2)));
            reserva.setId(rs.getInt(1));
            reserva.setFechaSolicitud(rs.getDate(3));
            reserva.setFechareserva(rs.getDate(4));
            reserva.setSalon(mySalon);
            reserva.setDescripcion(rs.getString(8));
            reserva.setAbonoReserva(rs.getInt(9));
            reserva.setHora(rs.getInt(10));
            reserva.setDuracion(rs.getInt(11) - rs.getInt(10));
            reserva.setTotal(rs.getInt(12));
            reservas.add(reserva);
        }
        return reservas;
    }
    
    
    public static int getReservasByEstadoMes(String estado, String mes, String agno) throws Exception {

        String sql;
        Object[] p;
        if (Integer.parseInt(mes) < 12) {
            sql = "select count(*) from reserva_salon inner join reserva on id_reserva_salon=id_reserva"
                    + " where reserva.estado = ? and (reserva.fecha_reserva between ?-?-01' and ?-?-01')";

            p = new Object[5];
            p[0] = estado;
            p[1] = agno;
            p[2] = mes;
            p[3] = agno;
            p[4] = Integer.parseInt(mes) + 1;
        } 
        else {
            sql = "select count(*) from reserva_salon inner join reserva on id_reserva_salon=id_reserva"
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
   
    

