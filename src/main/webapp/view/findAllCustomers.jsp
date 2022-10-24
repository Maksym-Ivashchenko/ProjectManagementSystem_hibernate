<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Customer ID:</th>
                    <th>Customer name:</th>
                    <th>Country:</th>
                    <th>E-mail:</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>
                            <c:out value="${customer.id}"/>
                        </td>
                        <td>
                            <c:out value="${customer.customerName}"/>
                        </td>
                        <td>
                            <c:out value="${customer.country}"/>
                        </td>
                        <td>
                            <c:out value="${customer.email}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>