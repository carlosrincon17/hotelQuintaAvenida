/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.Usuario_DAO;
import dto.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import util.BaseDeDatos;


// ola k as? probando git o que ase?  slfkjasfñlksjfñaslkfjas
// masteer marteeessss
// retroceder nunca, rendirse jamas ... version git !!

/**
 *
 * @author Jorge
 */
public class Hotel_facade {

    
    //atributos
    
    //constructores
    public Hotel_facade() {
        if(!BaseDeDatos.hayConexion()) BaseDeDatos.conectar();
    }
    
    //metodos getter setter
    
    
    //logica del negocio
    
    /*
     * verifica si el usuario existe 
     * 
     * retorna un int que corresponde con el rol
     * del usuario para cargar su interfaz
     * si el usuario no existe retorna -1
     */    
    public int validarUsuario(String id, String pass){
        return Usuario_DAO.validar(id, pass);
    }
    
    /**
     * 
     * TRABAJO DEL DIA DOMINGO 29 DE JULIO DE 2012
     * 
     */
    
    
    public String getMenuRol(String rol){
    
        
        ArrayList<Privilegio_DTO> menu = new Rol_negocio(Integer.parseInt(rol)).getPrivilegios();
        
        String html = "<ul>";
        
        for(Privilegio_DTO nuevo : menu){
        
            html+= "<li><a href='"+nuevo.getEnlace()+"' >"+nuevo.getNombre()+"</a></li>";
        }
        
        html+="</ul>";
        
        return html;
    
    }
    /**
    public String getMenuRolXModulos(String rol){
    
        ArrayList<Modulo_DTO> modulos = Modulo_negocio.getMenuRolXModulos(Integer.parseInt(rol));
        String msj = "<ul>";
        
        for(Modulo_DTO modulo: modulos){
            if(!modulo.getComportamientos().isEmpty())
            msj+="<li style='background-color: yellow; font-weight: bold'>"+modulo.getNombre().toUpperCase()+"</li>";
            for(Privilegio_DTO  priv : modulo.getComportamientos()){
                msj+= "<li><a href='"+priv.getEnlace()+"' >"+priv.getNombre()+"</a></li>";
            }
        }
        msj+="</ul>";
        
        return msj;
    }*/
    
    
    public String getMenuRolXModulos(String rol){
    
        ArrayList<Modulo_DTO> modulos = Modulo_negocio.getMenuRolXModulos(Integer.parseInt(rol));
        String msj = "";
        int i = 0;
        for(Modulo_DTO modulo: modulos){
        
            if(!modulo.getComportamientos().isEmpty()){
            msj+="item-"+i+",javascript:;,"+modulo.getNombre()+",_self*";
            i++;}
        }
        
        i = 0;
        for(Modulo_DTO modulo: modulos){
            if(!modulo.getComportamientos().isEmpty()){
            for(Privilegio_DTO  priv : modulo.getComportamientos()){
            msj+="subitem-"+i+","+priv.getEnlace()+","+priv.getNombre()+",_self#";
            i++;
            }
            i=0;
            msj+="&";
            }
        }
        
        return msj;
    }

    public String crearRol(String[] privilegios, String nombre, String descripcion){
    
        boolean ok = Rol_negocio.crearRol(nombre,privilegios,descripcion);
        String msj = "No se pudo añadir el rol";
        if(ok) msj = "Rol añadido Satisfactoriamente";
        return msj;
    }
    
    /**
     * 
     * Metodo que permite Cargar todos los comportamientos del sistema y
     * convertirlos a formato HTML para visualizarlos en checkbox en pantalla
     * 
     * @return El String msj formateado en HTML con todos los componentes del sistema 
     */
    public String cargarComportamientos(){
    
        String msj="<br>";
        
        ArrayList<Privilegio_DTO> comportamientos = Privilegio_negocio.readAll();
        for(Privilegio_DTO p: comportamientos ){
        
            msj+="<label><input type='checkbox' name='privilegio' value='"+p.getId()+
                    "' />"+p.getNombre()+"</label>";
        }
        msj+="<br><br>";
        return msj;
    }
    
    /**
     * 
     * TRABAJO DEL DIA 30 DE JULIO DE 2012
     * 
     */
    
    public String cargarComportamientosRol(String nombre){
    
    Rol_DTO nuevo = new Rol_negocio(nombre).getDatos();
    String msj="<div class='separador'>Detalles del rol</div>";
    msj+="<br><form name='editarRol' action='actualizarRol.jsp'>"
            + "<table class='formulario'>"
            + "<tr>"
            + "<td><p>Nombre: </p></td>"
            + "<td><input type='text' name='nombre' value='"+nombre+"' /></td>"
            + "</tr><tr>"
            + "<td><p>Descripcion: </p></td>"
            + "<td><input type='text' name='descripcion' value='"+nuevo.getDescripcion()+"' /></td>"
            + "</tr>"
            + "</table>";
    
    msj+="<div class='separador'>Privilegios del rol</div><br />";
    ArrayList<Privilegio_DTO> comportamientos = new Privilegio_negocio().readAll();
    ArrayList<Privilegio_DTO> privilegiosRol = new Rol_negocio(nombre).getPrivilegios();
    for(Privilegio_DTO p: comportamientos){
        
        if(esPrivilegioDeRol(p, privilegiosRol))
            msj+="<label><input type='checkbox' name='privilegio' value='"+p.getId()+"' checked='checked' />";
        else
            msj+="<label><input type='checkbox' name='privilegio' value='"+p.getId()+"' />";
        
        msj+=p.getNombre()+"</label>";
        }
        msj+="<br><br><br><br><br><br><br><input type='submit' value='Guardar Cambios' />"
                + "</form>";
    
        return msj;
    }
    
    /**
     * Metodo que permite saber si un Rol tiene un privilegio dado
     */
    private boolean esPrivilegioDeRol(Privilegio_DTO p, ArrayList<Privilegio_DTO> privilegios){
    
    for(Privilegio_DTO nuevo:privilegios){
        if(nuevo.equals(p))
            return true;
        }
    return false;
    }
    
    public String getRoles(){
    
    String msj ="<select name='misroles' size='5' id='rol'>";
    ArrayList<Rol_DTO> roles = Rol_negocio.readAll();
    for(Rol_DTO rol: roles){
    
        msj+="<option>"+rol.getNombre()+"</option>";
    
    }
    
    msj+="</select>";
    return msj;
    }
    
    /**
     * 
     * MI TRABAJO DEL DIA 31 DE JULIO DE 2012
     */
    
    /**
     * Metodo que permite actualizar un Rol del sistema 
     * @param privilegios Los nuevos privilegios del rol
     * @param nombre El nuevo Nombre del Rol
     * @param descripcion La nueva descripcion del rol
     * @return Un mensaje con el resultado de la operacion
     */
    public String actualizarRol(String [] privilegios, String nombre, String descripcion){
        boolean ok = Rol_negocio.actualizarRol(nombre, privilegios, descripcion);
        String msj = "No se pudo Actualizar el rol";
        if(ok) msj = "Rol Actualizado Satisfactoriamente";
        return msj;
    
    }
    
    
   /**
    * 
    * @param piso
    * @param hab
    * @param tipo
    * 
    * llama al metodo crear de la clase habitacion_negocio
    * 
    * @return true si se crea la habitacion
    */ 
    public boolean crear_habitacion(String piso,String hab, String tipo){
        return Habitacion_negocio.crear((piso+hab),tipo);
    }
    
    
    /**
     * Llama al metodo getListaHabitaciones de la clase habitacion_negocio
     * @return String con la lista de datos de las habitaciones 
     */
    public String getListaHabitaciones(){
        ArrayList<Habitacion_DTO> lista = Habitacion_negocio.listar();
        String msj= "";
        
        msj+="<table>";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>Habitacion</th>";
                    msj+="<th>Tipo</th>";
                    msj+="<th>Precio</th>";
                    msj+="<th>Estado</th>";
                    msj+="<th>Opciones</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(Habitacion_DTO x: lista){
            msj+="<tr>";
                    msj+="<td>"+x.getNumero()+"</td>";
                    msj+="<td>"+x.getTipo()+"</td>";
                    msj+="<td>"+x.getPrecio()+"</td>";
                    msj+="<td>"+Habitacion_negocio.getEstado(x.getNumero())+"</td>";
                    msj+="<td><a href='#' onclick='cambiarHabitacion(this)' name='form_editar_habitacion.jsp?habitacion="+x.getNumero()+"&tipo="+x.getTipo()+"&estado="+x.getEstado()+"' title='Cambiar Tipo'><img src='../../imagen/change.png' alt='Cambiar Tipo'></a>"
                    +"&nbsp;&nbsp;&nbsp;<a href='#' onclick='cambiarHabitacion(this)' name='form_cambiar_estado_habitacion.jsp?habitacion="+x.getNumero()+"' title='Cambiar Estado'><img src='../../imagen/edit.png' alt='Cambiar Estado'></a></td>";
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br>";
        return msj;
    }
    
    
    /**
     * 
     * @param habitacion
     * @return String con los tipos de habitacion del hotel en formato html <option>
     * para ser mostrados en una lista desplegable, la habitacion pasada como parametro 
     * aparecera como seleccion por defecto al desplegarse la lista
     */
    public String getTipoHabitacionListaHTML(String habitacion){
        ArrayList<String> l = Habitacion_negocio.getListaTipos();
        String tipo = Habitacion_negocio.getTipo(habitacion);
        String msj="";
        for(String dato: l){
            if(dato.equals(tipo))
                msj+="<option selected>"+dato+"</option>";
            else
                msj+="<option>"+dato+"</option>";
        }
        
        return msj;
    }
    
    public String getEstadoHabitacionListaHTML(String habitacion){
        String msj="";
        ArrayList<String> l = Habitacion_negocio.getListaEstados();
        String estado = Habitacion_negocio.getEstado(habitacion);
        
        for(String dato: l){
            if(dato.equals(estado))
                msj+="<option selected>"+dato+"</option>";
            else
                msj+="<option>"+dato+"</option>";
        }
        
        
        return msj;
    }
    
    public String editarHabitacion(String hab,String tipo){
        if(Habitacion_negocio.editar(hab,tipo))
            return "Informacion actualizada";
        else
            return "no se puede realizar la actualizacion";
    }
    
    public String cambiarEstadoHabitacion(String hab, String estado){
        if(Habitacion_negocio.cambiarEstado(hab,estado))
            return "El estado de la habitacion se ha actualizado";
        else
            return "No se pudo actualizar el estado de la habitacion";
    }
    
    public String registrarArticulo(String nombre, String precio,String cantidad){
        if(Articulo_negocio.registrar(nombre,precio,cantidad))
            return "Articulo registrado";
        else 
            return "no se pudo registrar el artículo";
    }
    
    public String getListaArticulos(){
        ArrayList<Articulo_DTO> lista = Articulo_negocio.listar();
        String msj= "";
        
        msj+="<table id='example' class='display'>";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>Nombre</th>";
                    msj+="<th>Precio</th>";
                    msj+="<th>Cantidad</th>";
                    msj+="<th>Opciones</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(Articulo_DTO x: lista){
            msj+="<tr>";
                    msj+="<td>"+x.getNombre()+"</td>";
                    msj+="<td>"+x.getPrecio()+"</td>";
                    msj+="<td>"+x.getCantidad()+"</td>";
                    msj+="<td><a onclick='cambiarHabitacion(this)'title='Agregar cantidad' href='#' name='form_agregar_articulo.jsp?articulo="+x.getId()+"&nombre="+x.getNombre()+"' ><img src='../../imagen/add.png' alt='Agregar Cantidad' /></a></td>";
                   
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br><br>";
        
        return msj;
    }
    
    
    /**
     * trabajo del 02 de agosto
     * Jorge
     * 
     */
    
    /**
     * 
     * @param idArticulo
     * @param cantidad
     * @return mensaje que indica si se pudo actualizar la cantidad en bodega
     * de un determinado articulo
     */
    public String agregarCantidadArticulo(String idArticulo,int cantidad){
        
        if(Articulo_negocio.agregarCantidad(idArticulo,cantidad))
            return "Agregado correctamente";
        else
            return "No se pudo agregar";
        
    }
    
    /**
     * 
     * @param id
     * @param marca
     * @param modelo
     * @return un mensaje que indica si se pudo o no realizar el registro
     */
    public String registrarMinibar(String id, String marca,String modelo){
        if(Minibar_negocio.registrar(id,marca,modelo))
            return "Minibar Registrado";
        else
            return "No se pudo efectuar el registro";
    }
    
    /**
     * 
     * @return una tabla listando los minibares registrados en el sistema
     * con la opcion de agregar articulos a cada minibar
     */
    public String getListaMinibares(){
        ArrayList<Minibar_DTO> lista = Minibar_negocio.listar();
        String msj="";
        msj+="<table>";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>No. de serie</th>";
                    msj+="<th>Marca</th>";
                    msj+="<th>Modelo</th>";
                    msj+="<th>Opciones</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(Minibar_DTO x: lista){
            msj+="<tr>";
                    msj+="<td>"+x.getId()+"</td>";
                    msj+="<td>"+x.getMarca()+"</td>";
                    msj+="<td>"+x.getModelo()+"</td>";
                    msj+="<td><a title='Agregar artículo' href='form_agregar_articulo_minibar.jsp?minibar="+x.getId()+"' ><img src='../../imagen/add.png' alt='agregar Articulos' /></a>&nbsp;&nbsp;&nbsp;"
                            + "<a title='listar articulos del minibar' href='form_listar_articulo_minibar.jsp?id_minibar="+x.getId()+"' ><img src='../../imagen/explore.png' alt='agregar Articulos' /></a></td>";
                   
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br><br>";
        return msj;
    }
    
    
    /**
     * 
     * @return Lista en formato <option> de html con los nombres de los productos
     * disponibles que se pueden añadir al minibar
     */
    public String getArticuloListaHTML(){
        String msj="";
        ArrayList<Articulo_DTO> lista = Articulo_negocio.listar();
        for(Articulo_DTO x: lista)
            if(x.getCantidad()>0) //si no hay existencias del producto no lo añade
                msj+="<option value="+x.getId()+">"+x.getNombre()+"</option>";       
        return msj;
    }
    
    /**
     * 
     * @param idMinibar
     * @param idArticulo
     * @param cantidad
     * @return mensaje que indica si se pudo añadir el articulo al minibar en la cantidad indicada
     */
    public String agregarArticuloMinibar(String idMinibar,String idArticulo,int cantidad){
        
        
        if(Minibar_negocio.agregarArticulo(idMinibar,idArticulo,cantidad))
            return "Articulo Agregado Correctamente";
        else 
            return "No se pudo agregar";
    }
    
    public String registrarServicio(String nombre, String precio){
        if(Servicio_negocio.registrar(nombre,Float.parseFloat(precio)))
            return "Registro Existoso";
        
        return "No se pudo registrar";
    }
    
    public String getListaServicios(){
        ArrayList<Servicio_DTO> lista = Servicio_negocio.listar();
        String msj="";
        msj+="<table id='example' class='display'>";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>Servicio</th>";
                    msj+="<th>Tarifa</th>";
                    msj+="<th>Opciones</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(Servicio_DTO x: lista){
            msj+="<tr>";
                    msj+="<td>"+x.getTipo()+"</td>";
                    msj+="<td>"+x.getPrecio()+"</td>";
                    msj+="<td><a href='#' onclick='cambiarHabitacion(this)' name='form_editar_servicio.jsp?tipo="+x.getTipo()+"&precio="+x.getPrecio()+"'><img src='../../imagen/edit.png' title='Modificar Servicio' /></a></td>";
                   
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br>";
        return msj;
    }
    
    public String crearSalon(int capacidad, float precio, String nombre, String estado){
        
        if (Salon_negocio.registrar(nombre,precio,capacidad,estado)) return "Salon Registrado Exitosamente";  
 
        return "Error en el registro del Salon";
    }
    
    public String getListaHabitacionesOption(){
       ArrayList<Habitacion_DTO>  lista= Habitacion_negocio.listar();
       String msj="";
       msj+="<select name='habitacion'>";
       for(Habitacion_DTO habitacion :lista){
           msj+="<option value='"+habitacion.getNumero()+"'>"+habitacion.getNumero()+"</option>";
       }
       return msj+="</select>";
       
    }
    
    public String guardarReservaHabitacion(String idHabitacion, String fechaReserva, Date fechaActual, 
              String idCliente, String descripcion, String idEmpleado){
       
        return Reserva_Habitacion_negocio.insertReserva(idHabitacion, fechaReserva, fechaActual, idCliente, descripcion, idEmpleado);     
    }
    
    public String getReservaByFecha(String fecha){
        
        ArrayList<ReservaHabitacion_DTO> reservas= Reserva_Habitacion_negocio.getReservasByFecha(fecha);
        if(reservas.isEmpty()) return "No existen Reservas para esta fecha";
        String msj="";
        for(ReservaHabitacion_DTO reserva:reservas){
            msj+=imprimirReservaHabitacion(reserva);
        }
        return msj;
    }
    
    public String getReservasHabitacionByID(String cedula){
        
        
        ArrayList<ReservaHabitacion_DTO> reservas= Reserva_Habitacion_negocio.getReservasByID(cedula);
        if(reservas.isEmpty()) return "No Existen Reservas para este cliente";
        String msj="";
        for(ReservaHabitacion_DTO reserva:reservas){
            msj+=imprimirReservaHabitacion(reserva);
        }
        return msj;
        
        
    }
    
    private String imprimirReservaHabitacion(ReservaHabitacion_DTO reserva){
        String msj="";
        msj+="<table>";
        msj+="<thead>Reserva: "+reserva.getId()+"</thead>"+
              "<tr><td>Cliente: </td><td>"+reserva.getCliente().getNombre()+" "+reserva.getCliente().getApellido()+"</td></tr>"+   
              "<tr><td>Cedula: </td><td>"+reserva.getCliente().getDocumento()+"</td></tr>"+  
              "<tr><td>Fecha Reserva: </td><td>"+reserva.getFechareserva().toGMTString()+"</td></tr>"+
              "<tr><td>Habitacion Reservada: </td><td>"+reserva.getHabitacion().getNumero()+"</td></tr>"+
              "<tr><td></td><td><a href='cancelarReserva.jsp?reserva="+
                    reserva.getId()+"' title='ver reservas' name=''> <img src='../../imagen/cancel.png' title='Cancelar Reserva'/></a></td></tr>"+
              "<tr><td></td><td><a href='../gestionarHospedajes/guardarHospedaje.jsp?habitacion="+
                    reserva.getHabitacion().getNumero()+"&cliente="+reserva.getCliente().getDocumento()+"' title='ver reservas' name=''>"+
                " <img src='../../imagen/enable.gif' title='Confirmar Reserva - Hospedar'/></a></td></tr>";      
        msj+="</table>";
        msj+="<br>";
        return msj;        
    }
    
    public String cancelarReserva(String idReserva){
        return Reserva_negocio.cancelarReserva(idReserva);
    }
    
    public String guardarReserva(String salon, String fechaReserva, Date fechaActual,
            String idEmpleado, String idCliente, int abono, String descripcion, int duracion, int hora){
     
     
                    return Reserva_Salon_negocio.insertReserva(salon, fechaReserva, fechaActual, idEmpleado, idCliente, abono, descripcion, duracion, hora);
     }
    
    public String listaSalonesHTML(){
        ArrayList<Salon_DTO> salones= Salon_negocio.cargarSalones();
        String msj="<table id='ejemplo' class='ejemplo'><tr><thead><th>Nombre del Salon</th><th>Capacidad</th><th>Precio por hora</th><th>Estado</th><th>Opciones</th></thead></tr><tbody>";
        for (Iterator<Salon_DTO> it = salones.iterator(); it.hasNext();) {
            Salon_DTO salon = it.next();
            msj+="<tr><td>"+salon.getNombre()+"</td><td>"+salon.getCapacidad()+"</td><td>"+
                    salon.getPrecioHora()+"</td><td>"+
                    salon.getEstado()+"</td>"+
                    
                    "<td><a href='#' title='ver reservas' name='editarSalon.jsp?nombre="+
                    salon.getNombre()+"' onclick=verReservas(this)><img src='../../imagen/edit.png' title='Editar Salon'/></a>"+
                     "<a href='#' title='ver reservas' name='verReservas.jsp?nombre="+salon.getNombre()+
                    "' onclick=verReservas(this)><img src='../../imagen/explore.png'/ title='Ver Reservas'>  </a></td></tr>";              
        }
        msj+="</tbody></table>";
     
        return msj;
    }
    
    public String editarSalon(String nombre, float precio, int capacidad, String estado){
        return Salon_negocio.editar(nombre,precio,capacidad,estado);
    }
    public String editarSalonHTML(String nombre){
        String msj="";
        Salon_DTO salon= Salon_negocio.cargarSalon(nombre);
        msj+="<form  action='editarSalon_1.jsp' name='form'>"+
                "<p>Nombre <input type='text' name='nombre' value='"+salon.getNombre()+"'/></p>"+
                "<p>Precio por Hora<input type='text' name='precio' value='"+salon.getPrecioHora()+"'/></p>"+
                "<p>Capacidad <input type='text' name='capacidad' value='"+salon.getCapacidad()+"'/></p>"+
                "<p>Estado <select name='estado'>"+
                    "<option>Habilitado</option>"+
                    "<option>Deshabilitado</option>"+
                "</select></p>"+
                
                "<p><input type='submit' value='Guardar' onclick=verReservas(this) /></p>"+       
               "</form>";
        return msj;
    }
    
    public String getFuncionListaHTML(){
        return Empleado_negocio.getFuncionListaHTML();
    }
    
    public String getFuncionListaHTML(String funcion){
        
        ArrayList <String[]> funciones = Empleado_negocio.getArrayFunciones();
        String msj = "";
        for(String[] m: funciones){
            
            if(m[1].equals(funcion))
            msj+="<option selected value='"+m[0]+"'>"+m[1]+"</option>";
            else
            msj+="<option value='"+m[0]+"'>"+m[1]+"</option>";
        }
        return msj;
    }
    
    public String registrarEmpleado(String nombre,String apellido,String cedula, String fecha_nto,String numero_ss,String direccion,String telefono,String correo,String funcion){
        if (Empleado_negocio.registrar(nombre,apellido,cedula, fecha_nto ,numero_ss,direccion,telefono,correo,funcion))
            return "Se pudo registrar correctamente";
        
        return "no se pudo registrar";
        
    }
    /**
     * Metodo que Obtiene todos los empleados del sistema
     * @return ArrayList<Empleado_DTO> con todos los empleados
     */
    public String getListaEmpleados(){
        ArrayList<Empleado_DTO> lista = Empleado_negocio.listar();
        String msj="";
        msj+="<table cellspacing='0' id='example' class='display'>";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>Nombre</th>";
                    msj+="<th>Apellidos</th>";
                    msj+="<th>Funcion</th>";
                    msj+="<th>Telefono</th>";
                    msj+="<th>Correo</th>";
                    msj+="<th>Estado</th>";
                    msj+="<th>Opciones</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(Empleado_DTO x: lista){
            msj+="<tr class='gradeA'>";
                    msj+="<td>"+x.getNombre()+"</td>";
                    msj+="<td>"+x.getApellido()+"</td>";
                    msj+="<td>"+x.getFuncion()+"</td>";
                    msj+="<td>"+x.getTelefono()+"</td>";
                    msj+="<td>"+x.getCorreo()+"</td>";
                    if(x.getEstado())
                    msj+="<td>Activo</td>";
                    else
                    msj+="<td>Inactivo</td>";
                    msj+="<td><a href='form_editar_empleado.jsp?cedula="+x.getDocumento()+"&nombre="+x.getNombre()+"&apellidos="+x.getApellido()
                            + "&funcion="+x.getFuncion()+"&telefono="+x.getTelefono()+"&correo="+x.getCorreo()+"&direccion="+x.getDireccion()+"&seguro="+x.getNumeroSS()
                            + "' title='Editar Datos'><img src='../../imagen/edit.png' alt='Editar Datos' /></a>&nbsp;&nbsp;&nbsp;";
                            if(x.getEstado())
                            msj+= "<a title='Deshabilitar Empleado' href='#' onclick='cambiarEstado(this)' name='cambiarEstado.jsp?cedula="+x.getDocumento()+"&estado="+x.getEstado()+"' ><img src='../../imagen/disable.png' alt='Editar Datos' /></a></td>";
                            else
                            msj+= "<a title='Habilitar Empleado' href='#' onclick='cambiarEstado(this)' name='cambiarEstado.jsp?cedula="+x.getDocumento()+"&estado="+x.getEstado()+"' ><img src='../../imagen/enable.gif' alt='Editar Datos' /></a></td>";
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br><br>";
        return msj;
    }
    public String habilitarEmpleado(String cedula){
        if(Empleado_negocio.habilitar(cedula))
            return "Se ha habilitado el usuario satisfactoriamente";
        return "Hubo un error en la operación";
    }
    
    
    public String deshabilitarEmpleado(String cedula){
        if(Empleado_negocio.deshabilitar(cedula))
            return " Empleado deshabilitado";
        
        return "no se pudo efectuar la operacion";
                
    }
    
    public String crearCliente(String cedula, String nombre, String apellido, String correo, String direccion, String telefono, String fechaNto, String empresa){
     
        boolean ok = Cliente_negocio.crearCliente(cedula, nombre, apellido, correo, direccion, telefono, fechaNto, empresa);
        String msj = "No se pudo Crear el Cliente";
        if(ok) msj = "Nuevo cliente creado Satisfactoriamente";
        return msj;
    }
    
    public String editarCliente(String cedula, String correo, String direccion, String telefono, String fechaNto, String empresa){
    
        boolean ok = Cliente_negocio.editarCliente(cedula, correo, direccion, telefono, fechaNto, empresa);
        String msj = "No se pudo Editar el Cliente";
        if(ok) msj = "Datos Actualizados Satisfactoriamente";
        return msj;
    }
    
    public String getClientes(){
        
        ArrayList<Cliente_DTO> lista = Cliente_negocio.getAll();
        String msj="";
        msj+="<table >";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>Cédula</th>";
                    msj+="<th>Nombres</th>";
                    msj+="<th>Apellidos</th>";
                    msj+="<th>e-mail</th>";
                    msj+="<th>Telefono</th>";
                    msj+="<th>Dirección</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(Cliente_DTO x: lista){
            msj+="<tr>";
                    msj+="<td>"+x.getDocumento()+"</td>";
                    msj+="<td>"+x.getNombre()+"</td>";
                    msj+="<td>"+x.getApellido()+"</td>";
                    msj+="<td>"+x.getCorreo()+"</td>";
                    msj+="<td>"+x.getTelefono()+"</td>";
                    msj+="<td>"+x.getDireccion()+"</td>";
                    msj+="<td><a href=''>Modificar Datos</a></td>";
                    msj+="<td><a href=''>Deshabilitar</a></td>";
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br><br>";
        return msj;
    }
    
    public String editarServicio(String nombre, float cantidad){
    
        boolean ok = Servicio_negocio.editar(nombre, cantidad);
        String msj = "No se pudo Editar el Servicio";
        if(ok) msj = "Datos Actualizados Satisfactoriamente";
        return msj;
    }
    
    public String editarServicio(String nombreNuevo, String anterior, float cantidad){
    
        boolean ok = Servicio_negocio.editar(nombreNuevo, anterior, cantidad);
        String msj = "No se pudo Editar el Servicio";
        if(ok) msj = "Datos Actualizados Satisfactoriamente";
        return msj;
    }
    
    public String getArticulosMinibar(String id_minibar){
        String msj="";
        ArrayList<ArticuloMinibar_DTO> lista = Minibar_negocio.getArticulos(id_minibar);
        
        msj+="<table >";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>Articulo</th>";
                    msj+="<th>Precio Unidad</th>";
                    msj+="<th>Cantidad</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(ArticuloMinibar_DTO x: lista){
            msj+="<tr>";
                    msj+="<td>"+x.getArticulo().getNombre()+"</td>";
                    msj+="<td>"+x.getArticulo().getPrecio()+"</td>";
                    msj+="<td>"+x.getCantidad()+"</td>";
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br><br>";
        return msj;
    }
    
    public String editarEmpleado(String cedula, String funcion, String telefono, String correo, String direccion, String seguro){
    
        boolean ok = Empleado_negocio.editarEmpleado(cedula,funcion,telefono,correo,direccion,seguro);
        String msj = "No se pudo Actualizar los datos del empleado";
        if(ok) msj = "Información actualizada exitosamente";
        return msj;
        }
    
    public String cargarListaSalones(){
        ArrayList<Salon_DTO> salones= Salon_negocio.cargarSalones();
        String msj="<select name='salon'>";
        for(Salon_DTO salon:salones){
            msj+="<option value='"+salon.getNombre()+"'>"+salon.getNombre()+"</option>";
        }
        return msj+="</select></p>";        
    }
    
    
    public String getListaClientes(){
        ArrayList<Cliente_DTO> lista = Cliente_negocio.getAll();
        String msj="";
        msj+="<table >";
            msj+="<thead>";
                msj+="<tr>";
                    msj+="<th>Nombre</th>";
                    msj+="<th>Apellidos</th>";
                    msj+="<th>DNI</th>";
                    msj+="<th>Telefono</th>";
                    msj+="<th>Correo</th>";
                msj+="</tr>";
            msj+="</thead>";
            msj+="<tbody>";
            for(Cliente_DTO x: lista){
            msj+="<tr>";
                    msj+="<td>"+x.getNombre()+"</td>";
                    msj+="<td>"+x.getApellido()+"</td>";
                    msj+="<td>"+x.getDocumento()+"</td>";
                    msj+="<td>"+x.getTelefono()+"</td>";
                    msj+="<td>"+x.getCorreo()+"</td>";
                    msj+="<td><a href=''>Modificar Datos</a></td>";
                    msj+="<td><a href=''>Deshabilitar</a></td>";
                msj+="</tr>";
            }
            msj+="</tbody>";
        msj+="</table><br><br>";
        return msj;
    }
    
    //TRABAJO DE CARLOS
    
    public String getListaHabitacionesDisponibles(){
       ArrayList<Habitacion_DTO>  lista= Habitacion_negocio.listarDisponibles();
       String msj="";
       msj+="<select name='habitacion'>";
       for(Habitacion_DTO habitacion :lista){
           msj+="<option value='"+habitacion.getNumero()+"'>"+habitacion.getNumero()+"</option>";
       }
       return msj+="</select>";
       
    }
    
    public String registrarHospedaje(String id_cliente, String id_habitacion){
        return Hospedaje_negocio.registrar(id_cliente,id_habitacion);
        //BUSCAR HOSPEDAJE NEGOCIO Y HOSPEDAJE DAO
    }
    
    public String registrarHospedaje(String id_cliente, int id_reserva){
        return Hospedaje_negocio.registrar(id_cliente,id_reserva);
    }
    public String listarHospedajesHTML(){
        ArrayList<Hospedaje_DTO> hospedajes= negocio.Hospedaje_negocio.listar();
        String msj="<table>";
        msj+="<tr><thead><th>Hablitacion</th><th>Cliente</th><th>Fecha de Inicio</th><th>Opciones</th> </thead><tbody>";
        for(Hospedaje_DTO hospedaje: hospedajes){
            
            String fecha= (hospedaje.getFechaInicio().getYear()+1900)+"-"+(hospedaje.getFechaInicio().getMonth()+1)+"-"+hospedaje.getFechaInicio().getDate();
            msj+="<tr>"+
            "<td>" + hospedaje.getHabitacion().getNumero() + "</td>"+
            "<td>" + hospedaje.getHuesped().getDocumento() + "</td>"+
            "<td>" + fecha + "</td>"+
            "<td><a href='#' title='ver reservas' name='terminarHospedaje.jsp?hospedaje="+hospedaje.getID()+""+
            "&habitacion="+hospedaje.getHabitacion().getNumero()+"' onclick=verReservas(this)><img src='../../imagen/edit.png' title='Editar Salon'/></a>"+
             "</td></tr>";
        }
        return msj+="</tbody></table>";
    }
    public String terminarHospedaje(int hospedaje, int habitacion){
    
    String x=Hospedaje_negocio.terminarHospedaje(hospedaje, habitacion);    
    System.out.println(x);
    return x;
    }
    
    public String listarReservasSalonesHTML(String nombreSalon){
        ArrayList<ReservaSalon_DTO> reservas= Reserva_Salon_negocio.listarReservas(nombreSalon);
        String msj="<b>Salon: "+nombreSalon+ "</b>";
        for(ReservaSalon_DTO reserva: reservas)
            msj+= this.imprimirReservaSalon(reserva);
        
        return msj;
    }
    
    private String imprimirReservaSalon(ReservaSalon_DTO reserva){
        String msj="";
        msj+="<table>";
        msj+="<thead>Reserva: "+reserva.getId()+"</thead>"+
              "<tr><td>Cliente: </td><td>"+reserva.getCliente().getNombre()+" "+reserva.getCliente().getApellido()+"</td></tr>"+   
              "<tr><td>Cedula: </td><td>"+reserva.getCliente().getDocumento()+"</td></tr>"+  
              "<tr><td>Fecha Reserva: </td><td>"+reserva.getFechareserva().toGMTString()+"</td></tr>"+
              "<tr><td>Hora de Inicio: </td><td>"+reserva.getHora()+"</td></tr>"+
              "<tr><td>Duracion del Evento: </td><td>"+reserva.getDuracion()+"</td></tr>"+ 
              "<tr><td>Descripcion: </td><td>"+reserva.getDescripcion()+"</td></tr>"+
              "<tr><td>Total: </td><td>"+reserva.getTotal()+"</td></tr>"+
              "<tr><td>Abono: </td><td>"+reserva.getAbonoReserva()+"</td></tr>"+
              "<tr><td>Deuda: </td><td>"+(reserva.getTotal()-reserva.getAbonoReserva())+"</td></tr>"+  
              "<tr><td></td><td><a href='../gestionarReservas/cancelarReserva.jsp?reserva="+
                    reserva.getId()+"' title='ver reservas' name=''><img src='../../imagen/cancel.png' title='Cancelar Reserva'/></a></td></tr>"; 
        msj+="</table><br>";
        return msj;
    }
    
    public String getReservaSalonesByID(String cedula){
        
    ArrayList<ReservaSalon_DTO> reservas= Reserva_Salon_negocio.getReservasByID(cedula);
    if(reservas.isEmpty()) return "No Existen Salones Reservados para este cliente";
        String msj="";
        for(ReservaSalon_DTO reserva:reservas){
            msj+=imprimirReservaSalon(reserva);
        }
        return msj;
    
    }
    
    
    /*Metodos del modulo de estadisticas*/
    
    public int[] getEstadisticasReservaSalonMes(String mes,String agno){
        int[] est = Reserva_Salon_negocio.getEstadisticasMes(mes, agno);
        /*
         * String msj="";
        msj+="<p>Las estadisticas del mes "+mes+" del "+agno+" son:</p>";
        
        msj+="<ul>";
        msj+="<li>Reservas activas: "+est[0];
        msj+="<li>Reservas efectivas: "+est[1];
        msj+="<li>Reservas canceladas: "+est[2];
        msj+="<li>Total reservas realizadas: "+(est[0]+est[1]+est[2]);
        msj+="</ul>";
        * 
        */
        return est;
    }
    
    public int[] getEstadisticasReservaHabitacionMes(String mes,String agno){
        int[] est = Reserva_Habitacion_negocio.getEstadisticasMes(mes, agno);
        String msj="";
        /*
        msj+="<p>Las estadisticas del mes "+mes+" del "+agno+" son:</p>";
        
        msj+="<ul>";
        msj+="<li>Reservas activas: "+est[0];
        msj+="<li>Reservas efectivas: "+est[1];
        msj+="<li>Reservas canceladas: "+est[2];
        msj+="<li>Total reservas realizadas: "+(est[0]+est[1]+est[2]);
        msj+="</ul>";
        * 
        */
        return est;
    }
    
    public int[] getEstadisticasHospedajes3Mes(){
        int[] est = Hospedaje_negocio.getHospedajes3Mes();
        /*
        String msj="";
        msj+="<p>Las estadisticas de los ultimos 3 meses son:</p>";
        msj+="<ul>";
        msj+="<li>Ultimo mes: "+est[0];
        msj+="<li>Mes pasado: "+est[1];
        msj+="<li>Mes anterior: "+est[2];
        msj+="<li>Total Hospedajes realizados: "+(est[0]+est[1]+est[2]);
        msj+="</ul>";
        * 
        */
        return est;
    }
    
}
