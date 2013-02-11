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
        String msj = (String)sesion.getAttribute("htmlmenu"); 
        %>
        <script type="text/javascript" src="../../js/ajax.js" ></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>   
    </head>
    <body>
         

        
        
        
        <div id="todo">  
        <div class="cabecera">
            
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
                
            </div>
            
            <div class="contenido">
                <div class='bloqueA'>
                    <div class="separador"><p>Lista de Salones</p></div><br>
                <%= fachada.listaSalonesHTML() %>
                
                <script language="JavaScript">$
                    function cargarTabla(){
                    
                            $("#ejemplo").dataTable(); 
                            } 
                        
                            ;</script>
                </div>
                <div class="bloqueB" id="bloqueB">
                    
                </div>
            </div>
        </div>
       </div>
    </body>
</html>
