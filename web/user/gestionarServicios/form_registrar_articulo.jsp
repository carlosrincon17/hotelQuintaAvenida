<%-- 
    Document   : form_registrar_articulo
    Created on : 01-ago-2012, 1:53:31
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
        <title>Registrar Artículos - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <link rel="stylesheet" href="../../css/fichaUsuario.css" />
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
         
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
               <form class="form-horizontal" action="registrar_articulo.jsp" name="form">
                   <fieldset>
                           <legend>Registrar Articulo</legend>
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombre: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre" value="" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="cantidad">Cantidad: </label>
                                <div class="controls">
                                    <input type="text" id="cantidad" name="cantidad"  value="" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="precio">Precio: </label>
                                <div class="controls">
                                <input type="text" id="precio" name="precio"  value="" required>
                                </div></div>



                            
                            
                            <div class="form-actions">
                            <button type="submit" name="guardar" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
        
          
    </body>
</html>
