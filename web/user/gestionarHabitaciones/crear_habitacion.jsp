<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
        <%
        
        HttpSession sesion=request.getSession(); 
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String piso = request.getParameter("piso");
        String hab = request.getParameter("habitacion");
        String tipo = request.getParameter("tipo_habitacion");
        
        if(fachada.crear_habitacion(piso,hab,tipo))
            out.println("Habitación creada con éxito");//se pudo crear la habitacion
        else{ 
            out.println("No se pudo crear la habitación");//no se pudo crear
        }
        %>

