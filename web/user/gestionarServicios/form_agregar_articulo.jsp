<html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />     

<% 
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        
        String idArticulo = request.getParameter("articulo");
        String nombre = request.getParameter("nombre");
        
        %>
        
        <div class="separador"><p>Editar una habitación</p></div><br>
                    <form action="agregar_articulo.jsp">
                        <p>Nombre del artículo: <input type="text" name="nombre" value="<%= nombre %>"  required/></p>
                        <p>Cantidad a añadir: <input type="text" name="cantidad"  required/></p>
                        <p><input type="hidden" name="idArticulo" value="<%= idArticulo %>"  /></p>
                        <input type="submit" value="Guardar cambios" name="guardar" /><br><br>
                    </form>
    </html>    