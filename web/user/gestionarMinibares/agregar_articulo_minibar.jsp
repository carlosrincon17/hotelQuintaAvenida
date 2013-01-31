<%-- 
    Document   : form_agregar_articulo_minibar
    Created on : 02-ago-2012, 14:26:28
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
        <title>Agregar Articulos a MiniBar - Hotel Quinta Avenida</title>
       <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        
<%
        String minibar = request.getParameter("minibar");
        String articulo = request.getParameter("articulo");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));    
%>
        <div id="todo">  
        <div class="cabecera">
            
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
                
            </div>
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Información</div><br>
                    <%= fachada.agregarArticuloMinibar(minibar, articulo, cantidad) %>
                    <br><br>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>   
