<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/find">
            <label for="id"><font color="#ffffff">Skill id:</font></label><br>
            <input type="text" id="skillId" name="skillId">
            <button type="submit">Find</button>
        </form><br>
        <c:if test="${not empty skill.id}">
            <table>
                <thead>
                    <tr>
                        <th>Skill id:</th>
                        <th>Branch:</th>
                        <th>Skill level:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${skill.id}"/>
                        </td>
                        <td>
                            <c:out value="${skill.branch}"/>
                        </td>
                        <td>
                            <c:out value="${skill.skillLevel}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty skill.id}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>