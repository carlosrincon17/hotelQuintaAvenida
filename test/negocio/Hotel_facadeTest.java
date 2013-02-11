/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sadalsuud
 */
public class Hotel_facadeTest {
    
    public Hotel_facadeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidarUsuario() {
        System.out.println("validarUsuario");
        String id = "007";
        String pass = "hotel007";
        Hotel_facade instance = new Hotel_facade();
        int expResult = 1;
        int result = instance.validarUsuario(id, pass);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMenuRol() {
        System.out.println("getMenuRol");
        String rol = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getMenuRol(rol);
        assertEquals(expResult, result);
    }
/*
    @Test
    public void testGetMenuRolXModulos() {
        System.out.println("getMenuRolXModulos");
        String rol = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getMenuRolXModulos(rol);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMenuRolXModulos2() {
        System.out.println("getMenuRolXModulos2");
        String rol = "";
        Hotel_facade instance = new Hotel_facade();
        ArrayList expResult = null;
        ArrayList result = instance.getMenuRolXModulos2(rol);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrearRol() {
        System.out.println("crearRol");
        String[] privilegios = null;
        String nombre = "";
        String descripcion = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.crearRol(privilegios, nombre, descripcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarComportamientos() {
        System.out.println("cargarComportamientos");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.cargarComportamientos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarComportamientosRol() {
        System.out.println("cargarComportamientosRol");
        String nombre = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.cargarComportamientosRol(nombre);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getRoles();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testActualizarRol() {
        System.out.println("actualizarRol");
        String[] privilegios = null;
        String nombre = "";
        String descripcion = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.actualizarRol(privilegios, nombre, descripcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrear_habitacion() {
        System.out.println("crear_habitacion");
        String piso = "";
        String hab = "";
        String tipo = "";
        Hotel_facade instance = new Hotel_facade();
        boolean expResult = false;
        boolean result = instance.crear_habitacion(piso, hab, tipo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaHabitaciones() {
        System.out.println("getListaHabitaciones");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaHabitaciones();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaHabitaciones2() {
        System.out.println("getListaHabitaciones2");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaHabitaciones2();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTipoHabitacionListaHTML() {
        System.out.println("getTipoHabitacionListaHTML");
        String habitacion = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getTipoHabitacionListaHTML(habitacion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEstadoHabitacionListaHTML() {
        System.out.println("getEstadoHabitacionListaHTML");
        String habitacion = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getEstadoHabitacionListaHTML(habitacion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarHabitacion() {
        System.out.println("editarHabitacion");
        String hab = "";
        String tipo = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.editarHabitacion(hab, tipo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCambiarEstadoHabitacion() {
        System.out.println("cambiarEstadoHabitacion");
        String hab = "";
        String estado = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.cambiarEstadoHabitacion(hab, estado);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarArticulo() {
        System.out.println("registrarArticulo");
        String nombre = "";
        String precio = "";
        String cantidad = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.registrarArticulo(nombre, precio, cantidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaArticulos() {
        System.out.println("getListaArticulos");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaArticulos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarCantidadArticulo() {
        System.out.println("agregarCantidadArticulo");
        String idArticulo = "";
        int cantidad = 0;
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.agregarCantidadArticulo(idArticulo, cantidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarMinibar() {
        System.out.println("registrarMinibar");
        String id = "";
        String marca = "";
        String modelo = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.registrarMinibar(id, marca, modelo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaMinibares() {
        System.out.println("getListaMinibares");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaMinibares();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetArticuloListaHTML() {
        System.out.println("getArticuloListaHTML");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getArticuloListaHTML();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarArticuloMinibar() {
        System.out.println("agregarArticuloMinibar");
        String idMinibar = "";
        String idArticulo = "";
        int cantidad = 0;
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.agregarArticuloMinibar(idMinibar, idArticulo, cantidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarServicio() {
        System.out.println("registrarServicio");
        String nombre = "";
        String precio = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.registrarServicio(nombre, precio);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaServicios() {
        System.out.println("getListaServicios");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaServicios();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrearSalon() {
        System.out.println("crearSalon");
        int capacidad = 0;
        float precio = 0.0F;
        String nombre = "";
        String estado = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.crearSalon(capacidad, precio, nombre, estado);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaHabitacionesOption() {
        System.out.println("getListaHabitacionesOption");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaHabitacionesOption();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGuardarReservaHabitacion() {
        System.out.println("guardarReservaHabitacion");
        String idHabitacion = "";
        String fechaReserva = "";
        Date fechaActual = null;
        String idCliente = "";
        String descripcion = "";
        String idEmpleado = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.guardarReservaHabitacion(idHabitacion, fechaReserva, fechaActual, idCliente, descripcion, idEmpleado);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetReservaByFecha() {
        System.out.println("getReservaByFecha");
        String fecha = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getReservaByFecha(fecha);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetReservasHabitacionByID() {
        System.out.println("getReservasHabitacionByID");
        String cedula = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getReservasHabitacionByID(cedula);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCancelarReserva() {
        System.out.println("cancelarReserva");
        String idReserva = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.cancelarReserva(idReserva);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGuardarReserva() {
        System.out.println("guardarReserva");
        String salon = "";
        String fechaReserva = "";
        Date fechaActual = null;
        String idEmpleado = "";
        String idCliente = "";
        int abono = 0;
        String descripcion = "";
        int duracion = 0;
        int hora = 0;
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.guardarReserva(salon, fechaReserva, fechaActual, idEmpleado, idCliente, abono, descripcion, duracion, hora);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListaSalonesHTML() {
        System.out.println("listaSalonesHTML");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.listaSalonesHTML();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarSalon() {
        System.out.println("editarSalon");
        String nombre = "";
        float precio = 0.0F;
        int capacidad = 0;
        String estado = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.editarSalon(nombre, precio, capacidad, estado);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarSalonHTML() {
        System.out.println("editarSalonHTML");
        String nombre = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.editarSalonHTML(nombre);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFuncionListaHTML_0args() {
        System.out.println("getFuncionListaHTML");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getFuncionListaHTML();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFuncionListaHTML_String() {
        System.out.println("getFuncionListaHTML");
        String funcion = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getFuncionListaHTML(funcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarEmpleado() {
        System.out.println("registrarEmpleado");
        String nombre = "";
        String apellido = "";
        String cedula = "";
        String fecha_nto = "";
        String numero_ss = "";
        String direccion = "";
        String telefono = "";
        String correo = "";
        String funcion = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.registrarEmpleado(nombre, apellido, cedula, fecha_nto, numero_ss, direccion, telefono, correo, funcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaEmpleados() {
        System.out.println("getListaEmpleados");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaEmpleados();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaEmpleados2() {
        System.out.println("getListaEmpleados2");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaEmpleados2();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHabilitarEmpleado() {
        System.out.println("habilitarEmpleado");
        String cedula = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.habilitarEmpleado(cedula);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeshabilitarEmpleado() {
        System.out.println("deshabilitarEmpleado");
        String cedula = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.deshabilitarEmpleado(cedula);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrearCliente() {
        System.out.println("crearCliente");
        String cedula = "";
        String nombre = "";
        String apellido = "";
        String correo = "";
        String direccion = "";
        String telefono = "";
        String fechaNto = "";
        String empresa = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.crearCliente(cedula, nombre, apellido, correo, direccion, telefono, fechaNto, empresa);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarCliente() {
        System.out.println("editarCliente");
        String cedula = "";
        String correo = "";
        String direccion = "";
        String telefono = "";
        String fechaNto = "";
        String empresa = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.editarCliente(cedula, correo, direccion, telefono, fechaNto, empresa);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetClientes() {
        System.out.println("getClientes");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getClientes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarServicio_String_float() {
        System.out.println("editarServicio");
        String nombre = "";
        float cantidad = 0.0F;
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.editarServicio(nombre, cantidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarServicio_3args() {
        System.out.println("editarServicio");
        String nombreNuevo = "";
        String anterior = "";
        float cantidad = 0.0F;
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.editarServicio(nombreNuevo, anterior, cantidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetArticulosMinibar() {
        System.out.println("getArticulosMinibar");
        String id_minibar = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getArticulosMinibar(id_minibar);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarEmpleado() {
        System.out.println("editarEmpleado");
        String cedula = "";
        String funcion = "";
        String telefono = "";
        String correo = "";
        String direccion = "";
        String seguro = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.editarEmpleado(cedula, funcion, telefono, correo, direccion, seguro);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarListaSalones() {
        System.out.println("cargarListaSalones");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.cargarListaSalones();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaClientes() {
        System.out.println("getListaClientes");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaClientes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListaHabitacionesDisponibles() {
        System.out.println("getListaHabitacionesDisponibles");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getListaHabitacionesDisponibles();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarHospedaje_String_String() {
        System.out.println("registrarHospedaje");
        String id_cliente = "";
        String id_habitacion = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.registrarHospedaje(id_cliente, id_habitacion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarHospedaje_String_int() {
        System.out.println("registrarHospedaje");
        String id_cliente = "";
        int id_reserva = 0;
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.registrarHospedaje(id_cliente, id_reserva);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarHospedajesHTML() {
        System.out.println("listarHospedajesHTML");
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.listarHospedajesHTML();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTerminarHospedaje() {
        System.out.println("terminarHospedaje");
        int hospedaje = 0;
        int habitacion = 0;
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.terminarHospedaje(hospedaje, habitacion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarReservasSalonesHTML() {
        System.out.println("listarReservasSalonesHTML");
        String nombreSalon = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.listarReservasSalonesHTML(nombreSalon);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetReservaSalonesByID() {
        System.out.println("getReservaSalonesByID");
        String cedula = "";
        Hotel_facade instance = new Hotel_facade();
        String expResult = "";
        String result = instance.getReservaSalonesByID(cedula);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEstadisticasReservaSalonMes() {
        System.out.println("getEstadisticasReservaSalonMes");
        String mes = "";
        String agno = "";
        Hotel_facade instance = new Hotel_facade();
        int[] expResult = null;
        int[] result = instance.getEstadisticasReservaSalonMes(mes, agno);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEstadisticasReservaHabitacionMes() {
        System.out.println("getEstadisticasReservaHabitacionMes");
        String mes = "";
        String agno = "";
        Hotel_facade instance = new Hotel_facade();
        int[] expResult = null;
        int[] result = instance.getEstadisticasReservaHabitacionMes(mes, agno);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEstadisticasHospedajes3Mes() {
        System.out.println("getEstadisticasHospedajes3Mes");
        Hotel_facade instance = new Hotel_facade();
        int[] expResult = null;
        int[] result = instance.getEstadisticasHospedajes3Mes();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
}
