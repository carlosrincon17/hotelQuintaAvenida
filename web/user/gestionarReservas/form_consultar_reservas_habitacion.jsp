<%-- 
    Document   : form_listar_salones
    Created on : 05-ago-2012, 15:24:37
    Author     : jorge
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
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
        
        
        
        %>
        <script type="text/javascript" src="../js/ajax.js" ></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Consultar reservas</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="../../css/fichaUsuario.css" />
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>    
    </head>
    <body >
        
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
                <div class="container" >
                <%=supermenu%>
                
            <div class="container" >
               <form class="form-horizontal" action="consultarReserva_Cliente.jsp" name="reservas">
                   <fieldset>
                           <legend>Consultar reservas</legend>
                   
                               <div class="control-group">
                                   <label class="control-label" for ="cedula">Cliente: </label>
                               <div class="controls">
                                <input type="text" name="cedula" id="cedula" value=""  />
                                </div></div>

                                
                            
                            <div class="form-actions">
                            <button type="submit" class="btn" >Consultar</button>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>