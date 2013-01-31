<%-- 
    Document   : crear_habitacion
    Created on : 29-jul-2012, 23:21:47
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
        <script type="text/javascript" src="../../js/ajax.js" ></script>
        <title>Crear Habitaciones - Hotel Quinta Avenida</title>
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
                <div class="contenido">
                    <div class="bloqueA">
                        <div class="separador">Datos de la nueva habitacion</div>
                    <form name="crear" action="crear_habitacion.jsp">
                        <p>Seleccione Piso: <select name="pisos">
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select></p>
                    
                        <p>Número de Habitacion:<select name="habitaciones">
                            <option>01</option>
                            <option>02</option>
                            <option>03</option>
                            <option>04</option>
                            <option>05</option>
                            <option>06</option>
                            <option>07</option>
                            <option>08</option>
                            <option>09</option>
                            <option>10</option>
                        </select></p>
                        
                        <p>Tipo:<select name="tipos">
                                <option>Estandar</option>
                                <option>Doble</option>
                                <option>Minisuite</option>
                                <option>Suite</option>
                            </select></p>
                    
                            <input type="button" value="Crear Habitacion" onclick="crearHabitacion()" name="crear" /><br><br>
                    </form>
                </div>
                    <div class="bloqueB" id="bloqueB">
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
