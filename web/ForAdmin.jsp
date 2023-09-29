<%-- 
    Document   : ForAdmin
    Created on : Sep 29, 2023, 8:34:38 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Account</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listAccount}" var="acc">
                <tr>
                    <td>${acc.username}</td>
                    <td>${acc.password}</td>
                    <td>${acc.role=='1'?"admin":"user"}</td>
                </tr>
            </c:forEach>
                
            </tbody>
        </table>
    <!--add account-->
    <button onclick="addAccount()">Add Account</button>
    <!--form add -->
    <form action="admin?action=add" method="post" style="display: none" id="addAccount">
            Username <input type="text" name="username"><br>
            Password <input type="password" name="password"><br>
            Role<input type="text" name="role"><br>
                        <input type="submit" value="ADD">
        </form>
        <!--list book -->
        <h1>List Book</h1>

    </body>
    <script>
        function addAccount(){
            let x = document.getElementById("addAccount");
            if(x.style.display == 'none')
            {
                x.style.display = "block";
            }else{ x.style.display = "none";}
            
        }
    </script>
        
</html>
