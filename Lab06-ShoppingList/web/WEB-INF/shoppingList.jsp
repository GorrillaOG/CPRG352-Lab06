<%-- 
    Document   : shoppingList
    Created on : Oct 17, 2021, 4:32:16 PM
    Author     : 504785
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <br>



        <p> Hello ${username}
            <a href="register?action=out">Logout</a></p>  

        <br>

        <h1>List</h1>
        <br>

        <form method="POST" >
            <label>Add Item: </label>
            <input type="text"  name="item" >
            <input type="submit"   value="add">
            <input type="hidden" value="add" name="action">
        </form>
        <br>
        <form method="POST" >
            <table>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>
                            <input type="radio" name="item" value="${item}">
                        </td>
                        <td>
                            ${item}
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
       
        <c:if test="${not empty list}">
            
            <input type="submit" value="delete">
            <input type="hidden" name="action" value="delete">
        </c:if>
 </form>
    </body>
</html>
