<%-- 
    Document   : form_editar_empleado
    Created on : 06-ago-2012, 20:39:07
    Author     : CONNORS
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
        <title>Lista de Empleados - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <script type="text/javascript" src="../js/ajax.js" ></script>
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
<%
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String funcion = request.getParameter("funcion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String seguro = request.getParameter("seguro");  
%>
        <div id="todo">  
        <div class="cabecera">
            <h1>Hotel Quinta Avenida</h1>
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
                
            </div>
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Editar Empleado</div><br>
                        <form name="editaempleado" action="editar_empleado.jsp">
                            <table class="formulario">
                                <tr>
                                    <td><p>Cédula: </p></td>
                                    <td><input type="text" name="cedula" value="<%= cedula %>" readonly  title="Este campo no se puede modificar"/></td>
                                </tr>
                                <tr>
                                    <td><p>Nombres: </p></td>
                                    <td><input type="text" name="nombre" value="<%= nombre %>"  readonly title="Este campo no se puede modificar"/></td>
                                </tr>
                                <tr>
                                    <td><p>Apellidos: </p></td>
                                    <td><input type="text" name="apellidos" value="<%= apellidos %>"  readonly title="Este campo no se puede modificar"/></td>
                                </tr>
                                <tr>
                                    <td><p>Función :</p></td>
                                    <td><select name="funcion">
                                            <%= fachada.getFuncionListaHTML(funcion) %>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td><p>Teléfono: </p></td>
                                    <td><input type="text" name="telefono" value="<%= telefono %>" required /></td>
                                </tr>
                                <tr>
                                    <td><p>Correo: </p></td>
                                    <td><input type="text" name="correo" value="<%= correo %>"  required/></td>
                                </tr>
                                <tr>
                                    <td><p>Dirección: </p></td>
                                    <td><input type="text" name="direccion" value="<%= direccion %>" required /></td>
                                </tr>
                                <tr>
                                    <td><p>ID Seguro: </td>
                                    <td><input type="text" name="seguro" value="<%= seguro %>" required /></td>
                                </tr>
                            </table>
                           <input type="submit" value="Actualizar Datos">
                        </form>
                </div>    
                <div class="bloqueB" id="bloqueB">
                    
                </div>
            </div>
        </div>
       </div>
    </body>
</html>