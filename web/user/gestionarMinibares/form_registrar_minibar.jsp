<%-- 
    Document   : form_registrar_minibar
    Created on : 02-ago-2012, 11:30:16
    Author     : jorge
--%>

<%@page import="java.util.ArrayList"%>
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
        
        <title>Registrar MiniBar - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="../../css/fichaUsuario.css" />
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body >
        
            <div class="page-header">
                <h1>Hotel Quinta Avenida<small> aqui deberia ir un mensaje</small></h1>
            </div>
        <div class="container" >
                <%
                ArrayList<String[]> menubt = (ArrayList<String[]>)sesion.getAttribute("modulos");
                String supermenu = "";
                
                supermenu+="<ul class= 'nav nav-pills'>";
                    supermenu+="<li class='active'>";
                        supermenu+="<a href='#'>Home</a>";  
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
               <form class="form-horizontal" name="crear" action="registrar_minibar.jsp">
                   <fieldset>
                           <legend>Agregar nuevo minibar</legend>
                   
                               <div class="control-group">
                                   <label class="control-label" for ="idMinibar">No. de serie: </label>
                               <div class="controls">
                                <input type="text" name="idMinibar" id="idMinibar" value=""  />
                                </div></div>

                                <div class="control-group">
                                   <label class="control-label" for ="marca">Marca: </label>
                               <div class="controls">
                                <input type="text" name="marca" id="marca" value=""  />
                                </div></div>

                                <div class="control-group">
                                   <label class="control-label" for ="modelo">Modelo: </label>
                               <div class="controls">
                                <input type="text" name="modelo" id="modelo" value=""  />
                                </div></div>
                            
                            <div class="form-actions">
                            <button type="submit" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
