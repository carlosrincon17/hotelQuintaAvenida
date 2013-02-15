<%-- 
    Document   : index
    Created on : 08-jul-2012, 18:26:02
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        
        <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 3px 2px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 3px 2px 2px rgba(0,0,0,.05);
                box-shadow: 3px 2px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
        
    </head>
    <body>
        
        <%
            if(request.getParameter("error") != null)
                out.println("<p style='color:#F00; text-align: center; top:100px'>"+request.getParameter("error") +"</p>");
        %>
       

            <div class="container" >
            	<form class="form-signin" action="login.jsp" method="POST">
            	<legend>Iniciar sesion</legend>

            		<label>Cedula:</label>
            		<input type="text" placeholder="Cedula" name="usuario" value="" required />

            		<label>Password:</label>
                        <input type="password" name="password" value="" required/> 
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary">Ingresar</button>
                                <a href="forgotPass.jsp">¿Olvidó su contraseña?</a>
                            </div>
                    
                </form>

                
            </div>
       
    </body>
</html>
