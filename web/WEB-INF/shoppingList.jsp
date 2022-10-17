<%-- 
    Document   : shoppingList
    Created on : 17-Oct-2022, 3:59:44 AM
    Author     : navjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged In</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
   
        <a href="ShoppingList?action=logout">Logout</a>
        
        <form action="" method="POST">
            <h2>List</h2>
                <br>
                <p>Add item:</p>
                <input type="text" name="item">
                <input type="submit" value="Add">
                <input type="hidden" name="action" value="add">
        </form>
        <form action="" method="POST">
            <ul> 
                <c:forEach var="items" items="${shoppingList}">
                    <li><input type="radio" name="item" value="${items}">${items}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" value="delete" name="action">
         </form>
    </body>
</html>
