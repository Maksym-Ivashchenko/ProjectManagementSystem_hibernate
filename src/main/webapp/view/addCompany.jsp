<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/add" method="post">
            <label for="name"><font color="#ffffff">Company name:</font></label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name"><font color="#ffffff">City:</font></label><br>
            <input type="text" id="city" name="city"><br>
            <label for="name"><font color="#ffffff">E-mail:</font></label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Save</button>
        </form><br>
        <c:if test="${not empty savedCompany}">
            <table>
                <thead>
                    <tr>
                        <th>Company name:</th>
                        <th>City:</th>
                        <th>E-mail:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${savedCompany.companyName}"/>
                        </td>
                        <td>
                            <c:out value="${savedCompany.city}"/>
                        </td>
                        <td>
                            <c:out value="${savedCompany.email}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
        <c:if test="${empty savedCompany}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>