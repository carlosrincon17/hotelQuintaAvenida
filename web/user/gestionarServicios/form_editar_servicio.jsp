<html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />     

<% 
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        
        String idArticulo = request.getParameter("articulo");
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String precio = request.getParameter("precio");
        
        %>
        
        <div class="separador"><p>Editar Servicio</p></div><br>
                    <form action="editar_servicio.jsp">
                        <p>Nombre del servicio: <input type="text" name="nombre" value="<%= tipo %>" required /></p>
                        <p>Precio: <input type="text" name="cantidad"  value="<%= precio %>" required/></p>
                        <input type="hidden" name="nombreReal" value ="<%= tipo %>">
                        <input type="submit" value="Guardar cambios" name="guardar" /><br><br>
                    </form>
    </html>    