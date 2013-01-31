<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />

          <%
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
          String rol = request.getParameter("rol");
          out.print(fachada.cargarComportamientosRol(rol));
          %>