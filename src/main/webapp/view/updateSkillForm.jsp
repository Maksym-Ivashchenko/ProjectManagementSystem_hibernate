<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/update" method="post">
            <label for="name"><font color="#ffffff">Skill ID:</font></label><br>
            <input type="text" id="skillId" name="skillId"><br>
            <label for="name"><font color="#ffffff">Branch:</font></label><br>
            <input type="text" id="branch" name="branch"><br>
            <label for="name"><font color="#ffffff">Skill level:</font></label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Update</button>
        </form>
    </body>
</html>