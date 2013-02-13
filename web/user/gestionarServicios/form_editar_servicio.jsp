<%@page import="java.util.ArrayList"%>
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

               <form class="form-horizontal" action="editar_servicio.jsp" name="form">
                   <fieldset>
                           <legend>Editar Servicio</legend>
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombre del servicio: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre" value="<%= tipo %>" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="cantidad">Precio: </label>
                                <div class="controls">
                                <input type="text" id="cantidad" name="cantidad"  value="<%= precio %>" required>
                                </div></div>

                                <input type="hidden" name="nombreReal" value ="<%= tipo %>">
                            
                            
                            <div class="form-actions">
                            <button type="submit" name="guardar" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
          
    </html>    