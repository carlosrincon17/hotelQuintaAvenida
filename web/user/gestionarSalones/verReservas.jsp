<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
        <%
            
            String nombre=request.getParameter("nombre");
            
            out.print(fachada.listarReservasSalonesHTML(nombre));
        %>
        
        