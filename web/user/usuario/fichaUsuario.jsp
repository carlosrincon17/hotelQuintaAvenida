  <%@page import="java.util.ArrayList"%>
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
        ArrayList<String[]> md = fachada.getMenuRolXModulos2(rol);
        sesion.setAttribute("modulos",md);
        sesion.setAttribute("htmlmenu", msj);
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
        
        </head>
     <body >
       
            
                
            <div class="page-header">
                
                <h1>Hotel Quinta Avenida<small> aqui deberia ir un mensaje</small></h1>
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
         <div class="centrao">       
         <%=supermenu%>
         </div>       
            <div class="container" >    
            <div class="container" >
                <h1>Esto es una plantilla de prueba</h1>
                <h2>asi que no jodan!</h2>
            </div>
                
        </div>
          
    </body>
</html>
