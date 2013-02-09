<%-- 
    Document   : form_registrar_empleado
    Created on : 05-ago-2012, 17:11:39
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<html>
    <head>
<% 
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        String msj = (String)sesion.getAttribute("htmlmenu");
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <title>Registro de Empleados - Hotel Quinta Avenida</title>
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">  
        <div id="todo">  
        <div class="cabecera">  
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
                
            </div>
            
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Datos del nuevo Empleado</div><br>
                    <form action="registrar_empleado.jsp">
                        <table class="formulario">
                            <tr>
                                <td><p>Nombre:</p></td>
                                <td><input type="text" name="nombre" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Apellidos:</td>
                                <td><input type="text" name="apellido" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Cedula:</p></td>
                                <td><input type="text" name="cedula" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Fecha de Nto. (aaaa-mm-dd):</td>
                                <td><input type="text" name="fecha_nto" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p><p>No. Seguridad Social:</td>
                                <td><input type="text" name="numero_ss" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Direccion:</td>
                                <td><input type="text" name="direccion" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Telefono:</td>
                                <td><input type="text" name="telefono" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Correo:</td>
                                <td><input type="text" name="correo" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Rol:</td>
                                <td><select name="funcion">
                                    <%= fachada.getFuncionListaHTML() %>
                                    </select>
                                </td>
                            </tr>
                            </table>
                                    <p><input type="submit" value="Registrar Empleado" /></p>
                        
                    </form>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>
