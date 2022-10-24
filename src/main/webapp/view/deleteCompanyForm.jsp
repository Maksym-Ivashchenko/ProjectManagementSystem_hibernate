<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/delete">
            <label for="id"><font color="#ffffff">Company id:</font></label><br>
            <input type="text" id="companyId" name="companyId">
            <button type="submit">Delete</button>
        </form>
    </body>
</html>