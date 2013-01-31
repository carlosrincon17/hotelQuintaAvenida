<%-- 
    Document   : form_crear_reserva_habitacion
    Created on : 07-ago-2012, 10:07:11
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
    <%@page session='true'%>
<html>
    <head>
<%
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        String msj = (String)sesion.getAttribute("htmlmenu"); 

        %>    
    <link rel="stylesheet" href="../../css/login.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                        <p><script type='text/javascript' src='../../js/calendar.js'> </script>
    
    <form action="guardar_reserva_habitacion.jsp" name="reservas">
    <p>Cliente:
        <input type="text" value="" name="cliente"/> 
    </p>
    <p>Fecha de reserva<input readonly="readonly" id="text" type="text" name="fecha"/>
        <img src="../../imagen/calendar.png" onclick="scwShow(scwID('text'),event);"/></p>
    <p>Seleccione la Habitacion: <%=fachada.getListaHabitacionesOption()%>    </p>    
    <p>Descripcion <input type="text" value="" name="descripcion" required/></p>
    <p> <input type="submit" value="Guardar" name="button"/></p>
    </form>
                    
            </div>
        </div>
       </div>
</div>
    </body>
</html>
