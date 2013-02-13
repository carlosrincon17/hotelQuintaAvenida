        <jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
        <%
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        
        String nombre=request.getParameter("nombre");
        out.print(fachada.editarSalonHTML(nombre));
    
        
        %>
        
