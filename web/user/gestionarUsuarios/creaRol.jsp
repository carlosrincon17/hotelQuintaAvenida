<%-- 
    Document   : creaRol
    Created on : 30-jul-2012, 6:30:01
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
        
        String nombre = request.getParameter("nombre");
        String[] privilegios = request.getParameterValues("privilegio");
        String descripcion = request.getParameter("descripcion");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <title>Hotel Quinta Avenida</title>
      <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <div id ="todo">
            <div class="cabecera">
                
            </div>
            <div class="principal"> 
                <div class="menu" id="menu">
        
                </div>
                <div class="contenido">
                    <div class="bloqueA">
                        <div class="separador">Información</div>
                        <p><%= fachada.crearRol(privilegios, nombre, descripcion)%></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
