<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<% 
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {
            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String cedula = request.getParameter("cedula");
                
        if(request.getParameter("estado").equals("false"))
            out.println(fachada.habilitarEmpleado(cedula));
        else
            out.println(fachada.deshabilitarEmpleado(cedula));
%>