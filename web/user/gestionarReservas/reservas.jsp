<%-- 
    Document   : reloj
    Created on : 05-ago-2012, 12:24:33
    Author     : Carlos
--%>
<%@page session='true'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        String habitacion = request.getParameter("habitacion");
        String estado = request.getParameter("estado");
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
                    <div class="separador">Nueva Reserva de Salón</div>
                        <p><script type='text/javascript' src='../../js/calendar.js'> </script>
    
    <form action="guardarReservas.jsp" name="reservas">   
    <p>Cliente:
        <input type="text" value="" name="cliente"/> 
    </p>
    <p>Fecha de reserva<input readonly="readonly" id="text" type="text" name="fecha"/>
        <img src="../../imagen/calendar.png" onclick="scwShow(scwID('text'),event);"/></p>
    <p>Seleccione el salon: <%=fachada.cargarListaSalones()%>
    <p>Hora de reserva<select name="hora">
        <option value="6"> 6 a.m </option>
        <option value="7"> 7 a.m </option>
        <option value="8"> 8 a.m </option>
        <option value="9"> 9 a.m </option>
        <option value="10"> 10 a.m </option>
        <option value="11"> 11 a.m </option>
        <option value="12"> 12 a.m </option>
        <option value="13"> 1 p.m </option>
        <option value="14"> 2 p.m </option>
        <option value="15"> 3 p.m </option>
        <option value="16"> 4 p.m </option>
        <option value="17"> 5 p.m </option>
        <option value="18"> 6 p.m </option>
        <option value="19"> 7 p.m </option>
        <option value="20"> 8 p.m </option>
           
    </select></p>
    <p>Duracion<select name="duracion">
        <option value="1">1 hora</option>
        <option value="2">2 horas</option>
        <option value="3">3 horas</option>
        <option value="4">4 horas</option>
        <option value="5">5 horas</option>
        <option value="6">6 horas</option>
        <option value="7">7 horas</option>
        <option value="8">8 horas</option>
        <option value="9">9 horas</option>
        <option value="10">10 horas</option>
        <option value="11">11 horas</option>
        <option value="12">12 horas</option>
    </select></p>    
    <p>Abono <input type="text" value="" name="abono" required/></p>
    
    <p>Descripcion <input type="text" value="" name="descripcion" required/></p>
    <p> <input type="submit" value="Guardar" name="button"/></p>
    </form>
                    
            </div>
        </div>
       </div>
</div>
    </body>
</html>

