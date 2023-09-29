<%-- 
    Document   : login
    Created on : Sep 28, 2023, 10:34:36 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 style="color: red">${notification}</h2>
        <form action="login" method="post">
            Username <input type="text" name="username"><br>
                        Password <input type="password" name="password"><br>
                        <input type="submit" value="LOGIN">
        </form>
    </body>
</html>
