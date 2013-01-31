<%-- 
    Document   : cambiar_estado_habitacion
    Created on : 31-jul-2012, 23:40:21
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<%@page session='true'%>
<!DOCTYPE html>
<html>
    <head>
<%
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        
        String nombre=request.getParameter("nombre");
        int capacidad= Integer.parseInt(request.getParameter("capacidad"));
        float precio= Float.parseFloat(request.getParameter("precio"));
        String estado= request.getParameter("estado");
        String msj = (String)sesion.getAttribute("htmlmenu");   
    
        
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <title>JSP Page</title>
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
                    <div class="separador"><p>Información</p></div>
                        <p><%=fachada.editarSalon(nombre,precio,capacidad, estado)%></p>
                    
                    <div class="bloqueB" id="bloqueB">
                        
                    </div>
                        <p></p>
                </div>
            </div>
        </div>
       </div>
    </body>
    
    
</html>
