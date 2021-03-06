<%-- 
    Document   : editar_habitacion
    Created on : 31-jul-2012, 22:49:05
    Author     : jorge
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
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
        String msj = (String)sesion.getAttribute("htmlmenu");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript" src="../../js/ajax.js" ></script>
        <title>Consultar Habitaciones - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../../css/fichaUsuario.css" />
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        
<%
        String habitacion = request.getParameter("habitacion");
        String tipo = request.getParameter("tipo");
        String msg = fachada.editarHabitacion(habitacion,tipo);
%>

            <div class="page-header">
                <h1>Hotel Quinta Avenida</h1>
            </div>
            <div class="container" >
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
            <h3><%= msg %></h3>
               <h2>Lista de Habitaciones </h2>
              <%=fachada.getListaHabitaciones2()%>
              
              <div class="bloqueB" id="bloqueB"></div>
         </div>
        </div>
    </body>
</html>
