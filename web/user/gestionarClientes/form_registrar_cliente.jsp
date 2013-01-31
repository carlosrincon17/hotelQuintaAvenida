<%-- 
    Document   : registro.jsp
    Created on : 05-ago-2012, 13:50:28
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
        <link rel="stylesheet" href="../../css/login.css" title="estilo"> 
        <script type="text/javascript" src="../../js/menu.js"></script>
        <title>Nuevo Cliente - Hotel Quinta Avenida</title>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <div id="todo">
            <div class="cabecera">
                <h1>Hotel Quinta Avenida</h1>
            </div>
            <div class="principal">
                <div class="menu" id="menu">
                </div>
                <div class="contenido">
                    <div class="bloqueC">
                        <div class="separador">Registro de Nuevo Usuario</div>
                        <form action="registrar_cliente.jsp" name="registro">
                            <table>
                                <br><br>
                            <tr>
                                <td><label>Cédula o NIT: </label></td>
                                <td><input type="text" name="cedula" required></td>
                            </tr>
                            <tr>
                                <td><label>Nombres: </label></td>
                                <td><input type="text" name="nombre"  required></td>
                            </tr>
                            <tr>
                                <td><label>Apellidos: </label></td>
                                <td><input type="text" name="apellido" required></td>
                            </tr>
                            <tr>
                                <td><label>E-mail: </label></td>
                                <td><input type="text" name="correo" required></td>
                            </tr>
                            <tr>
                                <td><label>Dirección: </label></td>
                                <td><input type="text" name="direccion" required></td>
                            </tr>
                            <tr>
                                <td><label>Teléfono: </label></td>
                                <td><input type="text" name="telefono" required></td>
                            </tr>
                            <tr>
                                <td><label>Fecha Nacimiento: (dd-mm-aaaa)</label></td>
                                <td><input type="text" name="fechaNto" required></td>
                            </tr>
                            <tr>
                                <td><label>Nombre Empresa: </label></td>
                                <td><input type="text" name="empresa" required></td>
                            </tr> 
                        </table>
                            <br>
                            <input type="submit" value="Registrar">
                            <br><br>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>