<%-- 
    Document   : cadastro
    Created on : 6 de out. de 2022, 08:04:46
    Author     : davifariasp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="cadastro" method="post">
            Nome:<input type="text" name="nome"><br>
            Endereco:<input type="text" name="endereco"><br>
            E-mail:<input type="text" name="email"><br>
            Login:<input type="text" name="login"><br>
            Senha:<input type="password" name="senha"><br>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
