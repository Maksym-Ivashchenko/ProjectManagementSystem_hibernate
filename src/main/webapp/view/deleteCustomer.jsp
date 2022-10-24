<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/delete">
            <label for="id"><font color="#ffffff">Customer id:</font></label><br>
            <input type="text" id="customerId" name="customerId">
            <button type="submit">Delete</button>
        </form><br>
        <p><font color="#ffffff">${message}</font></p>
    </body>
</html>