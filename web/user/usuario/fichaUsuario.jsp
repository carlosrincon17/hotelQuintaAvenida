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
        String msj = fachada.getMenuRolXModulos(rol);
        sesion.setAttribute("htmlmenu", msj);
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
        </head>
    <body onload="menu1.escribeacordeon('menu',22,5)">
        <div id="todo">
        <div class="cabecera">
        </div>       
        <div class="principal">
            <div class="menu" id="menu">
            </div>
            <div class="contenido">
                <div class="bloqueA">
                    
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
