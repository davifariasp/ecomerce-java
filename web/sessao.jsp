<%-- 
    Document   : sessao
    Created on : 6 de out. de 2022, 06:44:18
    Author     : davifariasp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sessão</title>
    </head>
    <body> 
        <%
            HttpSession sessao = request.getSession();
            
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");
            
            if(usuario.isAdm()){
                //sessao adm
                out.println("<h1>Usuário adm!</h1>");
            } else {
                //sessao usuario
                out.println("<h1>Usuário comum!</h1>");
            }
                  
        %>
        
        <a href="sair.jsp">Sair</a>
    </body>
</html>
