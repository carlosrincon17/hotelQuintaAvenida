<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
        
<%
        HttpSession sesion=request.getSession();
                
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }

        String habitacion = request.getParameter("habitacion");
%>
                    <div class="separador"><p>Editar una habitación</p></div><br>
                                   <form class="form-horizontal"name="roles" action="#">
                   <fieldset>
                           <legend>Editar una habitacion</legend>

                            
                            <div class="control-group">
                                    <label class="control-label" for="estado">Habitacion: </label>
                                <div class="controls">
                                <input type="text" name="habitacion" value="<%=habitacion%>"  required/>
                                </div></div>
                        
                                <div class="control-group">
                                    <label class="control-label" for="estado">Habitacion: </label>
                                <div class="controls">
                                <select name="tipo">
                                <%=fachada.getTipoHabitacionListaHTML(habitacion)%>
                                </select>
                                </div></div>

                                

                            <div class="form-actions">
                            <button type="submit" name="guardar" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>

