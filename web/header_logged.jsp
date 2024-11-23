<%-- 
    Document   : header_logged
    Created on : 8 de nov. de 2022, 12:01:16
    Author     : davifariasp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    function sair (){
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
</script>
<div>
    <h1> SMD E-Comerce</h1>
    <button class="btn btn-success" action="sair">Logout</button>
</div>
