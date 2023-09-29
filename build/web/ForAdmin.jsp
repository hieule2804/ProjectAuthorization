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
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listAccount}" var="acc">
                    <tr>
                        <td>${acc.username}</td>
                        <td>${acc.password}</td>
                        <td>${acc.role=='1'?"admin":"user"}</td>
                        <td>
                            <!--Delete-->
                            <form action="admin?action=delete&id=${acc.id}" method="post">
                                <input type="submit" value="DELETE">
                            </form>
                                <button onclick="UpdateAccount(`${acc.id}`,`${acc.username}`,`${acc.password}`,`${acc.role}`)">UPDATE</button>
                        </td>
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

        <!-- form update -->
 <form action="admin?action=update" method="post" style="display: none" id="accUpdate">
    <input style="display: none" type="text" name="id"><br>
            Username <input type="text" name="username"><br>
            Password <input type="password" name="password"><br>
            Role<input type="text" name="role"><br>
            <input type="submit" value="UPDATE">
        </form>
        <!--list book -->
        <h1>List Book</h1>

    </body>
    <script>
        function addAccount() {
            let x = document.getElementById("addAccount");
            if (x.style.display == 'none')
            {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }

        }
        function UpdateAccount(id,username,password,role){
            let y =document.getElementById("accUpdate");
            if (y.style.display == 'none')
            {
                y.style.display = "block";
            } else {
                y.style.display = "none";
            }
            //trueyn tham so vao form 
            document.querySelector("#accUpdate input[name = id]").value=id;
            document.querySelector("#accUpdate input[name =username]").value=username;
                        document.querySelector("#accUpdate input[name =password]").value=password;
            document.querySelector("#accUpdate input[name =role]").value=role;

        }
    </script>

</html>
