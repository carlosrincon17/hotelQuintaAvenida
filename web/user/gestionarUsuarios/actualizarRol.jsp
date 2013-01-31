<%-- 
    Document   : actualizarRol
    Created on : 01-ago-2012, 0:00:00
    Author     : CONNORS
--%>

<%@page import="com.sun.xml.internal.bind.v2.model.core.ID"%>
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
        
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String[] privilegios = request.getParameterValues("privilegio");
        
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
      <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        
        <div id="todo">
        <div class="cabecera">
        
        </div>
        

        
        <div class="principal">
            
            <div class="menu" id="menu">
     
            </div>
        </div>
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Información</div>
                    <p><%= fachada.actualizarRol(privilegios, nombre, descripcion) %></p>
                </div>
            </div>
        </div>
    </body>
</html>
