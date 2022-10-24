<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/update" method="post">
            <label for="name"><font color="#ffffff">ID:</font></label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="name"><font color="#ffffff">Company name:</font></label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name"><font color="#ffffff">City:</font></label><br>
            <input type="text" id="city" name="city"><br>
            <label for="name"><font color="#ffffff">E-mail:</font></label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Update</button>
        </form><br>
        <c:if test="${not empty updatedCompany}">
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
                    <tr>
                        <td>
                            <c:out value="${updatedCompany.id}"/>
                        </td>
                        <td>
                            <c:out value="${updatedCompany.companyName}"/>
                        </td>
                        <td>
                            <c:out value="${updatedCompany.city}"/>
                        </td>
                        <td>
                            <c:out value="${updatedCompany.email}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
        <c:if test="${empty updatedCompany}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>