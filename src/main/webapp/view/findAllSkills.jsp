<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Skill ID:</th>
                    <th>Branch:</th>
                    <th>Skill level:</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="skill" items="${skills}">
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
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>