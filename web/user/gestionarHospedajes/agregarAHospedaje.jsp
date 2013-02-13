<%@page import="java.util.Date"%>
<jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
        <%
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        String msj = (String)sesion.getAttribute("htmlmenu");
        String hospedaje = request.getParameter("hospedaje");
        String servicio = request.getParameter("servicio");
        String cantidad = request.getParameter("cantidad");
        java.util.Date fechaActual=new Date();
        fachada.agregarServicio(hospedaje, servicio, cantidad, fechaActual);
        
        out.print(fachada.cargarServicios(hospedaje));
%>