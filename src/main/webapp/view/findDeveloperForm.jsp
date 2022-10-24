<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/find">
            <label for="id"><font color="#ffffff">Developer id:</font></label><br>
            <input type="text" id="developerId" name="developerId">
            <button type="submit">Find</button>
        </form>
    </body>
</html>