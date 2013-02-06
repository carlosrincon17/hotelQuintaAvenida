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
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
        
        <%--<script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>--%>
        </head>
     <body <%--onload="menu1.escribeacordeon('menu',22,5)"--%> >
       
            <div class="container" >
            <div class="page-header">
                <h1>Hotel Quinta Avenida<small> aqui deberia ir un mensaje</small></h1>
            </div>
            
                <ul class=" nav nav-pills">
                    <li class="active">
                        <a href="#">Home</a>
                    </li>
                     <li class="dropdown">
                         <a class="dropdown-toggle" id="menuRoles" role="button" data-toggle="dropdown" data-target="#" href="#">
                             Roles
                             <b class="caret"></b>
                         </a>
                         <ul class="dropdown-menu" role="menu" aria-labelledby="menuRoles">
                             <!-- links -->
                             <li><a href="#">Registrar</a></li>
                             <li><a href="#">Editar</a></li>
                             <li><a href="#">Eliminar</a></li>
                         </ul>
                     </li>
                    <li class="dropdown">
                         <a class="dropdown-toggle" id="menuPrivilegios" role="button" data-toggle="dropdown" data-target="#" href="#">
                             Privilegios
                             <b class="caret"></b>
                         </a>
                         <ul class="dropdown-menu" role="menu" aria-labelledby="menuPrivilegios">
                             <!-- links -->
                             <li><a href="#">Registrar</a></li>
                             <li><a href="#">Editar</a></li>
                             <li><a href="#">Eliminar</a></li>
                         </ul>
                     </li>
                    <li class="dropdown">
                         <a class="dropdown-toggle" id="menuClientes" role="button" data-toggle="dropdown" data-target="#" href="#">
                             Clientes
                             <b class="caret"></b>
                         </a>
                         <ul class="dropdown-menu" role="menu" aria-labelledby="menuClientes">
                             <!-- links -->
                             <li><a href="#">Registrar</a></li>
                             <li><a href="#">Editar</a></li>
                             <li><a href="#">Eliminar</a></li>
                         </ul>
                     </li>
                    <li class="dropdown">
                         <a class="dropdown-toggle" id="menuHabitaciones" role="button" data-toggle="dropdown" data-target="#" href="#">
                             Habitaciones
                             <b class="caret"></b>
                         </a>
                         <ul class="dropdown-menu" role="menu" aria-labelledby="menuHabitaciones">
                             <!-- links -->
                             <li><a href="#">Registrar</a></li>
                             <li><a href="#">Editar</a></li>
                             <li><a href="#">Eliminar</a></li>
                         </ul>
                     </li>
                    <li class="dropdown">
                         <a class="dropdown-toggle" id="menuReservas" role="button" data-toggle="dropdown" data-target="#" href="#">
                             Reservas
                             <b class="caret"></b>
                         </a>
                         <ul class="dropdown-menu" role="menu" aria-labelledby="menuReservas">
                             <!-- links -->
                             <li><a href="#">Registrar</a></li>
                             <li><a href="#">Editar</a></li>
                             <li><a href="#">Eliminar</a></li>
                         </ul>
                     </li>
                    <li class="dropdown">
                         <a class="dropdown-toggle" id="menuServicios" role="button" data-toggle="dropdown" data-target="#" href="#">
                             Servicios
                             <b class="caret"></b>
                         </a>
                         <ul class="dropdown-menu" role="menu" aria-labelledby="menuServicios">
                             <!-- links -->
                             <li><a href="#">Registrar</a></li>
                             <li><a href="#">Editar</a></li>
                             <li><a href="#">Eliminar</a></li>
                         </ul>
                     </li>
                    <li class="dropdown">
                         <a class="dropdown-toggle" id="menuInformes" role="button" data-toggle="dropdown" data-target="#" href="#">
                             Informes
                             <b class="caret"></b>
                         </a>
                         <ul class="dropdown-menu" role="menu" aria-labelledby="menuInformes">
                             <!-- links -->
                             <li><a href="#">Opcion</a></li>
                             <li><a href="#">Opcion</a></li>
                             <li><a href="#">Opcion</a></li>
                         </ul>
                     </li>
                </ul>
            <div class="container" >
                <h1>Esto es una plantilla de prueba</h1>
                <h2>asi que no jodan!</h2>
            </div>
        </div>
          
    </body>
</html>
