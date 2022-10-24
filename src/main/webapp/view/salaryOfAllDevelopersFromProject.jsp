<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/salary">
            <label for="name"><font color="#ffffff">Project name:</font></label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <button type="submit">Get</button>
        </form><br>
        <c:if test="${not empty salary}">
            <table>
                <thead>
                    <tr>
                        <th>Salary:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${salary}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty salary}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>