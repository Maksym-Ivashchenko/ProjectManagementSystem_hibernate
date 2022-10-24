<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/find">
            <label for="name"><font color="#ffffff">Customer ID:</font></label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <button type="submit">Find</button>
        </form>
    </body>
</html>