<html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />     
<%@page import="java.util.ArrayList"%>
<% 
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        
        String idArticulo = request.getParameter("articulo");
        String nombre = request.getParameter("nombre");
        
        %>

                
            <div class="container" >
               <form class="form-horizontal" action="agregar_articulo.jsp" name="form">
                   <fieldset>
                           <legend>Agregar cantidad de un articulo</legend>
                   
                               
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombre: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre" value="<%= nombre %>" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="cantidad">Cantidad a añadir: </label>
                                <div class="controls">
                                <input type="text" id="cantidad" name="cantidad" required>
                                </div></div>

                                <input type="hidden" name="idArticulo" value="<%= idArticulo %>">
                            
                            
                            <div class="form-actions">
                            <button type="submit" name="guardar" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </html>    