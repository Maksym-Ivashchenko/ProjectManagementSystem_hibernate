<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/find">
            <label for="id"><font color="#ffffff">Project id:</font></label><br>
            <input type="text" id="projectId" name="projectId">
            <button type="submit">Find</button>
        </form>
    </body>
</html>