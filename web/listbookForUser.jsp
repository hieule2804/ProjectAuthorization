<%-- 
    Document   : listbook
    Created on : Sep 28, 2023, 10:58:33 AM
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
        <h1>LIST BOOK</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>describle</th>
                    <th>Action</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listBook}" var="book">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.describle}</td>
                        <td>
                            <form action="book?action=add&id=${book.name}" method="post">
                                <button onclick="themvaogiohang()">Them vao gio hang</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <!--gio hang -->
        <h2>GIO HANG CUA BAN</h2>
        <form action="action" style="display: block" id="gioHang">
            <table border="1">
                <thead>
                    <tr>
                        <th>name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBookBuy}" var="book">
                        <tr>
                            <td>${book.name}
                            <input type="checkbox" name="chooseBook" value="${book.name}">
                            </td>
                        </tr>
                    </c:forEach>
                </form>
                </tbody>
            </table>
                <form action="book?action=buy" method="post">
                    <input type="submit" value="BUY">

        </form>

        <!--        <script>
                    function themvaogiohang(){
                        let x= document.getElementById("gioHang");
                        if(x.style.display =='none')
                        {
                            x.style.display ='block';
                        }else{
                            x.style.display ='none';
                    }}
                </script>-->
    </body>

</html>
