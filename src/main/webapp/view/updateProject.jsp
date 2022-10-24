<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/update" method="post">
            <label for="name"><font color="#ffffff">Project ID:</font></label><br>
            <input type="text" id="projectId" name="projectId"><br>
            <label for="name"><font color="#ffffff">Project name:</font></label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <label for="name"><font color="#ffffff">Project type:</font></label><br>
            <input type="text" id="projectType" name="projectType"><br>
            <label for="name"><font color="#ffffff">Comments:</font></label><br>
            <input type="text" id="comments" name="comments"><br>
            <label for="name"><font color="#ffffff">Cost:</font></label><br>
            <input type="text" id="cost" name="cost"><br>
            <label for="name"><font color="#ffffff">Date created (by format yyyy-mm-dd):</font></label><br>
            <input type="text" id="dateCreated" name="dateCreated"><br>
            <button type="submit">Update</button>
        </form><br>
        <c:if test="${not empty updatedProject}">
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
                    <tr>
                        <td>
                            <c:out value="${updatedProject.id}"/>
                        </td>
                        <td>
                            <c:out value="${updatedProject.projectName}"/>
                        </td>
                        <td>
                            <c:out value="${updatedProject.projectType}"/>
                        </td>
                        <td>
                            <c:out value="${updatedProject.comments}"/>
                        </td>
                        <td>
                            <c:out value="${updatedProject.cost}"/>
                        </td>
                        <td>
                            <c:out value="${updatedProject.dateCreated}"/>
                        </td>
                    </tr>
                    <c:out value="Project updated."/>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty updatedProject}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>