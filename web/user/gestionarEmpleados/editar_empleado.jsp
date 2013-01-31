


<%-- 
    Document   : form_editar_empleado
    Created on : 06-ago-2012, 20:39:07
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
        String cedula = request.getParameter("cedula");
        String funcion = request.getParameter("funcion");
        String telefono = request.getParameter("telefono");
        String msj = (String)sesion.getAttribute("htmlmenu");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String seguro = request.getParameter("seguro");
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Empleados - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <script type="text/javascript" src="../js/ajax.js" ></script>
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <div id="todo">  
        <div class="cabecera">
            <h1>Hotel Quinta Avenida</h1>
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
                
            </div>
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Información</div><br>
                    <%= fachada.editarEmpleado(cedula,funcion,telefono,correo,direccion,seguro) %>
                </div>    
                <div class="bloqueB" id="bloqueB">
                </div>
            </div>
        </div>
       </div>
    </body>
</html>