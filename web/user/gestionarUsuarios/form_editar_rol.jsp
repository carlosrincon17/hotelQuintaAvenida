<%-- 
    Document   : editarRol
    Created on : 31-jul-2012, 0:00:34
    Author     : CONNORS
--%>

<%@page import="com.sun.xml.internal.bind.v2.model.core.ID"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
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
        <title>Consultar Roles - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
         <div class="container" >
            <div class="page-header">
                <h1>Hotel Quinta Avenida<small> aqui deberia ir un mensaje</small></h1>
            </div>
            
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
               <form class="form-horizontal"name="roles" action="#">
                   <fieldset>
                           <legend>Editar Privilegios</legend>
                        
                                <div class="control-group"> 
                                    <label class="control-label" for="rol">Seleccione un rol: </label>
                                <div class="controls">
                                    <select name='misroles' size='5' id='rol' >
                                <%= fachada.getRoles() %>
                                </select>
                                </div></div>

                                

                            <div class="form-actions">
                            <button onclick="sendRequest('getPrivilegiosRol.jsp')" type="submit" name="guardar" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
                                
                                <div id="bloqueB" class="bloqueB">
                            
                        </div>
            </div>
        </div>
        
          
    </body>
</html>
