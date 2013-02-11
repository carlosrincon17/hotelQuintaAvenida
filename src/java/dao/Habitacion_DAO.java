/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Habitacion_DTO;
import dto.ReservaHabitacion_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import util.BaseDeDatos;
/**
 *
 * @author Jorge
 */
public class Habitacion_DAO {
    
    
    public static boolean create(Habitacion_DTO myHab) throws Exception{
        /*
          prubea de setear un null en la base de datos
         */
        int id_tipo = Tipo_habitacion_DAO.getIdPorNombre(myHab.getTipo());
        int id_estado = Estado_habitacion_DAO.getIdporNombre("libre");
        String sql="INSERT INTO habitacion (id_habitacion ,id_tipo ,estado) VALUES (?, ? ,?)";
        Object[] p = new Object[4];
        p[0] = myHab.getNumero();
        p[1] = id_tipo;
        p[2] = id_estado;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static boolean update(Habitacion_DTO myHab) throws Exception{
        
        int id_tipo = Tipo_habitacion_DAO.getIdPorNombre(myHab.getTipo());
        String sql = "UPDATE habitacion SET id_tipo = ? WHERE id_habitacion = ?";
        Object[] p = new Object[2];
        p[0] = id_tipo;
        p[1] = myHab.getNumero();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }
    
    
    public static ArrayList<Habitacion_DTO> getAll() throws Exception {

        ArrayList<Habitacion_DTO> l = new ArrayList<>();
        String sql = "SELECT id_habitacion,nombre,precio,estado FROM habitacion inner join tipo_habitacion on habitacion.id_tipo = tipo_habitacion.id_tipo ORDER BY id_habitacion";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);

        while (rs.next()) {
            Habitacion_DTO n = new Habitacion_DTO();
            n.setNumero(String.valueOf(rs.getInt(1)));
            n.setTipo(rs.getString(2));
            n.setPrecio(rs.getFloat(3));
            n.setEstado(rs.getString(4));
            l.add(n);
        }
        return l;
    }
    
    
    public static int getIdTipo(Habitacion_DTO hab) throws Exception{
        
        String sql = "SELECT id_tipo FROM tipo_habitacion WHERE nombre = ?";
        Object[] p = new Object[1];
        p[0] = hab.getTipo();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        
        if (rs.next()) {
            System.out.println(rs.getString(1));
            return rs.getInt(1);
        }
        return 0;
    }
    
    
    public static String getTipo(Habitacion_DTO hab) throws Exception{
        
        String sql = "SELECT tipo_habitacion.nombre FROM habitacion inner join tipo_habitacion on habitacion.id_tipo= tipo_habitacion.id_tipo where id_habitacion = ?";
        Object[] p = new Object[1];
        p[0] = hab.getNumero();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        if (rs.next()) {
            return rs.getString(1);
        }
        return "error";
    }
    
    
    public static String getEstado(Habitacion_DTO hab) throws Exception{

        String sql = "SELECT estado_habitacion.nombre FROM habitacion inner join estado_habitacion on habitacion.estado= estado_habitacion.id_estado where id_habitacion = ?";
        Object[] p = new Object[1];
        p[0] = hab.getEstado();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);
        if (rs.next()) {
            return rs.getString(1);
        }
        return "error";
    }
    
    
    public static boolean cambiarEstado(Habitacion_DTO myHab) throws Exception{
        int id_estado = Estado_habitacion_DAO.getIdporNombre(myHab.getEstado());
        //String sql = "UPDATE habitacion SET estado="+id_estado+" WHERE id_habitacion="+myHab.getNumero();
        String sql = "UPDATE habitacion SET estado = ? WHERE id_habitacion = ?";
        Object[] p = new Object[2];
        p[0] = id_estado;
        p[1] = myHab.getNumero();
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, p);
    }

    
    public static ArrayList<Habitacion_DTO> getDisponibles() throws Exception {

        ArrayList<Habitacion_DTO> l = new ArrayList<>();
        String sql = "SELECT id_habitacion FROM habitacion where estado = 1";
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        while (rs.next()) {
            Habitacion_DTO n = new Habitacion_DTO();
            n.setNumero(String.valueOf(rs.getInt(1)));
            l.add(n);
        }
        return l;
    }
        
        
    private static boolean buscarReservas(int id, ReservaHabitacion_DTO reserva) throws Exception {
        
        Date f = reserva.getFechareserva();
        String fecha = f.getYear() + "-" + f.getMonth() + "-" + f.getDate();
        String sql = "Select * from reserva where id_reserva = ? and fecha_reserva = ?";
        Object[] p = new Object[2];
        p[0] = id;
        p[1] = fecha;
        
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, null);
        if (rs.next())
            return true;
        return false;

    }

    
    public static int cambiarEstado2(Habitacion_DTO habitacion) throws Exception {
        //String sql= "Select precio from tipo_habitacion where id_tipo=(Select id_tipo from habitacion"
        //       +" where id_habitacion="+habitacion.getNumero()+")";
        String sql = "Select precio from tipo_habitacion where id_tipo=(Select id_tipo from habitacion"
                + " where id_habitacion= ?";

        Object[] p = new Object[1];
        p[0] = habitacion.getNumero();
        ResultSet rs = BaseDeDatos.getInstance().ejecutarSQL(sql, p);

        if (rs.next()) {
            if (cambiar(habitacion.getNumero())) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    
    private static boolean cambiar(String habitacion) throws Exception{
        String Sql= "Update habitacion set id_estado=1 where id_habitacion = ?";
        Object[] p = new Object[1];
        p[0] = habitacion;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(Sql, p);
    }
    
}
