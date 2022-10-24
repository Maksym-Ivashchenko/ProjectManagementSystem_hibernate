<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <table>
            <thead>
                <tr>
                    <th>ID:</th>
                    <th>Company name:</th>
                    <th>City:</th>
                    <th>E-mail:</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="company" items="${companies}">
                    <tr>
                        <td>
                            <c:out value="${company.id}"/>
                        </td>
                        <td>
                            <c:out value="${company.companyName}"/>
                        </td>
                        <td>
                            <c:out value="${company.city}"/>
                        </td>
                        <td>
                            <c:out value="${company.email}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>