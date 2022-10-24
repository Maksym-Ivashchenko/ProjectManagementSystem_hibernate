<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/add" method="post">
            <label for="name"><font color="#ffffff">Branch:</font></label><br>
            <input type="text" id="branch" name="branch"><br>
            <label for="name"><font color="#ffffff">Skill level:</font></label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Save</button>
        </form><br>
        <c:if test="${not empty savedSkill}">
            <table>
                <thead>
                    <tr>
                        <th>Branch:</th>
                        <th>Skill level:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${savedSkill.branch}"/>
                        </td>
                        <td>
                            <c:out value="${savedSkill.skillLevel}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty savedSkill}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>