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
            out.println("Habitaci�n creada con �xito");//se pudo crear la habitacion
        else{ 
            out.println("No se pudo crear la habitaci�n");//no se pudo crear
        }
        %>

