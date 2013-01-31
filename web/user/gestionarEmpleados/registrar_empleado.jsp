<%-- 
    Document   : registrar_empleado
    Created on : 05-ago-2012, 17:06:22
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
                    <div class="separador">Registro de empleados</div><br>
                    <%
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String cedula = request.getParameter("cedula");
                    String fecha_nto = request.getParameter("fecha_nto");
                    String numero_ss = request.getParameter("numero_ss");
                    String direccion = request.getParameter("direccion");
                    String telefono = request.getParameter("telefono");
                    String correo = request.getParameter("correo");
                    String funcion = request.getParameter("funcion");
                    %>
                    <%= fachada.registrarEmpleado(nombre,apellido,cedula, fecha_nto ,numero_ss,direccion,telefono,correo,funcion)%>
                    <br><br>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>
