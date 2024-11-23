<%-- 
    Document   : login
    Created on : 6 de out. de 2022, 06:40:25
    Author     : davifariasp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Identificação do Usuário</h1>
        <form action="login" method="post">
            Usuário:<input type="text" name="login" placeholder="usuário"><br>
            Senha:<input type="password" name="senha" placeholder="senha"><br>
            <input type="submit" value="Entrar">
            <%
            String msg = (String) request.getAttribute("msg");
            out.println("<p><strong>" + msg + "</strong></p>");
            //String msg = "Alou";
            
            if(msg != null){
                out.println("<p><strong>" + msg + "</strong></p>");
            }
            
            %>
        </form>
        
    </body>
</html>
