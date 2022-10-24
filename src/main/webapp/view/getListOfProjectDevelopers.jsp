<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/project">
            <label for="name"><font color="#ffffff">Project name:</font></label><br>
            <input type="text" id="projectName" name="projectName">
            <button type="submit">Get</button>
        </form><br>
        <c:if test="${not empty developers}">
            <table>
                <thead>
                    <tr>
                        <th>ID:</th>
                        <th>Developer name:</th>
                        <th>Age:</th>
                        <th>Gender:</th>
                        <th>Different:</th>
                        <th>Salary:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="developer" items="${developers}">
                        <tr>
                            <td>
                                <c:out value="${developer.id}"/>
                            </td>
                            <td>
                                <c:out value="${developer.developerName}"/>
                            </td>
                            <td>
                                <c:out value="${developer.age}"/>
                            </td>
                            <td>
                                <c:out value="${developer.gender}"/>
                            </td>
                            <td>
                                <c:out value="${developer.different}"/>
                            </td>
                            <td>
                                <c:out value="${developer.salary}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty developers}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>