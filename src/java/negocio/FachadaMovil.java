/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Persona_DAO;
import dao.Usuario_DAO;
import dto.Persona_DTO;
import dto.ReservaHabitacion_DTO;
import dto.ReservaSalon_DTO;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author Carlos
 */
public class FachadaMovil {
    
      public FachadaMovil() throws Exception {
        if(!BaseDeDatos.getInstance().hayConexion())
            BaseDeDatos.getInstance().conectar();
    }
      
      public String listaHabitaciones() throws Exception{
          return TipoHabitacion_negocio.listaHabitaciones();
         
      }
      public String listaSalones() throws Exception{
            
          return Salon_negocio.cargarSalonesMovil();
         
      }
      
      public String listarOpcionSal() throws Exception{
          return Salon_negocio.cargarOptionMovil();
      }
      
      public boolean validarUsuario(String usuario, String password) throws Exception{
          if(Usuario_DAO.validar(usuario, password)!=-1)
              return true;
          return false;
      }
      
      public String getDatosUsuario(String usuario) throws Exception{
         Persona_DTO miUser = Persona_DAO.getPersona(usuario);
         String msj="<h1 stye='align-text:center;'>Datos de Cliente</h1><br>";
         msj+="<dl>";
         msj+="<dt style='background-color: #ddd;'><Strong>Nombre</Strong></dt><dd>"+miUser.getNombre()+" "+miUser.getApellido()+"</dd><br>";
         msj+="<dt style='background-color: #ddd;'><Strong>Cedula</Strong></dt><dd>"+miUser.getDocumento()+"</dd><br>";
         msj+="<dt style='background-color: #ddd;'><Strong>Correo</Strong></dt><dd>"+miUser.getCorreo()+"</dd><br>";
         msj+="<dt style='background-color: #ddd;'><Strong>Telefono</Strong></dt><dd>"+miUser.getTelefono()+"</dd><br>";
         msj+="<dt style='background-color: #ddd;'><Strong>Fecha Nacimiento</Strong></dt><dd>"+miUser.getFechaNacimiento()+"</dd><br>";
         msj+="<dt style='background-color: #ddd;'><Strong>Usuario Desde </Strong></dt><dd>"+miUser.getFechaInscripcion()+"</dd><br>";
         return msj+="</dl>";
      }
      
      public String getReservasMovil(String usuario){
          ArrayList<ReservaSalon_DTO> reservas= Reserva_Salon_negocio.getReservasByID(usuario);
          String msj="";
          if(reservas.isEmpty()) msj+="No tienes ninguna Reserva.";
          else{
              for(ReservaSalon_DTO myReserva: reservas){
                   msj+="<Strong style='text-align:center;'>Reserva: "+myReserva.getId()+"</Strong><br>";
                   msj+="Fecha: "+myReserva.getFechareserva()+"<br>";
                   msj+="Salon :"+myReserva.getSalon().getNombre()+"<br>";
                   msj+="<hr><br>";
              }
             
          }
          
          return msj;
      }
      
      public String getReservasHabitaciones(String usuario){
          ArrayList<ReservaHabitacion_DTO> reservas= Reserva_Habitacion_negocio.getReservasByID(usuario);
          String msj="";
          if(reservas.isEmpty()) msj+="No tienes ninguna Reserva.";
          else{
              for(ReservaHabitacion_DTO myReserva: reservas){
                   msj+="<Strong style='text-align:center;'>Reserva: "+myReserva.getId()+"</Strong><br>";
                   msj+="Fecha: "+myReserva.getFechareserva()+"<br>";
                   msj+="Habitacion :"+myReserva.getHabitacion().getNumero()+"<br>";
                   msj+="<hr><br>";
              }
             
          }
          
          return msj;
      }
      
      
}
