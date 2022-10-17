<%-- 
    Document   : register
    Created on : 17-Oct-2022, 3:59:25 AM
    Author     : navjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            <input type="text" name="username"/>
            <input type="hidden" name="action"/>
            <br>
            <input type="submit" value="register"/>
        </form>
    </body>
</html>
