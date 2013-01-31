<%-- 
    Document   : terminarHospedaje
    Created on : 09-ago-2012, 19:49:28
<%-- 
    Document   : guerdarReservas
    Created on : 05-ago-2012, 15:38:28
    Author     : Carlos
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session='true'%>
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
                
        int hospedaje= Integer.parseInt(request.getParameter("reserva"));
        int habitacion= Integer.parseInt(request.getParameter("habitacion"));
        String msj = (String)sesion.getAttribute("htmlmenu");         
        %>
         <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <div id="todo">  
        <div class="cabecera">
            <h1>Hotel Quinta Avenida</h1>
        </div>
        <div class ="´principal">
            <div class="menu" id="menu">
        
            </div>
            
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador"><p>Informacion</p></div><br>
                    <%=fachada.terminarHospedaje(hospedaje, habitacion)%>
                </div>
            </div>
        </div>
       </div>
    
    </body>
</html>


