<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/delete">
            <label for="id"><font color="#ffffff">Developer id:</font></label><br>
            <input type="text" id="developerId" name="developerId">
            <button type="submit">Delete</button>
        </form><br>
        <p><font color="#ffffff">${message}</font></p>
    </body>
</html>