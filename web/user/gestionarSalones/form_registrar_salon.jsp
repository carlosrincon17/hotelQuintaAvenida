<%-- 
    Document   : form_registrar_salon
    Created on : 05-ago-2012, 14:56:38
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
        <title>Registro de Salones - Hotel Quinta Avenida</title>
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
                    <div class="separador">Datos del nuevo Salon</div><br>
                    <form action="registrar_salon.jsp" name="form">
                <p>Nombre <input type="text" name="nombre" value="" required/></p>
                <p>Precio por Hora<input type="text" name="precio" value="" required/></p>
                <p>Capacidad <input type="text" name="capacidad" value="" required/></p>
                <p>Estado <select name="estado">
                    <option>Habilitado</option>
                    <option>Deshabilitado</option>
                </select></p>
                <p><input type="submit" value="Guardar"/></p>       
                </form>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>
