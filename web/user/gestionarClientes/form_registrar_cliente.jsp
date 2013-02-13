<%-- 
    Document   : registro.jsp
    Created on : 05-ago-2012, 13:50:28
    Author     : CONNORS
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
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
        <title>Nuevo Cliente - Hotel Quinta Avenida</title>
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
               <form class="form-horizontal" action="registrar_cliente.jsp" name="registro" >
                   <fieldset>
                           <legend>Registrar Cliente</legend>
                   
                               <div class="control-group">
                                   <label class="control-label" for ="inputCedula">Cédula o NIT: </label>
                               <div class="controls">
                                <input type="text" id="inputCedula" name="cedula" required>
                                </div></div>
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombres: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre"  required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="inputApellido">Apellidos: </label>
                                <div class="controls">
                                <input type="text" id="inputApellido" name="apellido" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputCorreo">E-mail: </label>
                                <div class="controls">
                                <input type="text" id="inputCorreo" name="correo" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputDireccion">Dirección: </label>
                                <div class="controls">
                                <input type="text" id="inputDireccion" name="direccion" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputTelefono">Teléfono: </label>
                                <div class="controls">
                                <input type="text" id="inputTelefono" name="telefono" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputFechaNto">Fecha Nacimiento: (dd-mm-aaaa)</label>
                                <div class="controls">
                                <input type="text" id= "inputFechaNto" name="fechaNto" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputEmpresa">Nombre Empresa: </label>
                                <div class="controls">
                                <input type="text" id="inputEmpresa" name="empresa" required>
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