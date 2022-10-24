<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/update" method="post">
            <label for="name"><font color="#ffffff">Project ID:</font></label><br>
            <input type="text" id="projectId" name="projectId"><br>
            <label for="name"><font color="#ffffff">Project name:</font></label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <label for="name"><font color="#ffffff">Project type:</font></label><br>
            <input type="text" id="projectType" name="projectType"><br>
            <label for="name"><font color="#ffffff">Comments:</font></label><br>
            <input type="text" id="comments" name="comments"><br>
            <label for="name"><font color="#ffffff">Cost:</font></label><br>
            <input type="text" id="cost" name="cost"><br>
            <label for="name"><font color="#ffffff">Date created (by format yyyy-mm-dd):</font></label><br>
            <input type="text" id="dateCreated" name="dateCreated"><br>
            <button type="submit">Update</button>
        </form>
    </body>
</html>