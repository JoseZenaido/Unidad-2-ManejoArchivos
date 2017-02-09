<%-- 
    Document   : 
    Created on : 23-sep-2016, 18:45:15
    Author     : @author
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar develogSql</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>created</th>
                    <th>sql0</th>
                    <th>sql1</th>
                    <th>params</th>
                    <th>tracer</th>
                    <th>timer</th>
                   
                </tr>
            </thead>
            <tbody>
                <c:forEach var="develogsql" items="${develogsqls}">
                    <tr>
                        <td>${develogsql.id}</td>
                        <td>${develogsql.created}</td>
                        <td>${develogsql.sql0}</td>
                        <td>${develogsql.sql1}</td>
                        <td>${develogsql.params}</td>
                        <td>${develogsql.tracer}</td>
                        <td>${develogsql.timer}</td>
                       
                       
                        <td><a href="DevelogSqlController?action=cambiar&id=${develogsql.id}">Cambiar</a></td>
                        <td><a href="DevelogSqlController?action=borrar&id=${develogsql.id}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="DevelogSqlController?action=agregar">Nuevo develog SQL</a>
        </p>
    </body>
</html>

