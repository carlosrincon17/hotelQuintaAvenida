<%-- 
    Document   : reloj
    Created on : 05-ago-2012, 12:24:33
    Author     : Carlos
--%>
<%@page import="java.util.ArrayList"%>
<%@page session='true'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
    <html>
<head> 
    <%-- cambio algo--%>
<%
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        
        String habitacion = request.getParameter("habitacion");
        String estado = request.getParameter("estado");
        String msj = (String)sesion.getAttribute("htmlmenu");          
%>    
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type='text/javascript' src='../../js/calendar.js'> </script>
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
               <form class="form-horizontal" action="guardarReservas.jsp" name="reservas">
                   <fieldset>
                           <legend>Consultar reservas</legend>
                   
                               <div class="control-group">
                                   <label class="control-label" for ="cliente">Cliente: </label>
                               <div class="controls">
                                <input type="text" name="cliente" id="cliente" value=""  />
                                </div></div>

                                <div class="control-group">
                                   <label class="control-label" for ="fecha">Fecha de reserva: </label>
                               <div class="controls">
                                <input readonly="readonly" id="text" type="text" name="fecha"/>
        <img src="../../imagen/calendar.png" onclick="scwShow(scwID('text'),event);"/>
                                </div></div>
                           
                           <div class="control-group">
                                   <label class="control-label" for ="salon">Seleccione Salon: </label>
                               <div class="controls">
                                <%=fachada.cargarListaSalones()%>
                                </div></div>
                                
                                <div class="control-group">
                                    <label class="control-label" for="abono">Abono: </label>
                                <div class="controls">
                                 <input type="text" id="abono" name="abono"/>
                                </div></div>

                                <div class="control-group">
                                   <label class="control-label" for ="hora">Hora de reserva: </label>
                               <div class="controls">
                                <select name="hora">
        <option value="6"> 6 a.m </option>
        <option value="7"> 7 a.m </option>
        <option value="8"> 8 a.m </option>
        <option value="9"> 9 a.m </option>
        <option value="10"> 10 a.m </option>
        <option value="11"> 11 a.m </option>
        <option value="12"> 12 a.m </option>
        <option value="13"> 1 p.m </option>
        <option value="14"> 2 p.m </option>
        <option value="15"> 3 p.m </option>
        <option value="16"> 4 p.m </option>
        <option value="17"> 5 p.m </option>
        <option value="18"> 6 p.m </option>
        <option value="19"> 7 p.m </option>
        <option value="20"> 8 p.m </option>
           
    </select>
                                </div></div>
                            
                            <div class="control-group">
                                   <label class="control-label" for ="duracion">Fecha de reserva: </label>
                               <div class="controls">
                                <select name="duracion">
      <option value="1">1 hora</option>
        <option value="2">2 horas</option>
        <option value="3">3 horas</option>
        <option value="4">4 horas</option>
        <option value="5">5 horas</option>
        <option value="6">6 horas</option>
        <option value="7">7 horas</option>
        <option value="8">8 horas</option>
        <option value="9">9 horas</option>
        <option value="10">10 horas</option>
        <option value="11">11 horas</option>
        <option value="12">12 horas</option>
    </select>
                                </div></div>
                            

                            <div class="control-group">
                                   <label class="control-label" for ="descripcion">Descripcion: </label>
                               <div class="controls">
                                <input type="text" name="descripcion" id="descripcion" value=""  />
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

