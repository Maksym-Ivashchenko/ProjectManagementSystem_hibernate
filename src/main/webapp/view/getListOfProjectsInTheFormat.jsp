<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <c:if test="${not empty projects}">
            <table>
                <thead>
                    <tr>
                        <th>Date created:</th>
                        <th>Project name:</th>
                        <th>Count developers:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="project" items="${projects}">
                        <tr>
                            <c:forEach var="projects" items="${project}">
                            <td>
                                <c:out value="${projects}"/>
                            </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty projects}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>