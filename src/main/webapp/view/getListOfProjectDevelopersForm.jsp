<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/project">
            <label for="name"><font color="#ffffff">Project name:</font></label><br>
            <input type="text" id="projectName" name="projectName">
            <button type="submit">Get</button>
        </form>
    </body>
</html>