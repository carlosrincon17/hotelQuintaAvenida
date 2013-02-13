<%-- 
    Document   : terminarHospedaje
    Created on : 09-ago-2012, 19:49:28
<%-- 
    Document   : guerdarReservas
    Created on : 05-ago-2012, 15:38:28
    Author     : Carlos
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session='true'%>
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
                
        int hospedaje= Integer.parseInt(request.getParameter("hospedaje"));
        int habitacion= Integer.parseInt(request.getParameter("habitacion"));
        String msj = (String)sesion.getAttribute("htmlmenu");         
        %>
        

               <h2><%=fachada.terminarHospedaje(hospedaje, habitacion)%>   </h2>
         
    
    </body>
</html>


