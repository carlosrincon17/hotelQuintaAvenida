


<%@page import="java.util.ArrayList"%>
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
        
        <script type="text/javascript" src="../js/ajax.js" ></script>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body >
        <div class="container" >
            <div class="page-header">
                <h1>Hotel Quinta Avenida</h1>
            </div>
            
                <%
                ArrayList<String[]> menubt = (ArrayList<String[]>)sesion.getAttribute("modulos");
                String supermenu = "";
                
                supermenu+="<ul class= 'nav nav-pills'>";
                    supermenu+="<li class='active'>";
                        supermenu+="<a href='../../user/usuario/fichaUsuario.jsp'>Home</a>";
                    supermenu+= "</li>";
                    for(String[] modulo : menubt){
                        supermenu+="<li class='dropdown'>";
                            supermenu+="<a class='dropdown-toggle' id='menu"+modulo[0]+"' role='button' data-toggle='dropdown' data-target='#' href='#'>";
                                supermenu+=modulo[0];
                                supermenu+="<b class='caret'></b>";
                            supermenu+="</a>";
                        supermenu+="<ul class='dropdown-menu' role='menu' aria-labelledby='menu"+modulo[0]+"'>";
                        for(int i = 1; i<modulo.length;i++){
                            String[] sp = modulo[i].split("--");
                            supermenu+="<li><a href='"+sp[1]+"'>"+sp[0]+"</a></li>";
                        }
                        supermenu+= "</ul>";
                        supermenu+= "</li>";
                    }
                    
                supermenu+= "</ul>";
                %>
                <%=supermenu%>
                
            <div class="container" >
               <h2><%= fachada.editarEmpleado(cedula,funcion,telefono,correo,direccion,seguro) %></h2>
            </div>
        </div>
    </body>
</html>