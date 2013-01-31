/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import java.sql.ResultSet;
import util.BaseDeDatos;
import dto.Habitacion_DTO;
import dto.ReservaHabitacion_DTO;
import java.util.Date;
/**
 *
 * @author Jorge
 */
public class Habitacion_DAO {
    
    public static boolean create(Habitacion_DTO myHab){
        int id_tipo = Tipo_habitacion_DAO.getIdPorNombre(myHab.getTipo());
        int id_estado = Estado_habitacion_DAO.getIdporNombre("libre");
        String sql="INSERT INTO habitacion (id_habitacion ,id_tipo ,id_minibar ,estado) VALUES ('"+ myHab.getNumero() +"', '"+id_tipo+"', NULL , '"+id_estado+"')";
        
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static boolean update(Habitacion_DTO myHab){
        
        int id_tipo = Tipo_habitacion_DAO.getIdPorNombre(myHab.getTipo());
        String sql = "UPDATE habitacion SET id_tipo="+id_tipo+" WHERE id_habitacion="+myHab.getNumero();
        
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }
    
    public static ArrayList<Habitacion_DTO> getAll(){
        ArrayList<Habitacion_DTO> l = new ArrayList<Habitacion_DTO>();
        String sql= "SELECT id_habitacion,nombre,precio,estado FROM habitacion inner join tipo_habitacion on habitacion.id_tipo = tipo_habitacion.id_tipo ORDER BY id_habitacion";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
                Habitacion_DTO n = new Habitacion_DTO();
                n.setNumero(String.valueOf(rs.getInt(1)));
                n.setTipo(rs.getString(2));
                n.setPrecio(rs.getFloat(3));
                n.setEstado(rs.getString(4));
                l.add(n);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return l;
    }
    
    public static int getIdTipo(Habitacion_DTO hab){
        String sql="SELECT id_tipo FROM tipo_habitacion WHERE nombre='"+hab.getTipo()+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            if(rs.next()){
                System.out.println(rs.getString(1));
            return rs.getInt(1);
        }
        } catch (Exception e) {
            
        }
        
        return 0;
    }
    
    public static String getTipo(Habitacion_DTO hab){
        String sql="SELECT tipo_habitacion.nombre FROM habitacion inner join tipo_habitacion on habitacion.id_tipo= tipo_habitacion.id_tipo where id_habitacion='"+hab.getNumero()+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            if(rs.next()){
            return rs.getString(1);
        }
        } catch (Exception e) {
            
        }
        
        return "error";
    }
    
    public static String getEstado(Habitacion_DTO hab){
        String sql="SELECT estado_habitacion.nombre FROM habitacion inner join estado_habitacion on habitacion.estado= estado_habitacion.id_estado where id_habitacion='"+hab.getNumero()+"'";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            if(rs.next()){
            return rs.getString(1);
        }
        } catch (Exception e) {
            
        }
        
        return "error";
    }
    
    public static boolean cambiarEstado(Habitacion_DTO myHab){
        int id_estado = Estado_habitacion_DAO.getIdporNombre(myHab.getEstado());
        String sql = "UPDATE habitacion SET estado="+id_estado+" WHERE id_habitacion="+myHab.getNumero();
        
        return BaseDeDatos.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<Habitacion_DTO> getDisponibles() {
        ArrayList<Habitacion_DTO> l = new ArrayList<Habitacion_DTO>();
        String sql= "SELECT id_habitacion FROM habitacion where estado=1";
        ResultSet rs = BaseDeDatos.ejecutarSQL(sql);
        try {
            while(rs.next()){
                Habitacion_DTO n = new Habitacion_DTO();
                n.setNumero(String.valueOf(rs.getInt(1)));
                l.add(n);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return l;
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

    public static int cambiarEstado2(Habitacion_DTO habitacion) {
        String sql= "Select precio from tipo_habitacion where id_tipo=(Select id_tipo from habitacion"
                +" where id_habitacion="+habitacion.getNumero()+")";
        ResultSet rs= BaseDeDatos.ejecutarSQL(sql);
        try{
            if(rs.next()){
                if(cambiar(habitacion.getNumero())){
                    return rs.getInt(1);
                }
                
            }
            }
        catch (Exception e){
            
        }
        return -1;
    }

    private static boolean cambiar(String habitacion) {
        String Sql= "Update habitacion set id_estado=1 where id_habitacion="+habitacion+"";
        return BaseDeDatos.ejecutarActualizacionSQL(Sql);
    }
    
}
