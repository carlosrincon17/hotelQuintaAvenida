<%-- 
    Document   : form_registrar_salon
    Created on : 05-ago-2012, 14:56:38
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
        
        <title>Registro de Salones - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>   
    </head>
    <body>
   
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
               <form class="form-horizontal" action="registrar_salon.jsp" name="form">
                   <fieldset>
                           <legend>Registrar salon</legend>
                   
                               
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombre: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre"  required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="precio">Precio por Hora: </label>
                                <div class="controls">
                                <input type="text" id="precio" name="precio" required>
                                </div></div>
                            
                               <div class="control-group">
                                    <label class="control-label" for="capacidad">Capacidad:</label>
                                <div class="controls">
                                <input type="text" id="capacidad" name="capacidad" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="estado">Estado: </label>
                                <div class="controls">
                                <select id="estado" name="estado">
                                    <option>Habilitado</option>
                                    <option>Deshabilitado</option>
                                </select>
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
