<%-- 
    Document   : registrar_cliente
    Created on : 05-ago-2012, 17:15:03
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
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
        <title>JSP Page</title>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <div id="todo">
            <div class="cabecera">
            </div>

        <%
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String fechaNto = request.getParameter("fechaNto");
        String empresa = request.getParameter("empresa");
        %>
            <div class="principal">
                <div class="menu" id="menu">    
                </div>
                <div class="contenido">
                    <div class="bloqueA">
                        <div class="separador">Información</div>
                        <p><%= fachada.crearCliente(cedula, nombre, apellido, correo, direccion, telefono, fechaNto, empresa) %></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
