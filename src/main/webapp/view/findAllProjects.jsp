<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Project ID:</th>
                    <th>Project name:</th>
                    <th>Project type:</th>
                    <th>Comments:</th>
                    <th>Cost:</th>
                    <th>Date created:</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="project" items="${projects}">
                    <tr>
                        <td>
                            <c:out value="${project.id}"/>
                        </td>
                        <td>
                            <c:out value="${project.projectName}"/>
                        </td>
                        <td>
                            <c:out value="${project.projectType}"/>
                        </td>
                        <td>
                            <c:out value="${project.comments}"/>
                        </td>
                        <td>
                            <c:out value="${project.cost}"/>
                        </td>
                        <td>
                            <c:out value="${project.dateCreated}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>