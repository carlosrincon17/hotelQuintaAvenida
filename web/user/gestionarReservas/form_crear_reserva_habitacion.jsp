<%-- 
    Document   : form_crear_reserva_habitacion
    Created on : 07-ago-2012, 10:07:11
    Author     : Carlos
--%>
<%@page import="java.util.ArrayList"%>
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
    <script type='text/javascript' src='../../js/calendar.js'> </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>    
    </head>
    <body>
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
               <form class="form-horizontal" action="guardar_reserva_habitacion.jsp" name="reservas">
                   <fieldset>
                           <legend>Reservar habitacion</legend>
                   
                               <div class="control-group">
                                   <label class="control-label" for ="cliente">Cliente: </label>
                               <div class="controls">
                                <input type="text" name="cliente" id="cliente" value=""  />
                                </div></div>

                                <div class="control-group">
                                   <label class="control-label" for ="text">Fecha Reserva:</label>
                               <div class="controls">
                                <input readonly="readonly" id="text" type="text" name="text"/>
        <img src="../../imagen/calendar.png" onclick="scwShow(scwID('text'),event);"/>
                                </div></div>

                                <div class="control-group">
                                   <label class="control-label" for ="descripcion">Descripcion: </label>
                               <div class="controls">
                                <input type="text" name="descripcion" id="descripcion" value=""  />
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="habitacion">Rol: </label>
                                <div class="controls">
                                <select name="habitacion" id="habitacion">
                                    <%=fachada.getListaHabitacionesOption()%>
                                    </select>
                                </div></div>
                            
                            <div class="form-actions">
                            <button type="submit" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
            </div>
    </body>
</html>
