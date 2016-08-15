<%-- 
    Document   : criarbanco
    Created on : 17/06/2015, 20:42:13
    Author     : Aislan
--%>

<%@page import="util.GeraBanco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        GeraBanco.main(null);
    %>
    <body>
        <h1>Banco Criado com Sucesso</h1>
        <a href="/WS">Voltar</a>
    </body>
</html>
