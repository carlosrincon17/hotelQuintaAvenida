<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
        <%
        
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        
        String habitacion = request.getParameter("habitacion");
        %>
                   
                         <form class="form-horizontal"name="roles" action="#">
                   <fieldset>
                           <legend>Editar una habitacion</legend>
                        
                                <div class="control-group">
                                    <label class="control-label" for="estado">Número de Habitacion: </label>
                                <div class="controls">
                                <select name="estado" id="estado">
                                    <%=fachada.getEstadoHabitacionListaHTML(habitacion)%>
                                    </select></p>
                                </div></div>

                                

                            <div class="form-actions">
                            <button type="submit" name="guardar" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
    </body>
</html>
