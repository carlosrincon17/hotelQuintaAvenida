<%-- 
    Document   : editar_habitacion
    Created on : 31-jul-2012, 22:49:05
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
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
        <script type="text/javascript" src="../../js/ajax.js" ></script>
        <title>Consultar Habitaciones - Hotel Quinta Avenida</title>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        
<%
        String habitacion = request.getParameter("habitacion");
        String tipo = request.getParameter("tipo");
        String msg = fachada.editarHabitacion(habitacion,tipo);
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
                    <div class="separador">Lista de Habitaciones</div>
                        <p><%=fachada.getListaHabitaciones()%></p>
                </div>
                <div class="bloqueB" id="bloqueB">
                    <div class="separador"><p>Información</p></div>
                        <p><%= msg %></p>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>
