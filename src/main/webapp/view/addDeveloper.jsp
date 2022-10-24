<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/add" method="post">
            <label for="name"><font color="#ffffff">Developer name:</font></label><br>
            <input type="text" id="developerName" name="developerName"><br>
            <label for="name"><font color="#ffffff">Age:</font></label><br>
            <input type="text" id="age" name="age"><br>
            <label for="name"><font color="#ffffff">Gender:</font></label><br>
            <input type="text" id="gender" name="gender"><br>
            <label for="name"><font color="#ffffff">Different:</font></label><br>
            <input type="text" id="different" name="different"><br>
            <label for="name"><font color="#ffffff">Salary:</font></label><br>
            <input type="text" id="salary" name="salary"><br>
            <button type="submit">Save</button>
        </form><br>
        <c:if test="${not empty savedDeveloper}">
            <table>
                <thead>
                    <tr>
                        <th>Developer name:</th>
                        <th>Age:</th>
                        <th>Gender:</th>
                        <th>Different:</th>
                        <th>Salary:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${savedDeveloper.developerName}"/>
                        </td>
                        <td>
                            <c:out value="${savedDeveloper.age}"/>
                        </td>
                        <td>
                            <c:out value="${savedDeveloper.gender}"/>
                        </td>
                        <td>
                            <c:out value="${savedDeveloper.different}"/>
                        </td>
                        <td>
                            <c:out value="${savedDeveloper.salary}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty savedDeveloper}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>