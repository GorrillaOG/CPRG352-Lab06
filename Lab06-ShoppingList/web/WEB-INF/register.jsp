<%-- 
    Document   : register
    Created on : Oct 17, 2021, 4:31:57 PM
    Author     : 504785
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
        
         <br>
        
        <form method="POST" action="ShoppingList">
            <label>Username: </label>
            <input type="text"  name="username" >
            <input type="submit"   value="Log in">
            <input type ="hidden" name="action" value="register">
        </form>
           
    </body>
</html>