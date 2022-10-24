<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        </form><br>
        <c:if test="${not empty updatedSkill}">
            <table>
                <thead>
                    <tr>
                        <th>Skill ID:</th>
                        <th>Branch:</th>
                        <th>Skill level:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${updatedSkill.id}"/>
                        </td>
                        <td>
                            <c:out value="${updatedSkill.branch}"/>
                        </td>
                        <td>
                            <c:out value="${updatedSkill.skillLevel}"/>
                         </td>
                    </tr>
                </tbody>
            </table>
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
        <c:if test="${empty updatedSkill}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>