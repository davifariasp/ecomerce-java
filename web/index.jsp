<%-- 
    Document   : index
    Created on : 8 de nov. de 2022, 11:52:09
    Author     : davifariasp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>SMD E-comerce</title>
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession();
            
            if (sessao == null){
                <%= @include file="header.jsp" %>
            } else {
                <%= @include file="header_logged.jsp" %>
            }
                  
        %>
        
    </body>
</html>
